package com.festivities.test.rest.ws;

import com.festivities.vo.FestivitiesVO;
import com.festivities.ws.rest.service.ServiceRestFestivities;

import junit.framework.TestCase;

/**
 * <b>Description: </b>Test  class for the test in the layer restful
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class ServiceRestFestivitiesTest extends TestCase {

	/**
	 * Method that evaluate if is posible create a festivity
	 */
	public void testCreateFestivity() {
		ServiceRestFestivities serviceBean = new ServiceRestFestivities();

		try {
			serviceBean.createFestivity(null, null, null, "test Event rest services", "Bogota north", "17-09-2017", "12-10-2017");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
		assertTrue(Boolean.TRUE);
	}

	/**
	 * Method that evaluate if is posible query a festivity
	 */
	public void testQueryFestivity() {
		ServiceRestFestivities serviceBean = new ServiceRestFestivities();

		FestivitiesVO festivity = new FestivitiesVO();
		festivity.setNamePlace("some place");
		Object listFestivities = null;
		try {
			listFestivities =  serviceBean.queryFestivity(null, null, null, null, "Bogota north", null, null);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
		assertNotNull(listFestivities);

	}

	/**
	 * Method that evaluate if is posible update a festivity
	 */
	public void testUpdateFestivity() {
		ServiceRestFestivities serviceBean = new ServiceRestFestivities();

		FestivitiesVO festivity = new FestivitiesVO();
		festivity.setNameEvent("very Soon");
		festivity.setNamePlace("Bogota north");
		festivity.setStartDate("12-10-2017");
		festivity.setEndDate("13-12-2017");
		try {
			serviceBean.updateFestivity(null, null, null, festivity);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
		assertTrue(Boolean.TRUE);
	}

}
