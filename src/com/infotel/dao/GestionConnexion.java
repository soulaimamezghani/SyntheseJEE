package com.infotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GestionConnexion {
	
				// preparer les éléments de connection
				private String url="jdbc:postgresql://localhost:5432/SyntheseJEE";
				private String user="postgres";
				private String pass="21031990";
				
				// Objet Connection
				private static Connection conn;// conn  nom de variable l'objet cest conn
				// constructeur privé     
				//ce constructeur permet de créer une connection
				private GestionConnexion() {// but ici je veux pas plusieurs ponts de cx 
					try {
							Class.forName("org.postgresql.Driver");		
							conn=DriverManager.getConnection(url,user,pass); //il te souligne Connection on fait import Connection.java.sql
					}
					catch (Exception e) {
							System.out.println("Erreur de Connection");
					}
				}
				
				// méthode d'attribution de connection
				// permet de s'assurer de l'unicité de la connection
				public static Connection getInstance () { //Connection nom de classe et getInstance nom de la methode
					if (conn==null) {
						new GestionConnexion ();// je dois donner  valeur à conn 
					}
					return conn;
				}
}