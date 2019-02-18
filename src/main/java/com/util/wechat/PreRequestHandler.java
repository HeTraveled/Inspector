package com.util.wechat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ΢�Ŷ�����ѯ �˿�  �ȴ�����Ϣ
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

    // �ύ
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
        System.out.println("���������"+params);
        String requestUrl = super.getGateUrl();
        System.out.println("����url��"+requestUrl);
        TenpayHttpClient httpClient = new TenpayHttpClient();
        httpClient.setReqContent(requestUrl);
        String resContent = "";
        if (httpClient.callHttpPost(requestUrl, params)) {
            resContent = httpClient.getResContent();
            System.out.println("��ȡselect�ķ���ֵ��"+resContent);
            Map<String,String> map=XMLUtil.doXMLParse(resContent);
            return map;
        }
        return null;
    }

    /**
     * xml ����
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
    //    System.out.println("�˿����������"+sb.substring(0));
        return sb.substring(0);
    }
}