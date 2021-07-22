package edu.cecar.AppCoranovirus;

import edu.cecar.componentes.Utilidades;

public class Test {

	public static void main(String[] args) {
		System.out.println(Utilidades.esCorreoCorrecto("juan.benavides@cecar.edu.co"));
		System.out.println(Utilidades.esCorreoCorrecto("juan.benavides1@cecar.edu.co"));
		System.out.println(Utilidades.esCorreoCorrecto("juan.benavides@free.com"));
		System.out.println(Utilidades.esCorreoCorrecto("juan.benavidescecar.edu.co"));

	}

}
