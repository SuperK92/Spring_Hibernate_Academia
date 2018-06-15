package com.kelly.academy.service;

import java.util.List;

import com.kelly.academy.model.Alumno;

public interface AlumnoService {

	public void addAlumno(Alumno a);
	public void updateAlumno(Alumno a);
	public List<Alumno> listAlumnos();
	public Alumno getAlumnoById(int id);
	public void removeAlumno(int id);
}
