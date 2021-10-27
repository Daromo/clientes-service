package com.cfm.clientes.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

	@NotNull(message = "El argumento rfc no puede ser nulo")
	private String rfc;
	
	@NotNull(message = "El argumento idRegimenFiscal no puede ser nulo")
	private Integer regimenFiscalId;
	
	private String nombreCliente;
	
	private String apPaternoCliente;
	
	private String apMaternoCliente;
	
	private String razonSocial;
	
	private Date fechaIngreso;
	
	private Date lastUpdate;
	
	private char status;
	
	@NotNull(message = "El argumento telefono1 no puede ser nulo")
	private String telefono1;
	
	private String telefono2;
	
	@NotNull(message = "El argumento correo no puede ser nula")
	@NotEmpty(message = "El argumento correo no puede ser vacio")
	private String correo;
	
	private String correoAlternativo;
	
	@NotNull(message = "El argumento domicilio no puede ser nula")
	@NotEmpty(message = "El argumento domicilio no puede ser vacio")
	private String domicilio;
	
	@NotNull(message = "El argumento codigoPostal no puede ser nulo")
	private String codigoPostal;
}
