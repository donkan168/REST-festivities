package com.festivities.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <b>Description: </b>Class for operations of the dates  
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public final class DateUtils {

	
	/** Formato fecha ddDeMMMMDeyyyy, ejemplo: 24 de diciembre de 2015. */
	public static final String FORMAT_ddDeMMMMDeyyyy = "dd ' de ' MMMM ' de ' yyyy";
	public static final String DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
	public static final String DATE_PATTERN_SIMPLE = "dd-MM-yyyy";

	private DateUtils() {
	}

	private static final Calendar getCalendar() {
		return GregorianCalendar.getInstance();
	}

	/**
	 * Retorna la fecha actual
	 * 
	 * @return
	 */
	public static final Date getCurrentDate() {
		return new Date();
	}

	/**
	 * Devuelve la fecha del d�a a medianoche
	 * 
	 * @param fecha
	 * @return fecha a medianoche del mismo d�a
	 */
	public static final Date dateAtMidnight(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		return calendar.getTime();
	}

	/**
	 * Devuelve la fecha actual del sistema a medianoche
	 * 
	 * @return fecha actual del sistema a medianoche
	 */
	public static final Date getCurrentDateAtMidnight() {
		return dateAtMidnight(getCurrentDate());
	}

	/**
	 * Formato en hora militar
	 * 
	 * @param fecha
	 * @return fecha en formato militar
	 */
	public static final Date to24HoursClockTimes(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		return calendar.getTime();
	}
	
	/**
	 * hora 23:59:59 a un date
	 * 
	 * @param fecha
	 * @return fecha en formato militar
	 */
	public static final Date to23HoursClockTimes(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * Suma (o resta pasandole un valor negativo) la fecha por el numero de dias
	 * 
	 * @param fecha
	 * @param n�mero
	 *            de d�as
	 * @return fecha
	 */
	public static final Date addDays(Date date, int numberDays) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, numberDays);
		return calendar.getTime();
	}
	
	/**
	 * Suma (o resta pasandole un valor negativo) la fecha por el numero de dias
	 * 
	 * @param fecha
	 * @param n�mero
	 *            de d�as
	 * @return fecha
	 */
	public static final Date addHours(Date date, int numberHours) {
		
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, numberHours);
		
		return calendar.getTime();
	}

	/**
	 * Suma (o resta pasandole un valor negativo) la fecha por el numero de mesews
	 * 
	 * @param fecha
	 * @param n�mero
	 *            de meses
	 * @return fecha
	 */
	public static final Date addMonths(Date date, int numberMonths) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, numberMonths);
		return calendar.getTime();
	}

	/**
	 * Suma (o resta pasandole un valor negativo) la fecha por el numero de a�os
	 * 
	 * @param fecha
	 * @param n�mero
	 *            de a�os
	 * @return fecha
	 */
	public static final Date addYears(Date date, int numberYears) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, numberYears);
		return calendar.getTime();
	}

	/**
	 * Retorna el a�o de una fecha
	 * 
	 * @param date
	 * @return a�o
	 */
	public static final int getYear(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * Retorna el mes de una fecha
	 * @param date
	 * @return
	 */
	public static final int getMonth(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}
	
	/**
	 * Retorna el dia del mes
	 * @param date
	 * @return
	 */
	public static final int getDay(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Retorna el a�o actual
	 * 
	 * @return a�o
	 */
	public static final int getCurrentYear() {
		return getYear(getCurrentDate());
	}

	/**
	 * Obtiene la fecha del �ltimo dia del a�o
	 * 
	 * @param date
	 * @return date
	 */
	public static final Date getLastDateOfYear(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 31);
		return calendar.getTime();
	}

	/**
	 * Obtiene la fecha del �ltimo dia del a�o actual
	 * 
	 * @param date
	 * @return date
	 */
	public static final Date getLastDateOfYearOfCurrentDate() {
		return getLastDateOfYear(getCurrentDate());
	}

	/**
	 * Retorna la fecha con el formato especificado
	 * 
	 * @param date
	 * @return string con la fecha formateada
	 */
	public static String format(Date date, String format) {
		Locale loc = new Locale("es", "ES");
		SimpleDateFormat sdf = new SimpleDateFormat(format, loc);
		return sdf.format(date);
	}

	/**
	 * Retorna la fecha con el formato por defecto cuando se aplica
	 * Date.toString()
	 * 
	 * @param fecha
	 *            en formato String
	 * @return fecha en formato Date
	 * @throws Exception 
	 */
	public static Date parse(String date) throws Exception {
		final String format = "EEE MMM dd hh:mm:ss zzz yyyy";
		return parse(date, format);
	}

	
	/**
	 * Retorna la fecha con el formato ingreasado, si no el formato es null
	 * apica el formato por defecto Locale.getDefault(Locale.Category.FORMAT)
	 * 
	 * @param fecha
	 *            en formato String
	 * @param Formato
	 * @return fecha en formato Date
	 * @throws Exception 
	 */
	public static Date parse(String date, String format) throws Exception {
		try {
			SimpleDateFormat sdf =! JavaUtils.isEmpty(format) ? new SimpleDateFormat(
					format, Locale.US) : new SimpleDateFormat();
			return sdf.parse(date);
		} catch (IllegalArgumentException e) {
			throw new Exception("El formato " + format
					+ " para la fecha no es v�lido", e);
		} catch (ParseException e) {
			throw new Exception("No se puede convertir la fecha "
					+ date + " en formato Date con el formato " + format, e);
		}
	}

	public static Date fromXMLGregorianCalendar(XMLGregorianCalendar date) {
		GregorianCalendar cal = date.toGregorianCalendar();
		return cal.getTime();
	}
	
	public static Calendar getCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static int diffDateInYears(Date fechaInicial, Date fechaFinal){
		Calendar fechaInic = DateUtils.getCalendar(fechaInicial);
		Calendar fechaFin = DateUtils.getCalendar(fechaFinal);
		int diff = fechaFin.get(Calendar.YEAR) - fechaInic.get(Calendar.YEAR);
		if (fechaInic.get(Calendar.MONTH) > fechaFin.get(Calendar.MONTH) || 
				(fechaInic.get(Calendar.MONTH) == fechaFin.get(Calendar.MONTH) && fechaInic.get(Calendar.DATE) > fechaFin.get(Calendar.DATE))) {
	        diff--;
	    }
	    return diff;
	}
	
	
	public static Date convertStringToDate(String formato, String fecha) throws ParseException{
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato, Locale.forLanguageTag("ES"));
		return formatoDelTexto.parse(fecha);
	}
	
}