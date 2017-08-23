package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.Articles;

public interface Articleservicejk
{
	public boolean tjwz(Articles articles);
	public boolean scwz(Articles articles);
	public List<Articles> dqwztime();
	public List<Articles> dqwzredu();
	public String dqwz(Integer articleid);
}
