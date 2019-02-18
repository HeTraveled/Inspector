package com.wechat.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WenXinUntil {
	
	public static final String APPID="wxb8b2220b23fc9b08";
	
	public static final String APPSERET="7807480190fc32cbe7a41be8942c602f";
	
	public static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	public static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	

	  public static Menu initMenu(){
	    	Menu menu = new Menu();

	    	ViewButton button21 = new ViewButton();
	    	button21.setName("督查系统");
	    	button21.setType("view");
	    	button21.setUrl("http://wx.qdgxtz.com/WeViews/index.html");

	    	menu.setButton(new Button[]{button21});
	    	return menu;
	    	}
	  //创建菜单
	    public static int createMenu(String token,String menu) throws Exception, IOException{
	    int result = 0;
	    String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
	    JSONObject jsonObject = doPostStr(url, menu);
	    if(jsonObject != null){
	    //正常返回0
	    result = jsonObject.getInt("errcode");
	    }
	    return result;
	    }
	    
	    public static JSONObject doPostStr(String url,String outStr){
	    	 
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(url);
	        JSONObject jsonObject = null;
	        String result="";
	        try {
	            httpPost.setEntity(new StringEntity(outStr,"utf-8"));
	            HttpResponse response = httpClient.execute(httpPost);
	            result = EntityUtils.toString(response.getEntity(),"utf-8");
	        } catch (Exception e) {
	        } 
	        jsonObject = JSONObject.fromObject(result);
	        return jsonObject;
	    }
	    /**
	    * 获取accessToken
	    * @param appID 微信公众号凭证
	    * @param appScret 微信公众号凭证秘钥
	    * @return
	    */
	    public static AccessToken getAccessToken() {
	    AccessToken token = new AccessToken();
	    // 访问微信服务器
	    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret="
	    + APPSERET;
	    try {
	    URL getUrl=new URL(url);
	    HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
	    http.setRequestMethod("GET"); 
	    http.setRequestProperty("Content-Type",
	    "application/x-www-form-urlencoded");
	    http.setDoOutput(true);
	    http.setDoInput(true);


	    http.connect();
	    InputStream is = http.getInputStream(); 
	    int size = is.available(); 
	    byte[] b = new byte[size];
	    is.read(b);

	    String message = new String(b, "UTF-8");

	    JSONObject json = JSONObject.fromObject(message);
	    token.setAccess_token(json.getString("access_token"));
	    token.setExpires_in(new Integer(json.getString("expires_in")));
	    } catch (MalformedURLException e) {
	    e.printStackTrace();
	    } catch (IOException e) {
	    e.printStackTrace();
	    }
	    return token;
	    }
}
