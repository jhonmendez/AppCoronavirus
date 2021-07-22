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

import edu.cecar.componentes.Utilidades;


public class CrearExcel3 {

	public static void generalExcel(String[] args)  throws IOException  {



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

		String url = "recursos/20200812-covid-19-sitrep-205.pdf";

		PDDocument pdDocument = PDDocument.load(new File(url));
		PDFTextStripper stripper = new PDFTextStripper();
		String texto = Utilidades.getTextoConFormato(pdDocument, 4).toLowerCase();

		texto = texto.replaceAll("united\\s*states\\s*of\\s*america", "united states of america").replaceAll("dominican\\s*republic", "dominican republic");

		//Se busca la posicion inicial del continente americano
		String tag = "table 1";
		String tag1 = "united states of america";
		String tag2 = "dominican republic";

		int posicionInicial = texto.indexOf(tag);
		posicionInicial = texto.indexOf(tag1,posicionInicial);
		int posicionFinal = texto.indexOf(tag2,posicionInicial);

		String datosPaises = texto.substring(posicionInicial,posicionFinal);
		String[]  paises = datosPaises.split("\n");


		for (String pais : paises) {


			pais = pais.replaceAll("\\s{10,}", "@");

			if (!pais.trim().isEmpty()) {

				String[] columnas = pais.split("@");
				String country = columnas[0].trim();

				String totalCasosConfirmados = columnas[1];
				String totalNuevosCasosConfirmados = columnas[2];
				String totalMuertes = columnas[3];
				String totalNuevasMuertes = columnas[4];


				//System.out.format("%s\n%s\n%s\n%s\n%s\n\n", country,totalCasosConfirmados,
				//totalNuevosCasosConfirmados,totalMuertes,totalNuevasMuertes);

				Sheet hoja = libro.createSheet(country);

				Row fila = hoja.createRow(1);
				Row fila2 = hoja.createRow(2);

				Cell celda = fila.createCell(0);

				Cell celda1 = fila.createCell(1);
				Cell celda2 = fila.createCell(2);
				Cell celda3 = fila.createCell(3);
				Cell celda4 = fila.createCell(4);

				celda.setCellValue("pais");
				celda1.setCellValue("totalCasos");
				celda2.setCellValue("totalNCasos");
				celda3.setCellValue("totalMuertos");
				celda4.setCellValue("totalNMuertos");

				celda = fila2.createCell(0);

				celda1 = fila2.createCell(1);
				celda2 = fila2.createCell(2);
				celda3 = fila2.createCell(3);
				celda4 = fila2.createCell(4);

				celda.setCellValue(country);
				celda1.setCellValue(totalCasosConfirmados);
				celda2.setCellValue(totalNuevosCasosConfirmados);
				celda3.setCellValue(totalMuertes);
				celda4.setCellValue(totalNuevasMuertes);



			}

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