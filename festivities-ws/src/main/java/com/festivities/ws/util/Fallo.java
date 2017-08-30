/**
 * 
 */
package com.festivities.ws.util;

/**
 * <b>Description: </b>Class for manage the exception fails  
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class Fallo {
	
	private String descripcionError;

	public Fallo(){}
	
	public Fallo(String descripcionError) {
		super();
		this.descripcionError = descripcionError;
	}

	/**
	 * @return the descripcionError
	 */
	public String getDescripcionError() {
		return descripcionError;
	}

	/**
	 * @param descripcionError the descripcionError to set
	 */
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

}
