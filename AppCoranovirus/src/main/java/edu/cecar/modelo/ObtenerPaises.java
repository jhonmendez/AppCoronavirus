package edu.cecar.modelo;




import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ObtenerPaises {

	public static void main(String[] args) throws IOException {

		String url = "recursos/20200812-covid-19-sitrep-205.pdf";
        String url1 = "recursos/20200813-covid-19-sitrep-206.pdf";
        String url2 = "recursos/20200813-covid-19-sitrep-207.pdf";
        String url3 = "recursos/20200813-covid-19-sitrep-208.pdf";
        String url4 = "recursos/20200813-covid-19-sitrep-209.pdf";
        
        
		PDDocument pdDocument = PDDocument.load(new File(url));
		PDFTextStripper stripper = new PDFTextStripper();
		String texto = stripper.getText(pdDocument).toLowerCase();

		//Se busca la posicion inicial del continente africano
		String tag = "table 1";
		String tag1 = "americas";
		String tag2 = "dominican republic";

		int posicionInicial = texto.indexOf(tag);
		posicionInicial = texto.indexOf(tag1,posicionInicial);
		int posicionFinal = texto.indexOf(tag2,posicionInicial);

		String datosPaises = texto.substring(posicionInicial,posicionFinal);
		String[] paises = datosPaises.split("\n");

		for (String pais : paises) {

			System.out.println(pais);
		}






	}

}



