package com.util.wechat;


import com.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by HQ on 2017/12/11 0011.
 */
public class OrderNumUtil {
    private static Date date = new Date();
    private static StringBuilder buf = new StringBuilder();
    private static int seq = 0;
    private static final int ROTATION = 99999;

    public static synchronized String next() {
        if (seq > ROTATION)
            seq = 0;
        buf.delete(0, buf.length());
        date.setTime(System.currentTimeMillis());
        String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
        return str;
    }

    public static synchronized String orderDatrNum() {
        String randNum ="";
        try {
            Random rand = new Random();
            int shu2 = rand.nextInt(9);
            randNum+=  new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + shu2;//  DateUtils ����Ŀ��ͳһ����ʱ��� û�еĻ������д���  ���Ǹ�ʱ���ʽת��
        } catch (Exception e) {
            Log.getLogger().error(e.getMessage(),e);
        }
        return randNum;
    }
}