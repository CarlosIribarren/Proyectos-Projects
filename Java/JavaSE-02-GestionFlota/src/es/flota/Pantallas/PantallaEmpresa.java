package es.flota.Pantallas;

import java.util.ArrayList;

import es.flota.Grupo.Departamento;
import es.flota.Grupo.Empresa;

public class PantallaEmpresa {

	private Empresa unekoEmpresa;
	private PantallaDepartamento pantallaDepartamento = new PantallaDepartamento();
	
	public void menuPantallaEmpresa(Empresa e1)
	{
		unekoEmpresa = e1;
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" ---------------- EMPRESA : " + unekoEmpresa.getNombre() + " -----------");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar Departamentos: ");
			System.out.println("\t2.- Añadir un Departamento : ");
			System.out.println("\t3.- Borrar un Departamento : ");
			System.out.println("\t4.- Gestion de un Departamento : ");
			System.out.println("\t5.- Cambiar nombre de la Empresa : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
						mostrarDepartamentos();
						//( Pulsa la tecla Enter ) 
						UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: 
						añadirDepartamento();
					break;
				case 3:
						borrarDepartamento();
					break;
				case 4: 
						prepararGestionrDepartamento();
					break;
				case 5: 
						cambiarNombreEmpresa();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);		
		
	}
	
	public void cambiarNombreEmpresa(){

		System.out.println("\n++++++ Cambiar el nombre de la Empresa +++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println("Introduce el nombre Nuevo de la Empresa :");
		String nombreEmpresa = "";	
		//leer cadena de teclado
		nombreEmpresa=UtilesPantalla.leerCadena();
		
		//obtener el nombre de la empresa que se va a cambiar
		String nombreViejo = unekoEmpresa.getNombre();
		//cambiar nombre + BD
		unekoEmpresa.cambiarNombre(nombreEmpresa);
	
		System.out.println("La Empresa [ " + nombreViejo + " ] ha sido modificado por [ " + nombreEmpresa +" ].");
	}
	
	public Integer mostrarDepartamentos()
	{
		System.out.println("\n+++++++ Listado de todos los Departamentos +++++++++ ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Nombre");
		System.out.println("\t --------");
		
		ArrayList<Departamento> listaDepartamentos = unekoEmpresa.getListaDepartamentos();
		for(int a=0 ; a<listaDepartamentos.size();a++)
		{
			Departamento d1 = listaDepartamentos.get(a);
			System.out.print("\t" + (a+1) + ".- ");
			System.out.println(d1.getNombre());
		}
		System.out.println("\n\t\tTotal : " + listaDepartamentos.size());
		
		return listaDepartamentos.size();
	}
	
	public void añadirDepartamento(){
		System.out.println("\n++++++++++++++ Añadir Departamento ++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.print("Introduce el nombre del Departamento nuevo :");

		String nombreDepartamento = "";	
		//leer cadena de teclado
		nombreDepartamento=UtilesPantalla.leerCadena();
		
		System.out.print("Introduce el codigo del Departamento nuevo :");
		String codigoDepartamento = "";	
		//leer cadena de teclado
		codigoDepartamento=UtilesPantalla.leerCadena();
		
		//añadir grupo a la Base de datos
		unekoEmpresa.añadirDepartamento(new Departamento(codigoDepartamento,nombreDepartamento,unekoEmpresa));
		
		System.out.println("\nEl Departamento [ " + codigoDepartamento +" - " + nombreDepartamento +" ] se ha guardado correctamente.");
		
	}
	public void borrarDepartamento()
	{		
		//Mostrar en pantalla todos los grupos
		Integer total = mostrarDepartamentos();
		
		System.out.print("\nIntroduce el numero del Departamento que quieres borrar :");
		Integer numeroElegido = -1;
		do
		{		
			//leer numero del teclado
			numeroElegido = UtilesPantalla.leerNumero();

			//si a pulsado una de las opciones
			if ( numeroElegido>0 && numeroElegido<=total){
				//obtener grupo para borrar
				Departamento d1 = unekoEmpresa.obtenerDepartamento(numeroElegido-1);
				//borrar Departamento de la BD 
				unekoEmpresa.borrarDepartamento(d1);
	
				System.out.println("\nEl Departamento [ " +d1.getNombre()+ " ] se ha borrado con exito!!!!");
			}
			else
			{
				System.out.print("Introduce el numero del Departamento que quieres borrar :");
			}
			
		} while (numeroElegido<=0 || numeroElegido>total);
	}
	

	public void prepararGestionrDepartamento()
	{
		//Mostrar en pantalla todos los grupos
		Integer totalDepartamentos = this.mostrarDepartamentos();
		
		System.out.print("\nIntroduce el numero del Departamento que quieres Gestionar :");
		Integer numeroElegido = -1;
		do
		{		
			//leer numero del teclado
			numeroElegido = UtilesPantalla.leerNumero();

			//si a pulsado una de las opciones
			if ( numeroElegido>0 && numeroElegido<=totalDepartamentos)
			{
				Departamento d1 = unekoEmpresa.obtenerDepartamento(numeroElegido-1);
				pantallaDepartamento.menuPantallaDepartamento(d1);
			}
			else
			{
				System.out.print("Introduce el numero del Departamento que quieres Gestionar :");
			}
			
		} while (numeroElegido<=0 || numeroElegido>totalDepartamentos);
		
	}
	
	
}
