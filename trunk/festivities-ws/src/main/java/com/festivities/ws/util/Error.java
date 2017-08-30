package com.festivities.ws.util;

/**
 * <b>Description: </b>Class for managed the exceptions  
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class Error {

	/** Atributos **/

	private Integer idError;
	private Integer idInternoError;
	private String mensaje;
	private String mensajeInterno;
	private Throwable excepcion;

	/** Constructor **/

	public Error(Integer idInternoError, Integer idError, String mensaje,
			String mensajeInterno, Throwable exception) {
		super();
		this.idInternoError = idInternoError;
		this.idError = idError;
		this.mensaje = mensaje;
		this.mensajeInterno = mensajeInterno;
		this.excepcion = exception;
	}

	/** Getters y setters **/

	public Integer getIdError() {
		return idError;
	}

	public void setIdError(Integer idError) {
		this.idError = idError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeInterno() {
		return mensajeInterno;
	}

	public void setMensajeInterno(String detalle) {
		this.mensajeInterno = detalle;
	}

	public Integer getIdInternoError() {
		return idInternoError;
	}

	public void setIdInternoError(Integer idInternoError) {
		this.idInternoError = idInternoError;
	}

	public Throwable getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(Throwable excepcion) {
		this.excepcion = excepcion;
	}

	@Override
	public String toString() {
		Throwable t = this.getExcepcion();
		String detallePlataforma = null;
		while (t != null && t.getCause() != null) {
			t = t.getCause();
			detallePlataforma = t.getLocalizedMessage();
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{\"idInterno\": \"");
		sb.append(this.getIdInternoError());
		sb.append("\", \"idExterno\": \"");
		sb.append(this.getIdError());
		sb.append("\", \"mensaje\": \"");
		sb.append(this.getMensaje());
		sb.append("\", \"mensajeInterno\": \"");
		sb.append(this.getMensajeInterno());
		sb.append("\", \"detallePlataforma\": \"");
		sb.append(detallePlataforma);
		sb.append("\"}");

		return sb.toString();
	}

}

