package com.festivities.ws.rest.business;

import java.util.List;

import com.festivities.constant.ConstantColletions;
import com.festivities.persistence.GenericDAO;
import com.festivities.vo.FestivitiesVO;

/**
 * <b>Descripcion: </b>Class for expose the services
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class FestivitiyServiceBean {

	
	/**Instancia del DAO generico para CRUD */
	private GenericDAO dao;
	
	/**
	 *<b>Descripcion: </b>Constructor de la clase
	 */
	public FestivitiyServiceBean() {
		dao = new GenericDAO();
	}
	
	/**
	 * <b>Description: </b> Method thar save a document of the festivitie collection
	 * @param persona
	 * @throws Exception
	 */
	public void createFestivity(final FestivitiesVO festivity) throws Exception {
		dao.guardarDocumento(festivity.festivityToBasicDBObject(), ConstantColletions.FESTIVITY);
	}

	/**
	 * <b>Description: </b> Method thar search documents of the festivitie collection
	 * @param persona
	 * @throws Exception
	 */
	public List<FestivitiesVO> queryFestivity(final FestivitiesVO festivity) {
		List<FestivitiesVO> listaFestivities = dao.getDocuments(festivity);
		return listaFestivities;
	}
	
	/**
	 * <b>Description: </b> Method thar update documents of the festivitie collection
	 * @param persona
	 * @throws Exception
	 */
	public void updateFestivity(final FestivitiesVO festivity) throws Exception {
		dao.updateDocumento(festivity.festivityToBasicDBObject(), ConstantColletions.FESTIVITY);
	}
}
