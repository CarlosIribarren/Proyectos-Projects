package es.flota.Pantallas;

import es.flota.Grupo.Camion;
import es.flota.Grupo.Empleado;

public class PantallaCamion {


	private Camion unekoCamion;
	
	public void menuPantallaCamion(Camion ca1){
		//actualizar el Camion actual
		unekoCamion = ca1;
				
				//definir numero para recibir la lectura del teclado
				Integer numeroMenu;
				do
				{
					System.out.println("\n -------------------------------------------------");
					System.out.println(" ---------------- CAMION : " + unekoCamion.getMatricula()+ " -----------");
					System.out.println(" -------------------------------------------------\n");
					System.out.println("\t1.- Ver caracteristicas del camion : ");
					System.out.println("\t2.- Cambiar la TARA del camion : ");
					System.out.println("\t3.- Cambiar la MMA del camion : ");
					System.out.println("\t4.- Poner el camion como disponible: ");
					System.out.println("\t5.- Poner el camion como ocupado : ");
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
							cambiarTARA();
							break;
						case 3:
							cambiarMMA();
							break;
						case 4:
							ponerCamionDisponible();
							break;
						case 5:
							ponerCamionOcupado();
							break;
						case 0: 
							break;
					}
					
				} while (numeroMenu!=0);
	}
	
	
	public void verCaracteristicas()
	{
		//recoger datos
		String disponibilidad = (unekoCamion.getDisponible().booleanValue()==Boolean.TRUE)?"Disponible":"Ocupado";
		String marca = unekoCamion.getMarca();
		String matricula = unekoCamion.getMatricula();
		Double tara = unekoCamion.getTara();
		Double mma = unekoCamion.getMma();
		Empleado empleadoAsignado = unekoCamion.getAsigandoEmpleado();
		String modelo = unekoCamion.getModelo();
		
		System.out.println("\n******************* Caracteristicas *************************\n");
		System.out.println("   Matricula : " + matricula + "\t\tDisponible : " + disponibilidad  );
		System.out.println("   Marca : " + marca + "\t\tModelo : " + modelo  );
		System.out.println("   TARA : " + tara+ "\t\t MMA : " + mma   );	
		System.out.print("   Empleado asignado : ");
		if(empleadoAsignado==null)
		{
			//el camion no tiene ningun empleado asignado
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
	public void cambiarMMA()
	{
		System.out.println("\n++++++ Cambiar la MMA del Camion +++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.print("Introduce la MMA nueva del Camion :");
		//leer double de teclado
		Double mma = UtilesPantalla.leerDouble();
		
		//obtener el MMA viejo
		Double mmaViejo = unekoCamion.getMma();
		//cambiar MMA + BD
		unekoCamion.cambiarMMA(mma);
	
		System.out.println("Al Camion [ " + unekoCamion.getMatricula() + " ] se le ha cambiado la MMA de [" + mmaViejo+" ] por el valor nuevo de [ " + mma+" ] .");
		
	}	
	public void cambiarTARA()
	{
		System.out.println("\n++++++ Cambiar la TARA del Camion +++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.print("Introduce la TARA nueva del Camion :");
		//leer double de teclado
		Double tara = UtilesPantalla.leerDouble();
		
		//obtener el MMA viejo
		Double taraViejo = unekoCamion.getTara();
		//cambiar MMA + BD
		unekoCamion.cambiarTARA(tara);
	
		System.out.println("Al Camion [ " + unekoCamion.getMatricula() + " ] se le ha cambiado la TARA de [" + taraViejo+" ] por el valor nuevo de [ " + tara+" ] .");
		
	}	
	public void ponerCamionDisponible()
	{
		unekoCamion.cambiarDisponibilidad(Boolean.TRUE);
		System.out.println("Al Camion [ " + unekoCamion.getMatricula() + " ] se le ha cambiado su disponibilidad a Disponible.");
	}
	public void ponerCamionOcupado()
	{
		unekoCamion.cambiarDisponibilidad(Boolean.FALSE);
		System.out.println("Al Camion [ " + unekoCamion.getMatricula() + " ] se le ha cambiado su disponibilidad a Ocupado.");
	}
	

}
