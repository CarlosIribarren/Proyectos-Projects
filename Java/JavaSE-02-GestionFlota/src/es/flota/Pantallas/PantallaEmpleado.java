package es.flota.Pantallas;

import es.flota.Grupo.Departamento;
import es.flota.Grupo.Empleado;
import es.flota.Grupo.Vehiculo;

public class PantallaEmpleado {

	private Empleado unekoEmpleado;
	
	public void menuPantallaEmpleado(Empleado e1){
		unekoEmpleado=e1;
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ---- Gestion del Empleado : " + e1.getDni() + " : " +e1.getNombre() + "--");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar datos del Empleado : ");
			System.out.println("\t2.- Modificar la carga : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
					verDatosEmpleado();
					break;
				case 2: 
					cambiarCarga();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);	
	}
	
	public void verDatosEmpleado()
	{
		//recoger datos
		String nombre = unekoEmpleado.getNombre();
		String apellido = unekoEmpleado.getApellido();
		String dni = unekoEmpleado.getDni();
		Double carga = unekoEmpleado.getCarga();
		Departamento departamento = unekoEmpleado.getDepartamento();
		String nombreDepartamento = departamento.getNombre();
		String codigoDepartamento = departamento.getCodigo();
		Vehiculo vehiculoAsignado = unekoEmpleado.getVehiculoAsignado();
		
		System.out.println("\n******************* Caracteristicas *************************\n");
		System.out.println("   Nombre : " + nombre + "\t\t Apellido : " + apellido  );
		System.out.println("   DNI : " + dni + "\t\t Carga : " + carga  );
		System.out.println("   Departamento : " + nombreDepartamento+ "\t Codigo Departamento : " + codigoDepartamento   );	
		System.out.print("   Vehiculo asignado : ");
		if(vehiculoAsignado==null)
		{
			//el camion no tiene ningun empleado asignado
			System.out.println("Ninguno");
		}
		else
		{
			//si tiene empleado asignado
			//recoger los datos del empleado
			String matricula = vehiculoAsignado.getMatricula();
			String tipoVehiculo = vehiculoAsignado.getClass().getSimpleName();
			System.out.println( tipoVehiculo + " : " +  matricula  );
		}

		System.out.println("\n*************************************************************");

	}
	
	public void cambiarCarga()
	{
		System.out.println("\n+++++++ Cambiar la Carga del Empleado ++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.print("Introduce la carga nueva del Empleado [ " + unekoEmpleado.getNombre()+ " ] :");
		//leer double de teclado
		Double carga = UtilesPantalla.leerDouble();
		
		//obtener el MMA viejo
		Double cargaVieja = unekoEmpleado.getCarga();
		//cambiar MMA + BD
		unekoEmpleado.cambiarCarga(carga);
	
		System.out.println("Al Empleado [ " + unekoEmpleado.getDni() + " ] se le ha cambiado la carga de [" + cargaVieja+" ] por el valor nuevo de [ " + carga+" ] .");
		
	}	
	
}
