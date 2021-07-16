package edu.cecar.modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.RowFunc;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.apache.poi.ss.usermodel.Cell;


public class CrearExcel3 {

	public static void main(String[] args)  throws IOException  {

     

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
        String texto = stripper.getText(pdDocument).toLowerCase();
        
        //Se busca la posicion inicial del continente africano
        String tag = "table 1";
        String tag1 = "united states of america";
        String tag2 = "dominican republic";
        
        int posicionInicial = texto.indexOf(tag);
        posicionInicial = texto.indexOf(tag1,posicionInicial);
        int posicionFinal = texto.indexOf(tag2,posicionInicial);

        
        
       
        
		String datosPaises = texto.substring(posicionInicial,posicionFinal);
		String[]  paises = datosPaises.split("\n");
		
		
		
		for (String pais : paises) {
			
			
			
			String nombre = null;
			String totalCasos = null;
			String totalNCasos = null;
			String totalMuertos = null;
			String totalNMuertos = null;
			
			
			Sheet hoja = libro.createSheet(pais);
			
			
			
			Row fila = hoja.createRow(1);
			Row fila1 = hoja.createRow(2);
			
			
			
	      
			
			
			Cell celda = fila1.createCell(0);
					
			Cell celda1 = fila.createCell(1);
			Cell celda2 = fila.createCell(2);
			Cell celda3 = fila.createCell(3);
			Cell celda4 = fila.createCell(4);
			
			celda.setCellValue(pais);
			celda1.setCellValue("totalCasos");
			celda2.setCellValue("totalNCasos");
			celda3.setCellValue("totalMuertos");
			celda4.setCellValue("totalNMuertos");
			
			
			
			
			
		}
		/*
		Sheet hoja = libro.createSheet("United States of America");
		Sheet hoja1 = libro.createSheet("Brazil");
		Sheet hoja2 = libro.createSheet("Mexico");
		Sheet hoja3 = libro.createSheet("Peru");
		Sheet hoja4 = libro.createSheet("Colombia");
		Sheet hoja5 = libro.createSheet("Chile");
		Sheet hoja6 = libro.createSheet("Argentina");
		Sheet hoja7 = libro.createSheet("Canada");
		Sheet hoja8 = libro.createSheet("Ecuador");
		Sheet hoja9 = libro.createSheet("Bolivia (Plurinational State of)");
		


		for(int f=0;f<1;f++){
			Row fila = hoja.createRow(f);
			Row fila1 = hoja1.createRow(f);
			Row fila2 = hoja2.createRow(f);
			Row fila3 = hoja3.createRow(f);
			Row fila4 = hoja4.createRow(f);
			Row fila5 = hoja5.createRow(f);
			Row fila6 = hoja6.createRow(f);
			Row fila7 = hoja7.createRow(f);
			Row fila8 = hoja8.createRow(f);
			Row fila9 = hoja9.createRow(f);


			for(int c=0;c<1;c++){
				Cell celda = fila.createCell(c);
				Cell celda1 = fila1.createCell(c);
				Cell celda2 = fila2.createCell(c);
				Cell celda3 = fila3.createCell(c);
				Cell celda4 = fila4.createCell(c);
				Cell celda5 = fila5.createCell(c);
				Cell celda6 = fila6.createCell(c);
				Cell celda7 = fila7.createCell(c);
				Cell celda8 = fila8.createCell(c);
				Cell celda9 = fila9.createCell(c);
				
				celda.setCellValue("pais  unidos de colombia unida");
				celda1.setCellValue("ciudad");
				celda2.setCellValue("pais");
				celda3.setCellValue("pais");
				celda4.setCellValue("pais");
				celda5.setCellValue("pais");
				celda6.setCellValue("pais");
				celda7.setCellValue("pais");
				celda8.setCellValue("pais");
				celda9.setCellValue("pais");
				
			}
		}

*/
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