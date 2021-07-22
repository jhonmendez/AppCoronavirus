package edu.cecar.vista;

import java.io.IOException;
import java.util.Scanner;

import edu.cecar.modelo.CrearExcel3;
import edu.cecar.modelo.ObtenerPaises;

public class Menu {
	public static void main(String[] args) throws IOException {
		Scanner sn = new Scanner(System.in);
		int opcion;
		boolean salir = false;

		while(!salir){
			
			System.out.println("_______APP CORONAVIRUS_______");
			System.out.println("Seleccione La Primera Opcion:");
			System.out.println("1. Introducir Correo Electronico");
			System.out.println("2. Scrapear PDF");
			System.out.println("3. General Excel");
			System.out.println("4. Salir");
     		
			opcion = sn.nextInt();

			switch(opcion){
			case 1:
				Vista.entradaYValidacion(args);;

				break;
			case 2:
				System.out.println("Estamos Scrapiando los diferentes PDF...");
				ObtenerPaises.scrapin(args);;
				break;
			case 3:
				System.out.println("Generando Excel, Por Favor Espere...");
				System.out.println("Abriendo Excel");
                CrearExcel3.generalExcel(args);
				break;
			case 4:
				salir=true;
				break;
			default:
				System.out.println("Solo números entre 1 y 4");
			}

		}
	}

}
