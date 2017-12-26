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
	public int inserttasks(Usertask usertask) throws Exception;
	public int insertdaan(Daan daan) throws Exception;
	public int deletetasks(Usertask usertask) throws Exception;
	public Usertask returntaskssx(Usertask usertask) throws Exception;
	public List<Tasks> returntasks() throws Exception;
	public int inupdatetasks(Integer taskid) throws Exception;
	public int deupdatetasks(Integer taskid) throws Exception;
	public List<Ceshi> returnceshi(CeshiSearch ceshiSearch) throws Exception;
}
