package com.kelly.academy.dao;

import java.util.List;

import com.kelly.academy.model.Alumno;
import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Matricula;

public interface MatriculaDAO {
	
	public void addMatricula(Matricula a);
	public void updateMatricula(Matricula a);
	public List<Matricula> listMatriculas();
	public Matricula getMatriculaById(int id);
	public void removeMatricula(int id);
	public List<Curso> listCursos();
	public List<Alumno> listAlumnos();
}
