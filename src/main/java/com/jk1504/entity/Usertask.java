package com.jk1504.entity;

/*
 * 用户任务列表显示，用户任务的完成和提交
 *
 */
public class Usertask {
	private Integer dbid;
	private Integer taskid;
	private Integer taskcomplete;//0是未完成任务

	public Integer getTaskcomplete() {
		return taskcomplete;
	}
	public void setTaskcomplete(Integer taskcomplete) {
		this.taskcomplete = taskcomplete;
	}
	public Integer getDbid() {
		return dbid;
	}
	public void setDbid(Integer dbid) {
		this.dbid = dbid;
	}
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}


}