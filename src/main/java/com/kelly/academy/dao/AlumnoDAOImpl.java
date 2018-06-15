package com.kelly.academy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kelly.academy.model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addAlumno(Alumno p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);	
	}

	@Override
	public void updateAlumno(Alumno p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> listAlumnos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Alumno> alumnosList = session.createQuery("from Alumno").list();
		for(Alumno p : alumnosList){
			logger.info("Person List::"+p);
		}
		return alumnosList;
	}

	@Override
	public Alumno getAlumnoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Alumno p = (Alumno) session.load(Alumno.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeAlumno(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Alumno p = (Alumno) session.load(Alumno.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
	
	

}
