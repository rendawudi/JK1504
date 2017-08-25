<<<<<<< HEAD
package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jk1504.dao.Tasksmapper;
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.js1504.exception.taskwcrsexception;
import com.js1504.exception.taskxgexception;

@Service
public class Taskservice implements Taskservicejk{
	@Autowired
	private Tasksmapper taskmapper;
	
	@Override
	public boolean faburenwu(Tasks tasks) {
		try {
			int boolpd=taskmapper.inserttask(tasks);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Tasks> yjfbrenwu(Integer dbid) {
		List<Tasks> list=new ArrayList<Tasks>();
		try {
		list=taskmapper.returntask(dbid);
			
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean scfbrenwu(Tasks tasks) {
		try {
			int boolpd=taskmapper.deletetask(tasks);
			taskmapper.deletetasksbyowner(tasks);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean wcrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=taskmapper.inserttasks(usertask);
			if (boolpd<=0) {
				throw new taskxgexception("Ìá½»ÈÎÎñÊ§°Ü");
			}
			else
			{
				int boww=taskmapper.inupdatetasks(usertask.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("Ôö¼ÓÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÌá½»´íÎó"+e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean csrenwu(Usertask usertask) throws taskwcrsexception,taskxgexception{
		try {
			int boolpd=taskmapper.deletetasks(usertask);
			if (boolpd<=0) {
				throw new taskxgexception("É¾³ıÈÎÎñÊ§°Ü");
			}
			else
			{
				int boww=taskmapper.deupdatetasks(usertask.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("¼õÉÙÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÉ¾³ı´íÎó"+e.getMessage());
		}
	}

	@Override
	public List<Tasks> fbhdrenwu(Integer stateid, Integer dbid) {
		List<Tasks> alltasks=new ArrayList<Tasks>();
		try {
			alltasks=taskmapper.returntasks();
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		if (alltasks.isEmpty()) {
			return alltasks;
		}
		if (stateid.equals(0)) {
			return alltasks;
		}
		List<Tasks> wwctasks=new ArrayList<Tasks>();
		List<Tasks> ywctasks=new ArrayList<Tasks>();
			for(Tasks tasks:alltasks)
			{
				Usertask t1=new Usertask();
				Usertask tasks2=new Usertask();
				t1.setTaskid(tasks.getTaskid());
				t1.setDbid(dbid);
				try 
				{
					tasks2=taskmapper.returntaskssx(t1);
					if (tasks2.getTaskcomplete().equals(0)) 
					{
						wwctasks.add(tasks);
					} else {
						ywctasks.add(tasks);
					}
				} catch (Exception e) 
				{
					// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
					e.printStackTrace();
				}
				
			}
		if (stateid.equals(1)) 
		{
			return wwctasks;
		}
		
		if (stateid.equals(2)) 
		{
			return ywctasks;
		}
		return alltasks;
	}
}
=======
package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jk1504.dao.Tasksmapper;
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.jk1504.exception.taskwcrsexception;
import com.jk1504.exception.taskxgexception;

@Service
public class Taskservice implements Taskservicejk{
	@Autowired
	private Tasksmapper taskmapper;
	
	@Override
	public boolean faburenwu(Tasks tasks) {
		try {
			int boolpd=taskmapper.inserttask(tasks);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Tasks> yjfbrenwu(Integer dbid) {
		List<Tasks> list=new ArrayList<Tasks>();
		try {
		list=taskmapper.returntask(dbid);
			
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean scfbrenwu(Tasks tasks) {
		try {
			int boolpd=taskmapper.deletetask(tasks);
			taskmapper.deletetasksbyowner(tasks);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean wcrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=taskmapper.inserttasks(usertask);
			if (boolpd<=0) {
				throw new taskxgexception("Ìá½»ÈÎÎñÊ§°Ü");
			}
			else
			{
				int boww=taskmapper.inupdatetasks(usertask.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("Ôö¼ÓÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÌá½»´íÎó"+e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean csrenwu(Usertask usertask) throws taskwcrsexception,taskxgexception{
		try {
			int boolpd=taskmapper.deletetasks(usertask);
			if (boolpd<=0) {
				throw new taskxgexception("É¾³ıÈÎÎñÊ§°Ü");
			}
			else
			{
				int boww=taskmapper.deupdatetasks(usertask.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("¼õÉÙÈËÊıÊ§°Ü");
				}
				else
				{
					return true;
				}
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			throw new taskxgexception("ÈÎÎñÉ¾³ı´íÎó"+e.getMessage());
		}
	}

	@Override
	public List<Tasks> fbhdrenwu(Integer stateid, Integer dbid) {
		List<Tasks> alltasks=new ArrayList<Tasks>();
		try {
			alltasks=taskmapper.returntasks();
		} catch (Exception e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		if (alltasks.isEmpty()) {
			return alltasks;
		}
		if (stateid.equals(0)) {
			return alltasks;
		}
		List<Tasks> wwctasks=new ArrayList<Tasks>();
		List<Tasks> ywctasks=new ArrayList<Tasks>();
			for(Tasks tasks:alltasks)
			{
				Usertask t1=new Usertask();
				Usertask tasks2=new Usertask();
				t1.setTaskid(tasks.getTaskid());
				t1.setDbid(dbid);
				try 
				{
					tasks2=taskmapper.returntaskssx(t1);
					if (tasks2.getTaskcomplete().equals(0)) 
					{
						wwctasks.add(tasks);
					} else {
						ywctasks.add(tasks);
					}
				} catch (Exception e) 
				{
					// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
					e.printStackTrace();
				}
				
			}
		if (stateid.equals(1)) 
		{
			return wwctasks;
		}
		
		if (stateid.equals(2)) 
		{
			return ywctasks;
		}
		return alltasks;
	}
}
>>>>>>> parent of 9adc572... Revert "ä¿®å¤äº†qqå·ï¼Œç”µè¯å·ï¼Œå­¦å·æ•°æ®æº¢å‡ºã€‚"
