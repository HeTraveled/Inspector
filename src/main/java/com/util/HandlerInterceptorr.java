package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.home.model.User;
import com.util.login.MemoryData;

public class HandlerInterceptorr implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String url = request.getRequestURI();
		//������ص����ǵ�¼��ҳ��Ļ����� 
					if(url.indexOf("login")>=0||url.indexOf("index")>=0||url.indexOf("js")>=0
							||url.indexOf("css")>=0||url.indexOf("error")>=0||url.indexOf("images")>=0||url.indexOf("retrievePwd")>=0
							||url.indexOf("MP_verify_KPpNH9OPmsCtIyMZ")>=0||url.indexOf("wechat")>=0||url.indexOf("websocket")>=0
							||url.indexOf("slogan")>=0){
					return true;
					}
//						//�����������
//						response.setHeader("Access-Control-Allow-Origin", "*");  
//				        response.setHeader("Access-Control-Allow-Methods", "*");  
//				        response.setHeader("Access-Control-Max-Age", "3600");  
//				        response.setHeader("Access-Control-Allow-Headers",
//				        		"Origin, X-Requested-With, Content-Type, Accept");  
					//��������������ַ���������� 
					User user = (User)request.getSession().getAttribute("user");
					if(user!=null){
						String sessionid = MemoryData.getSessionIDMap().get(user.getName());
						//����û������ڷ��У�����¼���У� 
							if(sessionid.equals(request.getSession().getId())){
								return true;
							}else{ //��������sessionID�ʹ��˺�Map�д�ŵ�sessionID��һ�£���ת����½ҳ
							//�ж�������첽����������Ӧͷ sessionstatusΪtimeout���Զ���ת�������ض���
							if(request.getHeader("x-requested-with")!=null
							&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
							response.setHeader("sessionstatus","timeout");
							return false;
							}else{
							String indexurl=request.getContextPath()+"/home/loginPage?isflag=1";
							response.sendRedirect(indexurl);
							return false;	
				}
			}
			}else{
			//���session��û��admin����ת����½ҳ
				String indexurl=request.getContextPath()+"/home/loginPage";
				response.sendRedirect(indexurl);
				return false;	
			}
	}
}