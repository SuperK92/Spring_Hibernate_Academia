package com.kelly.academy.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kelly.academy.dao.ProfesorDAO;
import com.kelly.academy.model.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	private ProfesorDAO profesorDAO;
	
	public void setProfesorDAO(ProfesorDAO profesorDAO) {
		this.profesorDAO = profesorDAO;
	}

	@Override
	@Transactional
	public void addProfesor(Profesor p) {
		this.profesorDAO.addProfesor(p);
	}

	@Override
	@Transactional
	public void updateProfesor(Profesor p) {
		this.profesorDAO.updateProfesor(p);
	}

	@Override
	@Transactional
	public List<Profesor> listProfesor() {
		return this.profesorDAO.listProfesor();
	}

	@Override
	@Transactional
	public Profesor getProfesorById(int id) {
		return this.profesorDAO.getProfesorById(id);
	}

	@Override
	@Transactional
	public void removeProfesor(int id) {
		this.profesorDAO.removeProfesor(id);
	}
	
	

}
