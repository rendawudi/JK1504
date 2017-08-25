<<<<<<< HEAD
package com.jk1504.dao;


import com.jk1504.entity.User;

public interface Usermapper {
	public int insertuser(User user) throws Exception;
	public User returnuser(User user) throws Exception;
	public User returnbgzz(Integer dbid) throws Exception;
}
=======
package com.jk1504.dao;


import com.jk1504.entity.User;

public interface Usermapper {
	public int insertuser(User user) throws Exception;
	public User returnuser(User user) throws Exception;
	public User returnbgzz(Integer dbid) throws Exception;
}
>>>>>>> parent of 08ac5ad... 修复了qq号，电话号，学号数据溢出。
