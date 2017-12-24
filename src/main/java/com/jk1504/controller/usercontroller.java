package com.jk1504.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jk1504.entity.Guanzhuform;
import com.jk1504.entity.User;
import com.jk1504.entity.Usermsg;
import com.jk1504.entity.Userxgxx;
import com.jk1504.entity.jsdto;
import com.jk1504.entity.simpleUser;
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
	
	@RequestMapping(value="/getmessage",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String ReturnMsg()
	{
		jsdto dto = new jsdto();
		ObjectMapper mapper = new ObjectMapper();
		dto.setData("irhwquierhweiuhf");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "ttttt";
	}

	 @RequestMapping(value="/getUserMsg",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
		
		public @ResponseBody String getUserMsg(@CookieValue(value="sessionId") String sessionId,HttpServletRequest request) throws JsonProcessingException
		{
			Usermsg user1=new Usermsg();
			jsdto dto = new jsdto();
			Integer userId;
			 ObjectMapper mapper = new ObjectMapper(); 
			try
			{
				userId = Tokenmg.getUserdbId(sessionId);
				user1=userservice.returnUserById(userId);
				dto.data = user1;
				return mapper.writeValueAsString(dto);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			dto.code = "101";
			return mapper.writeValueAsString(dto);
			} 
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	
	public @ResponseBody String loginUser(@RequestBody User user,HttpServletResponse response) throws JsonProcessingException
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
		String sdtId = user1.getStuid();
			if (dbid!=null)
		{
            //把用户登录信息放进Session
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("dbid", dbid);
        loginInfo.put("username", user.getUsername());
        loginInfo.put("monitor", user1.getMonitor());
        loginInfo.put("time", System.currentTimeMillis()+14400000);
        String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
        Cookie cookie = new Cookie("sdtId", sdtId);
        cookie.setMaxAge(6048000);
    	response.addCookie(cookie);
    	Cookie cookie1 = new Cookie("sessionId", sessionId);
    	cookie1.setMaxAge(604800);
    	response.addCookie(cookie1);
        redis.inserttoken(sessionId, user.getUsername()); 
        dto.setData(user1);
			return mapper.writeValueAsString(dto);
		} else
		{
			dto.setCode("-1");
			dto.setMsg("登陆失败");
			Cookie cookie = new Cookie("sdtId", null);
			cookie.setMaxAge(0);
	    	response.addCookie(cookie);
	    	Cookie cookie1 = new Cookie("sessionId", null);
			cookie1.setMaxAge(0);
	    	response.addCookie(cookie1);
			return mapper.writeValueAsString(dto);
		}
	}
	
@RequestMapping(value="/register",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	
	public @ResponseBody String register(@RequestBody User user,HttpServletResponse response) throws JsonProcessingException
	{
		User user1=new User();
		jsdto dto = new jsdto();
		user.setMonitor(1);
		user.setImgpath("/static/img/default.jpg");
		 ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			user1=userservice.Userzc(user);			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		Integer dbid=user1.getDbid();
		String sdtId = user1.getStuid();
			if (dbid!=null)
		{
            //把用户登录信息放进Session
        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("dbid", dbid);
        loginInfo.put("username", user.getUsername());
        loginInfo.put("monitor", 1);
        loginInfo.put("time", System.currentTimeMillis()+14400000);
        String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
        Cookie cookie = new Cookie("sdtId", sdtId);
        cookie.setMaxAge(6048000);
    	response.addCookie(cookie);
    	Cookie cookie1 = new Cookie("sessionId", sessionId);
    	cookie1.setMaxAge(6048000);
    	response.addCookie(cookie1);
         redis.inserttoken(sessionId, user.getUsername()); 
         dto.setData(user1);
			return mapper.writeValueAsString(dto);
		} else
		{
			dto.setCode("-1");
			dto.setMsg("注册失败");
			Cookie cookie = new Cookie("sdtId", null);
			cookie.setMaxAge(0);
	    	response.addCookie(cookie);
	    	Cookie cookie1 = new Cookie("sessionId", null);
			cookie1.setMaxAge(0);
	    	response.addCookie(cookie1);
			return mapper.writeValueAsString(dto);
		}
	}



@RequestMapping(value="/putgz",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
public @ResponseBody String putGz(@CookieValue(value="sessionId") String sessionId, Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	Integer userId;
	Guanzhuform guanzhuform=new Guanzhuform();	
	ObjectMapper mapper = new ObjectMapper(); 
	try
	{
		userId = Tokenmg.getUserdbId(sessionId);
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
public @ResponseBody String delGz(@CookieValue(value="sessionId") String sessionId, Integer bgzzid,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	Integer userId;
	Guanzhuform guanzhuform=new Guanzhuform();	
	ObjectMapper mapper = new ObjectMapper(); 
	try
	{
		userId = Tokenmg.getUserdbId(sessionId);
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
public @ResponseBody String getGz(@CookieValue(value="sessionId") String sessionId, HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	Integer userId;	
	ObjectMapper mapper = new ObjectMapper();
	List<Integer> gzList;
	try
	{
		userId = Tokenmg.getUserdbId(sessionId);
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
public @ResponseBody String getUsermessage(@RequestParam("userids") Integer[] userids) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	List<simpleUser> userList;
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
@RequestMapping(value="/changeimg",method=RequestMethod.POST)
public @ResponseBody String changeImg(@CookieValue(value="sessionId") String sessionId,@RequestParam("file")MultipartFile file,HttpServletRequest request,Model model) throws IOException
{
	String username;
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	if(!file.isEmpty())
	{
		String realPath = request.getSession().getServletContext().getRealPath("/static/img");
		try
		{
			username = Tokenmg.getUsername(sessionId);
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
			userxgxx.setDbid(Tokenmg.getUserdbId(sessionId));
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
public @ResponseBody String updateNick(@CookieValue(value="sessionId") String sessionId,String nickname,HttpServletRequest request) throws JsonProcessingException
{
	jsdto dto = new jsdto();
	ObjectMapper mapper = new ObjectMapper();
	try
	{
		Integer userid=Tokenmg.getUserdbId(sessionId);
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
public @ResponseBody String updatePaswd(@RequestBody Userxgxx userxgxx) throws JsonProcessingException
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

