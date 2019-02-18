package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.util.Log;
import com.util.json.Json;
import com.util.websocket.MyWebSocketHandler;
import com.util.wechat.WXUtil;
import com.wechat.model.JsapiTicketUtil;
import com.wechat.model.SHA1;
import com.wechat.model.SignUtil;
import com.wechat.model.Template;
import com.wechat.model.TemplateParam;
import com.wechat.model.WXAuthUtil;
import com.wechat.model.WenXinUntil;
import com.wechat.model.WxsendIns;
import com.wechat.service.TokenService;
import com.wechat.service.WechatService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@Scope("prototype")
@ApiIgnore
@RequestMapping("wechat")
public class WechatController {
    @Value("5FBB6A8AFD361725F0226518CF977522")
    private String DNBX_TOKEN;

    @Resource
    WechatService wechatService;
    @Autowired
    private TokenService tokenService;
    
    private static final Logger logger = Logger.getLogger(WechatController.class);
	private static String access_token;
	
	
	
    public static String getAccess_token() {
    	if(access_token==null)access_token=WenXinUntil.getAccessToken().getAccess_token();
		return access_token;
	}

	public void setAccess_token(String access_token) {
		WechatController.access_token = access_token;
	}

	// 网页授权接口
    public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
    			+getAccess_token()+"&type=jsapi";
    
   
    
    /**
     * 微信接入
     * @param wc
     * @return
     * @throws IOException 
     */
    @RequestMapping(value="connect",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        boolean isGet = request.getMethod().toLowerCase().equals("get"); 
        PrintWriter out = response.getWriter();
         
        try {
            if (isGet) {
                String signature = request.getParameter("signature");// 微信加密签名  
                String timestamp = request.getParameter("timestamp");// 时间戳  
                String nonce = request.getParameter("nonce");// 随机数  
                String echostr = request.getParameter("echostr");//随机字符串  
                
                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
                if (SignUtil.checkSignature(DNBX_TOKEN, signature, timestamp, nonce)) {  
                Log.getLogger().info("Connect the weixin server is successful.");
                    response.getWriter().write(echostr);  
                } else {  
                	Log.getLogger().error("Failed to verify the signature!"); 
                }
            }else{
                String respMessage = "异常消息！";
                
                try {
                    respMessage = wechatService.weixinPost(request);
                    if(respMessage!=null)out.write(respMessage);
                } catch (Exception e) {
                	 Log.getLogger().error(e.getMessage(),e);  
                }
                
            }
        } catch (Exception e) {
        	 Log.getLogger().error(e.getMessage(),e);  
        }finally{
            out.close();
        }
    }
    @RequestMapping("getJsSdk")
    @ResponseBody
    public Json getJsSdk(@RequestParam("url") String url,HttpServletResponse response){
    	try {
    		String noncestr = WXUtil.getNonceStr();//随机字符串
        	String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳
        	//4获取url
        	Map<String,String> JsapiTicketMap=JsapiTicket();
        	//5、将参数排序并拼接字符串
        	String str = "jsapi_ticket="+JsapiTicketMap.get("ticket")+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
        	//6、将字符串进行sha1加密
        	String signature = SHA1.encode(str);
        	Map<String,String> map=new HashMap();
        	map.put("appId", WXAuthUtil.APPID);
        	map.put("timestamp",timestamp);
        	map.put("accessToken",JsapiTicketUtil.getAccess_token());
        	map.put("ticket",JsapiTicketMap.get("ticket"));
        	map.put("noncestr",noncestr);
        	map.put("signature",signature);
        	return new Json(200,null,map);
		} catch (Exception e) {
			 Log.getLogger().error(e.getMessage(),e);  
			 return null;
		}
    }
    public Map<String, String> JsapiTicket() {
        String requestUrl = GetPageAccessTokenUrl.replace("ACCESS_TOKEN", getAccess_token());
        HttpClient client = null;
        Map<String, String> result = new HashMap<String, String>();
        try {
            client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(requestUrl);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(httpget, responseHandler);
            JSONObject OpenidJSONO = JSONObject.fromObject(response);
            String errcode = String.valueOf(OpenidJSONO.get("errcode"));
            String errmsg = String.valueOf(OpenidJSONO.get("errmsg"));
            String ticket = String.valueOf(OpenidJSONO.get("ticket"));
            String expires_in = String.valueOf(OpenidJSONO.get("expires_in"));
            result.put("errcode", errcode);
            result.put("errmsg", errmsg);
            result.put("ticket", ticket);
            result.put("expires_in", expires_in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
        return result;
    }
    @RequestMapping(value="getToken",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void getToken(){
    	//重新获取token并更新数据库中token
    	tokenService.update(WenXinUntil.getAccessToken().getAccess_token());
    }

    /**
     * 公众号微信登录授权
     * @param request
     * @param response
     * @return
     * @throws ParseException
     * @author  lbh 
     * @date 创建时间：2018年1月18日 下午7:33:59  
     * @parameter
     */
        @RequestMapping(value = "/wxLogin", method = RequestMethod.GET)
        public String wxLogin(HttpServletRequest request,
                HttpServletResponse response)
                throws ParseException {
            //这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
            String backUrl="http://gt.qdgxtz.com/wechat/callBack";
            // 第一步：用户同意授权，获取code
            String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WXAuthUtil.APPID
                    + "&redirect_uri="+URLEncoder.encode(backUrl)
                    + "&response_type=code"
                    + "&scope=snsapi_userinfo"
                    + "&state=STATE#wechat_redirect";

            logger.info("forward重定向地址{" + url + "}");
            //response.sendRedirect(url);
            return "redirect:"+url;//必须重定向，否则不能成功
        }
    /**
     * 公众号微信登录授权回调函数
     * @param modelMap
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     * @author  lbh 
     * @date 创建时间：2018年1月18日 下午7:33:53  
     * @parameter
     */
        @RequestMapping(value = "callBack", method = RequestMethod.GET)
        @ResponseBody
        public Json callBack(@RequestParam("code") String code,
        		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	try {
              //第二步：通过code换取网页授权access_token
                 String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WXAuthUtil.APPID
                        + "&secret="+WXAuthUtil.APPSECRET
                        + "&code="+code
                        + "&grant_type=authorization_code";
                com.alibaba.fastjson.JSONObject jsonObject = WXAuthUtil.doGetJson(url);
                String openid = jsonObject.getString("openid");
                String access_token = jsonObject.getString("access_token");
        //        String refresh_token = jsonObject.getString("refresh_token");
                //第五步验证access_token是否失效；展示都不需要
                String chickUrl="https://api.weixin.qq.com/sns/auth?access_token="+access_token+"&openid="+openid;
                com.alibaba.fastjson.JSONObject chickuserInfo = WXAuthUtil.doGetJson(chickUrl);
                if(!"0".equals(chickuserInfo.getString("errcode"))){
                    // 第三步：刷新access_token（如果需要）-----暂时没有使用,参考文档https://mp.weixin.qq.com/wiki，
                //    String refreshTokenUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+openid+"&grant_type=refresh_token&refresh_token="+refresh_token;
                    com.alibaba.fastjson.JSONObject refreshInfo = WXAuthUtil.doGetJson(chickUrl);
                    access_token=refreshInfo.getString("access_token");
                }
               // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
               String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
                        + "&openid="+openid
                        + "&lang=zh_CN";
                com.alibaba.fastjson.JSONObject userInfo = WXAuthUtil.doGetJson(infoUrl);
                return new Json(200,null,userInfo);
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
				 return new Json(500,null,null);
			}
        	
        }
        @RequestMapping(value = "template", method = RequestMethod.GET)
        @ResponseBody
        public Json template(@RequestParam("type") Integer type,@RequestParam("title") String title,
        		@RequestParam("date") String date,@RequestParam(value="remark",required=false) String remark,@RequestParam("openid") String openid,
        		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	try {
	        	String tplId = "qjdVYN-tcbtlxKFKXcASfYU4ogc0SVaDgwSJpxIA9lc";
	            Template tem=new Template();  
	            tem.setTemplateId(tplId);  
	            tem.setTopColor("#333");  
	            String key1;
	                      if(type==1)key1="督查事项";
	                      else if(type==2)key1="工作计划";
	                      else if(type==3)key1="留言讨论";
	                      else key1="其他";
	            List<TemplateParam> paras=new ArrayList<TemplateParam>();  
	            paras.add(new TemplateParam("first","高投集团行政督查系统","#333"));  
	            paras.add(new TemplateParam("keyword1",key1,"#333"));
	            paras.add(new TemplateParam("keyword2",title,"#333"));
	            paras.add(new TemplateParam("keyword3",date,"#333"));
	            if(remark!=null)paras.add(new TemplateParam("remark",remark,"#333"));        
	            tem.setTemplateParamList(paras);
	            tem.setToUser(openid);//用户openid
	            //设置超链接
	           tem.setUrl("http://wx.qdgxtz.com/WeViews/index.html");  
	            JSONObject jsonObject = Template.sendTemplateMsg(tem,getAccess_token());
	            	return new Json(200,null, jsonObject.get("errcode"));
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
				 return new Json(500,null,null);
			}
        }
        //工作日程提醒
        public void sendtemplate(Integer type,String title,String date,String remark,String openid) throws ServletException, IOException {
        	try {
	        	String tplId = "zUTe5nLI_I3fveqe3QXzkzzginXKkCqqAJTzA5L0sqU";
	            Template tem=new Template();  
	            tem.setTemplateId(tplId);  
	            tem.setTopColor("#333");  
	            String key1;
	                      if(type==1)key1="督查事项";
	                      else if(type==2)key1="工作计划";
	                      else if(type==3)key1="留言讨论";
	                      else if(type==4)key1="日程安排";
	                      else key1="其他";
	            List<TemplateParam> paras=new ArrayList<TemplateParam>();  
	            paras.add(new TemplateParam("first","高投集团行政督查系统","#333"));  
	        //    paras.add(new TemplateParam("keyword1",key1,"#333"));
	            paras.add(new TemplateParam("keyword1",title,"#333"));
	            paras.add(new TemplateParam("keyword2",date,"#333"));
	            if(remark!=null)paras.add(new TemplateParam("remark",remark,"#333"));        
	            tem.setTemplateParamList(paras);
	            tem.setToUser(openid);//用户openid
	            //设置超链接
	            tem.setUrl("http://wx.qdgxtz.com/WeViews/richeng_info");  
	            JSONObject jsonObject = Template.sendTemplateMsg(tem,getAccess_token());
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
			}
        }
        //系统事件通知
        public static void sendWechat(String type,String title,String date,String remark,String openid) throws ServletException, IOException {
        	try {
	        	String tplId = "qjdVYN-tcbtlxKFKXcASfYU4ogc0SVaDgwSJpxIA9lc";
	            Template tem=new Template();  
	            tem.setTemplateId(tplId);  
	            tem.setTopColor("#333");  
	            List<TemplateParam> paras=new ArrayList<TemplateParam>();  
	            paras.add(new TemplateParam("first","高投集团行政督查系统","#333"));  
	           paras.add(new TemplateParam("keyword1",type,"#333"));
	            paras.add(new TemplateParam("keyword2",title,"#333"));
	            paras.add(new TemplateParam("keyword3",date,"#333"));
	            if(remark!=null)paras.add(new TemplateParam("remark",remark,"#333"));        
	            tem.setTemplateParamList(paras);
	            tem.setToUser(openid);//用户openid
	            //设置超链接
	            tem.setUrl("http://wx.qdgxtz.com/WeViews/index.html");  
	            JSONObject jsonObject = Template.sendTemplateMsg(tem,getAccess_token());
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
			}
        }
        //工作进度通知
        @RequestMapping(value = "wxsendIns", method = RequestMethod.POST)
        @ResponseBody
        public Json wxsendIns(@RequestBody WxsendIns wxsendIns) throws ServletException, IOException {
        	try {
	        	String tplId = "k4Gug2Iq4BGTy0YR5fZ_haDZO4Gmln769dZG2tQDgcg";
	            Template tem=new Template();  
	            tem.setTemplateId(tplId);  
	            tem.setTopColor("#333");  
	            List<TemplateParam> paras=new ArrayList<TemplateParam>();  
	            paras.add(new TemplateParam("first",wxsendIns.getTitle(),"#333"));  
	           paras.add(new TemplateParam("keyword1",wxsendIns.getBody(),"#333"));
	            paras.add(new TemplateParam("keyword2","进行中","#333"));
	      //      if(remark!=null)paras.add(new TemplateParam("remark",remark,"#333"));        
	            tem.setTemplateParamList(paras);
	            tem.setToUser(wxsendIns.getOpenid());//用户openid
	            //设置超链接
	            tem.setUrl("http://wx.qdgxtz.com/WeViews/ducha_info?id="+wxsendIns.getIid());
	            JSONObject jsonObject = Template.sendTemplateMsg(tem,getAccess_token());
	            return new Json(200,null,jsonObject);
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
				 return new Json(500,null,null);
			}
        }
        //工作进度通知
        public static void sendIns(String title,String body,String state,
        		String remark,String openid,Integer iid) throws ServletException, IOException {
        	try {
	        	String tplId = "k4Gug2Iq4BGTy0YR5fZ_haDZO4Gmln769dZG2tQDgcg";
	            Template tem=new Template();  
	            tem.setTemplateId(tplId);  
	            tem.setTopColor("#333");  
	            List<TemplateParam> paras=new ArrayList<TemplateParam>();  
	            paras.add(new TemplateParam("first",title,"#333"));  
	           paras.add(new TemplateParam("keyword1",body,"#333"));
	            paras.add(new TemplateParam("keyword2",state,"#333"));
	            if(remark!=null)paras.add(new TemplateParam("remark",remark,"#333"));        
	            tem.setTemplateParamList(paras);
	            tem.setToUser(openid);//用户openid
	            //设置超链接
	            tem.setUrl("http://wx.qdgxtz.com/WeViews/ducha_info?id="+iid);
	            JSONObject jsonObject = Template.sendTemplateMsg(tem,getAccess_token());
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
			}
        }
        public static void sendAnnc(String title,String body,String state,
        		String remark,String openid,Integer aid) throws ServletException, IOException {
        	try {
	        	String tplId = "k4Gug2Iq4BGTy0YR5fZ_haDZO4Gmln769dZG2tQDgcg";
	            Template tem=new Template();  
	            tem.setTemplateId(tplId);  
	            tem.setTopColor("#333");  
	            List<TemplateParam> paras=new ArrayList<TemplateParam>();  
	            paras.add(new TemplateParam("first",title,"#333"));  
	           paras.add(new TemplateParam("keyword1",body,"#333"));
	            paras.add(new TemplateParam("keyword2",state,"#333"));
	            if(remark!=null)paras.add(new TemplateParam("remark",remark,"#333"));        
	            tem.setTemplateParamList(paras);
	            tem.setToUser(openid);//用户openid
	            //设置超链接
	            tem.setUrl("http://wx.qdgxtz.com/WeViews/gongwen_info?id="+aid);
	            JSONObject jsonObject = Template.sendTemplateMsg(tem,getAccess_token());
			} catch (Exception e) {
				 Log.getLogger().error(e.getMessage(),e);  
			}
        }
        //websocket
        @RequestMapping(value="websocket",method = RequestMethod.GET)
        @ResponseBody
        public Json websocket(@RequestParam("msgContent") String msgContent,
        		HttpServletRequest request,HttpServletResponse response){
        	try {
            	return new Json(MyWebSocketHandler.wxWebsocket(msgContent),null,null);
    		} catch (Exception e) {
    			 Log.getLogger().error(e.getMessage(),e);  
    			 return new Json(500,null,null);
    		}
        }
}