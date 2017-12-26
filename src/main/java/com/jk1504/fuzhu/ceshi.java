package com.jk1504.fuzhu;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;

public class ceshi
{
	@Resource
	private StringRedisTemplate redisTemplate;

	public boolean pdxg(String sessionid, String username)
	{
		if (username==null)
		{
			return false;
		}
		if (redisTemplate.hasKey(username))
		{
			if (sessionid.equals(redisTemplate.opsForValue().get(username)))
			{
				redisTemplate.expire(username,  12, TimeUnit.HOURS);
			return true;
			}
			else
			{
				return false;
			}
		}
		else {
			return false;
		}
		// TODO 自动生成的方法存根
	}

	public boolean inserttoken(String sessionid, String username)
	{
		try
		{
			if (redisTemplate.hasKey(username))
			{
				redisTemplate.delete(username);
				redisTemplate.opsForValue().set( username, sessionid , 12, TimeUnit.HOURS);
			}
			else {
				redisTemplate.opsForValue().set( username, sessionid , 12, TimeUnit.HOURS);			
			return true;
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return false;
	}

	public boolean deletetoken(String username)
	{
		try
		{
			redisTemplate.delete(username);
			return true;
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		// TODO 自动生成的方法存根
		return false;
	}
	public static void main(String argv[])
	{
		ceshi csCeshi=new ceshi();
		csCeshi.inserttoken("dwqd","rhp");
		csCeshi.deletetoken("rhp");
		System.out.println("adwad");
	}
}
