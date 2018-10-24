package com.probrains.io.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.probrains.io.entity.UserDetails;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserDetails> getUsers() {
		
		//get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<UserDetails> theQuery = currentSession.createQuery("From UserDetails", UserDetails.class);
		
		//execute query and get result list
		List<UserDetails> userDetails = theQuery.getResultList();
				
		//return the results
		return userDetails;
	}

	@Override
	public void saveUser(UserDetails theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public UserDetails getUser(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		UserDetails userDetails = currentSession.get(UserDetails.class,userId);
		return userDetails;
	}

	@Override
	public void delete(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from UserDetails where id=:userId");
		theQuery.setParameter("userId", userId);
		theQuery.executeUpdate();
	}
}
