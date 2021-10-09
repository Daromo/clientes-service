package com.cfm.clientes.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbl_cliente")
public class ClienteEntity {
	
	@Id
	private String rfc;
	
	@NotNull(message = "El argumento idRegimenFiscal no puede ser nulo")
	@OneToOne
	@JoinColumn(name="id_regimen_fiscal")
	private CatRegimenEntity regimenFiscal;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	@Column(name = "ap_paterno_cliente")
	private String apPaternoCliente;
	
	@Column(name = "ap_materno_cliente")
	private String apMaternoCliente;
	
	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Column(name = "status")
	private char status;
	
	@NotNull(message = "El parametro telefono1 no puede ser nulo")
	@Column(name = "telefono1")
	private Integer telefono1;
	
	@Column(name = "telefono2")
	private Integer telefono2;
	
	@NotNull(message = "El parametro correo no puede ser nula")
	@NotEmpty(message = "El parametro correo no puede ser vacio")
	@Column(name="correo")
	private String correo;
	
	@Column(name = "correo_alternativo")
	private String correoAlternativo;
	
	@NotNull(message = "El parametro domicilio no puede ser nula")
	@NotEmpty(message = "El parametro domicilio no puede ser vacio")
	@Column(name="domicilio")
	private String domicilio;
	
	@NotNull(message = "El parametro codigoPostal no puede ser nulo")
	@Column(name = "codigo_postal")
	private Integer codigoPostal;
	
}
