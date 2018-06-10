package com.kelly.academy.service;

import java.util.List;

import com.kelly.academy.model.Familia;


public interface FamiliaService {

	public void addFamilia(Familia f);
	public void updateFamilia(Familia f);
	public List<Familia> listFamilias();
	public Familia getFamiliaById(int id);
	public void removeFamilia(int id);

	
}
