package com.jk1504.entity;

public class Party {
	private Integer dbid;
	private String taskname;
	private String taskcontent;
	private Integer taskid;
	private Integer num;				//人数限制
	private Integer numnow;				//当前人数
	private boolean xingmingrst;		//是否需要姓名
	private boolean stuidrst;			//是否需要学号
	private boolean qqidrst;			//是否需要QQ号
	private boolean phonerst;			//是否需要手机号
	private boolean classrst;
	//是否需要班级名字
	
	public String getTaskname() {
		return taskname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getNumnow() {
		return numnow;
	}
	public void setNumnow(Integer numnow) {
		this.numnow = numnow;
	}
	public Integer getDbid() {
		return dbid;
	}
	public void setDbid(Integer dbid) {
		this.dbid = dbid;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskcontent() {
		return taskcontent;
	}
	public void setTaskcontent(String taskcontent) {
		this.taskcontent = taskcontent;
	}
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public boolean isXingmingrst() {
		return xingmingrst;
	}
	public void setXingmingrst(boolean xingmingrst) {
		this.xingmingrst = xingmingrst;
	}
	public boolean isStuidrst() {
		return stuidrst;
	}
	public void setStuidrst(boolean stuidrst) {
		this.stuidrst = stuidrst;
	}
	public boolean isQqidrst() {
		return qqidrst;
	}
	public void setQqidrst(boolean qqidrst) {
		this.qqidrst = qqidrst;
	}
	public boolean isPhonerst() {
		return phonerst;
	}
	public void setPhonerst(boolean phonerst) {
		this.phonerst = phonerst;
	}
	public boolean isClassrst() {
		return classrst;
	}
	public void setClassrst(boolean classrst) {
		this.classrst = classrst;
	}
	
}
