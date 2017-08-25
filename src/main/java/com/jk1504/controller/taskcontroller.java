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
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.service.Taskservice;

@Controller
@RequestMapping(value="/user")
public class taskcontroller
{
	@Autowired
	private Taskservice taskservice;
	
	@RequestMapping(value="/task/gettaskbymonitor",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String taskget(HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			List<Tasks> tasks=taskservice.yjfbrenwu(userId);
			
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("��ȡ����ʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/puttaskbymonitor",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String taskfb(@RequestBody Tasks tasks,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			tasks.setDbid(userId);
			if (taskservice.faburenwu(tasks))
			{
				dto.setMsg("���񷢲��ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("���񷢲�ʧ��");
			}
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("���񷢲�ʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
		
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/deltaskbymonitor",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String tasksc(@RequestBody Tasks tasks,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			tasks.setDbid(userId);
			if (taskservice.scfbrenwu(tasks))
			{
				dto.setMsg("����ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("����ɾ��ʧ��");
			}
			dto.setData(tasks); 
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
	
	@RequestMapping(value="/task/finishtask",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String taskwc(@RequestBody Usertask usertask,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			usertask.setDbid(userId);
			if (taskservice.wcrenwu(usertask))
			{
				dto.setMsg("�����ύ�ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�����ύʧ��");
			}
			dto.setData(usertask); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�����ύʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
		
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/deltask",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String sctask(@RequestBody Usertask usertask,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			usertask.setDbid(userId);
			if (taskservice.csrenwu(usertask))
			{
				dto.setMsg("����ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("����ɾ��ʧ��");
			}
			dto.setData(usertask); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�����ύʧ��");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/gettask",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String gettask(@RequestBody Integer stateid,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(request);
			List<Tasks> tasks=taskservice.fbhdrenwu(stateid,userId);
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�����ȡʧ��");
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