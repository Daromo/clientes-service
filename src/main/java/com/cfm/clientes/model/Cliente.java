package com.cfm.clientes.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

	@NotBlank(message = "El argumento rfc no puede ser nulo")
	private String rfc;
	
	@NotNull(message = "El argumento regimenFiscalId no puede ser nulo")
	private Integer regimenFiscalId;
	
	private String nombreCliente;
	
	private String apPaternoCliente;
	
	private String apMaternoCliente;
	
	private String razonSocial;
	
	private String nombreLargo;
	
	@NotNull(message = "El argumento fechaIngreso no puede ser nulo")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone =  "America/Mexico_City")
	private Date fechaIngreso;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone =  "America/Mexico_City")
	private Date lastUpdate;
	
	private Character status;
	
	@NotBlank(message = "El argumento telefono1 no puede ser nulo")
	private String telefono1;
	
	private String telefono2;
	
	@NotBlank(message = "El argumento correo no puede ser nulo")
	private String correo;
	
	private String correoAlternativo;
	
	@NotBlank(message = "El argumento domicilio no puede ser nulo")
	private String domicilio;
	
	@NotNull(message = "El argumento codigoPostal no puede ser nulo")
	private Integer codigoPostal;
}
