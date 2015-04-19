package es.flota.Pantallas;

import java.util.ArrayList;
import java.util.TreeMap;

import es.flota.Grupo.Coche;
import es.flota.Grupo.Empleado;
import es.flota.Grupo.Grupo;
import es.flota.Grupo.Vehiculo;

public class PantallaCoches {

	private Grupo unekoGrupo;
	private ArrayList<Coche> unekoListaCoches;
	private PantallaCoche pantallaCoche = new PantallaCoche();
	
	public void menuPantallaCoches(Grupo grupo){
		
		//actualizar variable Grupo
		this.unekoGrupo = grupo;

		this.unekoListaCoches = buscarCoches();
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ----------- Gestion de Coches -----------");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar todos los Coches : ");
			System.out.println("\t2.- Mostrar todos los Coches Disponibles : ");
			System.out.println("\t3.- Mostrar todos los Coches Asignados : ");
			System.out.println("\t4.- Asignar un Coche : ");
			System.out.println("\t5.- Des-asignar un Coche: ");
			System.out.println("\t6.- Gestion de un Coche : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
					mostrarCochesTodos();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: 
					mostrarCochesDisponibles();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 3:
					mostrarCochesAsignados();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 4: 
					asignarCoche();
					break;
				case 5: 
					desAsignarCoche();
					break;
				case 6: 
					prepararGestionDeUnCoche();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);	
	}

	public Integer mostrarCochesTodos()
	{
		System.out.println("\n ++++++++++++++++ Listado de todos los Coches +++++++++++++++++++++ ");
		System.out.println(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula \t Disponible \t  Asignado");
		System.out.println("\t---------\t-----------\t------------\t-----------\n");		
	
		for(int a=0 ; a<unekoListaCoches.size();a++)
		{
			//Obtener Vehiculo
			Vehiculo v1 = unekoListaCoches.get(a);
			//ternario para codificar (true=Si, false=No)
			String disponible="";
			disponible = (v1.getDisponible()==true)? "Si" : "No";
			String asignadoEmpleado;
			//ternario para saber si el vehiculo tiene un empleado asignado
			asignadoEmpleado = (v1.getAsigandoEmpleado()==null)? " " : v1.getAsigandoEmpleado().getDni() + " ( " + v1.getAsigandoEmpleado().getNombre() +" )";
			
			System.out.println("\t" + (a+1) + ".- " + v1.getClass().getSimpleName() + " \t " + v1.getMatricula() + "    \t    " + disponible + "\t\t " + asignadoEmpleado  );
		}
		System.out.println("\n\t\tTotal : " + unekoListaCoches.size());
		
		return unekoListaCoches.size();
	}
	


	public TreeMap<Integer,Coche> mostrarCochesDisponibles()
	{
		System.out.println("\n +++ Listado de todos los Coches Disponibles ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula ");
		System.out.println("\t---------\t-----------\n");		
		
		//Map para luego obtener el vehiculo
		TreeMap<Integer,Coche> cochesDisponibles = new TreeMap<Integer, Coche>();
		
		//Se recorre la listaCoches y se mira si el vehiculo esta disponible;		
				
		Integer numeroCochesDisponibles =0;
		for(int a=0 ; a<unekoListaCoches.size();a++)
		{
			Coche c1 = unekoListaCoches.get(a);
			if(c1.getDisponible()==true)
			{	
				System.out.println("\t" + (numeroCochesDisponibles+1) + ".- " + c1.getClass().getSimpleName() + " \t " + c1.getMatricula() );
				//guardar el vehiculo para devolver
				cochesDisponibles.put(numeroCochesDisponibles, c1);
				numeroCochesDisponibles=numeroCochesDisponibles+1;
			}
			
		}
		System.out.println("\n\t\tTotal : " + numeroCochesDisponibles);
		
		return cochesDisponibles;
	}
	
	
	public TreeMap<Integer,Coche> mostrarCochesAsignados()
	{
		System.out.println("\n +++ Listado de todos los Coches Asignados ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula \t  Asignado");
		System.out.println("\t---------\t-----------\t------------\n");		
		
		//Definir un Map para devolver
		//NOTA: TreeMap para aceder a un vehiculo en el metodo desAsignarVehiculo.
		//Este Map solo se utiliza para conseguir el vehiculo, es decir solo se lee en el Map
		//por eso se utiliza un estructura Map, porque solo se utiliza para leer, no para recorrer
		TreeMap<Integer,Coche> cochesAsignados = new TreeMap<Integer,Coche>();
		
		//Se recorre la listaCoches y se mira si el coche esta asigando
				
		Integer numeroCochesAsignados =0;
		for(int a=0 ; a<unekoListaCoches.size();a++)
		{
			Coche c1 = unekoListaCoches.get(a);
			if(c1.getDisponible()==false)
			{
				String infoAsignado = c1.getAsigandoEmpleado().getDni() + " ( " + c1.getAsigandoEmpleado().getNombre() + " ) ";
				System.out.println("\t" + (numeroCochesAsignados+1) + ".- " + c1.getClass().getSimpleName() + " \t " + c1.getMatricula() + "\t " + infoAsignado );
				//guardar el coche para el return
				cochesAsignados.put(numeroCochesAsignados, c1);
				numeroCochesAsignados=numeroCochesAsignados+1;
			}
			
		}
		System.out.println("\n\t\tTotal : " + numeroCochesAsignados);
		
		return cochesAsignados;
	}
	
	public ArrayList<Coche> buscarCoches()
	{
		//buscar todos los Coches
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();;
		for (Vehiculo v : this.unekoGrupo.getVehiculos())
		{
			if("Coche".equals(v.getClass().getSimpleName()))
					{
						listaCoches.add((Coche) v);
					}
		}
		return listaCoches;
	}
	

	public void asignarCoche()
	{

				//Mostrar Coches disponibles
				TreeMap<Integer,Coche> mapaCochesDisponibles = this.mostrarCochesDisponibles();
				Integer total=mapaCochesDisponibles.size();
				
				if(total==0)
				{
					//No hay Coches para des-asignar
					System.out.println("\n No hay coches para asignar.");
				}
				else
				{

					System.out.print("\n Introduce el numero del Coche que quieres asignar :");
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
							
							System.out.print("\nIntroduce el numero de la empleado que quieres asignar :");
							Integer numeroEmpleadoElegido = -1;
							do
							{		
								//leer numero del teclado
								numeroEmpleadoElegido = UtilesPantalla.leerNumero();

								//si a pulsado una de las opciones
								if ( numeroEmpleadoElegido>0 && numeroEmpleadoElegido<=numeroEmpleadosTotal){	
									
									//obtener vehiculo para desAsignar
									Coche c1 = mapaCochesDisponibles.get(numeroElegido-1);
									
									//Obtener empleado elegido utilizando el Map
									Empleado empleadoElegidoMenu = mapaEmlpleadosDisponibles.get(numeroEmpleadoElegido-1);
									
									//asignar empleado al vehiculo + BD
									c1.asignarEmpleado(empleadoElegidoMenu);
									
									System.out.println("\n El Coche [ " +c1.getMatricula() + " ] se ha asignado al empleado ( " + c1.getAsigandoEmpleado().getDni() + " : " + c1.getAsigandoEmpleado().getNombre() + " ) con exito.");		
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

	public void desAsignarCoche()
	{
		
		//Mostrar en pantalla todos los Coches
		// Y recuperar un Map con los Coches asignados
		//Este Map solo se utiliza para conseguir el Coche, es decir solo se lee en el Map
				//por eso se utiliza un estructura Map, porque solo se utiliza para leer, no para recorrer
		TreeMap<Integer,Coche> cochesAsignados = mostrarCochesAsignados();
		
		Integer total = cochesAsignados.size();
		
		if(total==0)
		{
			//No hay Coches para des-asignar
			System.out.println("\n No hay coches para des-asignar.");
		}
		else
		{
			//si hay Coches para des-asignar
			System.out.print("\n Introduce el numero del Coche que quieres des-asignar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=total){
					//obtener vehiculo para desAsignar
					Coche c1 = cochesAsignados.get(numeroElegido-1);
					//mostrar en pantalla antes de des-asignar
					System.out.println("\n El Coche [ " +c1.getMatricula() + " ] se ha des-asignado del empleado ( " + c1.getAsigandoEmpleado().getDni() + " : " + c1.getAsigandoEmpleado().getNombre() + " ) con exito.");
					//des-asignar vehiculo + BD
					c1.desAsignarVehiculo();
				}
				else
				{
					System.out.println(" Introduce el numero del Coche que quieres des-asignar :");
				}
				
			} while (numeroElegido<=0 || numeroElegido>total);
		}
		
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
	
	
	public void prepararGestionDeUnCoche()
	{

		//Mostrar en pantalla todos los Coches
		Integer totalCoches = mostrarCochesTodos();
		
		if (totalCoches==0)
		{
			//No hay ningun grupo para gestionar
			System.out.println("\nNo hay ningun Coche para gestionar, añade un Coche.");
		}
		else
		{
			//preparar para la gestion del grupo
			System.out.print("\nIntroduce el numero del Coche que quieres Gestionar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=totalCoches)
				{
					//Obtener el coche
					Coche c1 = unekoListaCoches.get(numeroElegido-1);
					//Ir a la pantalla de Gestion de un Coche
					pantallaCoche.menuPantallaCoche(c1);
				}
				else
				{
					System.out.print("Introduce el numero del Coche que quieres Gestionar :");
				}
				
			} while (numeroElegido<=0 || numeroElegido>totalCoches);
		}	
	}
}
