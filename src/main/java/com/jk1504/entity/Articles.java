package com.jk1504.entity;

import java.util.Date;

public class Articles {
		private String author;				//�����ǳ�
		private String name;				//��������
		private Integer dbid;				//����dbid
		private Integer articleid;			//����id
		private String articlecontent;		//��������
		private Date fbtime;
		private Integer redu;
		
		public Date getFbtime() {
			return fbtime;
		}
		public void setFbtime(Date fbtime) {
			this.fbtime = fbtime;
		}
		public Integer getRedu() {
			return redu;
		}
		public void setRedu(Integer redu) {
			this.redu = redu;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Integer getDbid() {
			return dbid;
		}
		public void setDbid(Integer dbid) {
			this.dbid = dbid;
		}
		public Integer getArticleid() {
			return articleid;
		}
		public void setArticleid(Integer articleid) {
			this.articleid = articleid;
		}
		public String getArticlecontent() {
			return articlecontent;
		}
		public void setArticlecontent(String articlecontent) {
			this.articlecontent = articlecontent;
		}
		
}
