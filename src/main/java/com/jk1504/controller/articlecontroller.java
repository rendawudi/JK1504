package com.jk1504.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk1504.entity.Articles;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.service.Articleservice;

@Controller
@RequestMapping(value="/user")
public class articlecontroller
{
	@Autowired
	private Articleservice articleservice;
	
	@RequestMapping(value="/article/putarticle",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String putarticle(@RequestBody Articles articles,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			articles.setDbid(userId);
			 Date dt = new Date(); 
			articles.setFbtime(dt);
			if (articleservice.tjwz(articles))
			{
				dto.setMsg("文章发布成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("文章发布失败");
			}
			dto.setData(articles); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("文章发布失败");
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
	public @ResponseBody String delarticle(@RequestBody Articles articles,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			articles.setDbid(userId);
			if (articleservice.scwz(articles))
			{
				dto.setMsg("文章删除成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("文章删除失败");
			}
			dto.setData(articles); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("文章删除失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/article/getarticle",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String getarticle(@RequestBody Integer stateid)
	{
		jsdto dto = new jsdto();
		ObjectMapper mapper = new ObjectMapper(); 
		List<Articles> articles;
		try
		{
			if (stateid.equals(0))//0时间排序   1热度排序
			{
				articles=articleservice.dqwztime();
			}
			else
			{
				articles=articleservice.dqwzredu();
			}
			dto.setData(articles); 
			dto.setMsg("文章读取成功");
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("文章读取失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/article/getarticlecontent",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String getarticlecontent(@RequestBody Integer articleid)
	{
		jsdto dto = new jsdto();
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			String articlecontent=articleservice.dqwz(articleid);
			dto.setData(articlecontent); 
			dto.setMsg("文章内容读取成功");
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("文章内容读取失败");
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
