package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.User;
import com.jk1504.entity.Userxgxx;
import com.jk1504.exception.Userexcption;
import com.jk1504.exception.loginsb;
import com.jk1504.exception.userzhucesb;

public interface Userservicejk {
	public User Userzc(User user) throws userzhucesb,Userexcption;
	public User Userlogin(User user) throws loginsb,Userexcption;
	public List<User> Userxx(List<Integer> dbid) throws Userexcption;
	public boolean Userpaswdxg(Userxgxx user)throws Exception;
	public User Usernickxg(Userxgxx user)throws Exception;
	public User Userimgxg(Userxgxx user)throws Exception;
	
}
