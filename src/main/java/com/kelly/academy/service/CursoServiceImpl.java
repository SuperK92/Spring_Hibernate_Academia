package com.kelly.academy.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kelly.academy.dao.CursoDAO;
import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Familia;
import com.kelly.academy.model.Profesor;

@Service
public class CursoServiceImpl implements CursoService {
	
	private CursoDAO cursoDAO;
	
	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	@Override
	@Transactional
	public void addCurso(Curso p) {
		this.cursoDAO.addCurso(p);
	}

	@Override
	@Transactional
	public void updateCurso(Curso p) {
		this.cursoDAO.updateCurso(p);
	}

	@Override
	@Transactional
	public List<Curso> listCursos() {
		return this.cursoDAO.listCursos();
	}

	@Override
	@Transactional
	public Curso getCursoById(int id) {
		return this.cursoDAO.getCursoById(id);
	}

	@Override
	@Transactional
	public void removeCurso(int id) {
		this.cursoDAO.removeCurso(id);
	}

	@Override
	@Transactional
	public List<Profesor> listaProfesores() {
		return this.cursoDAO.listaProfesores();
	}

	@Override
	@Transactional
	public List<Familia> listaFamilias() {
		return this.cursoDAO.listaFamilias();
	}
	
	
	
	

}
