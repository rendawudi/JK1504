package com.jk1504.entity;

public class Tasks {
		private Integer dbid;
		private Integer numnow;
		private Integer taskid;			//��������Ϣ��Ӧdbid,������Ϣ��Ӧtaskid
		private String taskjson;		//json��ʽ����ֱ�Ӵ���
		private String nickname;
		private String imgpath;
		
		public String getNickname()
		{
			return nickname;
		}
		public void setNickname(String nickname)
		{
			this.nickname = nickname;
		}
		public String getImgpath()
		{
			return imgpath;
		}
		public void setImgpath(String imgpath)
		{
			this.imgpath = imgpath;
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
		public String getTaskjson() {
			return taskjson;
		}
		public void setTaskjson(String taskjson) {
			this.taskjson = taskjson;
		}
		public Integer getTaskid() {
			return taskid;
		}
		public void setTaskid(Integer taskid) {
			this.taskid = taskid;
		}
		
		
}
