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
		//如果拦截到的是登录的页面的话放行 
					if(url.indexOf("login")>=0||url.indexOf("index")>=0||url.indexOf("js")>=0
							||url.indexOf("css")>=0||url.indexOf("error")>=0||url.indexOf("images")>=0||url.indexOf("retrievePwd")>=0
							||url.indexOf("MP_verify_KPpNH9OPmsCtIyMZ")>=0||url.indexOf("wechat")>=0||url.indexOf("websocket")>=0
							||url.indexOf("slogan")>=0){
					return true;
					}
//						//解决跨域问题
//						response.setHeader("Access-Control-Allow-Origin", "*");  
//				        response.setHeader("Access-Control-Allow-Methods", "*");  
//				        response.setHeader("Access-Control-Max-Age", "3600");  
//				        response.setHeader("Access-Control-Allow-Headers",
//				        		"Origin, X-Requested-With, Content-Type, Accept");  
					//如果是其他请求地址，进行拦截 
					User user = (User)request.getSession().getAttribute("user");
					if(user!=null){
						String sessionid = MemoryData.getSessionIDMap().get(user.getName());
						//如果用户名存在放行（即登录放行） 
							if(sessionid.equals(request.getSession().getId())){
								return true;
							}else{ //如果请求的sessionID和此账号Map中存放的sessionID不一致，跳转到登陆页
							//判断如果是异步请求，设置响应头 sessionstatus为timeout，自动跳转，否则重定向
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
			//如果session中没有admin，跳转到登陆页
				String indexurl=request.getContextPath()+"/home/loginPage";
				response.sendRedirect(indexurl);
				return false;	
			}
	}
}