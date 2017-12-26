package com.jk1504.fuzhu;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
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
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception
	{
		Cookie cookies[] = request.getCookies();        
        String sessionid="";
        Integer userId=0;
        String username="";
        String sdtId = "";
        if (cookies!=null)
		{
			for(Cookie cookie: cookies)
        {
        	if (cookie.getName().equals("sessionId"))
			{
        		sessionid = cookie.getValue();
			}
        	if (cookie.getName().equals("sdtId"))
			{
        		sdtId = cookie.getValue();
			}
        }
		}
        
        userId = Tokenmg.getUserdbId(sessionid);
        username = Tokenmg.getUsername(sessionid);
        Integer usermonitor = Tokenmg.getUsermonitor(sessionid);
        Long nowTime = System.currentTimeMillis();
		 Long beforeTime = Tokenmg.getSystemTime(sessionid);
		 if (nowTime>beforeTime)
		{
			 	Map<String, Object> loginInfo = new HashMap<>();
		        loginInfo.put("dbid", userId);
		        loginInfo.put("monitor", usermonitor);
		        loginInfo.put("username", username);
		        loginInfo.put("time", System.currentTimeMillis()+604800000);
		        String nowSessionIid = JavaWebToken.createJavaWebToken(loginInfo);
		        redis.inserttoken(nowSessionIid, username);
		        Cookie newCookie1 = new Cookie("sdtId", sdtId);
		        newCookie1.setMaxAge(6048000);
		        response.addCookie(newCookie1);
		        Cookie newCookie = new Cookie("sessionId", nowSessionIid);
		        newCookie.setMaxAge(604800);
		        response.addCookie(newCookie);
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		 String url = request.getRequestURI().toString();  
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制

		if (request.getMethod().equals("OPTIONS"))
			return true;

        if(url.contains("ws")||url.contains("getmessage")||url.contains("login")||url.contains("register")||url.contains("ddapiuser")||url.contains("index")||url.contains("getusermessage")){
            return true;  
        }
        //获取Session  
        Cookie cookies[] = request.getCookies();

        String sessionid= null;
        Integer userId=0;
        String username="";
        if (cookies != null) {
			for(Cookie cookie: cookies)
			{
				if (cookie.getName().equals("sessionId"))
				{
					sessionid = cookie.getValue();
				}
			}
		}
        if (sessionid==null)
		{
			System.out.println(request.getRequestURI());
        	Cookie cookie = new Cookie("sdtId", null);
			cookie.setMaxAge(0);
	    	response.addCookie(cookie);
	    	Cookie cookie1 = new Cookie("sessionId", null);
			cookie1.setMaxAge(0);
	    	response.addCookie(cookie1);
		} else {
			Integer usermonitor = Tokenmg.getUsermonitor(sessionid);
			userId = Tokenmg.getUserdbId(sessionid);
			username=Tokenmg.getUsername(sessionid);
		}

       if (sessionid!=null&&username!=null&userId!=null)
	{
		 if (redis.pdxg(sessionid, username)&&!userId.equals(0))
		 {
			return true;
		}
	}

        return false;  
}

		
    }  
	

