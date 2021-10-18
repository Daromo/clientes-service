package com.cfm.clientes.regimen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfm.clientes.jpa.entity.CatRegimenEntity;
import com.cfm.clientes.jpa.repository.CatRegimenRepository;

@Service
public class RegFiscalesService implements IRegFiscalesService {
	
	@Autowired
	private CatRegimenRepository repoCatRegimen;
	
	@Override
	public List<CatRegimenEntity> getListaRegimen() {
		return repoCatRegimen.findAll();
	}

}
