package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Usermapper;
import com.jk1504.entity.User;
import com.jk1504.entity.Usermsg;
import com.jk1504.entity.Userxgxx;
import com.jk1504.entity.simpleUser;
import com.jk1504.exception.Userexcption;
import com.jk1504.exception.loginsb;
import com.jk1504.exception.userzhucesb;

@Service
public class Userservice implements Userservicejk{

	@Autowired
	private Usermapper usermapper;

	@Override
	public User Userzc(User user) throws userzhucesb, Userexcption {
		String mmString=user.getPassword();
		String hashed=BCrypt.hashpw(mmString, BCrypt.gensalt());
		user.setPassword(hashed);
		try {
			int insertcount=usermapper.insertuser(user);
			if (insertcount<=0) {
				throw new userzhucesb("注册失败，可能账号重复");
			} else {
				User u1=usermapper.returnuser(user);
				return u1;
			}
		}
		catch (userzhucesb e1) {
			throw e1;
		}
		catch (Exception e) {

			throw new Userexcption("注册异常"+e.getMessage());
		}
	}

	@Override
	public Usermsg returnUserById(Integer id) throws Exception
	{
		Usermsg u1 = new Usermsg();
		try
		{
			u1=usermapper.returnUserId(id);
			return u1;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public User Userlogin(User user) throws loginsb, Userexcption {
		try
		{
			User zsuser=usermapper.returnuser(user);
			String zsmm=zsuser.getPassword();
			String srmm=user.getPassword();
			if (BCrypt.checkpw(srmm, zsmm)) {
				return zsuser;
			} else {
				throw new loginsb("登陆失败");
			}
		}
		catch (loginsb e1) {
			throw e1;
		}
		catch (Exception e) {
			throw new Userexcption("登录异常"+e.getMessage());
		}
	}

	@Override
	public List<simpleUser> Userxx(Integer[] dbid) throws Userexcption {
		List<simpleUser> cxUsers = new ArrayList<simpleUser>();
		for(Integer id:dbid)
		{
			simpleUser e;
			try {
				e = usermapper.returnbgzz(id);
				cxUsers.add(e);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				throw new Userexcption("获取用户信息失败"+e1.getMessage());
			}

		}
		return cxUsers;
	}

	@Override
	public boolean Userpaswdxg(Userxgxx user) throws Exception
	{
		try
		{
			User zsuser=new User();
			zsuser.setUsername(user.getUsername());
			zsuser=usermapper.returnuser(zsuser);
			String zsmm=zsuser.getPassword();
			String srmm=user.getUserpassword();
			if (BCrypt.checkpw(srmm, zsmm)) {
				String mmString=user.getNewuserpassword();
				String hashed=BCrypt.hashpw(mmString, BCrypt.gensalt());
				zsuser.setPassword(hashed);
				if (usermapper.updatapaswd(zsuser)>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			} else {
				return false;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User Usernickxg(Userxgxx user) throws Exception
	{
		User user1=new User();
		user1.setDbid(user.getDbid());
		user1.setNickname(user.getNickname());
		if (usermapper.updatanick(user1)>0)
		{
			return user1;
		} else
		{
			user1.setNickname("no");
		}
		return user1;
	}

	@Override
	public User Userimgxg(Userxgxx user) throws Exception
	{
		User user1=new User();
		user1.setDbid(user.getDbid());
		user1.setImgpath(user.getImgpath());
		if (usermapper.updataimg(user1)>0)
		{
			return user1;
		} else
		{
			user1.setNickname("no");
		}
		return user1;
	}


}