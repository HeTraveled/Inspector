package com.util.wechat;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class TenpayHttpClient {

    

    
    /** �������ݣ�����post��get������get��ʽ�ṩ */
    private String reqContent;
    
    /** Ӧ������ */
    private String resContent;
    
    /** ���󷽷� */
    private String method;
    
    /** ������Ϣ */
    private String errInfo;
    
    /** ��ʱʱ��,����Ϊ��λ */
    private int timeOut;
    
    /** httpӦ����� */
    private int responseCode;
    
    /** �ַ����� */
    private String charset;
    
    private InputStream inputStream;
    
    public TenpayHttpClient() {
        this.reqContent = "";
        this.resContent = "";
        this.method = "POST";
        this.errInfo = "";
        this.timeOut = 30;//30��
        
        this.responseCode = 0;
        this.charset = "utf8";
        
        this.inputStream = null;
    }
    
    /**
     * ������������
     * @param reqContent ��������
     */
    public void setReqContent(String reqContent) {
        this.reqContent = reqContent;
    }
    
    /**
     * ��ȡ�������
     * @return String
     * @throws IOException 
     */
    public String getResContent() {
        try {
            this.doResponse();
        } catch (IOException e) {
            this.errInfo = e.getMessage();
            //return "";
        }
        
        return this.resContent;
    }
    
    /**
     * �������󷽷�post����get
     * @param method ���󷽷�post/get
     */
    public void setMethod(String method) {
        this.method = method;
    }
    
    /**
     * ��ȡ������Ϣ
     * @return String
     */
    public String getErrInfo() {
        return this.errInfo;
    }
    
    /**
     * ���ó�ʱʱ��,����Ϊ��λ
     * @param timeOut ��ʱʱ��,����Ϊ��λ
     */
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
    
    /**
     * ��ȡhttp״̬��
     * @return int
     */
    public int getResponseCode() {
        return this.responseCode;
    }
    
    protected void callHttp() throws IOException {
        
        if("POST".equals(this.method.toUpperCase())) {
            String url = HttpClientUtil.getURL(this.reqContent);
            String queryString = HttpClientUtil.getQueryString(this.reqContent);
            byte[] postData = queryString.getBytes(this.charset);
            this.httpPostMethod(url, postData);
            
            return ;
        }
        
        this.httpGetMethod(this.reqContent);
        
    } 
    
    public boolean callHttpPost(String url, String postdata) {
        boolean flag = false;
        byte[] postData;
        try {
            postData = postdata.getBytes(this.charset);
            this.httpPostMethod(url, postData);
            flag = true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return flag;
    }
    
    /**
     * ��http post��ʽͨ��
     * @param url
     * @param postData
     * @throws IOException
     */
    protected void httpPostMethod(String url, byte[] postData)
            throws IOException {

        HttpURLConnection conn = HttpClientUtil.getHttpURLConnection(url);

        this.doPost(conn, postData);
    }
    
    /**
     * ��http get��ʽͨ��
     * 
     * @param url
     * @throws IOException
     */
    protected void httpGetMethod(String url) throws IOException {
        
        HttpURLConnection httpConnection =
            HttpClientUtil.getHttpURLConnection(url);
        
        this.setHttpRequest(httpConnection);
        
        httpConnection.setRequestMethod("GET");
        
        this.responseCode = httpConnection.getResponseCode();
        
        this.inputStream = httpConnection.getInputStream();
        
    }
    
    /**
     * ��https get��ʽͨ��
     * @param url
     * @param sslContext
     * @throws IOException
     */
    protected void httpsGetMethod(String url, SSLContext sslContext)
            throws IOException {

        SSLSocketFactory sf = sslContext.getSocketFactory();

        HttpsURLConnection conn = HttpClientUtil.getHttpsURLConnection(url);

        conn.setSSLSocketFactory(sf);

        this.doGet(conn);

    }
    
    protected void httpsPostMethod(String url, byte[] postData,
            SSLContext sslContext) throws IOException {

        SSLSocketFactory sf = sslContext.getSocketFactory();

        HttpsURLConnection conn = HttpClientUtil.getHttpsURLConnection(url);

        conn.setSSLSocketFactory(sf);

        this.doPost(conn, postData);

    }
    
    /**
     * ����http����Ĭ������
     * @param httpConnection
     */
    protected void setHttpRequest(HttpURLConnection httpConnection) {
        
        //�������ӳ�ʱʱ��
        httpConnection.setConnectTimeout(this.timeOut * 1000);
        
        
        //��ʹ�û���
        httpConnection.setUseCaches(false);
        
        //�����������
        httpConnection.setDoInput(true);
        httpConnection.setDoOutput(true);
        
    }
    
    /**
     * ����Ӧ��
     * @throws IOException
     */
    protected void doResponse() throws IOException {
        
        if(null == this.inputStream) {
            return;
        }

        //��ȡӦ������
        this.resContent=HttpClientUtil.InputStreamTOString(this.inputStream,this.charset); 

        //�ر�������
        this.inputStream.close();
        
    }
    
    /**
     * post��ʽ����
     * @param conn
     * @param postData
     * @throws IOException
     */
    protected void doPost(HttpURLConnection conn, byte[] postData)
            throws IOException {

        // ��post��ʽͨ��
        conn.setRequestMethod("POST");

        // ��������Ĭ������
        this.setHttpRequest(conn);

        // Content-Type
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");

        BufferedOutputStream out = new BufferedOutputStream(conn
                .getOutputStream());

        final int len = 1024; // 1KB
        HttpClientUtil.doOutput(out, postData, len);

        // �ر���
        out.close();

        // ��ȡ��Ӧ����״̬��
        this.responseCode = conn.getResponseCode();

        // ��ȡӦ��������
        this.inputStream = conn.getInputStream();

    }
    
    /**
     * get��ʽ����
     * @param conn
     * @throws IOException
     */
    protected void doGet(HttpURLConnection conn) throws IOException {
        
        //��GET��ʽͨ��
        conn.setRequestMethod("GET");
        
        //��������Ĭ������
        this.setHttpRequest(conn);
        
        //��ȡ��Ӧ����״̬��
        this.responseCode = conn.getResponseCode();
        
        //��ȡӦ��������
        this.inputStream = conn.getInputStream();
    }

    
}