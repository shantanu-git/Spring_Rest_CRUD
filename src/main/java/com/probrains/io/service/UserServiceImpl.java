package com.probrains.io.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.probrains.io.dao.UserDAO;
import com.probrains.io.entity.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<UserDetails> getUsers() {
		return userDAO.getUsers();
	}
	
	@Override
	@Transactional
	public UserDetails getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public void saveUser(UserDetails theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public void delete(int userId) {
		userDAO.delete(userId);
	}
}
