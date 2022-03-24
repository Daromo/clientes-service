package com.cfm.clientes.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfm.clientes.exception.BusinessException;
import com.cfm.clientes.jpa.entity.ClienteEntity;
import com.cfm.clientes.model.Cliente;
import com.cfm.clientes.service.IClientesService;
import com.cfm.clientes.util.GUIDGenerator;
import com.cfm.clientes.util.LogHandler;
import com.cfm.clientes.util.Parseador;

/**
 * @author Jose Daniel Rojas Morales
 * @version 1.0.0
 */
@RestController
@RequestMapping(value="/clientes")
public class ClientesController {

	@Autowired
	private IClientesService serviceClientes;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Endpoint para consultar los clientes activos
	 * @return List<ClienteEntity>
	 */
	@GetMapping("/activos")
	public ResponseEntity<List<ClienteEntity>> buscarClientesActivos(){
		List<ClienteEntity> lista = serviceClientes.buscarClienteStatus('A');
		String uid=GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "buscarClientesActivos"+Parseador.objectToJson(uid, lista));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para consultar los clientes inactivos
	 * @return List<ClienteEntity>
	 */
	@GetMapping("/inactivos")
	public ResponseEntity<List<ClienteEntity>> buscarClientesInactivos(){
		List<ClienteEntity> lista = serviceClientes.buscarClienteStatus('I');
		String uid=GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "buscarClientesInactivos"+Parseador.objectToJson(uid, lista));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
		
	/**
	 * Endpoint para consultar el registro de un cliente de acuerdo al RFC
	 * @param Cliente RFC
	 * @return ClienteEntity
	 */
	@GetMapping("/buscar/rfc/{clienteRFC}")
	public ResponseEntity<ClienteEntity> buscarClienteRFC(@PathVariable String clienteRFC) throws BusinessException{
		return new ResponseEntity<>(serviceClientes.buscarClienteByRFC(clienteRFC), HttpStatus.OK);
	}
	
	/**
	 * Endpoint para consultar el registro de un cliente de acuerdo a los valores 
	 * de las propiedades del objeto que se recibe como parametro
	 * @param Cliente
	 * @return ClienteEntity
	 */
	@PostMapping("/buscar")
	public ResponseEntity<List<ClienteEntity>> buscarCliente(@RequestBody Cliente cliente) {				
		String uid = GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "buscarCliente:"+Parseador.objectToJson(uid, cliente));
		ClienteEntity clienteMapper = modelMapper.map(cliente, ClienteEntity.class);
		Example<ClienteEntity> example = Example.of(clienteMapper);
		return new ResponseEntity<>(serviceClientes.buscarByExample(example),HttpStatus.OK);
	}
	
	/**
	 * Endpoint para guardar el registro de un cliente en DB
	 * @param Cliente
	 * @return Cliente
	 */
	@PostMapping("/nuevo")
	public ResponseEntity<Cliente> guardar(@Valid @RequestBody Cliente cliente) throws BusinessException {
		String uid=GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "guardar"+Parseador.objectToJson(uid, cliente));
		serviceClientes.guardar(cliente, "guardar");
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para actualizar el registro de un cliente en DB
	 * @param Cliente
	 * @return Cliente
	 * @throws BusinessException
	 */
	@PutMapping("/modificar")
	public ResponseEntity<Cliente> actualizar(@Valid @RequestBody Cliente cliente) throws BusinessException {
		serviceClientes.guardar(cliente, "modificar");
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para reactivar a un cliente en el sistema
	 * @param Cliente RFC
	 * @return ClienteEntity
	 * @throws BusinessException
	 */
	@PutMapping("/reactivar/{rfc}")
	public ResponseEntity<ClienteEntity> reactivarCliente(@PathVariable String rfc) throws BusinessException {
    	return new ResponseEntity<>(serviceClientes.modificarStatus(rfc, 'A'),HttpStatus.OK);
	}
	
	/**
	 * Endpoint para dar de baja a un cliente en el sistema
	 * @param Cliente RFC
	 * @return ClienteEntity
	 * @throws BusinessException
	 */
	@PutMapping("/baja/{rfc}")
	public ResponseEntity<ClienteEntity> bajaCliente(@PathVariable String rfc) throws BusinessException {		
		return ResponseEntity.status(HttpStatus.OK).body(serviceClientes.modificarStatus(rfc, 'I'));
	}
}
