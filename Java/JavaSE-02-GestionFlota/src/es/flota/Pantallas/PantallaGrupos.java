package es.flota.Pantallas;

import java.util.ArrayList;

import es.flota.DB.GestorDB;
import es.flota.Grupo.Grupo;

public class PantallaGrupos {

	private PantallaGrupo pantallaGestionGrupo = new PantallaGrupo();
	
	public void iniciarMenu()
	{
		//Generar Base de datos
		GestorDB.getInstance();
		
		//definir numero para recibir la lectura del teclado
		Integer numeroMenu;
		do
		{
			System.out.println("\n --------------------------------------------------");
			System.out.println(" ----- GESTION DE FLOTA - MENU PRINCIPAL ----------");
			System.out.println(" --------------------------------------------------\n");
			System.out.println("\t1.- Mostrar Grupos: ");
			System.out.println("\t2.- Añadir un Grupo : ");
			System.out.println("\t3.- Borrar un Grupo : ");
			System.out.println("\t4.- Gestion de un Grupo : ");
			System.out.println("\t0.- Salir : ");
			System.out.print("\n\t\tElige una opcion : ");
			 
			//leer numero del teclado
			numeroMenu = UtilesPantalla.leerNumero();

			switch(numeroMenu)
			{
				case 1: 
					mostrarGrupos();
					//( Pulsa la tecla Enter ) 
					UtilesPantalla.pulsaUnaTecla();
					break;
				case 2: 
					añadirGrupo();
					break;
				case 3:
					borrarGrupo();
					break;
				case 4: 
					prepararGestionrGrupo();
					break;
				case 0: 
					System.out.println("\n -----------------------------------------------");
					System.out.println(" ------------- PROGRAMA TERMINADO --------------");
					System.out.println(" -----------------------------------------------");
					break;
			}	
		} while (numeroMenu!=0);	
	}
	
	public Integer mostrarGrupos()
	{
		System.out.println("\n++++++++++++ Listado de todos los Grupos +++++++++ ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("\t  Nombre");
		System.out.println("\t --------");
		
		ArrayList<Grupo> listaGrupos = GestorDB.getInstance().getBd().getListaGrupos();
		for(int a=0 ; a<listaGrupos.size();a++)
		{
			Grupo g1 = listaGrupos.get(a);
			System.out.print("\t" + (a+1) + ".- ");
			System.out.println(g1.getNombre());
		}
		System.out.println("\n\t\tTotal : " + listaGrupos.size());
		return listaGrupos.size();
	}

	public void añadirGrupo(){
		System.out.println("\n++++++++++++++ Añadir Grupo ++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.print("Introduce el nombre del grupo nuevo :");
		
		String nombreGrupo = "";	
		//leer cadena de teclado
		nombreGrupo=UtilesPantalla.leerCadena();

		//añadir grupo a la Base de datos
		GestorDB.getInstance().añadirGrupoGestor(new Grupo(nombreGrupo));
		
		System.out.println("\nEl nombre [ " + nombreGrupo +" ] se ha guardado correctamente!!!");
	}

	public void borrarGrupo()
	{		
		//Mostrar en pantalla todos los grupos
		Integer total = mostrarGrupos();
		
		System.out.print("\nIntroduce el numero del grupo que quieres borrar :");	
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

	public void prepararGestionrGrupo()
	{
		//Mostrar en pantalla todos los grupos
		Integer totalGrupos = mostrarGrupos();
		
		if (totalGrupos==0)
		{
			//No hay ningun grupo para gestionar
			System.out.println("\nNo hay ningun grupo para gestionar, añade un grupo.");
		}
		else
		{
			//preparar para la gestion del grupo
			System.out.print("\nIntroduce el numero del Grupo que quieres Gestionar :");
			Integer numeroElegido = -1;
			do
			{		
				//leer numero del teclado
				numeroElegido = UtilesPantalla.leerNumero();

				//si a pulsado una de las opciones
				if ( numeroElegido>0 && numeroElegido<=totalGrupos)
				{
					Grupo g1 = GestorDB.getInstance().obtenerGrupo(numeroElegido-1);
					pantallaGestionGrupo.menuPantallaGrupo(g1);
				}
				else
				{
					System.out.print("Introduce el numero del Grupo que quieres Gestionar :");
				}
				
			} while (numeroElegido<=0 || numeroElegido>totalGrupos);
		}	
	}
}
