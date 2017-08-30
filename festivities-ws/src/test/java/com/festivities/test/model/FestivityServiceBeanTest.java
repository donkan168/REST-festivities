package com.festivities.test.model;

import java.util.List;

import com.festivities.vo.FestivitiesVO;
import com.festivities.ws.rest.business.FestivitiyServiceBean;

import junit.framework.TestCase;
/**
 * <b>Description: </b>Test class for test method in the layer of services  
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class FestivityServiceBeanTest extends TestCase {

	/**
	 * Method that evaluate if is posible create a festivity in the services layer
	 */
	public void testCreateFestivity() {
		FestivitiyServiceBean serviceBean = new FestivitiyServiceBean();

		FestivitiesVO festivity = new FestivitiesVO();
		festivity.setNameEvent("testEvent");
		festivity.setNamePlace("some place");
		festivity.setStartDate("27-08-2017");
		festivity.setEndDate("29-08-2017");
		try {
			serviceBean.createFestivity(festivity );
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
		assertTrue(Boolean.TRUE);
	}

	/**
	 * Method that evaluate if is posible search a festivity in the services layer
	 */
	public void testQueryFestivity() {
		FestivitiyServiceBean serviceBean = new FestivitiyServiceBean();

		FestivitiesVO festivity = new FestivitiesVO();
		festivity.setNamePlace("some place");
		List<FestivitiesVO> listFestivities = null;
		try {
			listFestivities = serviceBean.queryFestivity(festivity );
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
		assertNotNull(listFestivities);

	}

	/**
	 * Method that evaluate if is posible update a festivity in the services layer
	 */
	public void testUpdateFestivity() {
		FestivitiyServiceBean serviceBean = new FestivitiyServiceBean();

		FestivitiesVO festivity = new FestivitiesVO();
		festivity.setNameEvent("NEW test Event");
		festivity.setNamePlace("some place");
		festivity.setStartDate("27-08-2017");
		festivity.setEndDate("31-08-2017");
		try {
			serviceBean.updateFestivity(festivity );
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
		assertTrue(Boolean.TRUE);
	}

}
