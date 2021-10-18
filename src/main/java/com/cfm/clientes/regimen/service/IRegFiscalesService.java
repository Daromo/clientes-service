package com.cfm.clientes.regimen.service;

import java.util.List;

import com.cfm.clientes.jpa.entity.CatRegimenEntity;

public interface IRegFiscalesService {
	List<CatRegimenEntity> getListaRegimen();
}
