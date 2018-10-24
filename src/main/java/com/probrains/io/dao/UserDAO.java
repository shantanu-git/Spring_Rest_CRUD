package com.probrains.io.dao;

import java.util.List;

import com.probrains.io.entity.UserDetails;

public interface UserDAO {

	public List<UserDetails> getUsers();
	
	public void saveUser(UserDetails theUser);

	public UserDetails getUser(int userId);
	
	public void delete(int userId);	
}
