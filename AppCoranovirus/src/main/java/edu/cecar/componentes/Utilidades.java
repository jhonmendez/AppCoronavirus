package edu.cecar.componentes;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.json.JSONObject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

public class Utilidades {
	
	public static boolean esCorreoCorrecto(String emailAverificar) {
		
		
		
		boolean resultado = false;
		
		String endPoint ="http://apilayer.net/api/check?access_"
				+ "key=703c7b883e3e7e526f362a6d2200c471&email="+emailAverificar
				+ "&smtp=1&format=1" ;


			
			Client client1 = ClientBuilder.newClient();
			Response response = client1.target(endPoint).request().get();
			String resultadoAPI = response.readEntity(String.class);

			JSONObject jsonObject = new JSONObject(resultadoAPI);
			if (!jsonObject.has("error")) {
				resultado = jsonObject.getBoolean("smtp_check");
			}
			
		
		return resultado;
		
		
	}

	public static String getTextoConFormato(PDDocument document,float size) throws IOException {

		LayoutTextStripper stripper = new LayoutTextStripper();
		stripper.setSortByPosition(true);

		stripper.fixedCharWidth = size;
		String textoConFormato = stripper.getText(document);

		return textoConFormato;
	}
	
}
