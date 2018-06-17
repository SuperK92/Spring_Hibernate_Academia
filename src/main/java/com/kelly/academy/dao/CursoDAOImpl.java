package com.kelly.academy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Familia;
import com.kelly.academy.model.Profesor;

public class CursoDAOImpl implements CursoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CursoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCurso(Curso c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Curso guardado correctamente, detalles = "+c);	
	}

	@Override
	public void updateCurso(Curso c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Curso actualizado correctamente, detalles = "+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listCursos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Curso> cursosList = session.createQuery("from Curso").list();
		for(Curso c : cursosList){
			logger.info("Lista Cursos: "+c);
		}
		return cursosList;
	}

	@Override
	public Curso getCursoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Curso c = (Curso) session.load(Curso.class, new Integer(id));
		logger.info("Curso cargado correctamente, detalles = "+c);
		return c;
	}

	@Override
	public void removeCurso(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Curso c = (Curso) session.load(Curso.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Curso eliminado correctamente, detalles = ="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> listaProfesores() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Profesor> profesorList = session.createQuery("from Profesor").list();
		for(Profesor c : profesorList){
			logger.info("Lista Profesores: "+c);
		}
		return profesorList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> listaFamilias() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Familia> familiasList = session.createQuery("from Familia").list();
		for(Familia f : familiasList){
			logger.info("Lista Familia: "+f);
		}
		return familiasList;
	}
	

}
