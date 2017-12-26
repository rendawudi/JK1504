package com.jk1504.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class User {
	private String username;		//用户名
	private String nickname;   //昵称
	private String password;	//密码
	private String xingming;		//学生姓名
	private String stuid;			//学号
	private Integer dbid;			//数据库关联id
	private String imgpath; 		//头像路径
	private String qqid;			//QQ号
	private String phone;			//手机号
	private Integer monitor;		//是否为班委
	private Integer guanzhuliang;//用户自己的关注量
	private String userclass;			//班级
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public Integer getDbid() {
		return dbid;
	}
	public void setDbid(Integer dbid) {
		this.dbid = dbid;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getQqid() {
		return qqid;
	}
	public void setQqid(String qqid) {
		this.qqid = qqid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getMonitor() {
		return monitor;
	}
	public void setMonitor(Integer monitor) {
		this.monitor = monitor;
	}
	public Integer getGuanzhuliang() {
		return guanzhuliang;
	}
	public void setGuanzhuliang(Integer guanzhuliang) {
		this.guanzhuliang = guanzhuliang;
	}
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
