package com.festivities.persistence;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * <b>Descripcion: </b>Singleton for the conexion of the DataBase 
 * @author Mauricio Salamanca - donkan168@gmail.com
 * 	
 * 29/08/2017 2017  
 */
public class DBConexion {


	/**Instancia de la clase */
	private static DBConexion INSTANCE = null;
	
	/**instancia de DB */
	private static DB db;
	
	/**instancia del cliente mongo */
	private static MongoClient mongoClient;

	/**
	 *<b>Descripcion: </b>Constructor de la clase
	 */
	private DBConexion() {
		try {
			//With auth, but if necesary create de user in the databse 
//			Mongo mongo = Mongo.Holder.singleton().connect(MonURI );
//			db = mongo.getDB("festivities");
			
			MongoClient mongoClient = new MongoClient("localhost",27017);
			db = mongoClient.getDB("festivities");
			//		mongo.close();
		} catch (Exception e) {
			System.out.println("No es posible obtener la conexion");
		}
	}
	

	/**
	 * <b>Descripcion: </b> Metodo que obtiene el objeto DB
	 * @return
	 */
	public static DB getConexion() {
		return db;
	}

	/**
	 * <b>Descripcion: </b> Metodo que obtiene la instancia de la clase
	 * @return
	 */
	public static DBConexion getInstance() {
		if (INSTANCE == null) 
			INSTANCE =  new DBConexion();

		return INSTANCE;
	}

	/**
	 * <b>Descripcion: </b> Metodo que se encarga de cerrar la conexion
	 */
	public static void closeConnection() {
		try {
			mongoClient.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexi�n.");
		}
	}

	/**
	 * <b>Descripcion: </b> Metodo que se encarga del borrado de la instancia
	 */
	public static void delInstance() {
		INSTANCE = null;
		closeConnection();
	}
}
