package com.festivities.ws.util;

import java.io.Serializable;
import java.util.List;


/**
 * <b>Description: </b>Class for respone de the request petition  
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class ObjectSetResponse implements Serializable {

	private static final long serialVersionUID = 3261830607267887570L;
	
	private String lastModified;
	private Links links;
	private List<?> data;
	private int codeResponse;
	private String message;


 
	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}



	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}



	/**
	 * @return the links
	 */
	public Links getLinks() {
		return links;
	}



	/**
	 * @param links the links to set
	 */
	public void setLinks(Links links) {
		this.links = links;
	}



	/**
	 * @return the data
	 */
	public List<?> getData() {
		return data;
	}



	/**
	 * @param data the data to set
	 */
	public void setData(List<?> data) {
		this.data = data;
	}



	/**
	 * @return the codeResponse
	 */
	public int getCodeResponse() {
		return codeResponse;
	}



	/**
	 * @param codeResponse the codeResponse to set
	 */
	public void setCodeResponse(int codeResponse) {
		this.codeResponse = codeResponse;
	}



	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}



	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}



public static class Links implements Serializable {
		
		/** Atributo */
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 */
		private Link[] paginasDatos;
		
		/**
		 * @param paginasDatos
		 */
		public Links(Link[] paginasDatos) {
			super();
			this.paginasDatos = paginasDatos;
		}

		/**
		 * @return
		 */
		public Link[] getPaginasDatos() {
			return paginasDatos;
		}

		/**
		 * @param paginasDatos
		 */
		public void setPaginasDatos(Link[] paginasDatos) {
			this.paginasDatos = paginasDatos;
		}
	}


}
