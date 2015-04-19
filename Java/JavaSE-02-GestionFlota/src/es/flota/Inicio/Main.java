package es.flota.Inicio;

import es.flota.DB.GestorDB;
import es.flota.Pantallas.PantallaGrupos;

public class Main {

	public static void main(String[] args) {
		
		PantallaGrupos pPrincipal = new PantallaGrupos();
		pPrincipal.iniciarMenu();
		
		System.out.println("Log : ");
		System.out.println(GestorDB.getInstance().getBd().getLog());
	}
	

}
