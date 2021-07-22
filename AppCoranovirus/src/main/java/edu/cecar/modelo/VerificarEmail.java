package edu.cecar.modelo;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;


public class VerificarEmail {


	Scanner entrada = new Scanner(System.in);
	Scanner entradaYN = new Scanner(System.in);
	Scanner entradac1 = new Scanner(System.in);
	//String emailAverificar;
	public VerificarEmail() {
		// TODO Auto-generated constructor stub
		String emailAverificar = null ;
		String emailAverificar2 = null ;
		
		String y = "y";
		//String emailAverificar = "juan.benavides@cecar.edu.co";
		ArrayList<String> almacenarCorreos = new ArrayList<String>();

		System.out.println(".:: BIENVENIDOS ::.");

		System.out.print("Ingrese su correo: ");
		emailAverificar = entrada.nextLine();

		almacenarCorreos.add(emailAverificar);

		String endPoint ="http://apilayer.net/api/check?access_"
				+ "key=703c7b883e3e7e526f362a6d2200c471&email="+emailAverificar+emailAverificar2
				+ "&smtp=1&format=1" ;

		System.out.println("desea ingresar otro correo y/n");
		String respuesta = entradaYN.nextLine();
		if (y.equals(respuesta)) {

			System.out.print("Ingrese su correo: ");
			emailAverificar2 = entradac1.nextLine();
			almacenarCorreos.add(emailAverificar2);
		}

       




		Client client = ClientBuilder.newClient();
		Response response = client.target(endPoint).request().get();
		String result = response.readEntity(String.class);
		//System.out.println(result);



		JSONObject jsonObject = new JSONObject(result);
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
		// System.out.println(format_valid);
		//  System.out.println(smtp_check);



	}

	public static void main(String[] args) {

		new VerificarEmail();


		/*
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("c:\\FileTests\\prueba.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String blog = (String) jsonObject.get("Blog");
			System.out.println(blog);

			String temas = (String) jsonObject.get("Temas");
			System.out.println(temas);

			long inicio = (Long) jsonObject.get("Inicio");
			System.out.println(inicio);

			JSONObject innerObject = (JSONObject) jsonObject.get("Posts");
			System.out.println(innerObject.toJSONString());

			// loop array
			JSONArray tags = (JSONArray) jsonObject.get("Tags");
			Iterator<Object> iterator = tags.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (ParseException e) {
			//manejo de error
		}
		 */

	}
}
