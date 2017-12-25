package com.jk1504.entity;


public class Tasks {
		private Integer dbid;
		private String taskname;
		private Integer taskid;			//发布人信息对应dbid,任务信息对应taskid
		public Integer getDbid()
		{
			return dbid;
		}
		public void setDbid(Integer dbid)
		{
			this.dbid = dbid;
		}
		public String getTaskname()
		{
			return taskname;
		}
		public void setTaskname(String taskname)
		{
			this.taskname = taskname;
		}
		public Integer getTaskid()
		{
			return taskid;
		}
		public void setTaskid(Integer taskid)
		{
			this.taskid = taskid;
		}

		
		
}
