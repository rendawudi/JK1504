package com.jk1504.service;

import java.util.List;

import com.jk1504.entity.User;
import com.js1504.exception.Userexcption;
import com.js1504.exception.loginsb;
import com.js1504.exception.userzhucesb;

public interface Userservicejk {
	public User Userzc(User user) throws userzhucesb,Userexcption;
	public User Userlogin(User user) throws loginsb,Userexcption;
	public List<User> Userxx(List<Integer> dbid) throws Userexcption;
}
