package com.probrains.io.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.probrains.io.entity.UserDetails;

@Repository
public class UserDAO{

	@Autowired
	private DBServiceUtil theDBServiceUtil;

	public List<UserDetails> getUsers() {
		return theDBServiceUtil.getAll(UserDetails.class);
	}

	public void saveUser(UserDetails theUser) {
		theDBServiceUtil.save(theUser);
	}
	
	public UserDetails getUser(int userId) {
		return theDBServiceUtil.getById(UserDetails.class,userId);
	}

	public void delete(int userId) {
		theDBServiceUtil.delete(UserDetails.class,userId);
	}
}
