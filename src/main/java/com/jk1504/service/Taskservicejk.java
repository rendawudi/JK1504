package com.jk1504.service;

import java.util.List;


import com.jk1504.entity.*;
import com.jk1504.exception.taskwcrsexception;
import com.jk1504.exception.taskxgexception;

public interface Taskservicejk {
	public boolean faburenwu(TaskPut taskPut);
	public List<Tasks> yjfbrenwu(Integer dbid);
	public boolean scfbrenwu(Tasks tasks);
	public boolean wcrenwu(DaanPut daanPut)throws Exception;
	public boolean csrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception;
	public List<Ceshi>fbhdrenwu(Integer type,Integer taskid, Integer num);
	public List<Tasks> geTasks()throws Exception;
	public List<Ceshi> getCeshiTop(Integer taskid) throws Exception;
	public List<Daan> getwcDaan(Integer stuid,Integer taskid) throws Exception;
}