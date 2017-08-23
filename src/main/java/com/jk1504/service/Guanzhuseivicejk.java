package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.Guanzhuform;

public interface Guanzhuseivicejk
{
	public boolean ingz(Guanzhuform guanzhuform);
	public List<Integer> tuisong(Integer bgzzdbid);
	public List<Integer> duqugz(Integer gzzdbid);
	public boolean qxgz(Guanzhuform guanzhuform);
}
