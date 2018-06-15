package com.kelly.academy.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kelly.academy.dao.AlumnoDAO;
import com.kelly.academy.model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	private AlumnoDAO alumnoDAO;
	
	public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
	}

	@Override
	@Transactional
	public void addAlumno(Alumno p) {
		this.alumnoDAO.addAlumno(p);
	}

	@Override
	@Transactional
	public void updateAlumno(Alumno p) {
		this.alumnoDAO.updateAlumno(p);
	}

	@Override
	@Transactional
	public List<Alumno> listAlumnos() {
		return this.alumnoDAO.listAlumnos();
	}

	@Override
	@Transactional
	public Alumno getAlumnoById(int id) {
		return this.alumnoDAO.getAlumnoById(id);
	}

	@Override
	@Transactional
	public void removeAlumno(int id) {
		this.alumnoDAO.removeAlumno(id);
	}
	
	

}
