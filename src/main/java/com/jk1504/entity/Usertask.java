package com.jk1504.entity;

/*
 * �û������б���ʾ���û��������ɺ��ύ
 * 
 */
public class Usertask {
	private Integer dbid;		
	private Integer taskid;
	private Integer taskcomplete;//0��δ�������
	
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
