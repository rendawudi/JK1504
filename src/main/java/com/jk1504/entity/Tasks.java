package com.jk1504.entity;

public class Tasks {
		private Integer dbid;
		private Integer numnow;
		private Integer taskid;			//��������Ϣ��Ӧdbid,������Ϣ��Ӧtaskid
		private String taskjson;		//json��ʽ����ֱ�Ӵ���
		
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
