package com.cfm.clientes.regimen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfm.clientes.jpa.entity.CatRegimenEntity;
import com.cfm.clientes.regimen.service.RegFiscalesService;
import com.cfm.clientes.util.GUIDGenerator;
import com.cfm.clientes.util.LogHandler;
import com.cfm.clientes.util.Parseador;

@RestController
@RequestMapping(value="/clientes/regimen")
public class RegFiscalesController {
	
	@Autowired
	RegFiscalesService serviceRegFiscales;
	
	@GetMapping("/lista")
	public ResponseEntity<List<CatRegimenEntity>> getListaRegimenFiscales(){
		List<CatRegimenEntity> lista = serviceRegFiscales.getListaRegimen();
		String uid = GUIDGenerator.generateGUID();
		LogHandler.info(uid, getClass(), "getListaRegimenFiscales: "+Parseador.objectToJson(uid,lista));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
