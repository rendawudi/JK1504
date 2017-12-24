package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.Articles;

public interface Articleservicejk
{
	public boolean tjwz(Articles articles);
	public boolean scwz(Articles articles);
	public List<Articles> dqwztime(Integer dbid);
	public List<Articles> dqwzredu(Integer dbid);
	public boolean dzwz(Integer articleid,Integer dbid);
	public boolean qxdzwz(Integer articleid,Integer dbid);
}
