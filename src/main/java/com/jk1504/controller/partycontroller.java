<<<<<<< HEAD
<<<<<<< HEAD
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
		dto.setMsg("��ȡ�ʧ��");
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
				dto.setMsg("������ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�����ʧ��");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�����ʧ��");
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
				dto.setMsg("�ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�ɾ��ʧ��");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�ɾ��ʧ��");
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
				dto.setMsg("��ύ�ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("��ύʧ��");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("��ύʧ��");
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
				dto.setMsg("�ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�ɾ��ʧ��");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�ɾ��ʧ��");
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
		dto.setMsg("���ȡʧ��");
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
=======
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
		dto.setMsg("��ȡ�ʧ��");
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
				dto.setMsg("������ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�����ʧ��");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�����ʧ��");
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
				dto.setMsg("�ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�ɾ��ʧ��");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�ɾ��ʧ��");
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
				dto.setMsg("��ύ�ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("��ύʧ��");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("��ύʧ��");
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
				dto.setMsg("�ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�ɾ��ʧ��");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�ɾ��ʧ��");
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
		dto.setMsg("���ȡʧ��");
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
>>>>>>> parent of 08ac5ad... 修复了qq号，电话号，学号数据溢出。
=======
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
@RequestMapping(value="/function")
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
		dto.setMsg("��ȡ�ʧ��");
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
				dto.setMsg("������ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�����ʧ��");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�����ʧ��");
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
				dto.setMsg("�ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�ɾ��ʧ��");
			}
			dto.setData(party); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�ɾ��ʧ��");
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
				dto.setMsg("��ύ�ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("��ύʧ��");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("��ύʧ��");
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
				dto.setMsg("�ɾ���ɹ�");
			} else
			{
				dto.setCode("-1");
				dto.setMsg("�ɾ��ʧ��");
			}
			dto.setData(joinparty); 
			return mapper.writeValueAsString(dto);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		dto.setCode("-1");
		dto.setMsg("�ɾ��ʧ��");
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
		dto.setMsg("���ȡʧ��");
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
>>>>>>> parent of 9adc572... Revert "修复了qq号，电话号，学号数据溢出。"
