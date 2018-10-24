package com.probrains.io.service;

import java.util.List;

import com.probrains.io.entity.UserDetails;

public interface UserService {

	public List<UserDetails> getUsers();
	
	public void saveUser(UserDetails theUser);

	public UserDetails getUser(int userId);
	
	public void delete(int userId);
}
