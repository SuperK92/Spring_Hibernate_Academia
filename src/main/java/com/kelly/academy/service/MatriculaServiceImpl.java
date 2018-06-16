package com.kelly.academy.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kelly.academy.dao.MatriculaDAO;
import com.kelly.academy.model.Alumno;
import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	private MatriculaDAO matriculaDAO;
	
	public void setMatriculaDAO(MatriculaDAO matriculaDAO) {
		this.matriculaDAO = matriculaDAO;
	}

	@Override
	@Transactional
	public void addMatricula(Matricula p) {
		this.matriculaDAO.addMatricula(p);
	}

	@Override
	@Transactional
	public void updateMatricula(Matricula p) {
		this.matriculaDAO.updateMatricula(p);
	}

	@Override
	@Transactional
	public List<Matricula> listMatriculas() {
		return this.matriculaDAO.listMatriculas();
	}

	@Override
	@Transactional
	public Matricula getMatriculaById(int id) {
		return this.matriculaDAO.getMatriculaById(id);
	}

	@Override
	@Transactional
	public void removeMatricula(int id) {
		this.matriculaDAO.removeMatricula(id);
	}
	
	@Override
	@Transactional
	public List<Curso> listCursos() {
		return this.matriculaDAO.listCursos();
	}

	
	@Override
	@Transactional
	public List<Alumno> listAlumnos() {
		return this.matriculaDAO.listAlumnos();
	}

	
	

}
