package com.festivities.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.festivities.enumeration.EnumFestivity;
import com.festivities.ws.util.DateUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * <b>Descripcion: </b>VO of the entity or collection festivity 
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class FestivitiesVO implements Serializable {

	
	/**
	 * Serial Version attribute
	 */
	private static final long serialVersionUID = 1L;
	private String nameEvent;
	private String namePlace;
	private String startDate;
	private String endDate;
	
	public FestivitiesVO() {
		super();
	}
	
	public FestivitiesVO(BasicDBObject dBObjectFutbolista) {
		this.nameEvent = dBObjectFutbolista.getString("nameEvent");
		this.namePlace = dBObjectFutbolista.getString("namePlace");
	}

	
	public FestivitiesVO(DBObject document) {
		this.nameEvent =   (String) document.get(EnumFestivity.NAME_EVENT.name());
		this.namePlace =   (String) document.get(EnumFestivity.NAME_PLACE.name());
		try {
//			if (((Date) document.get(EnumFestivity.START_DATE.name())!=null)) {
//				this.startDate = DateUtils.parse(DateUtils.format((Date) document.get(EnumFestivity.START_DATE.name()), DateUtils.DATE_PATTERN_SIMPLE), DateUtils.DATE_PATTERN_SIMPLE);
//			}
//			if (((Date) document.get(EnumFestivity.START_DATE.name()) != null)) {
//				this.endDate = DateUtils.parse(DateUtils.format((Date) document.get(EnumFestivity.END_DATE.name()), DateUtils.DATE_PATTERN_SIMPLE), DateUtils.DATE_PATTERN_SIMPLE);
//			}

			//Time in UTC
			if ((document.get(EnumFestivity.START_DATE.name())!=null)) {
				final SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_PATTERN_SIMPLE);
			    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			    this.startDate = sdf.format(new Date());
			}
			if ((document.get(EnumFestivity.START_DATE.name())!=null)) {
				final SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_PATTERN_SIMPLE);
			    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			    this.startDate = sdf.format(new Date());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public BasicDBObject festivityToBasicDBObject() {
		BasicDBObject documento =new BasicDBObject();
		documento.append(EnumFestivity.NAME_EVENT.name(), nameEvent);
		documento.append(EnumFestivity.NAME_PLACE.name(), namePlace);
		documento.append(EnumFestivity.START_DATE.name(), startDate);
		documento.append(EnumFestivity.END_DATE.name(), endDate);
		
		return documento;
	}
	
	public BasicDBObject toDBObjectFutbolista() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectFestivity = new BasicDBObject();

		dBObjectFestivity.append("nameEvent", this.getNameEvent());
		dBObjectFestivity.append("namePlace", this.getNamePlace());

		return dBObjectFestivity;
	}

	/**
	 * @return the nameEvent
	 */
	public String getNameEvent() {
		return nameEvent;
	}

	/**
	 * @param nameEvent the nameEvent to set
	 */
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	/**
	 * @return the namePlace
	 */
	public String getNamePlace() {
		return namePlace;
	}

	/**
	 * @param namePlace the namePlace to set
	 */
	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "NameEvent: " + this.getNameEvent() + "NamePlace: " + this.getNamePlace();
	}
}
