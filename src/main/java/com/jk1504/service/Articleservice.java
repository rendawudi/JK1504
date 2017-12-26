package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Articlesmapper;
import com.jk1504.entity.Articles;
import com.jk1504.entity.usercomeon;


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
			articlesmapper.deltearticledzbyOwner(articles.getArticleid());
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
	public List<Articles> dqwztime(Integer dbid)
	{
		List<Articles> list=new ArrayList<Articles>();
		List<Integer> articleids=new ArrayList<Integer>();
		try
		{
			list=articlesmapper.returnarticlestm();
			articleids=articlesmapper.boolarticledz(dbid);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		for(Articles article:list)
		{
			if (articleids.contains(article.getArticleid()))
			{
				article.setBoolgood(true);
			}
		}
		return list;
	}

	@Override
	public List<Articles> dqwzredu(Integer dbid)
	{
		List<Articles> list=new ArrayList<Articles>();
		List<Integer> articleids=new ArrayList<Integer>();
		try
		{
			list=articlesmapper.returnarticlesrd();
			articleids=new ArrayList<Integer>();
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(Articles article:list)
		{
			if (articleids.contains(article.getArticleid()))
			{
				article.setBoolgood(true);
			}
		}
		return list;
	}

	@Override
	public boolean dzwz(Integer articleid,Integer dbid)
	{
		
		boolean action=false;
		try
		{
			articlesmapper.deupdateredu(articleid);
			usercomeon user=new usercomeon();
			user.setArticleid(articleid);
			user.setDbid(dbid);
			articlesmapper.desertarticledz((user));
			action =true;
		} catch (Exception e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return action;
	}

	@Override
	public boolean qxdzwz(Integer articleid,Integer dbid)
	{
		
		boolean action=false;
		try
		{
			articlesmapper.inupdateredu(articleid);
			usercomeon user=new usercomeon();
			user.setArticleid(articleid);
			user.setDbid(dbid);
			articlesmapper.inletearticledz((user));
			action =true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return action;
	}
}
