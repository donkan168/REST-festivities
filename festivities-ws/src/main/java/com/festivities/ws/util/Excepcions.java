package com.festivities.ws.util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * <b>Description: </b>Class for manage the exceptions  
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class Excepcions {


	/**
	 * Method that generate a error response with 500 code
	 * @param internalMessage
	 * @param e
	 * @param entity
	 * @return
	 */
	public static WebApplicationException internalError(String internalMessage,
			Exception e, Object entity) {
		Status status = Status.INTERNAL_SERVER_ERROR;
		String mensaje = "Ha ocurrido un error inesperado en el sistema.";
		Error err = new Error(500, status.getStatusCode(), mensaje, internalMessage, e);
		//logExcepcion(err);
		return generarExcepcionBodyJSON(err, entity);
	}

	/**
	 * Method that generate a error response with 404 code
	 * @param principalName
	 * @param idUsuario
	 * @param e
	 * @param entidad
	 * @return
	 */
	public static WebApplicationException noEncontrado(String principalName,
			String idUsuario, Exception e, Object entidad) {
		Status status = Status.NOT_FOUND;
		String mensaje = "No se ha encontrado informacion para los criterios de busqueda.";
		String mensajeInterno = "Principal: " + principalName + " Recurso: /u/"
				+ idUsuario;
		Error err = new Error(404, status.getStatusCode(), mensaje,
				mensajeInterno, e);
		return generarExcepcionBodyJSON(err, entidad);
	}

	/**
	 * Method that generate a error response with 500 code
	 * @param principalName
	 * @param e
	 * @param entity
	 * @return
	 */
	public static WebApplicationException preCondicionFallida(String principalName,
			Exception e, Object entity) {
		Status status = Response.Status.INTERNAL_SERVER_ERROR;
		String mensaje = "Recurso NO modificado.";
		String mensajeInterno = "Principal: " + principalName + " Recurso: /u/";
		Error err = new Error(412, status.getStatusCode(), mensaje, mensajeInterno, e);
		return generarExcepcionBodyJSON(err, entity);
	}

	/**
	 * Method that generate a JSON response
	 * @param err
	 * @param entidadError
	 * @return
	 */
	private static WebApplicationException generarExcepcionBodyJSON(Error err, Object entidadError) {
		return new WebApplicationException(Response.status(err.getIdError()).entity(entidadError)
				.type(MediaType.APPLICATION_JSON).language("es-CO").build());
	}	

}
