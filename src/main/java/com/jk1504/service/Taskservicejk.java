<<<<<<< HEAD
package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.js1504.exception.taskwcrsexception;
import com.js1504.exception.taskxgexception;

public interface Taskservicejk {
	public boolean faburenwu(Tasks tasks);
	public List<Tasks> yjfbrenwu(Integer dbid);
	public boolean scfbrenwu(Tasks tasks);
	public boolean wcrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception;
	public boolean csrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception;
	public List<Tasks>fbhdrenwu(Integer stateid,Integer dbid);
}
=======
package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.Tasks;
import com.jk1504.entity.Usertask;
import com.jk1504.exception.taskwcrsexception;
import com.jk1504.exception.taskxgexception;

public interface Taskservicejk {
	public boolean faburenwu(Tasks tasks);
	public List<Tasks> yjfbrenwu(Integer dbid);
	public boolean scfbrenwu(Tasks tasks);
	public boolean wcrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception;
	public boolean csrenwu(Usertask usertask)throws taskwcrsexception,taskxgexception;
	public List<Tasks>fbhdrenwu(Integer stateid,Integer dbid);
}
>>>>>>> parent of 9adc572... Revert "修复了qq号，电话号，学号数据溢出。"
