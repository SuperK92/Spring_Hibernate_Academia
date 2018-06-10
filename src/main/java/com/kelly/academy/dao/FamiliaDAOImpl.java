package com.kelly.academy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kelly.academy.model.Familia;

public class FamiliaDAOImpl implements FamiliaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(FamiliaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addFamilia(Familia f) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(f);
		logger.info("Familia saved successfully, Familia Details="+f);	
	}

	@Override
	public void updateFamilia(Familia f) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(f);
		logger.info("Familia updated successfully, Familia Details="+f);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> listFamilias() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Familia> familiasList = session.createQuery("from Familia").list();
		for(Familia f : familiasList){
			logger.info("Familia List::"+f);
		}
		return familiasList;
	}

	@Override
	public Familia getFamiliaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Familia f = (Familia) session.load(Familia.class, new Integer(id));
		logger.info("Familia loaded successfully, Familia details="+f);
		return f;
	}

	@Override
	public void removeFamilia(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Familia f = (Familia) session.load(Familia.class, new Integer(id));
		if(null != f){
			session.delete(f);
		}
		logger.info("Familia deleted successfully, Familia details="+f);
	}
	
	

}
