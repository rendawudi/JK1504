package com.jk1504.entity;

public class Tasks {
		private Integer dbid;
		private Integer numnow;
		private Integer taskid;			//发布人信息对应dbid,任务信息对应taskid
		private String taskjson;		//json格式数据直接储存
		
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
