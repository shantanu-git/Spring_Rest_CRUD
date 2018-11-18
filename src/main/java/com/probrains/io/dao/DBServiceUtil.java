package com.probrains.io.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DBServiceUtil {

	@Autowired
	private SessionFactory sessionFactory;
	
	public <T> T getById(Class<T> cName, int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		T tObj = currentSession.get(cName, id);
		return tObj;
	}

	public <T> List<T> getAll(Class<T> cName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<T> theQuery = currentSession.createQuery("From "+cName.getSimpleName(), cName);
		List<T> userDetails = theQuery.getResultList();
		return userDetails;
	}

	public <T> void save(T theObj) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theObj);
	}

	public <T> void delete(Class<T> cName, int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from "+cName.getSimpleName()+" where id=:uId");
		theQuery.setParameter("uId", id);
		theQuery.executeUpdate();

	}

}
