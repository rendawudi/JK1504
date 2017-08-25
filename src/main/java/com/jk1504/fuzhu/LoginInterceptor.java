<<<<<<< HEAD
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
		// TODO ×Ô¶¯Éú³ÉµÄ·½·¨´æ¸ù
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO ×Ô¶¯Éú³ÉµÄ·½·¨´æ¸ù
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		
		 String url = request.getRequestURI();  
        //URL:login.jspÊÇ¹«¿ªµÄ;Õâ¸ödemoÊÇ³ıÁËlogin.jspÊÇ¿ÉÒÔ¹«¿ª·ÃÎÊµÄ£¬ÆäËüµÄURL¶¼½øĞĞÀ¹½Ø¿ØÖÆ  
        if(url.indexOf("login")>=0||url.indexOf("register")>=0||url.indexOf("ddapiuser")>=0){  
            return true;  
        }  
        //»ñÈ¡Session  
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
       
        //²»·ûºÏÌõ¼şµÄ£¬Ìø×ªµ½µÇÂ¼½çÃæ  
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);  
          
        return false;  
}

		
    }  
	

=======
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
		// TODO ×Ô¶¯Éú³ÉµÄ·½·¨´æ¸ù
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO ×Ô¶¯Éú³ÉµÄ·½·¨´æ¸ù
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		
		 String url = request.getRequestURI().toString();  
        //URL:login.jspÊÇ¹«¿ªµÄ;Õâ¸ödemoÊÇ³ıÁËlogin.jspÊÇ¿ÉÒÔ¹«¿ª·ÃÎÊµÄ£¬ÆäËüµÄURL¶¼½øĞĞÀ¹½Ø¿ØÖÆ  
        if(url.contains("login")||url.contains("register")||url.contains("ddapiuser")||url.contains("api-docs")||url.contains("api-doc")){  
            return true;  
        }  
        //»ñÈ¡Session  
        String sessionid="";
        Integer userId=0;
        String username="";
        sessionid = request.getHeader("sessionid");  
        if (sessionid==null)
		{
			return false;
		}
        userId = Tokenmg.getUserdbId(request);  
        username=Tokenmg.getUsername(request);
       if (sessionid!=null&&username!=null&userId!=null)
	{
		 if (redis.pdxg(sessionid, username)&&!userId.equals(0))
		{
			return true;
		}
	}
       
        //²»·ûºÏÌõ¼şµÄ£¬Ìø×ªµ½µÇÂ¼½çÃæ  
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);  
          
        return false;  
}

		
    }  
	

>>>>>>> parent of 9adc572... Revert "ä¿®å¤äº†qqå·ï¼Œç”µè¯å·ï¼Œå­¦å·æ•°æ®æº¢å‡ºã€‚"
