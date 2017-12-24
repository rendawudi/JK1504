package com.jk1504.dao;

import java.util.List; 

import com.jk1504.entity.Articles;
import com.jk1504.entity.usercomeon;


public interface Articlesmapper {
	public int insertarticle(Articles articles) throws Exception;
	public int deletearticle(Articles articles) throws Exception;
	public List<Articles> returnarticlesrd() throws Exception;
	public List<Articles> returnarticlestm() throws Exception;
	public int deupdateredu(Integer articleid) throws Exception;
	public int inupdateredu(Integer articleid) throws Exception;
	public int desertarticledz(usercomeon user) throws Exception;
	public int inletearticledz(usercomeon user) throws Exception;
	public List<Integer> boolarticledz(Integer dbid) throws Exception;
	public int deltearticledzbyOwner(Integer articleid) throws Exception;
}
