package com.cfm.clientes.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value="/clientes")
public class ClientesController {

	@Autowired
	private IClientesService serviceClientes;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//LISTAR CLIENTES ACTIVOS
	@GetMapping("/activos")
	public ResponseEntity<List<ClienteEntity>> buscarClientesActivos(){
		List<ClienteEntity> lista = serviceClientes.buscarClienteStatus('A');
		String uid=GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "buscarClientesActivos"+Parseador.objectToJson(uid, lista));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	//LISTAR CLIENTES INACTIVOS
	@GetMapping("/inactivos")
	public ResponseEntity<List<ClienteEntity>> buscarClientesInactivos(){
		List<ClienteEntity> lista = serviceClientes.buscarClienteStatus('I');
		String uid=GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "buscarClientesInactivos"+Parseador.objectToJson(uid, lista));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
		
	//BUSCAR CLIENTE POR RFC
	@GetMapping("/buscar/rfc/{clienteRFC}")
	public ResponseEntity<ClienteEntity> buscarClienteRFC(@PathVariable String clienteRFC) throws BusinessException{
		return new ResponseEntity<>(serviceClientes.buscarClienteByRFC(clienteRFC), HttpStatus.OK);
	}
	
	//BUSCAR CLIENTES POR REGIMEN FISCAL
	@GetMapping("/buscar/regimen/{searchValue}")
	public ResponseEntity<List<ClienteEntity>> filtrarClientes(@PathVariable String searchValue)throws BusinessException {
		List<ClienteEntity> lista = null;
		if (searchValue.equals("personas-fisicas")) {
			lista = serviceClientes.buscarClienteByRegimen(13);
		}else if(searchValue.equals("personas-morales")) {
			lista = serviceClientes.buscarClienteByRegimen(12);
		}	
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	//AGREGAR CLIENTE
	@PostMapping("/nuevo")
	public ResponseEntity<Cliente> guardar(@Valid @RequestBody Cliente cliente) throws BusinessException {
		String uid=GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "guardar"+Parseador.objectToJson(uid, cliente));
		serviceClientes.guardar(cliente, "guardar");
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	//MODIFICAR CLIENTE
	@PutMapping("/modificar")
	public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente) throws BusinessException {
		serviceClientes.guardar(cliente, "modificar");
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	//REACTIVAR CLIENTE
	@PutMapping("/reactivar/{rfc}")
	public ResponseEntity<ClienteEntity> reactivarCliente(@PathVariable String rfc) throws BusinessException {
    	return new ResponseEntity<>(serviceClientes.modificarStatus(rfc, 'A'),HttpStatus.OK);
	}
	
	//BAJA CLIENTE
	@PutMapping("/baja/{rfc}")
	public ResponseEntity<ClienteEntity> bajaCliente(@PathVariable String rfc) throws BusinessException {		
		return ResponseEntity.status(HttpStatus.OK).body(serviceClientes.modificarStatus(rfc, 'I'));
	}
}
