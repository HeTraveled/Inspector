package com.wechat.model;

public class JsapiTicketUtil {
	
	private static String access_token;
	
	
	
    public static String getAccess_token() {
    	if(access_token==null)access_token=WenXinUntil.getAccessToken().getAccess_token();
		return access_token;
	}

	public void setAccess_token(String access_token) {
		JsapiTicketUtil.access_token = access_token;
	}

	public static String getGetpageaccesstokenurl() {
		return GetPageAccessTokenUrl;
	}

	// 网页授权接口
    public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
    			+getAccess_token()+"&type=jsapi";


//    public static void main(String[] args) {
//   
//    	String noncestr = WXUtil.getNonceStr();//随机字符串
//    	String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳
//    	//4获取url
//    	Map<String,String> JsapiTicketMap=JsapiTicket();
//    	String url="http://gt.qdgxtz.com/wechat/getJSSDK";
//    	//5、将参数排序并拼接字符串
//    	String str = "jsapi_ticket="+JsapiTicket().get("ticket")+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
//    	//6、将字符串进行sha1加密
//    	String signature = SHA1.encode(str);
//    	Map<String,String> map=new HashMap();
//    	map.put("timestamp",timestamp);
//    	map.put("accessToken",getAccess_token());
//    	map.put("ticket",JsapiTicketMap.get("ticket"));
//    	map.put("noncestr",noncestr);
//    	map.put("signature",signature);
//    	System.out.println(signature);
//	}
}