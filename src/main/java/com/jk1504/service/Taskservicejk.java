package com.jk1504.service;

import java.util.List;


import com.jk1504.entity.Ceshi;
import com.jk1504.entity.DaanPut;
import com.jk1504.entity.TaskPut;
import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.jk1504.exception.taskwcrsexception;
import com.jk1504.exception.taskxgexception;

public interface Taskservicejk {
	public boolean faburenwu(TaskPut taskPut);
	public List<Tasks> yjfbrenwu(Integer dbid);
	public boolean scfbrenwu(Tasks tasks);
	public boolean wcrenwu(DaanPut daanPut)throws taskwcrsexception,taskxgexception;
	public boolean csrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception;
	public List<Ceshi>fbhdrenwu(Integer type,Integer taskid, Integer num);
	public List<Tasks> geTasks()throws Exception;
}