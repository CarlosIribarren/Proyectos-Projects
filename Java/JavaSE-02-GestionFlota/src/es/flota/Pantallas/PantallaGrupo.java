package es.flota.Pantallas;

import es.flota.Grupo.Grupo;

//No se define el ambito de la clase como public para que solo sea visible desde el paquete
class PantallaGrupo {

	private Grupo unekoGrupo;
	private PantallaEmpresas pantallaEmpresas = new PantallaEmpresas();
	private PantallaVehiculos pantallaVehiculos = new PantallaVehiculos();
	
	public void menuPantallaGrupo(Grupo g)
	{
		//actualizar el grupo actual
		unekoGrupo = g;
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ---------------- GRUPO : " + unekoGrupo.getNombre() + " -----------");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Gestion de las Empresas : ");
			System.out.println("\t2.- Gestion de los Vehiculos : ");
			System.out.println("\t3.- Cambiar el nombre del Grupo : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();
			
			switch(numeroMenu)
			{
				case 1: 
					pantallaEmpresas.menuPantallaEmpresas(unekoGrupo);
					break;
				case 2: 
					pantallaVehiculos.menuPantallaVehiculos(unekoGrupo);
					break;
				case 3:
					cambiarNombreGrupo();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);
	}
	

	public void cambiarNombreGrupo()
	{
		System.out.println("\n+++++++++ Cambiar el nombre al Grupo ++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println("Introduce el nombre Nuevo del Grupo :");
		String nombreGrupo = "";	
		//leer cadena de teclado
		nombreGrupo=UtilesPantalla.leerCadena();

		//obtener el nombre del grupo que se va a cambiar
		String nombreViejo = unekoGrupo.getNombre();
		//cambiar nombre + BD
		unekoGrupo.cambiarNombre(nombreGrupo);
	
		System.out.println("El Grupo [ " + nombreViejo + " ] ha sido modificado por [ " + nombreGrupo +" ].");
	}

	

	
}
