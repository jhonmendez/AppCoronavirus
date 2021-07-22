/**
 * @Clase: DatoCoranovirus.java
 * 
 * @version  0.1
 * 
 * @since 22 jul. 2021
 * 
 * @autor Ing. Jhon Mendez
 *
 * @Copyrigth: CECAR
 */


package edu.cecar.modelo;


/**
 * Descripción de la clase 
 */

public class DatoCoranovirus {
	
	private String pais;
	private String totalCasosConfirmados;
	private String totalNuevosCasosConfirmados;
	private String totalMuertes;
	private String totalNuevasMuertes;
	
	public DatoCoranovirus(String pais, String totalCasosConfirmados, String totalNuevosCasosConfirmados,
			String totalMuertes, String totalNuevasMuertes) {
		
		this.pais = pais;
		this.totalCasosConfirmados = totalCasosConfirmados;
		this.totalNuevosCasosConfirmados = totalNuevosCasosConfirmados;
		this.totalMuertes = totalMuertes;
		this.totalNuevasMuertes = totalNuevasMuertes;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTotalCasosConfirmados() {
		return totalCasosConfirmados;
	}

	public void setTotalCasosConfirmados(String totalCasosConfirmados) {
		this.totalCasosConfirmados = totalCasosConfirmados;
	}

	public String getTotalNuevosCasosConfirmados() {
		return totalNuevosCasosConfirmados;
	}

	public void setTotalNuevosCasosConfirmados(String totalNuevosCasosConfirmados) {
		this.totalNuevosCasosConfirmados = totalNuevosCasosConfirmados;
	}

	public String getTotalMuertes() {
		return totalMuertes;
	}

	public void setTotalMuertes(String totalMuertes) {
		this.totalMuertes = totalMuertes;
	}

	public String getTotalNuevasMuertes() {
		return totalNuevasMuertes;
	}

	public void setTotalNuevasMuertes(String totalNuevasMuertes) {
		this.totalNuevasMuertes = totalNuevasMuertes;
	}
	
	@Override
	public String toString() {
		
		return "Pais: " + pais +
				"\nTotal Casos Confirmados : " + totalCasosConfirmados +
				"\nTotal Nuevos Casos Confirmados : " + totalNuevosCasosConfirmados +
				"\nTotal Muertes : " + totalMuertes+ 
				"\nTotal NuevasMuertes: " + totalNuevasMuertes +
				"\n\n";
		
	}
	

}
