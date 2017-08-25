package com.jk1504.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk1504.entity.Guanzhuform;
import com.jk1504.entity.User;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.JavaWebToken;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.fuzhu.redisdao;
import com.jk1504.service.Guanzhuservice;
import com.jk1504.service.Userservice;

@Controller
public class usercontroller
{
	@Autowired
	private redisdao redis;
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private Guanzhuservice guanzhuservice;
	
	 @RequestMapping(value="/refreshtoken",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String refreshtk(HttpServletRequest request)
	{
		jsdto dto = new jsdto();		 
		Integer userId;
		Integer usermonitor;
		String username;
        ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			username=Tokenmg.getUsername(request);	
			usermonitor=Tokenmg.getUsermonitor(request);
            //把用户登录信息放进Session
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("dbid", userId);
        loginInfo.put("monitor", usermonitor);
        loginInfo.put("username", username);
        loginInfo.put("time", System.currentTimeMillis());
        String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
        dto.data = sessionId;
        redis.inserttoken(sessionId, username);
        return mapper.writeValueAsString(dto);	
		} catch (Exception e)
		{
			e.printStackTrace();
		}  
		dto.setCode("-1");
		dto.setMsg("登陆失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "1";
	}
	
	 
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	
	public @ResponseBody String loginuser(@RequestBody User user) throws JsonProcessingException
	{
		User user1=new User();
		jsdto dto = new jsdto();
		 ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			user1=userservice.Userlogin(user);			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		Integer dbid=user1.getDbid();
		
			if (dbid!=null)
		{
            //把用户登录信息放进Session
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("dbid", dbid);
        loginInfo.put("username", user.getUsername());
        loginInfo.put("monitor", user.getMonitor());
        loginInfo.put("time", System.currentTimeMillis());
        String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
        dto.data = sessionId;
        redis.inserttoken(sessionId, user.getUsername()); 
			return mapper.writeValueAsString(dto);
		} else
		{
			dto.setCode("-1");
			dto.setMsg("登陆失败");
			return mapper.writeValueAsString(dto);
		}
	}
	
@RequestMapping(value="/register",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	
	public @ResponseBody String register(@RequestBody User user) throws JsonProcessingException
	{
		User user1=new User();
		jsdto dto = new jsdto();
		 ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			user1=userservice.Userzc(user);			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		Integer dbid=user1.getDbid();
		
			if (dbid!=null)
		{
            //把用户登录信息放进Session
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("dbid", dbid);
        loginInfo.put("username", user.getUsername());
        loginInfo.put("monitor", user.getMonitor());
        loginInfo.put("time", System.currentTimeMillis());
        String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
        dto.data = sessionId;
        
         redis.inserttoken(sessionId, user.getUsername()); 
			return mapper.writeValueAsString(dto);
		} else
		{
			dto.setCode("-1");
			dto.setMsg("登陆失败");
			return mapper.writeValueAsString(dto);
		}
	}


@RequestMapping(value="/ddapiuser",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
public @ResponseBody String ddapiuser() throws JsonProcessingException
{
	User user=new User();
	user.setImgpath("dawd");
	user.setMonitor(1);
	user.setNickname("rdwd");
	user.setPhone(12455);
	user.setQqid(3156);
	user.setStuid(15231);
	user.setUserclass("js1504");
	user.setUsername("renhaopeng");
	user.setUserpassword("ren12345");
	user.setXingming("任昊鹏");
	
	User user1=new User();
	jsdto dto = new jsdto();
	 ObjectMapper mapper = new ObjectMapper(); 
	try
	{
		user1=userservice.Userzc(user);			
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	Integer dbid=user1.getDbid();
	
	if (dbid!=null)
	{
        //把用户登录信息放进Session
    Map<String, Object> loginInfo = new HashMap<>();
    loginInfo.put("dbid", dbid);
    loginInfo.put("username", user.getUsername());
    loginInfo.put("time", System.currentTimeMillis());
    String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
    dto.data = sessionId;
    
     redis.inserttoken(sessionId, user.getUsername()); 
		return mapper.writeValueAsString(dto);
	} else
	{
		dto.setCode("-1");
		dto.setMsg("登陆失败");
		return mapper.writeValueAsString(dto);
	}
}

@RequestMapping(value="/putgz",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String putgz(@RequestBody Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	Integer userId;
	Guanzhuform guanzhuform=new Guanzhuform();	
	ObjectMapper mapper = new ObjectMapper(); 
	try
	{
		userId = Tokenmg.getUserdbId(request);
		guanzhuform.setBgzzdbid(bgzzid);
		guanzhuform.setGzzdbid(userId);
		if (guanzhuservice.ingz(guanzhuform))
		{
			dto.setMsg("关注成功");
		} else
		{
			dto.setCode("-1");
			dto.setMsg("关注失败");
		}
		return mapper.writeValueAsString(dto);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	dto.setCode("-1");
	dto.setMsg("关注失败");
	try
	{
		return mapper.writeValueAsString(dto);
	} catch (JsonProcessingException e)
	{
		e.printStackTrace();
	}
	return "false";
}

@RequestMapping(value="/delgz",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String delgz(@RequestBody Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	Integer userId;
	Guanzhuform guanzhuform=new Guanzhuform();	
	ObjectMapper mapper = new ObjectMapper(); 
	try
	{
		userId = Tokenmg.getUserdbId(request);
		guanzhuform.setBgzzdbid(bgzzid);
		guanzhuform.setGzzdbid(userId);
		if (guanzhuservice.qxgz(guanzhuform))
		{
			dto.setMsg("取消关注成功");
		} else
		{
			dto.setCode("-1");
			dto.setMsg("取消关注失败");
		}
		return mapper.writeValueAsString(dto);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	dto.setCode("-1");
	dto.setMsg("取消关注失败");
	try
	{
		return mapper.writeValueAsString(dto);
	} catch (JsonProcessingException e)
	{
		e.printStackTrace();
	}
	return "false";
}

@RequestMapping(value="/getgz",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String getgz(@RequestBody Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	Integer userId;	
	ObjectMapper mapper = new ObjectMapper();
	List<Integer> gzList;
	try
	{
		userId = Tokenmg.getUserdbId(request);
		gzList=guanzhuservice.duqugz(userId);
		dto.setMsg("读取关注成功");
		dto.setData(gzList);
		return mapper.writeValueAsString(dto);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	dto.setCode("-1");
	dto.setMsg("读取关注失败");
	try
	{
		return mapper.writeValueAsString(dto);
	} catch (JsonProcessingException e)
	{
		e.printStackTrace();
	}
	return "false";
}

@RequestMapping(value="/getusermessage",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String getusermessage(@RequestBody List<Integer> userids) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	List<User> userList;
	try
	{
		userList=userservice.Userxx(userids);
		dto.setMsg("读取用户信息成功");
		dto.setData(userList);
		return mapper.writeValueAsString(dto);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	dto.setCode("-1");
	dto.setMsg("读取用户信息失败");
	try
	{
		return mapper.writeValueAsString(dto);
	} catch (JsonProcessingException e)
	{
		e.printStackTrace();
	}
	return "false";
}
}

