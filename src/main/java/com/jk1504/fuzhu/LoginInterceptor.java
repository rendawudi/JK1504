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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		
		 String url = request.getRequestURI();  
        //URL:login.jsp�ǹ�����;���demo�ǳ���login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���  
        if(url.indexOf("login")>=0||url.indexOf("register")>=0||url.indexOf("ddapiuser")>=0){  
            return true;  
        }  
        //��ȡSession  
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
       
        //�����������ģ���ת����¼����  
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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		
		 String url = request.getRequestURI();  
        //URL:login.jsp�ǹ�����;���demo�ǳ���login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���  
        if(url.indexOf("login")>=0||url.indexOf("register")>=0||url.indexOf("ddapiuser")>=0){  
            return true;  
        }  
        //��ȡSession  
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
       
        //�����������ģ���ת����¼����  
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);  
          
        return false;  
}

		
    }  
	

>>>>>>> parent of 08ac5ad... 修复了qq号，电话号，学号数据溢出。
