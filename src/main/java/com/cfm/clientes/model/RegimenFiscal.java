package com.cfm.clientes.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegimenFiscal {
	
	@NotNull(message = "El argumento id no puede ser nulo")
	private Integer id;
	
	@NotBlank(message = "El argumento nombreRegimen no puede ser nulo")
	private String nombreRegimen;
	
	@NotNull(message = "El argumento rfcSize no puede ser nulo")
	private Integer rfcSize;
}
