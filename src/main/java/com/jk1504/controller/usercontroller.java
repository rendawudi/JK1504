package com.jk1504.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jk1504.entity.Guanzhuform;
import com.jk1504.entity.User;
import com.jk1504.entity.Userxgxx;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.JavaWebToken;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.fuzhu.redisdao;
import com.jk1504.service.Guanzhuservice;
import com.jk1504.service.Userservice;



@Controller
@RequestMapping(value="/user")
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
        loginInfo.put("monitor", user1.getMonitor());
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
		user.setMonitor(1);
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
        loginInfo.put("monitor", 1);
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
public @ResponseBody String putgz( Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
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
public @ResponseBody String delgz( Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
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
public @ResponseBody String getgz( Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
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
@RequestMapping(value="/changimg",method=RequestMethod.POST)
public String changimg(@RequestParam("file")MultipartFile file,HttpServletRequest request,Model model) throws IOException
{
	String username;
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	if(!file.isEmpty())
	{
		String realPath = request.getSession().getServletContext().getRealPath("/img");
		try
		{
			username = Tokenmg.getUsername(request);
			File file1=new File(realPath+username);
			if (file1.exists()) {
				file1.delete();
			}
		} catch (Exception e1)
		{
			dto.setCode("-1");
			dto.setMsg(e1.getMessage());
			e1.printStackTrace();
			return mapper.writeValueAsString(dto);
		}
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,username));
		realPath+="/";
		try {
			Userxgxx userxgxx=new Userxgxx();
			userxgxx.setDbid(Tokenmg.getUserdbId(request));
			userxgxx.setImgpath(realPath);
			User user1=userservice.Userimgxg(userxgxx);
			if (user1.getNickname().equals("no"))
			{
				dto.setCode("-1");
				return mapper.writeValueAsString(dto);
			} else
			{
				dto.setData(user1);
				return mapper.writeValueAsString(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	return "false";
}
@RequestMapping(value="/updatenick",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String updatenick(String nickname,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	try
	{
		Integer userid=Tokenmg.getUserdbId(request);
		Userxgxx user1=new Userxgxx();
		user1.setDbid(userid);
		user1.setNickname(nickname);
		if (userid!=null&&nickname!=null)
		{
			User user=userservice.Usernickxg(user1);
		dto.setData(user);
		return mapper.writeValueAsString(dto);
		}
		dto.setCode("-1");
		dto.setMsg("修改昵称失败");
		return mapper.writeValueAsString(dto);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	dto.setCode("-1");
	dto.setMsg("修改昵称失败");
	try
	{
		return mapper.writeValueAsString(dto);
	} catch (JsonProcessingException e)
	{
		e.printStackTrace();
	}
	return "false";
}
@RequestMapping(value="/updatepaswd",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String updatepaswd(@RequestBody Userxgxx userxgxx) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	try
	{
		if (userservice.Userpaswdxg(userxgxx))
		{
			return mapper.writeValueAsString(dto);
		}
		dto.setCode("-1");
		dto.setMsg("修改密码失败");
		return mapper.writeValueAsString(dto);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	dto.setCode("-1");
	dto.setMsg("修改密码失败");
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

