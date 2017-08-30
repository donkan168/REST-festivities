package com.festivities.ws.util;

/**
 * <b>Description: </b>Class with the links of the reponse service restful
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class Link {
	
	private String id;
	private String href;
	
	public Link(String id, String href) {
		super();
		this.id = id;
		this.href = href;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param rel the rel to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

}
