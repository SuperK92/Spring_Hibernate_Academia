package com.kelly.academy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kelly.academy.model.Alumno;
import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Matricula;

public class MatriculaDAOImpl implements MatriculaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MatriculaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addMatricula(Matricula p) {
		Session session = this.sessionFactory.getCurrentSession();
		
		int id_alumno = p.getAlumno().getId();
		Alumno alumno = (Alumno) session.load(Alumno.class, new Integer(id_alumno));
		
		int id_curso = p.getCurso().getId();
		Curso curso = (Curso) session.load(Curso.class, new Integer(id_curso));
		
		p.setAlumno(alumno);
		p.setCurso(curso);
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);	
	}

	@Override
	public void updateMatricula(Matricula p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listMatriculas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Matricula> matriculasList = session.createQuery("from Matricula").list();
		for(Matricula p : matriculasList){
			logger.info("Person List::"+p);
		}
		return matriculasList;
	}

	@Override
	public Matricula getMatriculaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Matricula p = (Matricula) session.load(Matricula.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeMatricula(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Matricula p = (Matricula) session.load(Matricula.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listCursos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Curso> cursosList = session.createQuery("from Curso").list();
		for(Curso c : cursosList){
			logger.info("Person List::"+c);
		}
		return cursosList;
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
	
	

}
