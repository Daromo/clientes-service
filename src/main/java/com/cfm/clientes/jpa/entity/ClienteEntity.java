package com.cfm.clientes.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbl_clientes")
public class ClienteEntity {
	@Id
	private String rfc;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@Column(name = "status")
	private Character status;
	
	@NotNull(message = "El parametro telefono1 no puede ser nulo")
	@Column(name = "telefono1")
	private String telefono1;
	
	@Column(name = "telefono2")
	private String telefono2;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name = "correo_alternativo")
	private String correoAlternativo;
	
	@Column(name="domicilio")
	private String domicilio;
	
	@Column(name = "codigo_postal")
	private Integer codigoPostal;
	
	@PrePersist
	private void onCreate() {
		rfc = rfc.toUpperCase();
		fechaIngreso = new Date();
		lastUpdate = new Date();
		status = 'A';
	}
	
	@PreUpdate
	private void onUpdate() {
		lastUpdate = new Date();
	}
}
