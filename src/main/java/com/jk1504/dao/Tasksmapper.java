package com.jk1504.dao;

import java.util.List;

import com.jk1504.entity.Ceshi;
import com.jk1504.entity.CeshiSearch;
import com.jk1504.entity.Daan;
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;

public interface Tasksmapper {
	public int inserttask(Tasks tasks) throws Exception;
	public int insertceshi(Ceshi ceshi) throws Exception;
	public List<Tasks> returntask(Integer dbid) throws Exception;
	public int deletetask(Tasks tasks) throws Exception;
	public int deleteceshi(Tasks tasks) throws Exception;
	public int deletetasksbyowner(Tasks tasks)throws Exception;
	public int insertdaan(Daan daan) throws Exception;
	public Ceshi returnceshipercent(Integer timuid) throws Exception;
	public int inupdatetasks(Ceshi ceshi) throws Exception;
	public int deletetasks(Daan daan) throws Exception;
	public List<Tasks> returntasks() throws Exception;
	public List<Integer> returnceshitimu(CeshiSearch ceshiSearch) throws Exception;
	public Ceshi returnceshi(Integer timuid);
	public List<Daan> returndaan(Daan daan) throws Exception;
	public List<Ceshi> returnceshitop(Ceshi ceshi) throws Exception;
	public int updatedaan(Daan daan) throws Exception;
}

