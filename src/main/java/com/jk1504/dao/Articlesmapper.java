package com.jk1504.dao;

import java.util.List; 

import com.jk1504.entity.Articles;


public interface Articlesmapper {
	public int insertarticle(Articles articles) throws Exception;
	public int deletearticle(Articles articles) throws Exception;
	public List<Articles> returnarticlesrd() throws Exception;
	public List<Articles> returnarticlestm() throws Exception;
	public String returnneirong(Integer articleid) throws Exception;
	public int deupdateredu(Integer articleid) throws Exception;
}
