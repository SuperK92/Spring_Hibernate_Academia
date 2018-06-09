package com.kelly.academy.dao;

import java.util.List;

import com.kelly.academy.model.Profesor;

public interface ProfesorDAO {
	
	public void addProfesor(Profesor p);
	public void updateProfesor(Profesor p);
	public List<Profesor> listProfesor();
	public Profesor getProfesorById(int id);
	public void removeProfesor(int id);

}
