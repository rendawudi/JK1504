package com.jk1504.entity;

public class Joinparty {
	private Integer sfjoinp;
	private Integer taskid;			//任务id
	private Integer dbid;			//参与者dbid
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public Integer getDbid() {
		return dbid;
	}
	public void setDbid(Integer dbid) {
		this.dbid = dbid;
	}
	public Integer getSfjoinp()
	{
		return sfjoinp;
	}
	public void setSfjoinp(Integer sfjoinp)
	{
		this.sfjoinp = sfjoinp;
	}
	
}
