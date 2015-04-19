package es.flota.Pantallas;

import es.flota.Grupo.Coche;
import es.flota.Grupo.Empleado;

public class PantallaCoche {

	private Coche unekoCoche;
	
	public void menuPantallaCoche(Coche c1){
		//actualizar el Coche actual
		unekoCoche = c1;
				
				//definir numero para recibir la lectura del teclado
				Integer numeroMenu;
				do
				{
					System.out.println("\n -------------------------------------------------");
					System.out.println(" ---------------- COCHE : " + unekoCoche.getMatricula()+ " -----------");
					System.out.println(" -------------------------------------------------\n");
					System.out.println("\t1.- Ver caracteristicas del coche : ");
					System.out.println("\t2.- Cambiar el modelo del coche : ");
					System.out.println("\t3.- Poner el coche como disponible: ");
					System.out.println("\t4.- Poner el coche como ocupado : ");
					System.out.println("\t5.- Cambiar la capacidad del maletero : ");					
					System.out.println("\t0.- Atras : ");
					System.out.print("\n\t\tElige una opcion : ");
					
					//leer numero del teclado
					numeroMenu = UtilesPantalla.leerNumero();
					
					switch(numeroMenu)
					{
						case 1: 
							verCaracteristicas();
							break;
						case 2: 
							cambiarElModeloDelCoche();
							break;
						case 3:
							ponerCocheDisponible();
							break;
						case 4:
							ponerCocheOcupado();
							break;
						case 5:
							this.cambiarCapacidadMaletero();
							break;
						case 0: 
							break;
					}
					
				} while (numeroMenu!=0);
	}
	
	
	public void verCaracteristicas()
	{
		//recoger datos
		String disponibilidad = (unekoCoche.getDisponible().booleanValue()==Boolean.TRUE)?"Disponible":"Ocupado";
		String marca = unekoCoche.getMarca();
		String matricula = unekoCoche.getMatricula();
		Double capacidadMaletero = unekoCoche.getCapacidadMaletero();
		Empleado empleadoAsignado = unekoCoche.getAsigandoEmpleado();
		String modelo = unekoCoche.getModelo();
		
		System.out.println("\n******************* Caracteristicas *************************\n");
		System.out.println("   Matricula : " + matricula + "\t\tDisponible : " + disponibilidad  );
		System.out.println("   Marca : " + marca + "\t\tModelo : " + modelo  );
		System.out.println("   Capacidad Maletero : " + capacidadMaletero   );	
		System.out.print("   Empleado asignado : ");
		if(empleadoAsignado==null)
		{
			//el coche no tiene ningun empleado asignado
			System.out.println("Ninguno");
		}
		else
		{
			//si tiene empleado asignado
			//recoger los datos del empleado
			String dni = empleadoAsignado.getDni();
			String nombre = empleadoAsignado.getNombre();
			System.out.println(" DNI : " + dni + "  Nombre : " +  nombre  );
		}
		

		System.out.println("\n*************************************************************");

	}
	public void cambiarElModeloDelCoche()
	{
		System.out.println("\n++++++ Cambiar el modelo del Coche +++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.print("Introduce el modelo nuevo del Coche :");
		String nombreModelo = "";	
		//leer cadena de teclado
		nombreModelo=UtilesPantalla.leerCadena();
		
		//obtener el modelo viejo
		String nombreViejo = unekoCoche.getModelo();
		//cambiar nombre + BD
		unekoCoche.cambiarModelo(nombreModelo);
	
		System.out.println("El modelo [ "+ nombreViejo +" ] se ha cambiado por [ " + nombreModelo +" ] con exito.");
		
	}	
	public void ponerCocheDisponible()
	{
		unekoCoche.cambiarDisponibilidad(Boolean.TRUE);
		System.out.println("Al Coche [ " + unekoCoche.getMatricula() + " ] se le ha cambiado su disponibilidad a Disponible.");
	}
	public void ponerCocheOcupado()
	{
		unekoCoche.cambiarDisponibilidad(Boolean.FALSE);
		System.out.println("Al Coche [ " + unekoCoche.getMatricula() + " ] se le ha cambiado su disponibilidad a Ocupado.");
	}
	//------------------------------------------------------------
	public void cambiarCapacidadMaletero()
	{
		System.out.println("\n++++++ Cambiar la capacidad del maletero +++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.print("Introduce la capacidad del maletero nueva ( ejemplo: 5.0 ) : ");
		
		//leer cadena de teclado
		Double capacidadMaletero = UtilesPantalla.leerDouble();
		
		if (capacidadMaletero!=null)
		{
			//obtener el modelo viejo
			Double capacidadViejo = unekoCoche.getCapacidadMaletero();
			//cambiar nombre + BD
			unekoCoche.cambiarCapacidadMaletero(capacidadMaletero);
		
			System.out.println("El capacidad del maletero se ha cambiado de [ "+ capacidadViejo +" ], a la capacidad nueva [ " + capacidadMaletero +" ] con exito.");
		}
		
		
	}	
}
