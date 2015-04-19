package es.flota.Pantallas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UtilesPantalla {

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static Integer leerNumero()
	{
		//Leer el STREAM y pasar a numero
		
		String grupoNumero = "";
		Integer numeroElegido = -1;
		
		try {
			grupoNumero = stdin.readLine();
			numeroElegido = new Integer(grupoNumero);
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("¡\nError de Entrada/Salida!");
		}catch (NumberFormatException e) {
			
			//e.printStackTrace();
			System.out.print("\n\t\t***********************");
			System.out.println("\n\t\t** ¡No es un numero! **");
			System.out.println("\t\t***********************\n");
		}
		return numeroElegido;
	}
	public static Double leerDouble()
	{
		//Leer el STREAM y pasar a numero
		
		String grupoNumero = "";
		Double numeroElegido = null;
		
		try {
			grupoNumero = stdin.readLine();
			numeroElegido = new Double(grupoNumero);
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("¡\nError de Entrada/Salida!");
		}catch (NumberFormatException e) {
			
			//e.printStackTrace();
			System.out.print("\n\t\t***********************");
			System.out.println("\n\t\t** ¡No es un numero! **");
			System.out.println("\t\t***********************\n");
		}
		return numeroElegido;
	}
	public static String leerCadena()
	{
		String cadena="";
		//Leer el STREAM de entrada
		try
		{
			cadena = stdin.readLine();	
		}
		catch (IOException e) 
		{
			//e.printStackTrace();
			System.out.println("¡Error de Entrada/Salida!");
		}
		catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("¡Error al leer el numero!");
		}
		
		return cadena;
	}
	
	public static void pulsaUnaTecla()
	{
		//pulsa una tecla para seguir
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n\t\t\t ( Pulsa la tecla Enter ) ");
		try {
			stdin.read();
		} catch (IOException e) {
			System.out.println("Error de Entrada/Salida");
		}
	}
	
}
