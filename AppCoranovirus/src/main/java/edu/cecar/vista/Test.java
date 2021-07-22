/**
 * @Clase: Test.java
 * 
 * @version  0.1
 * 
 * @since 22 jul. 2021
 * 
 * @autor Ing. Jhon Mendez
 *
 * @Copyrigth: CECAR
 */


package edu.cecar.vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.cecar.componentes.Utilidades;
import edu.cecar.generarArchivos.GenerarReporteExcel;
import edu.cecar.modelo.DatoCoranovirus;
import edu.cecar.scraper.ScraperExcel;

/**
 * Descripción de la clase 
 */

public class Test {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int opcion;
		boolean salir = false;

		List<DatoCoranovirus> listadoDatosCoranovirus = null;
		ArrayList<String> correos = new ArrayList<String>();


		while(!salir){

			System.out.println("_______APP CORONAVIRUS_______");
			System.out.println("Seleccione La Primera Opcion:");
			System.out.println("1. Introducir Correo Electronico");
			System.out.println("2. Scrapear PDF");
			System.out.println("3. General Excel");
			System.out.println("4. Salir");

			opcion = scanner.nextInt();

			switch(opcion){
			case 1:

				System.out.print("Ingrese su correo: ");
				String  emailAverificar = new Scanner(System.in).nextLine();
				boolean esCorreoCorrecto = Utilidades.esCorreoCorrecto(emailAverificar);
				if (esCorreoCorrecto) {
					correos.add(emailAverificar);
					System.out.println("Correo a sido verificado de forma exitosa");
				}else {
					System.out.println("Correo incorrecto");
				}
				
				break;

			case 2:

				listadoDatosCoranovirus = ScraperExcel.getDatosScrapingExcel();

				for (DatoCoranovirus datoCoranovirus : listadoDatosCoranovirus) {

					System.out.println(datoCoranovirus);

				}

				break;
			case 3:
				System.out.println("Generando Excel, Por Favor Espere...");
				GenerarReporteExcel.generarReporte(listadoDatosCoranovirus);
				break;
			case 4:
				salir = true;
				break;
			default:
				System.out.println("Solo números entre 1 y 4");
			}

		}
	}


}
