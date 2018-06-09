package com.kelly.academy.dao;

import java.util.List;

import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Profesor;

public interface CursoDAO {
	
	public void addCurso(Curso c);
	public void updateCurso(Curso c);
	public List<Curso> listCursos();
	public Curso getCursoById(int id);
	public void removeCurso(int id);
	public List<Profesor> listaProfesores();

}
