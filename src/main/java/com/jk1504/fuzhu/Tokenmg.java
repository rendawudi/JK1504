package com.jk1504.fuzhu;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import  static com.jk1504.fuzhu.JavaWebToken.verifyJavaWebToken;

public class Tokenmg
{
	    private static Map<String, Object> getClientLoginInfo(HttpServletRequest request) throws Exception {
	        Map<String, Object> r = new HashMap<>();
	        String sessionId = request.getHeader("sessionId");
	        if (sessionId != null) {
	            r = decodeSession(sessionId);
	            return r;
	        }
	        throw new Exception("sessionΩ‚Œˆ¥ÌŒÛ");
	    }

	    public static Integer getUserdbId(HttpServletRequest request) throws Exception {
	        return  Integer.valueOf((Integer)getClientLoginInfo(request).get("dbid"));
	    }
	    
	    public static Integer getUsermonitor(HttpServletRequest request) throws Exception {
	        return  Integer.valueOf((Integer)getClientLoginInfo(request).get("monitor"));
	    }
	    
	    public static String getUsername(HttpServletRequest request) throws Exception {
	        return  ((String)getClientLoginInfo(request).get("username"));
	    }
	    /**
	     * sessionΩ‚√‹
	     */
	    public static Map<String, Object> decodeSession(String sessionId) {
	        try {
	            return verifyJavaWebToken(sessionId);
	        } catch (Exception e) {
	            System.err.println("");
	            return null;
	        }
	    }
	}

