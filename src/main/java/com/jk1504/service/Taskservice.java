package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jk1504.dao.Tasksmapper;
import com.jk1504.entity.Ceshi;
import com.jk1504.entity.CeshiSearch;
import com.jk1504.entity.Daan;
import com.jk1504.entity.DaanPut;
import com.jk1504.entity.TaskPut;
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.jk1504.exception.taskwcrsexception;
import com.jk1504.exception.taskxgexception;

@Service
public class Taskservice implements Taskservicejk{
	@Autowired
	private Tasksmapper taskmapper;
	
	@Override
	public boolean faburenwu(TaskPut taskPut) {
		try {
			int boolpd=taskmapper.inserttask(taskPut.getTasks());
			if (boolpd<=0) {
				return false;
			}
			else
			{
				for(Ceshi i : taskPut.getCeshis())
				{
					i.setTaskid(taskPut.getTasks().getTaskid());
					taskmapper.insertceshi(i);
				}
				return true;
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean wcrenwu(DaanPut daanPut)throws taskwcrsexception,taskxgexception {
		try {
			int boolpd=taskmapper.inserttasks(daanPut.getUsertask());
			if (boolpd<=0) {
				throw new taskxgexception("�ύ����ʧ��");
			}
			else
			{
				for(Daan daan : daanPut.getDaans())
				{
					daan.setId(daanPut.getUsertask().getDbid());
					taskmapper.insertdaan(daan);
				}
				return true;
			}
		} 
		catch (taskwcrsexception e1) {
			throw e1;
		}
		catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			throw new taskxgexception("�����ύ����"+e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean csrenwu(Usertask usertask) throws taskwcrsexception,taskxgexception{
		try {
			int boolpd=taskmapper.deletetasks(usertask);
			if (boolpd<=0) {
				throw new taskxgexception("ɾ������ʧ��");
			}
			else
			{
				int boww=taskmapper.deupdatetasks(usertask.getTaskid());
				if (boww<0) {
					throw new taskwcrsexception("��������ʧ��");
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
			// TODO �Զ����ɵ� catch ��
			throw new taskxgexception("����ɾ������"+e.getMessage());
		}
	}

	@Override
	public List<Ceshi> fbhdrenwu(Integer type,Integer taskid, Integer num) {
		List<Ceshi> alltasks=new ArrayList<Ceshi>();
		CeshiSearch ceshiSearch = new CeshiSearch();
		ceshiSearch.setNum(num);
		ceshiSearch.setTaskid(taskid);
		ceshiSearch.setType(type);
		try {
			alltasks=taskmapper.returnceshis(ceshiSearch);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return alltasks;
	}

	@Override
	public List<Tasks> geTasks() throws Exception
	{
		// TODO �Զ����ɵķ������
		return taskmapper.returntasks();
	}
}
