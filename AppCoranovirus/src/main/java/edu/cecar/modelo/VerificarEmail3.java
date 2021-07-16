package edu.cecar.modelo;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.mail.search.AndTerm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;


public class VerificarEmail3 {


	Scanner entrada = new Scanner(System.in);
	Scanner entradaYN = new Scanner(System.in);
	Scanner entradac1 = new Scanner(System.in);
	String emailAverificar = null ;
	String emailAverificar2 = null ;
	//String emailAverificar;
	public VerificarEmail3() {



		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; //Guardaremos la opcion del usuario

		System.out.println(".:: APP CORONAVIRUS ::.");
		
		
		while(!salir){

			System.out.println("1. ingresar correo");
			
			System.out.println("2. mostrando datos en pantalla");
	
			System.out.println("3. Salir");

			System.out.println("Escribe una de las opciones");
			opcion = sn.nextInt();

			switch(opcion){
			case 1:
				
				

				System.out.print("Ingrese su correo: ");
				String emailAverificar = entrada.nextLine();
				
				
				break;
			case 2:
				
				
				//System.out.println(pais);
				  
			case 3:
				salir=true;
				break;
			default:
				System.out.println("Solo números entre 1 y 4");
			}

		}
		// TODO Auto-generated constructor stub
		

		String y = "y";
		String n = "n";
		//String emailAverificar = "juan.benavides@cecar.edu.co";
		ArrayList<String> almacenarCorreos = new ArrayList<String>();

		

		almacenarCorreos.add(emailAverificar);

		String endPoint ="http://apilayer.net/api/check?access_"
				+ "key=703c7b883e3e7e526f362a6d2200c471&email="+emailAverificar
				+ "&smtp=1&format=1" ;

		
		
		

			System.out.print("Ingrese su correo: ");
			emailAverificar2 = entradac1.nextLine();
			almacenarCorreos.add(emailAverificar2);

			String endPoint1 ="http://apilayer.net/api/check?access_"
					+ "key=703c7b883e3e7e526f362a6d2200c471&email="+emailAverificar2
					+ "&smtp=1&format=1" ;
			Client client1 = ClientBuilder.newClient();
			Response response = client1.target(endPoint1).request().get();
			String result1 = response.readEntity(String.class);

			JSONObject jsonObject = new JSONObject(result1);
			boolean format_valid = jsonObject.getBoolean("format_valid");
			boolean smtp_check = jsonObject.getBoolean("smtp_check");




			if (smtp_check == true) {
				System.out.println("El correo es existente");
			}
			else {
				System.out.println("El correo no existe");
			}
			if (format_valid == true) {
				System.out.println("El correo tiene un formato valido");
			}
			else {
				System.out.println("El correo no tiene un formato valido");
			}

			System.out.println("desea ingresar otro correo y/n");
			String respuesta2 = entradaYN.nextLine();
			if (y.equals(respuesta2)) {


			}


		


		













		if (smtp_check == true) {
			System.out.println("El correo es existente");
		}
		else {
			System.out.println("El correo no existe");
		}
		if (format_valid == true) {
			System.out.println("El correo tiene un formato valido");
		}
		else {
			System.out.println("El correo no tiene un formato valido");
		}
		// System.out.println(format_valid);
		//  System.out.println(smtp_check);

		System.out.println("datos en pantalla de los 10 paises");


	}

	public static void main(String[] args) {

		new VerificarEmail3();
		new ObtenerPaises3();
	}
}