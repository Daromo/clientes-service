package com.cfm.clientes.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

@Service
public class ClientesService implements IClientesService {
	
	@Autowired
	private ClientesRepository repoClientes;
	
	@Autowired
	private CatRegimenRepository repoCatRegimen;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EntityManager entityManager;
	
	private static final String OPTION_UPDATE = "modificar";
	private static final String OPTION_SAVE = "guardar";
	
	/**
	 * Metodo para obtener la lista de los clientes
	 */
	@Override
	public List<ClienteEntity> buscarClienteStatus(char status) {
		return repoClientes.findByStatus(status);
	}
	
	/**
	 * Metodo para obtener el registro de un cliente a traves de su RFC
	 */	
	@Override
	public ClienteEntity buscarClienteByRFC(String rfc) throws BusinessException {
		Optional<ClienteEntity> cliente = repoClientes.findById(rfc);
		if (!cliente.isPresent())
			throw new BusinessException("El RFC del cliente no existe service");
		return cliente.get();
	}
	
	/**
	 * Metodo para REGISTRAR y MODIFICAR los datos de un cliente
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
	 * Metodo para filtrar a los clientes de acuerdo al regimen
	 * Personas Fisicas
	 * Personas Morales
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteEntity> buscarClienteByRegimen(Integer sizeRFC) {
		Query query = entityManager.createQuery("SELECT c FROM tbl_cliente c INNER JOIN cat_regimen_fiscal r ON r.id = c.regimenFiscal WHERE r.rfcSize = :sizeRFC");
		query.setParameter("sizeRFC", sizeRFC);
		return query.getResultList();
	}
	
	/**
	 * Metodo para dar de BAJA o realizar el REINGRESO de un cliente por medio del status. 
	 * A: Activo 
	 * I: Inactivo
	 */
	@Override
	public ClienteEntity modificarStatus(String rfc, char newStatus) throws BusinessException {
		Optional<ClienteEntity> clienteEntity = repoClientes.findById(rfc);
		if(!clienteEntity.isPresent())
			throw new BusinessException("El rfc del cliente no existe");		
		clienteEntity.get().setStatus(newStatus);
		return repoClientes.save(clienteEntity.get());
	}
	
	//PREGUNTAR
	@Override
	public List<CatRegimenEntity> getListaRegimen() {
		return repoCatRegimen.findAll();
	}

	@Override
	public List<ClienteEntity> buscarByExample(Example<ClienteEntity> example) {
		return repoClientes.findAll(example);
	}

}
