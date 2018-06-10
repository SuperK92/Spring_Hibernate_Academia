package com.kelly.academy.service;

import java.util.List;

import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Familia;
import com.kelly.academy.model.Profesor;

public interface CursoService {

	public void addCurso(Curso c);
	public void updateCurso(Curso c);
	public List<Curso> listCursos();
	public Curso getCursoById(int id);
	public void removeCurso(int id);
	public List<Profesor> listaProfesores();
	public List<Familia> listaFamilias();
	
}
