/**
 * @Clase: ScraperExcel.java
 * 
 * @version  0.1
 * 
 * @since 22 jul. 2021
 * 
 * @autor Ing. Jhon Mendez
 *
 * @Copyrigth: CECAR
 */

package edu.cecar.scraper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;

import edu.cecar.componentes.Utilidades;
import edu.cecar.modelo.DatoCoranovirus;

/**
 * Descripción de la clase
 */

public class ScraperExcel {

	public static List<DatoCoranovirus>  getDatosScrapingExcel() throws IOException {

		List<DatoCoranovirus> listadoDatosCoranovirus = new ArrayList<DatoCoranovirus>();

		String url1 = "recursos/20200813-covid-19-sitrep-206.pdf";
		String url2 = "recursos/20200814-covid-19-sitrep-207.pdf";
		String url3 = "recursos/20200815-covid-19-sitrep-208.pdf";
		String url4 = "recursos/20200816-covid-19-sitrep-209.pdf";
		String url5 = "recursos/20200812-covid-19-sitrep-205.pdf";

		List<String> urls = new ArrayList<String>();
		urls.add(url5);
		urls.add(url1);
		urls.add(url2);
		urls.add(url3);
		urls.add(url4);

		for (String url : urls) {

			PDDocument pdDocument = PDDocument.load(new File(url));
			String texto = Utilidades.getTextoConFormato(pdDocument, 4).toLowerCase();

			texto = texto.replaceAll("united\\s*states\\s*of\\s*america", "united states of america").replaceAll("dominican\\s*republic", "dominican republic");

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
					String nombrePais = columnas[0].trim();
					String totalCasosConfirmados = columnas[1];
					String totalNuevosCasosConfirmados = columnas[2];
					String totalMuertes = columnas[3];
					String totalNuevasMuertes = columnas[4];

					DatoCoranovirus datoCoranovirus = new DatoCoranovirus(nombrePais, totalCasosConfirmados, 
							totalNuevosCasosConfirmados, totalMuertes, totalNuevasMuertes);

					listadoDatosCoranovirus.add(datoCoranovirus);

				}

			}


		}


		return listadoDatosCoranovirus;



	}

}
