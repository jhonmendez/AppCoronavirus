package edu.cecar.modelo;




import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ObtenerPaises2 {

	public static void main(String[] args) throws IOException {

		String url = "recursos/20200812-covid-19-sitrep-205.pdf";
        String url1 = "recursos/20200813-covid-19-sitrep-206.pdf";
        String url2 = "recursos/20200813-covid-19-sitrep-207.pdf";
        String url3 = "recursos/20200813-covid-19-sitrep-208.pdf";
        String url4 = "recursos/20200813-covid-19-sitrep-209.pdf";
        
        
		PDDocument pdDocument = PDDocument.load(new File(url));
		PDFTextStripper stripper = new PDFTextStripper();
		String texto = stripper.getText(pdDocument).toLowerCase();

		//Se busca la posicion inicial del continente americano
		String tag = "table 1";
		String tag1 = "americas";
		String tag2 = "united states of america";
		String tag21 = "community transmission";
		String tag9 = "brazil";
		

		int posicionInicial1 = texto.indexOf(tag);
		posicionInicial1 = texto.indexOf(tag2,posicionInicial1);
		int posicionFinal1 = texto.indexOf(tag21,posicionInicial1);
		
		String datounitedStatesOfAmerica = texto.substring(posicionInicial1, posicionFinal1);
		String[] unitedStatesOfAmerica = datounitedStatesOfAmerica.split("\n");
		
		for (String usa : unitedStatesOfAmerica) {
			//System.out.println(usa);
			
		}
		
		
		//*************************************************************************
		int posicionInicial = texto.indexOf(tag);
		posicionInicial = texto.indexOf(tag1,posicionInicial);
		int posicionFinal = texto.indexOf(tag9,posicionInicial);

		String datosPaises = texto.substring(posicionInicial,posicionFinal);
		String[] paises = datosPaises.split("\n");
		
		String rutaArchivo = System.getProperty("user.home")+"/AMERICA.xls";

		File archivoXLS = new File(rutaArchivo);

		if(archivoXLS.exists()) archivoXLS.delete();

		try {
			archivoXLS.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Workbook libro = new HSSFWorkbook();

		FileOutputStream archivo = new FileOutputStream(archivoXLS);

		for (String pais : paises) {
			
			  String nombre1 = null;
			  String TotalConfirmedCases = null;
			  String TotalConfirmedNewCases = null;
			  String TotalDeaths = null;
			  String TotalNewDeaths = null;
			  
			Sheet hoja = libro.createSheet(nombre1);
			  
			Row fila = hoja.createRow(0);
			Cell celda = fila.createCell(0);
			Cell celda1 = fila.createCell(1);
			Cell celda2 = fila.createCell(1);
			Cell celda3 = fila.createCell(1);
			Cell celda4 = fila.createCell(1);
			celda.setCellValue("Pais");
			celda1.setCellValue("Total Confirmed Cases");
			celda2.setCellValue("Total Confirmed New Cases");
			celda3.setCellValue("Total Deaths");
			celda4.setCellValue("Total New Deaths");

			  Row fila2 = hoja.createRow(1);
			  Cell celda12 = fila.createCell(0);
				Cell celda11 = fila.createCell(1);
				Cell celda22 = fila.createCell(1);
				Cell celda33 = fila.createCell(1);
				Cell celda44 = fila.createCell(1);
				
				celda12.setCellValue(nombre1);
				celda11.setCellValue(TotalConfirmedCases);
				celda22.setCellValue(TotalConfirmedNewCases);
				celda33.setCellValue(TotalDeaths);
				celda44.setCellValue(TotalNewDeaths);
			  

			//System.out.println(pais);
		}


		try {
			libro.write(archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Desktop.getDesktop().open(archivoXLS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
