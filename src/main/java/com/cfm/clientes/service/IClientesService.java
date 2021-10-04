package com.cfm.clientes.service;

import java.util.List;
import java.util.Optional;

import com.cfm.clientes.exception.BusinessException;
import com.cfm.clientes.jpa.entity.ClienteEntity;
import com.cfm.clientes.model.Cliente;

public interface IClientesService {
	List<ClienteEntity> buscarClientes(char status);
	Optional<ClienteEntity> buscarClienteByRFC(String rfc);
	void guardar(Cliente cliente, String operacion)throws BusinessException;
	List<ClienteEntity> buscarClienteByRegimen(Integer sizeRFC);
	ClienteEntity modificarStatus(String rfc, char newStatus) throws BusinessException;
}
