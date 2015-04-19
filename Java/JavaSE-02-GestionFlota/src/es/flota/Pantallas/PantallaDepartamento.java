package es.flota.Pantallas;

import java.util.ArrayList;
import java.util.TreeMap;

import es.flota.Grupo.Departamento;
import es.flota.Grupo.Empleado;
import es.flota.Grupo.Empresa;
import es.flota.Grupo.Grupo;
import es.flota.Grupo.Vehiculo;

public class PantallaDepartamento {

	private Departamento unekoDepartamento;
	private PantallaEmpleado pantallaEmpleado= new PantallaEmpleado();
	
	public void menuPantallaDepartamento(Departamento departamento){
		this.unekoDepartamento = departamento;
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ---- Gestion del departamento : " + unekoDepartamento.getNombre()+" ----");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar todos los Empleados : ");
			System.out.println("\t2.- Mostrar todos los Empleados Disponibles : ");
			System.out.println("\t3.- Mostrar todos los Empleados Asignados : ");
			System.out.println("\t4.- Asignar un Empleado : ");
			System.out.println("\t5.- Des-asignar un Empleado: ");
			System.out.println("\t6.- Gestion de un Empleado : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
					this.mostrarTodosLosEmpleados();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: 
					this.mostrarEmpleadosDisponibles();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 3:
					this.mostrarEmpleadosAsignados();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 4: 
					this.asignarEmpleado();
					break;
				case 5: 
					this.desAsignarEmpleado();
					break;
				case 6: 
					this.prepararGestionDeUnEmpleado();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);	
		
	}
	public TreeMap<Integer,Empleado> mostrarTodosLosEmpleados()
	{
		System.out.println("\n +++ Listado de Todos los Empleados del departamento : " +unekoDepartamento.getNombre() +" ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t Nombre\t\t Apellido \t Carga\t\t  DNI 	\t Asignado");
		System.out.println("\t---------\t-----------\t--------\t---------\t------------\n");
		
		//Mapa para return
		TreeMap<Integer,Empleado> mapaTodosLosEmlpleados = new TreeMap<Integer, Empleado>();
				//Obtener en un List todos los empleados de la empresa
		ArrayList<Empleado> listaEmlpleadosDepartamento = unekoDepartamento.getListaEmpleados();
		Integer numeroEmpleado=0;
		for(Empleado empleado : listaEmlpleadosDepartamento)
		{
			String asignado="";
			//buscar el vehiculo asignado
			if ( empleado.getVehiculoAsignado()!=null)
			{
				//tiene vehiculo asginado
				//obtener el vehiculo
				Vehiculo v1 = empleado.getVehiculoAsignado();
				String matricula = v1.getMatricula();
				String tipo = v1.getClass().getSimpleName();
				asignado= tipo+" : "+matricula; 
			}

			String utxune = (empleado.getApellido().length()>7 )?"\t":"\t\t";
			//mostrar en pantalla cada empleado
			System.out.println("\t" + (numeroEmpleado+1)+".- " + empleado.getNombre() + "\t " + empleado.getApellido() + utxune+ "  "  + empleado.getCarga() + "\t\t "  + empleado.getDni() + "\t" + asignado);
			//guardar en el map
			mapaTodosLosEmlpleados.put(numeroEmpleado,empleado);
			numeroEmpleado=numeroEmpleado+1;	
		}
		return mapaTodosLosEmlpleados;
	}
	public TreeMap<Integer,Empleado> mostrarEmpleadosAsignados()
	{
		System.out.println("\n +++ Listado de los Empleados Asignados del departamento : " +unekoDepartamento.getNombre() +" ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t Nombre\t\t Apellido \t Carga\t\t  DNI 	\t Vehiculo");
		System.out.println("\t---------\t-----------\t--------\t---------\t--------------\n");
		
		//Mapa para return
		TreeMap<Integer,Empleado> mapaEmlpleadosAsignados = new TreeMap<Integer, Empleado>();
		//Obtener en un List todos los empleados de la empresa
		ArrayList<Empleado> listaEmlpleadosAsigandosDepartamento = unekoDepartamento.buscarEmpleadosOcupados();
		Integer numeroEmpleado=0;
		for(Empleado empleado : listaEmlpleadosAsigandosDepartamento)
		{
			//obtener el vehiculo
			Vehiculo v1 = empleado.getVehiculoAsignado();
			String matricula = v1.getMatricula();
			String tipo = v1.getClass().getSimpleName();
			
			String utxune = (empleado.getApellido().length()>7 )?"\t":"\t\t";
			//mostrar en pantalla cada empleado
			System.out.println("\t" + (numeroEmpleado+1)+".- " + empleado.getNombre() + "\t " + empleado.getApellido() + utxune+ "  "  + empleado.getCarga() + "\t\t "  + empleado.getDni()+ "\t"  + tipo + " : "  + matricula);
			//guardar en el map
			mapaEmlpleadosAsignados.put(numeroEmpleado,empleado);
			numeroEmpleado=numeroEmpleado+1;	
		}
		return mapaEmlpleadosAsignados;
	}
	public TreeMap<Integer,Empleado> mostrarEmpleadosDisponibles()
	{
		System.out.println("\n +++ Listado de los Empleados Disponibles del departamento : " +unekoDepartamento.getNombre() +" ++++++ ");
		System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t Nombre\t\t Apellido \t Carga\t\t  DNI");
		System.out.println("\t---------\t-----------\t--------\t---------\n");
		
		//Mapa para return
		TreeMap<Integer,Empleado> mapaEmlpleadosDisponibles = new TreeMap<Integer, Empleado>();
		//Obtener en un List todos los empleados de la empresa
		ArrayList<Empleado> listaEmlpleadosDepartamento = unekoDepartamento.buscarEmpleadosDisponibles();
		Integer numeroEmpleado=0;
		for(Empleado empleado : listaEmlpleadosDepartamento)
		{
			String utxune = (empleado.getApellido().length()>7 )?"\t":"\t\t";
			//mostrar en pantalla cada empleado
			System.out.println("\t" + (numeroEmpleado+1)+".- " + empleado.getNombre() + "\t " + empleado.getApellido() + utxune+ "  "  + empleado.getCarga() + "\t\t "  + empleado.getDni());
			//guardar en el map
			mapaEmlpleadosDisponibles.put(numeroEmpleado,empleado);
			numeroEmpleado=numeroEmpleado+1;	
			
		}
		return mapaEmlpleadosDisponibles;
	}
	public void desAsignarEmpleado()
	{
		//mostrar los empleados asignados
		TreeMap<Integer, Empleado>  mapaEmpleadosAsigandos = this.mostrarEmpleadosAsignados();
		Integer total = mapaEmpleadosAsigandos.size();
		
		if(total==0)
		{
			//No hay vehiculos para des-asignar
			System.out.println("\n No hay empleados para des-asignar.");
		}
		else
		{
			//desAsignar vehiculo
			System.out.print("\n Introduce el numero del Empleado que quieres Des-Asignar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=total){
					//obtener vehiculo para desAsignar
					Empleado e1 = mapaEmpleadosAsigandos.get(numeroElegido-1);
					//mostrar en pantalla antes de des-asignar
					System.out.println("\n El Empleado [ " + e1.getDni() + " : " + e1.getNombre()  + " ]  se ha des-asignado correctamente del vehiculo ( " + e1.getVehiculoAsignado().getClass().getSimpleName()+ " : " + e1.getVehiculoAsignado().getMatricula()+ " ) con exito.");
					//des-asignar empleado + BD
					e1.desAsignarVehiculo();
				}
				else
				{
					System.out.println(" Introduce el numero del Empleado que quieres des-asignar :");
				}
				
			} while (numeroElegido<=0 || numeroElegido>total);
			
		}
	}
	public void asignarEmpleado()
	{
		//mostrar los empleados disponibles ( sin asignar )
		TreeMap<Integer, Empleado> mapaEmpleadosLibres =  this.mostrarEmpleadosDisponibles();
		Integer total = mapaEmpleadosLibres.size();
		
		if(total==0)
		{
			//No hay vehiculos para des-asignar
			System.out.println("\n No hay empleados para asignar.");
		}
		else
		{
			//asiganr empleado
			System.out.print("\n Introduce el numero del Empleado que quieres Asignar :");
			Integer numeroEmpleadoElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroEmpleadoElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroEmpleadoElegido>0 && numeroEmpleadoElegido<=total){
					
					
					//ELEGIR EL VEHICULO PARA ASIGNAR
					//mostrar los vehiculos disponibles
					TreeMap<Integer, Vehiculo> mapaVehiculosDisponibloes = this.mostrarVehiculosDisponibles();

					//obtener el total de empleados
					Integer numeroVehiculosTotal = mapaVehiculosDisponibloes.size();
					
					System.out.print("\nIntroduce el numero del Vehiculo que quieres asignar :");
					Integer numeroVehiculoElegido = -1;
					do
					{		
						//leer numero del teclado
						numeroVehiculoElegido = UtilesPantalla.leerNumero();

						//si a pulsado una de las opciones
						if ( numeroVehiculoElegido>0 && numeroVehiculoElegido<=numeroVehiculosTotal){	
							
							//obtener Empleado para Asignar
							Vehiculo v1 = mapaVehiculosDisponibloes.get(numeroVehiculoElegido-1);
							
							//Obtener empleado elegido utilizando el Map
							Empleado empleadoElegidoMenu = mapaEmpleadosLibres.get(numeroEmpleadoElegido-1);
							
							//asignar empleado al vehiculo + BD
							empleadoElegidoMenu.asignarVehiculo(v1);
							
							System.out.println("\nEl Empleado ( " + v1.getAsigandoEmpleado().getDni() + " : " + v1.getAsigandoEmpleado().getNombre() + " ) se ha asignado al Vehiculo [ " + v1.getClass().getSimpleName() +  " : " +v1.getMatricula() + " ] con exito.");		
						}
						else
						{
							System.out.print("\n Introduce el numero del vehiculo que quieres asignar :");
						}
						
					} while (numeroVehiculoElegido<=0 || numeroVehiculoElegido>numeroVehiculosTotal);				
					
				}
				else
				{
					System.out.println(" Introduce el numero del Empleado que quieres des-asignar :");
				}
				
			} while (numeroEmpleadoElegido<=0 || numeroEmpleadoElegido>total);
			
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
		
		//-------- OBTENER GRUPO GRACIAS AL LA DOBLE UNION -----------------
		// DEPARTAMENTO-> EMPRESA -> GRUPO
		
		//Obtener empresa
		Empresa empresaPadre = unekoDepartamento.getEmpresaPadre();
		//Obtener grupo
		Grupo grupoPadre = empresaPadre.getGrupoPadre();
		
		//------------------------------------------------------------------
		
		//Se recorre la listaVehiculos y se mira si el vehiculo esta asigando
		ArrayList<Vehiculo> listaVehiculos = grupoPadre.getVehiculos();		
				
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
	public void prepararGestionDeUnEmpleado(){
		
		//mostrar todos los empleados 
		TreeMap<Integer, Empleado> mapaEmpleadosTodos =  this.mostrarTodosLosEmpleados();
		Integer total = mapaEmpleadosTodos.size();
		
		if(total==0)
		{
			//No hay emleados
			System.out.println("\n No hay empleados para mostrar.");
		}
		else
		{
			//gestionar empleado
			System.out.print("\n Introduce el numero del Empleado que gestionar :");
			Integer numeroEmpleadoElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroEmpleadoElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroEmpleadoElegido>0 && numeroEmpleadoElegido<=total){
					
					Empleado e1 = mapaEmpleadosTodos.get(numeroEmpleadoElegido-1);
					pantallaEmpleado.menuPantallaEmpleado(e1);
				}
				else
				{
					System.out.println(" Introduce el numero del Empleado que quieres gestionar :");
				}
				
			} while (numeroEmpleadoElegido<=0 || numeroEmpleadoElegido>total);
			
		}
		
	}
}
