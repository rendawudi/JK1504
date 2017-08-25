package com.jk1504.fuzhu;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisdao
{
	private JedisPool jedisPool;
	
	public redisdao(JedisPoolConfig poolConfig,String host,int port,int timeout,String password,int database)
	{
		jedisPool=new JedisPool(poolConfig, host, port, timeout, password, database);
	}
	
	public boolean pdxg(String sessionid, String username)
	{
		try
		{
			Jedis jedis=jedisPool.getResource();
			try
			{
				if (username==null)
		{
			return false;
		}
		
			if (sessionid.equals(jedis.get(username)))
			{
				jedis.expire(username, 3600*12);
			return true;
			}
			else
			{
				return false;
			}
		
			} finally
			{
				jedis.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
		// TODO 自动生成的方法存根
	}

	public boolean inserttoken(String sessionid, String username)
	{
		try
		{
			Jedis jedis=jedisPool.getResource();
			try
			{
				if (jedis.exists(username))
			{
				jedis.del(username);
				jedis.setex(username, 3600*12, sessionid);
				return true;
			}
			else {
				jedis.setex(username, 3600*12, sessionid);		
			return true;
			}
			} finally
			{
				jedis.close();
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deletetoken(String username)
	{
		try
		{
			Jedis jedis=jedisPool.getResource();
			try
			{
				jedis.del(username);
				return true;
			} finally
			{
				jedis.close();
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		// TODO 自动生成的方法存根
		return false;
	}
}
