package com.kelly.academy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kelly.academy.model.Profesor;

public class ProfesorDAOImpl implements ProfesorDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfesorDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProfesor(Profesor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);	
	}

	@Override
	public void updateProfesor(Profesor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> listProfesor() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Profesor> profesoresList = session.createQuery("from Profesor").list();
		for(Profesor p : profesoresList){
			logger.info("Person List::"+p);
		}
		return profesoresList;
	}

	@Override
	public Profesor getProfesorById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Profesor p = (Profesor) session.load(Profesor.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeProfesor(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Profesor p = (Profesor) session.load(Profesor.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
	
	

}
