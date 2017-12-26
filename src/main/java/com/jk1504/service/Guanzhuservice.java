package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Guanzhumapper;
import com.jk1504.entity.Guanzhuform;
@Service
public class Guanzhuservice implements Guanzhuseivicejk
{
	@Autowired
	private Guanzhumapper guanzhumapper;
	
	@Override
	public boolean ingz(Guanzhuform guanzhuform)
	{
		try
		{
			int boolgz=guanzhumapper.ingz(guanzhuform);
			if (boolgz<=0)
			{
				return false;
			} else
			{
				guanzhumapper.inupdateusergz(guanzhuform.getBgzzdbid());
				return true;
			}
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Integer> tuisong(Integer bgzzdbid)
	{
		List<Integer> gzzids=new ArrayList<Integer>();
		try
		{
			gzzids=guanzhumapper.tuisong(bgzzdbid);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return gzzids;
	}

	@Override
	public List<Integer> duqugz(Integer gzzdbid)
	{
		List<Integer> gzzids=new ArrayList<Integer>();
		try
		{
			gzzids=guanzhumapper.searchgz(gzzdbid);
			} catch (Exception e)
		{
			e.printStackTrace();
		}
		return gzzids;
	}

	@Override
	public boolean qxgz(Guanzhuform guanzhuform)
	{
		try
		{
			int boolgz=guanzhumapper.deletegz(guanzhuform);
			if (boolgz<=0)
			{
				return false;
			} else
			{
				guanzhumapper.deupdateusergz(guanzhuform.getBgzzdbid());
				return true;
			}
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

}
