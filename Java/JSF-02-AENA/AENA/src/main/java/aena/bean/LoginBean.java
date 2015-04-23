package aena.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import aena.model.Empleado;
import aena.service.EmpleadoService;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = -3442131060366331401L;

	EmpleadoService empleadoService = new EmpleadoService();
    
    private String user;
    private String pass;
    
    public LoginBean(){}

    public String login() {  
    	
    	String respuesta = null;
    	
    	//verificar que los datos estan introducidos
    	if(user!=null && pass!=null)
    	{
    		//buscar el empleado
	        Empleado empleado = empleadoService.obtenerEmpleado(user, pass);
	        
	        if( empleado!=null ) {  
	        	//ENTRAR AL SISTEMA
	        	respuesta = "pantallaPrincipal";
	        } else {  
	        	//ERROR
	        	//para que se kede en la pantalla de login
	        	respuesta = null;  
	        }
    	}
    	//devolver respuesta
    	return respuesta;
    }  
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    

    
        
    
    
    
}
