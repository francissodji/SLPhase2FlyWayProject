package com.dao;

import com.beans.User;

public interface UserDao {

	public Integer addUser(User user);
	
	public Integer getIdUser(String userName);
	
	public void updateUserName(Integer userId, String userName);
	
	public void updateUserPassword(Integer userId, String passWord);
	
	public boolean validateAuthentication(String userName, String passWord);
}
