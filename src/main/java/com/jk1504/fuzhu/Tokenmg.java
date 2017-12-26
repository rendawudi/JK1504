package com.jk1504.fuzhu;

import java.util.HashMap;
import java.util.Map;


import  static com.jk1504.fuzhu.JavaWebToken.verifyJavaWebToken;

public class Tokenmg
{
	    private static Map<String, Object> getClientLoginInfo(String sessionId) throws Exception {
	        Map<String, Object> r = new HashMap<>();
	        if (sessionId != null) {
	            r = decodeSession(sessionId);
	            return r;
	        }
	        throw new Exception("sessionΩ‚Œˆ¥ÌŒÛ");
	    }

	    public static Integer getUserdbId(String sessionId) throws Exception {
	        return  Integer.valueOf((Integer)getClientLoginInfo(sessionId).get("dbid"));
	    }
	    
	    public static Integer getUsermonitor(String sessionId) throws Exception {
	        return  Integer.valueOf((Integer)getClientLoginInfo(sessionId).get("monitor"));
	    }
	    
	    public static String getUsername(String sessionId) throws Exception {
	        return  ((String)getClientLoginInfo(sessionId).get("username"));
	    }
	    
	    
	    public static Long getSystemTime(String sessionId) throws Exception {
	        return  ((Long)getClientLoginInfo(sessionId).get("time"));
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

