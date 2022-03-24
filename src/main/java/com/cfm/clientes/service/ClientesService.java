package com.cfm.clientes.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cfm.clientes.exception.BusinessException;
import com.cfm.clientes.jpa.entity.CatRegimenEntity;
import com.cfm.clientes.jpa.entity.ClienteEntity;
import com.cfm.clientes.jpa.repository.CatRegimenRepository;
import com.cfm.clientes.jpa.repository.ClientesRepository;
import com.cfm.clientes.model.Cliente;

/**
 * @author Jose Daniel Rojas Morales
 * @version 1.0.0
 */
@Service
public class ClientesService implements IClientesService {
	
	@Autowired
	private ClientesRepository repoClientes;
	
	@Autowired
	private CatRegimenRepository repoCatRegimen;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final String OPTION_UPDATE = "modificar";
	private static final String OPTION_SAVE = "guardar";
	
	/**
	 * Metodo para obtener la lista de clientes de acuerdo al status
	 * @param status
	 * @return List<ClienteEntity>
	 */
	@Override
	public List<ClienteEntity> buscarClienteStatus(char status) {
		return repoClientes.findByStatusOrderByLastUpdateDesc(status);
	}
	
	/**
	 * Metodo para obtener el registro de un cliente a traves de su RFC
	 * @param Cliente RFC
	 * @return ClienteEntity
	 */	
	@Override
	public ClienteEntity buscarClienteByRFC(String rfc) throws BusinessException {
		Optional<ClienteEntity> cliente = repoClientes.findById(rfc);
		if (!cliente.isPresent())
			throw new BusinessException("El RFC del cliente no existe service");
		return cliente.get();
	}
	
	/**
	 * Metodo para Agregar o Actualizar los datos de un cliente
	 * @param Cliente
	 * @param Tipo de operacion
	 */
	@Override
	public void guardar(Cliente cliente, String operacion) throws BusinessException {

		Optional<CatRegimenEntity> catRegimenFiscal = repoCatRegimen.findById(cliente.getRegimenFiscalId());
		
		if(!catRegimenFiscal.isPresent())
			throw new BusinessException("El regimen no existe");
		
		if (repoClientes.existsById(cliente.getRfc()) && operacion.equals(OPTION_SAVE))
			throw new BusinessException("El cliente ya existe");
		
		if (!repoClientes.existsById(cliente.getRfc()) && operacion.equals(OPTION_UPDATE))
			throw new BusinessException("El rfc del cliente no existe");
		
		if(cliente.getRfc().length() != catRegimenFiscal.get().getRfcSize())
			throw new BusinessException("El RFC no es valido para el regimen fiscal seleccionado");
		
		ClienteEntity clienteMapper = modelMapper.map(cliente, ClienteEntity.class);
		repoClientes.save(clienteMapper);
	}
	
	/**
	 * Metodo para dar de BAJA o realizar el REINGRESO de un cliente por medio del status.
	 * @param Cliente RFC
	 * @param Nuevo status
	 * @return ClienteEntity
	 */
	@Override
	public ClienteEntity modificarStatus(String rfc, char newStatus) throws BusinessException {
		Optional<ClienteEntity> clienteEntity = repoClientes.findById(rfc);
		if(!clienteEntity.isPresent())
			throw new BusinessException("El rfc del cliente no existe");		
		clienteEntity.get().setStatus(newStatus);
		return repoClientes.save(clienteEntity.get());
	}
	
	/**
	 * Metodo para buscar el registro de un cliente a traves de las propiedades del objeto 
	 * que recibo como argumento
	 * @param ClienteEntity
	 * @return List<ClienteEntity>
	 */
	@Override
	public List<ClienteEntity> buscarByExample(Example<ClienteEntity> example) {
		return repoClientes.findAll(example);
	}

}
