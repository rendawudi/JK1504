package com.jk1504.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk1504.entity.Articles;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.service.Articleservice;

@Controller
@RequestMapping(value="/function")
public class articlecontroller
{
	@Autowired
	private Articleservice articleservice;
	
	@RequestMapping(value="/article/putarticle",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String putArticle(@CookieValue(value="sessionId") String sessionId,@RequestBody Articles articles,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(sessionId);
			articles.setDbid(userId);
			 Date dt = new Date(); 
			articles.setFbtime(dt);
			if (articleservice.tjwz(articles))
			{
				dto.setMsg("���·����ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("���·���ʧ��");
			}
			dto.setData(articles); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("���·���ʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/article/delarticle",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String delArticle(@CookieValue(value="sessionId") String sessionId,@RequestBody Articles articles,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(sessionId);
			articles.setDbid(userId);
			if (articleservice.scwz(articles))
			{
				dto.setMsg("����ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("����ɾ��ʧ��");
			}
			dto.setData(articles); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("����ɾ��ʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/article/getarticle",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String getArticle(@CookieValue(value="sessionId") String sessionId,@RequestParam Integer stateid,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		List<Articles> articles;
		try
		{
			userId = Tokenmg.getUserdbId(sessionId);
			if (stateid.equals(0))//0ʱ������   1�ȶ�����
			{
				articles=articleservice.dqwztime(userId);
			}
			else
			{
				articles=articleservice.dqwzredu(userId);
			}
			dto.setData(articles); 
			dto.setMsg("���¶�ȡ�ɹ�");
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("���¶�ȡʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/article/goodarticle",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String goodArticle(@CookieValue(value="sessionId") String sessionId,@RequestParam Integer articleid,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId=Tokenmg.getUserdbId(sessionId);
			if (articleservice.dzwz(articleid,userId))
			{
			return mapper.writeValueAsString(dto);				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("���µ���ʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/article/degoodarticle",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String degoodArticle(@CookieValue(value="sessionId") String sessionId,@RequestParam Integer articleid,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId=Tokenmg.getUserdbId(sessionId);
			if (articleservice.qxdzwz(articleid,userId))
			{
			return mapper.writeValueAsString(dto);				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("����ȡ������ʧ��");
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
