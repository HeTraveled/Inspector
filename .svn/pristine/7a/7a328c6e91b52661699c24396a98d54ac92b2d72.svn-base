package com.util.wechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.security.KeyStore;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.util.ResourceUtils;
import org.xml.sax.InputSource;

import com.util.Log;

public class WXUtil {
    /**
     * �������ַ�
     * @return
     */
    public static String getNonceStr() {
        Random random = new Random();
        return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "utf8");
    }
    /**
     * ��ȡʱ���
     * @return
     */
    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
    /**
     * ��ȡʮλ��ʱ���
     * @param d ʱ��
     * @return
     */
    public static String getTimeStamp(Date d) {
        return String.valueOf(d.getTime() / 1000);
    }
    /**
     * https˫��ǩ����֤������֧�������˿�
     *
     * */
    public static String payHttps(String url,String xml) throws Exception {
        //�̻�id
        String MCH_ID = ConstantUtil.MCH_ID;
        //ָ����ȡ֤���ʽΪPKCS12
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        File path = ResourceUtils.getFile("classpath:com/util/wechat/apiclient_cert.p12");
        //��ȡ�����ŵ�PKCS12֤���ļ�
        FileInputStream instream = new FileInputStream(path);
        try {
            //ָ��PKCS12������(�̻�ID)
            keyStore.load(instream, MCH_ID.toCharArray());
        } catch (Exception e) {
			Log.getLogger().error(e.getMessage(),e);
		}finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, MCH_ID.toCharArray()).build();
        //ָ��TLS�汾
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,new String[] { "TLSv1" },null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        //����httpclient��SSLSocketFactory
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpPost httpost = new HttpPost(url); // ������Ӧͷ��Ϣ
            httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(xml, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();
                String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                EntityUtils.consume(entity);
              //  System.out.println(jsonStr);
                return jsonStr;
            }catch (Exception e) {
				Log.getLogger().error(e.getMessage(),e);
			}finally {
                response.close();
            }
        }catch (Exception e) {
			Log.getLogger().error(e.getMessage(),e);
		}finally {
            httpclient.close();
        }
		return null;
    }
    /**
     * ��ȡ�ص���ַ
     * @param request
     * @return
     */
    public static String getNotifyUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String domain = url.substring(0, url.length()-13);
        //���
        return domain+ConstantUtil.GATEREFUNDURL;
    }

    public static Map parseXmlToMap(String xml) {
        //  Map retMap = new HashMap();
        SortedMap<String, String> retMap = new TreeMap<String, String>();
        try {
            StringReader read = new StringReader(xml);
            // �����µ�����ԴSAX ��������ʹ�� InputSource ������ȷ����ζ�ȡ XML ����
            InputSource source = new InputSource(read);
            // ����һ���µ�SAXBuilder
            SAXBuilder sb = new SAXBuilder();
            // ͨ������Դ����һ��Document
            Document doc =  sb.build(source);
            Element root = doc.getRootElement();// ָ���ڵ�
            List<Element> es = root.getChildren();
            if (es != null && es.size() != 0) {
                for (Element element : es) {
                    retMap.put(element.getName(), element.getValue());
                }
            }
        } catch (Exception e) {
            Log.getLogger().error(e.getMessage(),e);
        }
        return retMap;
    }
    /*public static void main(String[] args){

        System.out.println(getTimeStamp(new Date()));
    }*/
}