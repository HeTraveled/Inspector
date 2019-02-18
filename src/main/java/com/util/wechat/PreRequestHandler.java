package com.util.wechat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 微信订单查询 退款  等处理信息
 * Created by HQ on 2017/12/11 0011.
 */
public class PreRequestHandler extends RequestHandler {
    public PreRequestHandler(HttpServletRequest request,
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
        String params=sb.append("key="+ ConstantUtil.APP_KEY).substring(0);
        String sign = MD5Util.MD5Encode(params, "utf8");
        return sign.toUpperCase();
    }

    // 提交
    public  Map<String,String> sendPreSelect() throws Exception {
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
        System.out.println("请求参数："+params);
        String requestUrl = super.getGateUrl();
        System.out.println("请求url："+requestUrl);
        TenpayHttpClient httpClient = new TenpayHttpClient();
        httpClient.setReqContent(requestUrl);
        String resContent = "";
        if (httpClient.callHttpPost(requestUrl, params)) {
            resContent = httpClient.getResContent();
            System.out.println("获取select的返回值："+resContent);
            Map<String,String> map=XMLUtil.doXMLParse(resContent);
            return map;
        }
        return null;
    }

    /**
     * xml 参数
     * @return
     * @throws Exception
     */
    public  String sendPreSelectXml() throws Exception {
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
    //    System.out.println("退款请求参数："+sb.substring(0));
        return sb.substring(0);
    }
}