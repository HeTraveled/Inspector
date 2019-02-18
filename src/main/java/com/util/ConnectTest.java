package com.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wechat.controller.WechatController;
import com.wechat.model.Template;
import com.wechat.model.TemplateParam;
import com.wechat.service.TokenService;

import net.sf.json.JSONObject;



public class ConnectTest {
	
    @Autowired
    private TokenService tokenService;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		String tplId = "k4Gug2Iq4BGTy0YR5fZ_haDZO4Gmln769dZG2tQDgcg";
        Template tem=new Template();  
        tem.setTemplateId(tplId);  
        tem.setTopColor("#333");  
        List<TemplateParam> paras=new ArrayList<TemplateParam>();  
        paras.add(new TemplateParam("first","123","#333"));  
       paras.add(new TemplateParam("keyword1","12","#333"));
        paras.add(new TemplateParam("keyword2","12","#333"));
        tem.setTemplateParamList(paras);
        tem.setToUser("oJ8ZtwYsp5A5JwJugIo8YH4dpiC4");//用户openid
        //设置超链接
        tem.setUrl("http://wx.qdgxtz.com/WeViews/ducha_info?id=5");
        JSONObject jsonObject = Template.sendTemplateMsg(tem,WechatController.getAccess_token());
	} catch (Exception e) {
		 Log.getLogger().error(e.getMessage(),e);  
	}
//		ApplicationContext act=new FileSystemXmlApplicationContext("classpath:resources/spring/ApplicationContext.xml"); 
//		UserService userService=(UserService) act.getBean("userService"); 
//		List<User> users=userService.selectuser(new User("admin",ToPwd.EncryptionAll("123456")));
//		System.out.println(users.size());
		//System.out.println(new MD5().getMD5ofStr("inspector"));
//		try {
//			WechatController.sendIns("12","   1231232312123123", "进行中",null, "oJ8ZtwYsp5A5JwJugIo8YH4dpiC4");
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String menu = JSONObject.fromObject(WenXinUntil.initMenu()).toString();
//		int result;
//		try {
//			result = WenXinUntil.createMenu(WenXinUntil.getAccessToken().getAccess_token(), menu);
//			if(result == 0)System.out.println("创建菜单成功");
//				else System.out.println("创建菜单失败");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
