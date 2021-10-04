package com.cfm.clientes.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cat_regimen_fiscal")
public class CatRegimenEntity {
	
	@Id
	private Integer id;
	@Column(name = "nombre_regimen")
	private String nombre;
	@Column(name = "rfc_size")
	private Integer rfcSize;
}
