package es.flota.Pantallas;

import java.util.ArrayList;
import java.util.TreeMap;

import es.flota.Grupo.Camion;
import es.flota.Grupo.Empleado;
import es.flota.Grupo.Grupo;
import es.flota.Grupo.Vehiculo;

public class PantallaCamiones {

	private Grupo unekoGrupo;
	private ArrayList<Camion> unekoListaCamiones;
	private PantallaCamion pantallaCamion = new PantallaCamion();
	
	public void menuPantallaCamiones(Grupo grupo){
		
		//actualizar variable Grupo
		this.unekoGrupo = grupo;

		this.unekoListaCamiones = buscarCamiones();
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ----------- Gestion de Camiones -----------");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar todos los Camiones : ");
			System.out.println("\t2.- Mostrar todos los Camiones Disponibles : ");
			System.out.println("\t3.- Mostrar todos los Camiones Asignados : ");
			System.out.println("\t4.- Asignar un Camion : ");
			System.out.println("\t5.- Des-asignar un Camion: ");
			System.out.println("\t6.- Gestion de un Camion : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
					mostrarCamionesTodos();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: 
					mostrarCamionesDisponibles();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 3:
					mostrarCamionesAsignados();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 4: 
					asignarCamion();
					break;
				case 5: 
					desAsignarCamion();
					break;
				case 6: 
					prepararGestionDeUnCamion();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);	
	}

	public Integer mostrarCamionesTodos()
	{
		System.out.println("\n ++++++++++++++++ Listado de todos los Camiones +++++++++++++++++++++ ");
		System.out.println(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula \t Disponible \t  Asignado");
		System.out.println("\t---------\t-----------\t------------\t-----------\n");		
	
		for(int a=0 ; a<unekoListaCamiones.size();a++)
		{
			//Obtener Vehiculo
			Vehiculo v1 = unekoListaCamiones.get(a);
			//ternario para codificar (true=Si, false=No)
			String disponible="";
			disponible = (v1.getDisponible()==true)? "Si" : "No";
			String asignadoEmpleado;
			//ternario para saber si el vehiculo tiene un empleado asignado
			asignadoEmpleado = (v1.getAsigandoEmpleado()==null)? " " : v1.getAsigandoEmpleado().getDni() + " ( " + v1.getAsigandoEmpleado().getNombre() +" )";
			
			System.out.println("\t" + (a+1) + ".- " + v1.getClass().getSimpleName() + " \t " + v1.getMatricula() + "    \t    " + disponible + "\t\t " + asignadoEmpleado  );
		}
		System.out.println("\n\t\tTotal : " + unekoListaCamiones.size());
		
		return unekoListaCamiones.size();
	}
	


	public TreeMap<Integer,Camion> mostrarCamionesDisponibles()
	{
		System.out.println("\n +++ Listado de todos los Camiones Disponibles ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula ");
		System.out.println("\t---------\t-----------\n");		
		
		//Map para luego obtener el vehiculo
		TreeMap<Integer,Camion> camionesDisponibles = new TreeMap<Integer, Camion>();
		
		//Se recorre la listaCamiones y se mira si el vehiculo esta disponible;		
				
		Integer numeroCamionesDisponibles =0;
		for(int a=0 ; a<unekoListaCamiones.size();a++)
		{
			Camion c1 = unekoListaCamiones.get(a);
			if(c1.getDisponible()==true)
			{	
				System.out.println("\t" + (numeroCamionesDisponibles+1) + ".- " + c1.getClass().getSimpleName() + " \t " + c1.getMatricula() );
				//guardar el vehiculo para devolver
				camionesDisponibles.put(numeroCamionesDisponibles, c1);
				numeroCamionesDisponibles=numeroCamionesDisponibles+1;
			}
			
		}
		System.out.println("\n\t\tTotal : " + numeroCamionesDisponibles);
		
		return camionesDisponibles;
	}
	
	
	public TreeMap<Integer,Camion> mostrarCamionesAsignados()
	{
		System.out.println("\n +++ Listado de todos los Camiones Asignados ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Tipo\t\t Matricula \t  Asignado");
		System.out.println("\t---------\t-----------\t------------\n");		
		
		//Definir un Map para devolver
		//NOTA: TreeMap para aceder a un vehiculo en el metodo desAsignarVehiculo.
		//Este Map solo se utiliza para conseguir el vehiculo, es decir solo se lee en el Map
		//por eso se utiliza un estructura Map, porque solo se utiliza para leer, no para recorrer
		TreeMap<Integer,Camion> camioneAsignados = new TreeMap<Integer,Camion>();
		
		//Se recorre la listaCamione y se mira si el camion esta asigando
				
		Integer numeroCamioneAsignados =0;
		for(int a=0 ; a<unekoListaCamiones.size();a++)
		{
			Camion c1 = unekoListaCamiones.get(a);
			if(c1.getDisponible()==false)
			{
				String infoAsignado = c1.getAsigandoEmpleado().getDni() + " ( " + c1.getAsigandoEmpleado().getNombre() + " ) ";
				System.out.println("\t" + (numeroCamioneAsignados+1) + ".- " + c1.getClass().getSimpleName() + " \t " + c1.getMatricula() + "\t " + infoAsignado );
				//guardar el camion para el return
				camioneAsignados.put(numeroCamioneAsignados, c1);
				numeroCamioneAsignados=numeroCamioneAsignados+1;
			}
			
		}
		System.out.println("\n\t\tTotal : " + numeroCamioneAsignados);
		
		return camioneAsignados;
	}
	
	public ArrayList<Camion> buscarCamiones()
	{
		//buscar todos los Camione
		ArrayList<Camion> listaCamione = new ArrayList<Camion>();;
		for (Vehiculo v : this.unekoGrupo.getVehiculos())
		{
			if("Camion".equals(v.getClass().getSimpleName()))
					{
						listaCamione.add((Camion) v);
					}
		}
		return listaCamione;
	}
	

	public void asignarCamion()
	{

				//Mostrar Camione disponibles
				TreeMap<Integer,Camion> mapaCamioneDisponibles = this.mostrarCamionesDisponibles();
				Integer total=mapaCamioneDisponibles.size();
				
				if(total==0)
				{
					//No hay Camione para des-asignar
					System.out.println("\n No hay camione para asignar.");
				}
				else
				{

					System.out.print("\n Introduce el numero del Camion que quieres asignar :");
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
									Camion c1 = mapaCamioneDisponibles.get(numeroElegido-1);
									
									//Obtener empleado elegido utilizando el Map
									Empleado empleadoElegidoMenu = mapaEmlpleadosDisponibles.get(numeroEmpleadoElegido-1);
									
									//asignar empleado al vehiculo + BD
									c1.asignarEmpleado(empleadoElegidoMenu);
									
									System.out.println("\n El Camion [ " +c1.getMatricula() + " ] se ha asignado al empleado ( " + c1.getAsigandoEmpleado().getDni() + " : " + c1.getAsigandoEmpleado().getNombre() + " ) con exito.");		
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

	public void desAsignarCamion()
	{
		
		//Mostrar en pantalla todos los Camione
		// Y recuperar un Map con los Camione asignados
		//Este Map solo se utiliza para conseguir el Camion, es decir solo se lee en el Map
				//por eso se utiliza un estructura Map, porque solo se utiliza para leer, no para recorrer
		TreeMap<Integer,Camion> camioneAsignados = mostrarCamionesAsignados();
		
		Integer total = camioneAsignados.size();
		
		if(total==0)
		{
			//No hay Camione para des-asignar
			System.out.println("\n No hay camione para des-asignar.");
		}
		else
		{
			//si hay Camione para des-asignar
			System.out.print("\n Introduce el numero del Camion que quieres des-asignar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=total){
					//obtener vehiculo para desAsignar
					Camion c1 = camioneAsignados.get(numeroElegido-1);
					//mostrar en pantalla antes de des-asignar
					System.out.println("\n El Camion [ " +c1.getMatricula() + " ] se ha des-asignado del empleado ( " + c1.getAsigandoEmpleado().getDni() + " : " + c1.getAsigandoEmpleado().getNombre() + " ) con exito.");
					//des-asignar vehiculo + BD
					c1.desAsignarVehiculo();
				}
				else
				{
					System.out.println(" Introduce el numero del Camion que quieres des-asignar :");
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
	
	
	public void prepararGestionDeUnCamion()
	{

		//Mostrar en pantalla todos los Camione
		Integer totalCamione = mostrarCamionesTodos();
		
		if (totalCamione==0)
		{
			//No hay ningun grupo para gestionar
			System.out.println("\nNo hay ningun Camion para gestionar, añade un Camion.");
		}
		else
		{
			//preparar para la gestion del grupo
			System.out.print("\nIntroduce el numero del Camion que quieres Gestionar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=totalCamione)
				{
					//Obtener el camion
					Camion c1 = unekoListaCamiones.get(numeroElegido-1);
					//Ir a la pantalla de Gestion de un Camion
					pantallaCamion.menuPantallaCamion(c1);
				}
				else
				{
					System.out.print("Introduce el numero del Camion que quieres Gestionar :");
				}
				
			} while (numeroElegido<=0 || numeroElegido>totalCamione);
		}	
	}
}
