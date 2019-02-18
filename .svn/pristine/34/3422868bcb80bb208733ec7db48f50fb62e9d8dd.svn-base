package com.util.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Log;

public class PrepayIdRequestHandler extends RequestHandler {

    public PrepayIdRequestHandler(HttpServletRequest request,
            HttpServletResponse response) {
        super(request, response);
    }

    public String createMD5Sign() {
        StringBuffer sb = new StringBuffer();
        Set es = super.getAllParameters().entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            sb.append(k + "=" + v + "&");
        }
        String params=sb.append("key="+ConstantUtil.APP_KEY).substring(0);
        String sign = MD5Util.MD5Encode(params, "utf8");
        return sign.toUpperCase();
    }

    // 提交预支付
    public String sendPrepay() throws Exception {
        String prepayid = "";
        Set es=super.getAllParameters().entrySet();
        Iterator it=es.iterator();
        StringBuffer sb = new StringBuffer("<xml>");
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            sb.append("<"+k+">"+v+"</"+k+">");
        }
        sb.append("</xml>");
        String params=sb.substring(0);
        String requestUrl = super.getGateUrl();
       // System.out.println(params);
        String resContent = postHtpps(requestUrl,params);
        //System.out.println(resContent);
            if(resContent!=null){
            Map<String,String> map=XMLUtil.doXMLParse(resContent);
            if(map.containsKey("prepay_id"))
                prepayid=map.get("prepay_id");
            }
        return prepayid;
    }
    public static String postHtpps(String urlStr,String xmlInfo){
				try{
				URL url = new URL(urlStr);
				URLConnection con = url.openConnection();
				con.setDoOutput(true);
				con.setRequestProperty("Cache-Control", "no-cache");
				con.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
				//在输入流里面进行转码，是最重要的
				OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream(), "utf-8");
				out.write(xmlInfo);
				out.flush();
				out.close();
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer lines = new StringBuffer();
				String line = "";
				for(line = br.readLine(); line != null; line = br.readLine()){
				lines.append(line);
				}
				return new String(lines.toString().getBytes(),"utf-8");
				}catch(MalformedURLException e){
				Log.getLogger().error(e.getMessage(),e);
				}catch(IOException e){
				Log.getLogger().error(e.getMessage(),e);
				}
				return null;
				}
}