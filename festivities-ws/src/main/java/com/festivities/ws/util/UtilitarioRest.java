/**
 * 
 */
package com.festivities.ws.util;

import java.util.Date;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;


/**
 * <b>Description: </b>Util Class for the control of the message in the response petitions   
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class UtilitarioRest {

	/** Constantes **/	
	private static final int MAX_AGE = 900;	

	/** Constructores **/	
	public UtilitarioRest() {
	}


	/**
	 * Method create response successful
	 * @param lastModified
	 * @param entidad
	 * @return
	 */
	public Response createResponseOK( Date lastModified, ObjectSetResponse entidad){

		ResponseBuilder response = null;

		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(MAX_AGE); // Expira caché después de MAX_AGE segundos.
		cacheControl.setPrivate(true); // Los proxies no deben cachear
		entidad.setCodeResponse(Status.OK.getStatusCode());
		entidad.setMessage("OK");
		response =  Response.status(Status.OK).entity(entidad).cacheControl(cacheControl)
				.lastModified(lastModified).language("es-CO");		

		return response.build();		
	}

	/**
	 * Method create error response 
	 * @param lastModified
	 * @param entidad
	 * @param e1
	 * @return
	 */
	public Response createResponseFail( Date lastModified, ObjectSetResponse entidad, Exception e1){

		ResponseBuilder response = null;

		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(MAX_AGE); 
		cacheControl.setPrivate(true); 
		entidad.setCodeResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode());
		
		if (e1!=null) {
			entidad.setMessage("Caused by: " + e1.getMessage());
		}
		response =  Response.status(Status.OK).entity(entidad).cacheControl(cacheControl)
				.lastModified(lastModified).language("es-CO");		

		return response.build();		
	}


	/**
	 * Method create a not found matches
	 * @param date
	 * @param dataResponse
	 * @return
	 */
	public Object createResponseNotFound(Date date, ObjectSetResponse dataResponse) {
		ResponseBuilder response = null;

		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(MAX_AGE); 
		cacheControl.setPrivate(true); 
		dataResponse.setCodeResponse(Status.NOT_FOUND.getStatusCode());
		dataResponse.setMessage("Data not found");
		response =  Response.status(Status.OK).entity(dataResponse).cacheControl(cacheControl)
				.lastModified(date).language("es-CO");		

		return response.build();	
	}
}
