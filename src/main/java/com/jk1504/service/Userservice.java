package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Usermapper;
import com.jk1504.entity.User;
import com.jk1504.entity.Userxgxx;
import com.jk1504.exception.Userexcption;
import com.jk1504.exception.loginsb;
import com.jk1504.exception.userzhucesb;

@Service
public class Userservice implements Userservicejk{
	
	@Autowired
	private Usermapper usermapper;

	@Override
	public User Userzc(User user) throws userzhucesb, Userexcption {
		String mmString=user.getUserpassword();
		String hashed=BCrypt.hashpw(mmString, BCrypt.gensalt());
		user.setUserpassword(hashed);
		try {
			int insertcount=usermapper.insertuser(user);
			if (insertcount<=0) {
			throw new userzhucesb("ע��ʧ�ܣ������˺��ظ�");
		} else {
			User u1=usermapper.returnuser(user);
			return u1;
		}
		}
		catch (userzhucesb e1) {
			throw e1;
		}
		catch (Exception e) {
			
			throw new Userexcption("ע���쳣"+e.getMessage());
		}
	}

	@Override
	public User Userlogin(User user) throws loginsb, Userexcption {
		try
		{
		User zsuser=usermapper.returnuser(user);
		String zsmm=zsuser.getUserpassword();
		String srmm=user.getUserpassword();
		if (BCrypt.checkpw(srmm, zsmm)) {
			return zsuser;
		} else {
			throw new loginsb("��½ʧ��");
		}
		}
		catch (loginsb e1) {
			throw e1;
		}
		catch (Exception e) {
			throw new Userexcption("��¼�쳣"+e.getMessage());
		}
	}

	@Override
	public List<User> Userxx(List<Integer> dbid) throws Userexcption {
		List<User> cxUsers = new ArrayList<User>();
		for(Integer id:dbid)
		{
			User e;
			try {
				e = usermapper.returnbgzz(id);
				cxUsers.add(e);				
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				throw new Userexcption("��ȡ�û���Ϣʧ��"+e1.getMessage());
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
		String zsmm=zsuser.getUserpassword();
		String srmm=user.getUserpassword();
		if (BCrypt.checkpw(srmm, zsmm)) {
			String mmString=user.getNewuserpassword();
			String hashed=BCrypt.hashpw(mmString, BCrypt.gensalt());
			zsuser.setUserpassword(hashed);
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
