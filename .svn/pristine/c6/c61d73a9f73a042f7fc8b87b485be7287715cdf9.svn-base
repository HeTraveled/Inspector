package com.util.wechat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.StringUtil;
import com.util.Log;

public class WeChat {

	 /**
	    * ΢���˿�
  */
	public static boolean weiXinPayOrderRefund(Integer out_trade_no,BigDecimal total_fee,
		 HttpServletRequest request,HttpServletResponse response){
     try {
             // ��ȡ���Ԥ֧��������������
    	 PreRequestHandler preRequestHandler = new PreRequestHandler(request, response);
    	 preRequestHandler.setParameter("appid", ConstantUtil.APP_ID);
    	 preRequestHandler.setParameter("mch_id", ConstantUtil.MCH_ID);
    	 preRequestHandler.setParameter("out_refund_no", OrderNumUtil.orderDatrNum());
    	 preRequestHandler.setParameter("nonce_str", WXUtil.getNonceStr());
    	 preRequestHandler.setParameter("out_trade_no", String.valueOf(out_trade_no));
    	 String totalFee=String.valueOf((int)(Float.valueOf(total_fee.floatValue())*100));
    	 preRequestHandler.setParameter("total_fee", totalFee);//�������
    	 preRequestHandler.setParameter("refund_fee", totalFee);//�˿���
             /**
              * ע��ǩ��sign������ɷ�ʽ�������ٷ��ĵ������ζ�Ҫ�������ǩ���Ҳ��������ֵ�������������APP_KEY,ת���ɴ�д��
              */
             preRequestHandler.setParameter("sign", preRequestHandler.createMD5Sign());
             preRequestHandler.setGateUrl(ConstantUtil.GATEREFUNDURL);
             String preSelectXml = preRequestHandler.sendPreSelectXml();
             String retur = WXUtil.payHttps(ConstantUtil.GATEREFUNDURL, preSelectXml);
             Map returnMap = new HashMap();
             if (StringUtil.isNotEmpty(retur)) {
                 returnMap = WXUtil.parseXmlToMap(retur);
                 //�ж��Ƿ�ɹ�
                 if (StringUtil.isNotEmpty((String) returnMap.get("result_code")) && "SUCCESS".equals(returnMap.get("result_code"))) {
                     //���?����Ϣ
                     //��ݶ����Ų�ѯ������Ϣ//�޸Ķ�����Ϣ  �޸�֧��״̬  Ϊ�˿�״̬
                     return true;
                 }
             }
         }catch (Exception e) {
         Log.getLogger().error(e.getMessage(),e);
         return false;
     }
	return false;
 }
}
