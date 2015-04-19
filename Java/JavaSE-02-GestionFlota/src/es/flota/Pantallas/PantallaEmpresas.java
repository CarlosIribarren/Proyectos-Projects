package es.flota.Pantallas;

import java.util.ArrayList;

import es.flota.Grupo.Empresa;
import es.flota.Grupo.Grupo;

//No se define el ambito de la clase como public para que solo sea visible desde el paquete
class PantallaEmpresas {

	private Grupo unekoGrupo;
	private PantallaEmpresa pantallaEmpresa = new PantallaEmpresa();
	
	public void menuPantallaEmpresas(Grupo unekoGrupo){
		this.unekoGrupo = unekoGrupo;
		
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n -------------------------------------------------");
			System.out.println(" -------Gestion de Empresas de " + unekoGrupo.getNombre() + " ------");
			System.out.println(" -------------------------------------------------\n");
			System.out.println("\t1.- Mostrar Empresas: ");
			System.out.println("\t2.- Añadir una Empresa : ");
			System.out.println("\t3.- Borrar una Empresa : ");
			System.out.println("\t4.- Gestor de Empresas : ");
			System.out.println("\t0.- Atras : ");
			System.out.print("\n\t\tElige una opcion : ");
			
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
					mostrarEmpresas();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: 
					añadirUnaEmpresa();
					break;
				case 3:
					borrarUnaEmpresa();
					break;
				case 4: 
					prepararPantallaEmpresa();
					break;
				case 0: 
					break;
			}
			
		} while (numeroMenu!=0);	
	}
	
	
	
	
	public Integer mostrarEmpresas()
	{
		System.out.println("\n++++++++++++ Listado de todas las empresas +++++++++ ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Nombre\t   Direccion");
		System.out.println("\t --------\t  -----------\n");
		
		ArrayList<Empresa> listaEmpresas = unekoGrupo.getListaEmpresas();
		
		for(int a=0 ; a<listaEmpresas.size();a++)
		{
			Empresa e1 = listaEmpresas.get(a);
			
			System.out.println("\t" + (a+1) + ".- " + e1.getNombre() + " \t " + e1.getDireccion() );
		}
		System.out.println("\n\t\tTotal : " + listaEmpresas.size());
		
		return listaEmpresas.size();
	}
	
	public void añadirUnaEmpresa()
	{
		System.out.println("\n++++++++++++++ Añadir Empresa +++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println("Introduce el Nombre de la Empresa nueva :");
		String nombreEmpresa = "";	
		//leer cadena de teclado
		nombreEmpresa=UtilesPantalla.leerCadena();
		
		System.out.println("Introduce la Direccion de la Empresa nueva :");
		String nombreDireccion = "";
		//leer cadena de teclado
		nombreDireccion=UtilesPantalla.leerCadena();
		
		Empresa e1 = new Empresa(nombreEmpresa, nombreDireccion, unekoGrupo);
		//añadir la empresa + Guardar en BD
		unekoGrupo.añadirEmpresa(e1);
	
		System.out.println("El nombre [ " + nombreEmpresa +" ] se ha guardado correctamente.");
	}
	
	public void borrarUnaEmpresa()
	{
		
		//Mostrar en pantalla todos los grupos
		Integer numeroTotalEmpresas = mostrarEmpresas();
		
		System.out.print("\nIntroduce el numero de la empresa que quieres borrar :");	
		Integer numeroElegido = -1;
		do
		{		
			//leer numero del teclado
			numeroElegido = UtilesPantalla.leerNumero();

			//si a pulsado una de las opciones
			if ( numeroElegido>0 && numeroElegido<=numeroTotalEmpresas){	
				//encontrar empresa
				Empresa e = unekoGrupo.obtenerEmpresa(numeroElegido-1);
				//borrar empresa de uneko + BD
				unekoGrupo.eliminarEmpresa(e);
				System.out.println("\nLa empresa [ " + e.getNombre()+ " ] se ha borrado con exito!!!!");
			}
			else
			{
				System.out.println("Por favor eliga un numero de la lista");
			}
			
		} while (numeroElegido<=0 || numeroElegido>numeroTotalEmpresas);
	}

	public void prepararPantallaEmpresa()
	{
		//Mostrar en pantalla todos los grupos
		Integer totalEmpresas = mostrarEmpresas();
		
		System.out.print("\nIntroduce el numero de la Empresa que quieres Gestionar :");
		Integer numeroElegido = -1;
		do
		{		
			//leer numero del teclado
			numeroElegido = UtilesPantalla.leerNumero();

			//si a pulsado una de las opciones
			if ( numeroElegido>0 && numeroElegido<=totalEmpresas)
			{
				Empresa e = unekoGrupo.obtenerEmpresa(numeroElegido-1);
				pantallaEmpresa.menuPantallaEmpresa(e);
			}
			else
			{
				System.out.print("Introduce el numero de la Empresa que quieres Gestionar :");
			}
			
		} while (numeroElegido<=0 || numeroElegido>totalEmpresas);
		
	}
}
