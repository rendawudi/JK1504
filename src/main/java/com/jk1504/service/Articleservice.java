package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Articlesmapper;
import com.jk1504.entity.Articles;


@Service
public class Articleservice implements Articleservicejk
{
	@Autowired
	private Articlesmapper articlesmapper;
	
	@Override
	public boolean tjwz(Articles articles)
	{
		try
		{
			int boolgz=articlesmapper.insertarticle(articles);
			if (boolgz<=0)
			{
				return false;
			} else
			{
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
	public boolean scwz(Articles articles)
	{
		try
		{
			int boolgz=articlesmapper.deletearticle(articles);
			if (boolgz<=0)
			{
				return false;
			} else
			{
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
	public List<Articles> dqwztime()
	{
		List<Articles> list=new ArrayList<Articles>();
		try
		{
			list=articlesmapper.returnarticlestm();
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Articles> dqwzredu()
	{
		List<Articles> list=new ArrayList<Articles>();
		try
		{
			list=articlesmapper.returnarticlesrd();
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String dqwz(Integer articleid)
	{
		
		String content=null;
		try
		{
			content=articlesmapper.returnneirong(articleid);
			articlesmapper.deupdateredu(articleid);
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return content;
	}

}
