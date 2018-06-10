package com.kelly.academy.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kelly.academy.dao.FamiliaDAO;
import com.kelly.academy.model.Familia;

@Service
public class FamiliaServiceImpl implements FamiliaService {
	
	private FamiliaDAO familiaDAO;
	
	public void setFamiliaDAO(FamiliaDAO familiaDAO) {
		this.familiaDAO = familiaDAO;
	}

	@Override
	@Transactional
	public void addFamilia(Familia f) {
		this.familiaDAO.addFamilia(f);
	}

	@Override
	@Transactional
	public void updateFamilia(Familia f) {
		this.familiaDAO.updateFamilia(f);
	}

	@Override
	@Transactional
	public List<Familia> listFamilias() {
		return this.familiaDAO.listFamilias();
	}

	@Override
	@Transactional
	public Familia getFamiliaById(int id) {
		return this.familiaDAO.getFamiliaById(id);
	}

	@Override
	@Transactional
	public void removeFamilia(int id) {
		this.familiaDAO.removeFamilia(id);
	}
	
	

}
