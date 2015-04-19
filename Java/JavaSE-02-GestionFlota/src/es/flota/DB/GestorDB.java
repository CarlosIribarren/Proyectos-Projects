package es.flota.DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import es.flota.Grupo.Camion;
import es.flota.Grupo.Coche;
import es.flota.Grupo.Departamento;
import es.flota.Grupo.Empleado;
import es.flota.Grupo.Empresa;
import es.flota.Grupo.Grupo;

public class GestorDB {
    
    //Base de datos
    //Como solo existira una instacia del Gestor de Base de Datos, entonces solo existira una
    // instacia de la Base de Datos ( el metodo new BaseDatos() solo se ejecuta una vez )
    private DB bd;
 
    //------------------------ PATRON SINGLETON --------------
    //--------------------------------------------------------
    
    private static GestorDB INSTANCE = null;
    // El constructor privado no permite que se genere un constructor por defecto
    private GestorDB() {
    	//este constructor solo se ejecuta una vez, cuando la INSTANCE = null
    	bd = new DB();
    	this.generarBD();
    }
 
    // Crear la instancia debe ser sincronizado (o sincronizar el código dentro)
    // para protegerse de posibles problemas  multi-hilo
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new GestorDB();
        }
    }
 
    public static GestorDB getInstance() {
        createInstance();
        return INSTANCE;
    }
    
    @Override
    // El método "clone" debe ser sobreescrito para evitar duplicación de objetos
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
    
    
    
    //-------------- METODOS DE LA CLASE ----------------------
    //---------------------------------------------------------
    public Grupo obtenerGrupo(Integer index)
    {
    	int indexInt = index;
    	return bd.getListaGrupos().get(indexInt);
    }
    
	public void añadirGrupoGestor(Grupo g1)
	{
		bd.añadirGrupo(g1);
		this.añadirLog("Grupo [ " + g1.getNombre() + " ] añadido.");
		this.guardarBD();
	}
	public Boolean borrarGrupoGestor(Grupo g1)
	{
		Boolean accion = bd.borrarGrupo(g1);
		if (accion==true)
		{
			this.añadirLog("Grupo [ " + g1.getNombre() + " ] borrado.");
		}
		else
		{
			this.añadirLog("Error al borrar el grupo [ " + g1.getNombre() + " ].");
		}
		this.guardarBD();
		return accion;
	}
    
    public void añadirLog(String log)
    {
		//guardar fecha de cuando se añadido el grupo
		java.util.Date fecha = new Date();
		bd.setUltimaConexion(fecha);
		//aladir log
		bd.setLog(bd.getLog() + "\n - " + fecha + " : " + log);
    }

    public void guardarBD()
    {
		//---------- ESCRIBIR -----------------
		try {
			//crear flujo de salida hacia el fichero
			FileOutputStream fos = new FileOutputStream("GruposBD");
			//crear un Stream de salida, apuntando al fichero
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(bd);
			//cerrar el flujo
			ous.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void leerBD()
    {
		//--------- LEER --------------------
		try {
			//leer fichero
			//definir un flujo de entrada en archivo
			FileInputStream fis = new FileInputStream("GruposBD");
			//crear un flujo de entrada de objetos, apuntando al fichero
			ObjectInputStream ois = new ObjectInputStream(fis);
			//leer el objeto
			bd =   (DB) ois.readObject();
			//cerrar el flujo
			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    //metodo private para que solo lo puedo utilizar esta clase
    // y no pueda ser utilizado en ningun otro lugar
	private void generarBD(){
		
	    String sFichero = "GruposBD";
	    File fichero = new File(sFichero);
	    if (fichero.exists())
	    {
	    	//existe
	    	this.leerBD();
	    }
	        
	    else
	    {
	    	//El archivo no existe, generar los datos
	    	
			//Crear el archivo por primera vez 
			this.guardarBD();
			
	    	//Definir estructura para guardar los grupos
			ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
			
			//datos grupo
			Grupo grupo = new Grupo("Grupo Zuatzu");

			//datos empresas
			Empresa innova4b = new Empresa("Innova4b", "C Mayor",grupo);
			Empresa asolif = new Empresa("asolif", "C Donosti",grupo);
			Empresa innoBasque = new Empresa("innoBasque", "C Oiartzun",grupo);

			//departamentos
			Departamento depInformatica = new Departamento("1A","Informatica",innova4b);
			Departamento depVentas = new Departamento("2A","Ventas",innova4b);
			Departamento depGestion = new Departamento("3A","Gestion",innova4b);
			Departamento depInformaticaASOLIF = new Departamento("1A","Informatica - ASOLIF",asolif);
			Departamento depVentasASOLIF = new Departamento("2A","Ventas - ASOLIF",asolif);
			Departamento depGestionASOLIF = new Departamento("3A","Gestion - ASOLIF",asolif);
			Departamento depInformaticaBASQUE = new Departamento("1A","Informatica - BASQUE",innoBasque);
			Departamento depVentasBASQUE = new Departamento("2A","Ventas - BASQUE",innoBasque);
			Departamento depGestionBASQUE = new Departamento("3A","Gestion - BASQUE",innoBasque);
			
			//Empleados Informatica
			Empleado emIn1 = new Empleado("44560675S", "Carlos","Iribarren",1.0d,depInformatica);
			Empleado emIn2 = new Empleado("22222222E", "David","izquierda",2.0d,depInformatica);
			Empleado emIn3 = new Empleado("33333333F", "Antonio","profesor",3.0d,depInformatica);
			//Empleados Ventas
			Empleado emVe1 = new Empleado("44444444G", "Juan44","juju",4.0d,depVentas);
			Empleado emVe2 = new Empleado("55555555H", "Antonio","ant",5.0d,depVentas);
			Empleado emVe3 = new Empleado("66666666J", "Jesus","je",6.0d,depVentas);
			//Empleados Gestion
			Empleado emGe1 = new Empleado("77777777G", "Luis","lu",7.0d,depGestion);
			Empleado emGe2 = new Empleado("88888888D", "Jose","jo",8.0d,depGestion);
			Empleado emGe3 = new Empleado("99999999O", "Miren","mi",9.0d,depGestion);
			//Coches
			Coche coche1 = new Coche("0984-JYW","Peugeot1", "201",50.5d,true);
			Coche coche2 = new Coche("8753-CGS","Peugeot2", "202",100.5d,false,emIn1);
			emIn1.setVehiculoAsignado(coche2);
			Coche coche3 = new Coche("7407-KIY","Peugeot3", "203",150.5d,true);
			Coche coche4 = new Coche("1123-TWE","Peugeot4", "204",200.5d,false, emGe2);
			emGe2.setVehiculoAsignado(coche4);
			//Camiones
			Camion camion1 = new Camion("7741-GLB", "Orion1", "Supra1", 450.9d, 460d,true);
			Camion camion2 = new Camion("8462-HDE", "Orion2", "Supra2", 550.9d, 560d,true);
			Camion camion3 = new Camion("1965-LOY", "Orion3", "Supra3", 650.9d, 660d,true);
			Camion camion4 = new Camion("2543-PWE", "Orion4", "Supra4", 750.9d, 760d,true);

			//asignaciones

			//Añadir Vehiculos
			grupo.añadirVehiculo(coche1);
			grupo.añadirVehiculo(coche2);
			grupo.añadirVehiculo(coche3);
			grupo.añadirVehiculo(coche4);
			grupo.añadirVehiculo(camion1);
			grupo.añadirVehiculo(camion2);
			grupo.añadirVehiculo(camion3);
			grupo.añadirVehiculo(camion4);	
			
			//Añadir empleados
			depInformatica.añadirEmpleado(emIn1);
			depInformatica.añadirEmpleado(emIn2);
			depInformatica.añadirEmpleado(emIn3);
			depVentas.añadirEmpleado(emVe1);
			depVentas.añadirEmpleado(emVe2);
			depVentas.añadirEmpleado(emVe3);
			depGestion.añadirEmpleado(emGe1);
			depGestion.añadirEmpleado(emGe2);
			depGestion.añadirEmpleado(emGe3);

			//añadir departamentos
			innova4b.añadirDepartamento(depInformatica);
			innova4b.añadirDepartamento(depVentas);
			innova4b.añadirDepartamento(depGestion);
			asolif.añadirDepartamento(depInformaticaASOLIF);
			asolif.añadirDepartamento(depVentasASOLIF);
			asolif.añadirDepartamento(depGestionASOLIF);
			innoBasque.añadirDepartamento(depInformaticaBASQUE);
			innoBasque.añadirDepartamento(depVentasBASQUE);
			innoBasque.añadirDepartamento(depGestionBASQUE);

			//añadir empresas
			grupo.añadirEmpresa(innova4b);
			grupo.añadirEmpresa(innoBasque);
			grupo.añadirEmpresa(asolif);

			//añadir el grupo creado a la estructura de datos
			listaGrupos.add(grupo);
			
			//guardar la la estructura en la Base de Datos
			bd.setListaGrupos(listaGrupos);
			
			//Guardar los datos 
			this.guardarBD();
			
	    }
	       
	}
    
    
    // ------------- GETTER Y SETTER ---------------------------
    //----------------------------------------------------------
	public DB getBd() {
		return bd;
	} 
    
}