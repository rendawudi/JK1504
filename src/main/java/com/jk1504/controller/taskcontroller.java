package com.jk1504.controller;

import java.util.ArrayList;
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
import com.jk1504.entity.Ceshi;
import com.jk1504.entity.DaanPut;
import com.jk1504.entity.TaskPut;
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.jk1504.entity.jsdto;
import com.jk1504.fuzhu.Tokenmg;
import com.jk1504.service.Taskservice;

@Controller
@RequestMapping(value="/function")
public class taskcontroller
{
	@Autowired
	private Taskservice taskservice;
	
	@RequestMapping(value="/task/gettaskbymonitor",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String taskGet(@CookieValue(value="sessionId") String sessionId,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(sessionId);
			List<Tasks> tasks=taskservice.yjfbrenwu(userId);
			
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("获取任务失败");
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
	public @ResponseBody String taskFb(@CookieValue(value="sessionId") String sessionId,@RequestBody TaskPut taskPut,HttpServletRequest request) throws Exception
	{
		jsdto dto = new jsdto();
		Integer userId = Tokenmg.getUserdbId(sessionId);
		taskPut.getTasks().setDbid(userId);
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			if (taskservice.faburenwu(taskPut))
			{
				dto.setMsg("任务发布成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("任务发布失败");
			}
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("任务发布失败");
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
	public @ResponseBody String taskSc(@CookieValue(value="sessionId") String sessionId,@RequestBody Tasks tasks,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(sessionId);
			tasks.setDbid(userId);
			if (taskservice.scfbrenwu(tasks))
			{
				dto.setMsg("任务删除成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("任务删除失败");
			}
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("任务删除失败");
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
	public @ResponseBody String taskWc(@CookieValue(value="sessionId") String sessionId,@RequestBody DaanPut daanPut,HttpServletRequest request) throws Exception
	{
		jsdto dto = new jsdto();
		Integer userId = Tokenmg.getUserdbId(sessionId);
		daanPut.getUsertask().setDbid(userId);
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			
			if (taskservice.wcrenwu(daanPut))
			{
				dto.setMsg("任务提交成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("任务提交失败");
			}
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("任务提交失败");
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
	public @ResponseBody String scTask(@CookieValue(value="sessionId") String sessionId,@RequestBody Usertask usertask,HttpServletRequest request)
	{
		jsdto dto = new jsdto();
		Integer userId;
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			userId = Tokenmg.getUserdbId(sessionId);
			usertask.setDbid(userId);
			if (taskservice.csrenwu(usertask))
			{
				dto.setMsg("任务删除成功");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("任务删除失败");
			}
			dto.setData(usertask); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("任务提交失败");
		try
		{
			return mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return "false";
	}
	
	@RequestMapping(value="/task/getceshi",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public @ResponseBody String getceshi(@RequestParam(value="taskid", required = false)Integer taskid)
	{
		jsdto dto = new jsdto();
		ObjectMapper mapper = new ObjectMapper(); 
		List<Ceshi> task = new ArrayList<>();
		try
		{
			List<Ceshi> tasks=taskservice.fbhdrenwu(0,taskid,30);
			List<Ceshi> tasks1=taskservice.fbhdrenwu(1,taskid,30);
			List<Ceshi> tasks2=taskservice.fbhdrenwu(2,taskid,30);
			task.addAll(tasks2);
			task.addAll(tasks1);
			task.addAll(tasks);
			dto.setData(task); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("任务获取失败");
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
	public @ResponseBody String getTask()
	{
		jsdto dto = new jsdto();
		ObjectMapper mapper = new ObjectMapper(); 
		try
		{
			List<Tasks> tasks=taskservice.geTasks();
			dto.setData(tasks); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("任务获取失败");
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
