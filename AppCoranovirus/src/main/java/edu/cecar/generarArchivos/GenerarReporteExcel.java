/**
 * @Clase: GenerarReporteExcel.java
 * 
 * @version  0.1
 * 
 * @since 22 jul. 2021
 * 
 * @autor Ing. Jhon Mendez
 *
 * @Copyrigth: CECAR
 */


package edu.cecar.generarArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import edu.cecar.modelo.DatoCoranovirus;

/**
 * Descripción de la clase 
 */

public class GenerarReporteExcel {

	public static boolean generarReporte(List<DatoCoranovirus> listadoDatosCoranovirus) throws Exception {

		String rutaArchivo = "recursos/ExcelGenerados/ReporteCoranovirus.xls";

		File archivoXLS = new File(rutaArchivo);
		FileOutputStream archivo = new FileOutputStream(archivoXLS);

		Workbook libro = new HSSFWorkbook();

		for (DatoCoranovirus datoCoranovirus : listadoDatosCoranovirus) {

			String nombreHoja = datoCoranovirus.getPais().replace("(", "").replace(")", "");
			Sheet hoja = libro.getSheet(nombreHoja);

			if ( hoja == null) {
				
				hoja = libro.createSheet(nombreHoja);

				Row filaEncabezado = hoja.createRow(1);
				filaEncabezado = configurarRowDatoCoranivirus(filaEncabezado,"Pais","Total Casos","Total Nuevos Casos","Total Muertos","Total Nuevos Muertos");

			} else {
				
				Row filaDatos = hoja.createRow(hoja.getLastRowNum() + 1);
				filaDatos = configurarRowDatoCoranivirus(filaDatos,datoCoranovirus.getPais(),datoCoranovirus.getTotalCasosConfirmados(),datoCoranovirus.getTotalNuevosCasosConfirmados(),
						datoCoranovirus.getTotalMuertes(),datoCoranovirus.getTotalNuevasMuertes());

			}

		}

		libro.write(archivo);
		libro.close();

		return true;
	}


	private static Row configurarRowDatoCoranivirus(Row fila, String valor1, String valor2,
			String valor3,String valor4,String valor5) {

		Cell celda = fila.createCell(0);
		Cell celda1 = fila.createCell(1);
		Cell celda2 = fila.createCell(2);
		Cell celda3 = fila.createCell(3);
		Cell celda4 = fila.createCell(4);

		celda.setCellValue(valor1);
		celda1.setCellValue(valor2);
		celda2.setCellValue(valor3);
		celda3.setCellValue(valor4);
		celda4.setCellValue(valor5);

		return fila;

	}

}
