package es.flota.Pantallas;

import java.util.ArrayList;
import java.util.TreeMap;

import es.flota.DB.GestorDB;
import es.flota.Grupo.Empleado;
import es.flota.Grupo.Grupo;
import es.flota.Grupo.Vehiculo;

public class PantallaVehiculos {

	Grupo unekoGrupo;
	PantallaCoches pantallaCoches = new PantallaCoches();
	PantallaCamiones pantallaCamiones = new PantallaCamiones();
	
	public void menuPantallaVehiculos(Grupo unekoGrupo){
		
		this.unekoGrupo = unekoGrupo;
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ---------------- GRUPO : " + unekoGrupo.getNombre() + " -----------");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar todos los Vehiculos : ");
			System.out.println("\t2.- Mostrar todos los Vehiculos Disponibles : ");
			System.out.println("\t3.- Mostrar todos los Vehiculos Asignados : ");
			System.out.println("\t4.- Asignar un Vehiculo : ");
			System.out.println("\t5.- Des-asignar un Vehiculo: ");
			System.out.println("\t6.- Gestion de los Coches : ");
			System.out.println("\t7.- Gestion de los Camiones : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");

			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: ;
					mostrarVehiculos();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: ;
					mostrarVehiculosDisponibles();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 3:
					mostrarVehiculosAsignados();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 4: ;
					asignarVehiculo();
					break;
				case 5: ;
					desAsignarVehiculo();
					break;
				case 6: ;
					//mostrar pantalla de Coches
					pantallaCoches.menuPantallaCoches(unekoGrupo);
					break;
				case 7: ;
					pantallaCamiones.menuPantallaCamiones(unekoGrupo);
					break;
				case 0: ;
					break;
			}
			
		} while (numeroMenu!=0);
	}
	
	
	public Integer mostrarVehiculos()
	{
		System.out.println("\n ++++++++++++++++ Listado de todos los Vehiculos +++++++++++++++++++++ ");
		System.out.println(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula \t Disponible \t  Asignado");
		System.out.println("\t---------\t-----------\t------------\t-----------\n");		
		
		ArrayList<Vehiculo> listaVehiculos = unekoGrupo.getVehiculos();
	
		for(int a=0 ; a<listaVehiculos.size();a++)
		{
			//Obtener Vehiculo
			Vehiculo v1 = listaVehiculos.get(a);
			//ternario para codificar (true=Si, false=No)
			String disponible="";
			disponible = (v1.getDisponible()==true)? "Si" : "No";
			String asignadoEmpleado;
			//ternario para saber si el vehiculo tiene un empleado asignado
			asignadoEmpleado = (v1.getAsigandoEmpleado()==null)? " " : v1.getAsigandoEmpleado().getDni() + " ( " + v1.getAsigandoEmpleado().getNombre() +" )";
			
			System.out.println("\t" + (a+1) + ".- " + v1.getClass().getSimpleName() + " \t " + v1.getMatricula() + "    \t    " + disponible + "\t\t " + asignadoEmpleado  );
		}
		System.out.println("\n\t\tTotal : " + listaVehiculos.size());
	
		return listaVehiculos.size();
	}
	

	public void borrarVehiculo()
	{		
		//Mostrar en pantalla todos los grupos
		Integer total = mostrarVehiculos();
		
		System.out.print("\nIntroduce el numero del vehiculo que quieres borrar :");
		Integer numeroElegido = -1;
		do
		{		
			//leer numero del teclado
			numeroElegido = UtilesPantalla.leerNumero();

			//si a pulsado una de las opciones
			if ( numeroElegido>0 && numeroElegido<=total){
				//obtener grupo para borrar
				Grupo g1 = GestorDB.getInstance().obtenerGrupo(numeroElegido-1);
				//borrar
				GestorDB.getInstance().borrarGrupoGestor(g1);
				System.out.println("\nEl grupo [ " +g1.getNombre()+ " ] se ha borrado con exito!!!!");
			}
			else
			{
				System.out.println("Por favor eliga un numero de la lista");
			}
			
		} while (numeroElegido<=0 || numeroElegido>total);
	}
	
	
	
	public TreeMap<Integer,Vehiculo> mostrarVehiculosAsignados()
	{
		System.out.println("\n +++ Listado de todos los Vehiculos Asignados ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula \t  Asignado");
		System.out.println("\t---------\t-----------\t------------\n");		
		
		//Definir un Map para devolver
		//NOTA: TreeMap para aceder a un vehiculo en el metodo desAsignarVehiculo.
		//Este Map solo se utiliza para conseguir el vehiculo, es decir solo se lee en el Map
		//por eso se utiliza un estructura Map, porque solo se utiliza para leer, no para recorrer
		TreeMap<Integer,Vehiculo> vehiculosAsignados = new TreeMap<Integer,Vehiculo>();
		
		//Se recorre la listaVehiculos y se mira si el vehiculo esta asigando
		ArrayList<Vehiculo> listaVehiculos = unekoGrupo.getVehiculos();		
				
		Integer numeroVehiculosAsignados =0;
		for(int a=0 ; a<listaVehiculos.size();a++)
		{
			Vehiculo v1 = listaVehiculos.get(a);
			if(v1.getDisponible()==false)
			{
				String infoAsignado = v1.getAsigandoEmpleado().getDni() + " ( " + v1.getAsigandoEmpleado().getNombre() + " ) ";
				System.out.println("\t" + (numeroVehiculosAsignados+1) + ".- " + v1.getClass().getSimpleName() + " \t " + v1.getMatricula() + "\t " + infoAsignado );
				//guardar el vehiculo para el return
				vehiculosAsignados.put(numeroVehiculosAsignados, v1);
				numeroVehiculosAsignados=numeroVehiculosAsignados+1;
			}
			
		}
		System.out.println("\n\t\tTotal : " + numeroVehiculosAsignados);
		return vehiculosAsignados;
	}
	

	
	public void desAsignarVehiculo()
	{
		
		//Mostrar en pantalla todos los Vehiculos
		// Y recuperar un Map con los vehiculos asignados
		//Este Map solo se utiliza para conseguir el vehiculo, es decir solo se lee en el Map
				//por eso se utiliza un estructura Map, porque solo se utiliza para leer, no para recorrer
		TreeMap<Integer,Vehiculo> vehiculosAsignados = mostrarVehiculosAsignados();
		
		Integer total = vehiculosAsignados.size();
		
		if(total==0)
		{
			//No hay vehiculos para des-asignar
			System.out.println("\n No hay vehiculos para des-asignar.");
		}
		else
		{
			//si hay vehiculos para des-asignar
			System.out.print("\n Introduce el numero del Vehiculo que quieres des-asignar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=total){
					//obtener vehiculo para desAsignar
					Vehiculo v1 = vehiculosAsignados.get(numeroElegido-1);
					//mostrar en pantalla antes de des-asignar
					System.out.println("\n El Vehiculo " + v1.getClass().getSimpleName() +  " [ " +v1.getMatricula() + " ] se ha des-asignado del empleado ( " + v1.getAsigandoEmpleado().getDni() + " : " + v1.getAsigandoEmpleado().getNombre() + " ) con exito.");
					//des-asignar vehiculo + BD
					v1.desAsignarVehiculo();
				}
				else
				{
					System.out.println(" Introduce el numero del Vehiculo que quieres des-asignar :");
				}
				
			} while (numeroElegido<=0 || numeroElegido>total);
		}
		
	}
	
	public void asignarVehiculo()
	{

				//Mostrar Vehiculos disponibles
				TreeMap<Integer,Vehiculo> mapaVehiculosDisponibles = this.mostrarVehiculosDisponibles();
				Integer total=mapaVehiculosDisponibles.size();
				
				if(total==0)
				{
					//No hay vehiculos para des-asignar
					System.out.println("\n No hay vehiculos para asignar.");
				}
				else
				{

					System.out.print("\n Introduce el numero del Vehiculo que quieres asignar :");
					Integer numeroElegido = -1;
					do
					{		
						//leer numero del teclado
						numeroElegido = UtilesPantalla.leerNumero();

						//si a pulsado una de las opciones
						if ( numeroElegido>0 && numeroElegido<=total){

								//---------- ELEGIR EMPLEADO GENERAL ------------
							//mostrar en pantalla todos los empleados de la empresa
							TreeMap<Integer,Empleado> mapaEmlpleadosDisponibles = this.mostrarEmpleadosDisponibles();
							
							//obtener el total de empleados
							Integer numeroEmpleadosTotal = mapaEmlpleadosDisponibles.size();
							
							System.out.print("\nIntroduce el numero del empleado que quieres asignar :");
							Integer numeroEmpleadoElegido = -1;
							do
							{		
								//leer numero del teclado
								numeroEmpleadoElegido = UtilesPantalla.leerNumero();

								//si a pulsado una de las opciones
								if ( numeroEmpleadoElegido>0 && numeroEmpleadoElegido<=numeroEmpleadosTotal){	
									
									//obtener vehiculo para desAsignar
									Vehiculo v1 = mapaVehiculosDisponibles.get(numeroElegido-1);
									
									//Obtener empleado elegido utilizando el Map
									Empleado empleadoElegidoMenu = mapaEmlpleadosDisponibles.get(numeroEmpleadoElegido-1);
									
									//asignar empleado al vehiculo + BD
									v1.asignarEmpleado(empleadoElegidoMenu);
									
									System.out.println("\n El Vehiculo " + v1.getClass().getSimpleName() +  " [ " +v1.getMatricula() + " ] se ha asignado del empleado ( " + v1.getAsigandoEmpleado().getDni() + " : " + v1.getAsigandoEmpleado().getNombre() + " ) con exito.");		
								}
								else
								{
									System.out.print("\n Introduce el numero de la empleado que quieres asignar :");
								}
								
							} while (numeroEmpleadoElegido<=0 || numeroEmpleadoElegido>numeroEmpleadosTotal);
						}
						else
						{
							System.out.print("\n Introduce el numero del Vehiculo que quieres asignar :");
						}
						
					} while (numeroElegido<=0 || numeroElegido>total);
				}
	}
	
	public TreeMap<Integer,Vehiculo> mostrarVehiculosDisponibles()
	{
		System.out.println("\n +++ Listado de todos los Vehiculos Disponibles ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula ");
		System.out.println("\t---------\t-----------\n");		
		
		//Map para luego obtener el vehiculo
		TreeMap<Integer,Vehiculo> vehiculosDisponibles = new TreeMap<Integer, Vehiculo>();
		
		//Se recorre la listaVehiculos y se mira si el vehiculo esta asigando
		ArrayList<Vehiculo> listaVehiculos = unekoGrupo.getVehiculos();		
				
		Integer numeroVehiculosDisponibles =0;
		for(int a=0 ; a<listaVehiculos.size();a++)
		{
			Vehiculo v1 = listaVehiculos.get(a);
			if(v1.getDisponible()==true)
			{	
				System.out.println("\t" + (numeroVehiculosDisponibles+1) + ".- " + v1.getClass().getSimpleName() + " \t " + v1.getMatricula() );
				//guardar el vehiculo para devolver
				vehiculosDisponibles.put(numeroVehiculosDisponibles, v1);
				numeroVehiculosDisponibles=numeroVehiculosDisponibles+1;
			}
			
		}
		System.out.println("\n\t\tTotal : " + numeroVehiculosDisponibles);
		return vehiculosDisponibles;
	}
	
	public TreeMap<Integer,Empleado> mostrarEmpleadosDisponibles()
	{
		System.out.println("\n +++ Listado de todos los Empleados Disponibles ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t Nombre\t\t Apellido \t Carga\t\t  DNI");
		System.out.println("\t---------\t-----------\t--------\t---------\n");
		
		//Mapa para return
		TreeMap<Integer,Empleado> mapaEmlpleadosTodos = new TreeMap<Integer, Empleado>();
				//Obtener en un List todos los empleados de la empresa
		ArrayList<Empleado> listaEmlpleadosTodos = unekoGrupo.buscarEmpleadosDisponibles();
		Integer numeroEmpleado=0;
		for(Empleado empleado : listaEmlpleadosTodos)
		{
			String utxune = (empleado.getApellido().length()>7 )?"\t":"\t\t";
			//mostrar en pantalla cada empleado
			System.out.println("\t" + (numeroEmpleado+1)+".- " + empleado.getNombre() + "\t " + empleado.getApellido() + utxune+ "  "  + empleado.getCarga() + "\t\t "  + empleado.getDni());
			//guardar en el map
			mapaEmlpleadosTodos.put(numeroEmpleado,empleado);
			numeroEmpleado=numeroEmpleado+1;	
			
		}
		return mapaEmlpleadosTodos;
	}
}
