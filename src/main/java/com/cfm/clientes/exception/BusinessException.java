package com.cfm.clientes.exception;

/**
 * @author Jose Daniel Rojas Morales
 * @version 1.0.0
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 2067211376491502400L;
	
	public BusinessException(String message) {
		super(message);
	}
	
}
 