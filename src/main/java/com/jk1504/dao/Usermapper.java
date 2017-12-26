package com.jk1504.dao;


import com.jk1504.entity.User;
import com.jk1504.entity.Usermsg;
import com.jk1504.entity.simpleUser;

public interface Usermapper {
	public int insertuser(User user) throws Exception;
	public User returnuser(User user) throws Exception;
	public simpleUser returnbgzz(Integer dbid) throws Exception;
	public int updataimg(User user) throws Exception;
	public int updatapaswd(User user)throws Exception;
	public int updatanick(User user)throws Exception;
	public Usermsg returnUserId(Integer dbid) throws Exception;
}
