package com.jk1504.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.jk1504.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jk1504.dao.Tasksmapper;
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
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@Transactional
	public boolean wcrenwu(DaanPut daanPut)throws Exception {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int cuowu = 0;
			for(DaanGet daanGet : daanPut.getDaans())
			{
				Ceshi ceshi = taskmapper.returnceshipercent(daanGet.getTimuid());
				if (!daanGet.getRightdaan())
				{
					ceshi.setNum(ceshi.getNum()+1);
					ceshi.setErrornum(ceshi.getErrornum()+1);
					ceshi.setErrorpercent(ceshi.getErrornum()/ceshi.getNum());
					taskmapper.inupdatetasks(ceshi);
					cuowu++;
				}
				else
				{
					ceshi.setNum(ceshi.getNum()+1);
					ceshi.setErrorpercent(ceshi.getErrornum()/ceshi.getNum());
					taskmapper.inupdatetasks(ceshi);
				}
			}
			Daan daan = daanPut.getDaan();
			daan.setQtime(sdf.format(date));
			daan.setCorrectpercent(cuowu/daanPut.getDaans().size());//BUG:如果size只为1时，正确率可能为100
			int boolpd=taskmapper.insertdaan(daan);
			if (boolpd<=0) {
				return false;
			}
			else
			{
				return true;
			}

	}

	@Override
	@Transactional
	public boolean csrenwu(Usertask usertask) throws taskwcrsexception,taskxgexception{
		return true;
	}

	@Override
	public List<Ceshi> fbhdrenwu(Integer type,Integer taskid, Integer num)  {
		List<Integer> taskids=new ArrayList<>();
		List<Integer> suiji = new ArrayList<>();
		CeshiSearch ceshiSearch = new CeshiSearch();
		ceshiSearch.setNum(num);
		ceshiSearch.setTaskid(taskid);
		ceshiSearch.setQtype(type);


		try {
			taskids=taskmapper.returnceshitimu(ceshiSearch);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if (taskids==null||taskids.size()==0)
        {
            return null;
        }
		Taskservice.randomSet(0, taskids.size()-1, num, suiji);
        List<Ceshi> newceshis = new ArrayList<>();
		for (Integer j : suiji)
        {
            Ceshi ceshi = taskmapper.returnceshi(taskids.get(j));
            newceshis.add(ceshi);
        }

		return newceshis;
	}

	@Override
	public List<Tasks> geTasks() throws Exception
	{
		// TODO 自动生成的方法存根
		return taskmapper.returntasks();
	}

	@Override
	public List<Ceshi> getCeshiTop(Integer taskid) throws Exception {
		Ceshi ceshi = new Ceshi();
		ceshi.setTaskid(taskid);
		List<Ceshi> ceshis = taskmapper.returnceshitop(ceshi);
		return ceshis;
	}

	@Override
	public List<Daan> getwcDaan(String stuid,Integer taskid) throws Exception {
		Daan daan = new Daan();
		daan.setStuid(stuid);
		daan.setTaskid(taskid);
		List<Daan> daans = taskmapper.returndaan(daan);
		return daans;
	}

    public static void randomSet(int min, int max, int n, List<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        while (set.size()<n)
        {
            int num = (int) (Math.random() * (max - min)) + min;
            if (!set.contains(num))
            set.add(num);// 将不同的数存入HashSet中
        }
    }
}