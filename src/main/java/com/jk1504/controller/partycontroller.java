package com.jk1504.controller;

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
import com.jk1504.entity.Joinparty;
import com.jk1504.entity.Party;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.service.Partyservice;

@Controller
@RequestMapping(value="/user")
public class partycontroller
{
	@Autowired
	private Partyservice partyservice;
	
	@RequestMapping(value="/task/getpartybymonitor",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String partyget(HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			List<Party> tasks=partyservice.yjfbParty(userId);
			
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("获取活动失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/putpartybymonitor",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String partyfb(@RequestBody Party party,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			party.setDbid(userId);
			if (partyservice.fabuParty(party))
			{
				dto.setMsg("活动发布成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("活动发布失败");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("活动发布失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
		
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/delpartybymonitor",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String partysc(@RequestBody Party party,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			party.setDbid(userId);
			if (partyservice.scfbParty(party))
			{
				dto.setMsg("活动删除成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("活动删除失败");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("活动删除失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
		
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/finishparty",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String partywc(@RequestBody Joinparty joinparty,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			joinparty.setDbid(userId);
			if (partyservice.wcParty(joinparty))
			{
				dto.setMsg("活动提交成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("活动提交失败");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("活动提交失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
		
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/delparty",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String scparty(@RequestBody Joinparty joinparty,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			joinparty.setDbid(userId);
			if (partyservice.csParty(joinparty))
			{
				dto.setMsg("活动删除成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("活动删除失败");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("活动删除失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/getparty",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String getparty(@RequestBody Integer stateid,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			List<Party> tasks=partyservice.fbhdParty(stateid, userId);
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("活动获取失败");
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
