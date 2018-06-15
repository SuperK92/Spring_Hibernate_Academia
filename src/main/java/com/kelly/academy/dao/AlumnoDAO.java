package com.kelly.academy.dao;

import java.util.List;

import com.kelly.academy.model.Alumno;

public interface AlumnoDAO {
	
	public void addAlumno(Alumno a);
	public void updateAlumno(Alumno a);
	public List<Alumno> listAlumnos();
	public Alumno getAlumnoById(int id);
	public void removeAlumno(int id);

}
