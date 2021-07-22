package edu.cecar.modelo;




import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import edu.cecar.componentes.Utilidades;

public class ObtenerPaises {

	public static void scrapin(String[] args) throws IOException {

		String url5 = "recursos/20200812-covid-19-sitrep-205.pdf";
		String url1 = "recursos/20200813-covid-19-sitrep-206.pdf";
		String url2 = "recursos/20200814-covid-19-sitrep-207.pdf";
		String url3 = "recursos/20200815-covid-19-sitrep-208.pdf";
		String url4 = "recursos/20200816-covid-19-sitrep-209.pdf";

		List<String> urls = new ArrayList<String>();
		urls.add(url5);
		urls.add(url1);
		urls.add(url2);
		urls.add(url3);
		urls.add(url4);

		for (String url : urls) {

			PDDocument pdDocument = PDDocument.load(new File(url));
			PDFTextStripper stripper = new PDFTextStripper();
			String texto = Utilidades.getTextoConFormato(pdDocument, 4).toLowerCase();
			
			texto = texto.replaceAll("united\\s*states\\s*of\\s*america", "united states of america").replaceAll("dominican\\s*republic", "dominican republic");
			//System.out.println(texto);

			//Se busca la posicion inicial del continente africano
			String tag = "table 1";
			String tag1 = "united states of america";
			String tag2 = "dominican republic";

			int posicionInicial = texto.indexOf(tag);
			posicionInicial = texto.indexOf(tag1,posicionInicial);
			int posicionFinal = texto.indexOf(tag2,posicionInicial);

			String datosPaises = texto.substring(posicionInicial,posicionFinal);
			String[] paises = datosPaises.split("\n");
			
			for (String pais : paises) {

				pais = pais.replaceAll("\\s{10,}", "@");

				if (!pais.trim().isEmpty()) {

				String[] columnas = pais.split("@");
				String country = columnas[0].trim();
				String totalCasosConfirmados = columnas[1];
				String totalNuevosCasosConfirmados = columnas[2];
				String totalMuertes = columnas[3];
				String totalNuevasMuertes = columnas[4];

				System.out.format("%s\n%s\n%s\n%s\n%s\n\n", country,
						" Total Casos Confirmados: "+ totalCasosConfirmados,
						" Total Nuevos Casos Confirmados: "+ totalNuevosCasosConfirmados,
						" Total Muertes: "+totalMuertes,
						" Total Nuevas Muertes: 2"+totalNuevasMuertes);

				}

				}

			
		}






	}

}



