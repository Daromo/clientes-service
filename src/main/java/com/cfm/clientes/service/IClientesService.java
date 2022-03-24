package com.cfm.clientes.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.cfm.clientes.exception.BusinessException;
import com.cfm.clientes.jpa.entity.CatRegimenEntity;
import com.cfm.clientes.jpa.entity.ClienteEntity;
import com.cfm.clientes.model.Cliente;

public interface IClientesService {
	List<ClienteEntity> buscarClienteStatus(char status);
	ClienteEntity buscarClienteByRFC(String rfc) throws BusinessException;
	void guardar(Cliente cliente, String operacion)throws BusinessException;
	//List<ClienteEntity> buscarClienteByRegimen(Integer sizeRFC);
	ClienteEntity modificarStatus(String rfc, char newStatus) throws BusinessException;
	//List<CatRegimenEntity> getListaRegimen();
	List<ClienteEntity> buscarByExample(Example<ClienteEntity> example);
}
