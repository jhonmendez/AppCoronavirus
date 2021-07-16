package edu.cecar.modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.apache.poi.ss.usermodel.Cell;
import edu.cecar.modelo.ObtenerPaises3;


public class CrearExcel4 {

	public static void main(String[] args)  throws FileNotFoundException  {

     

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
		
		/*
		for (String pais : paises) {

			  String nombre ;
			  String TotalConfirmedCases;
			  String TotalConfirmedNewCases;
			  String TotalDeaths;
			  String TotalNewDeaths;
			  
			  Sheet hoja = libro.createSheet(nombre);
			  
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
				
				celda12.setCellValue(nombre);
				celda11.setCellValue(TotalConfirmedCases);
				celda22.setCellValue(TotalConfirmedNewCases);
				celda33.setCellValue(TotalDeaths);
				celda44.setCellValue(TotalNewDeaths);
				
				}
			  
		*/
		

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



	
