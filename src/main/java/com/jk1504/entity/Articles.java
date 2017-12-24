package com.jk1504.entity;

import java.util.Date;

public class Articles {
		private String author;				//作者昵称
		private String name;				//文章名字
		private Integer dbid;				//作者dbid
		private Integer articleid;			//文章id
		private String articlecontent;		//文章内容
		private Date fbtime;
		private Integer redu;
		private String nickname;
		private String imgpath;
		private boolean boolgood;
		
		
		
		public boolean getBoolgood()
		{
			return boolgood;
		}
		public void setBoolgood(boolean boolgood)
		{
			this.boolgood = boolgood;
		}
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
