package edu.cecar.vista;

import java.util.ArrayList;
import java.util.Scanner;

import edu.cecar.componentes.Utilidades;

public class Vista {

	public static void entradaYValidacion(String[] args) {

		Scanner entrada = new Scanner(System.in);
		ArrayList<String> correos = new ArrayList<String>();

		System.out.print("Ingrese su correo: ");
		String  emailAverificar = entrada.nextLine();

		System.out.println("Estamos validando y verificando su correo, "
				+ "esto puede demorar unos minutos...");

		boolean esCorreoCorrecto = Utilidades.esCorreoCorrecto(emailAverificar);
		if (esCorreoCorrecto) {
			correos.add(emailAverificar);
			System.out.println("Correo a sido verificado de forma exitosa");
		}else {
			System.out.println("Correo incorrecto");
		}


	}


}
