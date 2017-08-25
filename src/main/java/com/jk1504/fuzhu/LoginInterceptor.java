package com.jk1504.fuzhu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class LoginInterceptor implements HandlerInterceptor
{
	@Autowired
	private redisdao redis;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO 自动生成的方法存根
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		
		 String url = request.getRequestURI();  
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        if(url.indexOf("login")>=0||url.indexOf("register")>=0||url.indexOf("ddapiuser")>=0){  
            return true;  
        }  
        //获取Session  
        String sessionid="";
        Integer userId=0;
        String username="";
        sessionid = request.getHeader("sessionid");  
        userId = Tokenmg.getUserdbId(request);  
        username=Tokenmg.getUsername(request);
       if (sessionid!=null&&username!=null&userId!=null)
	{
		 if (redis.pdxg(sessionid, username)&&!userId.equals(0))
		{
			return true;
		}
	}
       
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);  
          
        return false;  
}

		
    }  
	

