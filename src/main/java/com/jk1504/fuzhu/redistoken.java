package com.jk1504.fuzhu;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
@Component
public class redistoken  
{
	private static ApplicationContext applicationContext;
	static{  
        applicationContext = new ClassPathXmlApplicationContext("springmvc-config.xml");  
    }  

	public boolean pdxg(String sessionid, String username)
	{
		StringRedisTemplate redisTemplate=(StringRedisTemplate)applicationContext.getBean("redisTemplate");
		redisTemplate.setEnableTransactionSupport(true);
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
		StringRedisTemplate redisTemplate=(StringRedisTemplate)applicationContext.getBean("redisTemplate");
		redisTemplate.setEnableTransactionSupport(true);
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
		StringRedisTemplate redisTemplate=(StringRedisTemplate)applicationContext.getBean("redisTemplate");
		redisTemplate.setEnableTransactionSupport(true);
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

}
