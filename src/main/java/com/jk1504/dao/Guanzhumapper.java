package com.jk1504.dao;

import java.util.List;

import com.jk1504.entity.Guanzhuform;

public interface Guanzhumapper {
	public int ingz(Guanzhuform guanzhuform) throws Exception;
	public int inupdateusergz(Integer dbid) throws Exception;
	public List<Integer> tuisong(Integer bgzzdbid) throws Exception;
	public List<Integer> searchgz(Integer gzzdbid) throws Exception;
	public int deletegz(Guanzhuform guanzhuform) throws Exception;
	public int deupdateusergz(Integer dbid) throws Exception;
}
