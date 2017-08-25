<<<<<<< HEAD
package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Usermapper;
import com.jk1504.entity.User;
import com.js1504.exception.Userexcption;
import com.js1504.exception.loginsb;
import com.js1504.exception.userzhucesb;

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
			throw new userzhucesb("×¢²áÊ§°Ü£¬¿ÉÄÜÕËºÅÖØ¸´");
		} else {
			User u1=usermapper.returnuser(user);
			return u1;
		}
		}
		catch (userzhucesb e1) {
			throw e1;
		}
		catch (Exception e) {
			
			throw new Userexcption("×¢²áÒì³£"+e.getMessage());
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
			throw new loginsb("µÇÂ½Ê§°Ü");
		}
		}
		catch (loginsb e1) {
			throw e1;
		}
		catch (Exception e) {
			throw new Userexcption("µÇÂ¼Òì³£"+e.getMessage());
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
				// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
				throw new Userexcption("»ñÈ¡ÓÃ»§ĞÅÏ¢Ê§°Ü"+e1.getMessage());
			}

		}
		return cxUsers;
	}
	

}
=======
package com.jk1504.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk1504.dao.Usermapper;
import com.jk1504.entity.User;
import com.js1504.exception.Userexcption;
import com.js1504.exception.loginsb;
import com.js1504.exception.userzhucesb;

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
			throw new userzhucesb("×¢²áÊ§°Ü£¬¿ÉÄÜÕËºÅÖØ¸´");
		} else {
			User u1=usermapper.returnuser(user);
			return u1;
		}
		}
		catch (userzhucesb e1) {
			throw e1;
		}
		catch (Exception e) {
			
			throw new Userexcption("×¢²áÒì³£"+e.getMessage());
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
			throw new loginsb("µÇÂ½Ê§°Ü");
		}
		}
		catch (loginsb e1) {
			throw e1;
		}
		catch (Exception e) {
			throw new Userexcption("µÇÂ¼Òì³£"+e.getMessage());
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
				// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
				throw new Userexcption("»ñÈ¡ÓÃ»§ĞÅÏ¢Ê§°Ü"+e1.getMessage());
			}

		}
		return cxUsers;
	}
	

}
>>>>>>> parent of 08ac5ad... ä¿®å¤äº†qqå·ï¼Œç”µè¯å·ï¼Œå­¦å·æ•°æ®æº¢å‡ºã€‚
