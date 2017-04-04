package es.eurohelp.springjdbc.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.eurohelp.springjdbc.config.AppConfiguration;
import es.eurohelp.springjdbc.dao.QueryForListReturnListDAO;

public class QueryForListReturnList_Test {
	 
    public static void main(String[] args) throws SQLException {
 
    	//iniciar la configuracion con la base de datos
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
 
        //cargar la clase que tiene las consultas que necesitamos
        QueryForListReturnListDAO dao = context.getBean(QueryForListReturnListDAO.class);
 
        //cargar el resultado que devuelve
        List<String> names = dao.getDeptNames("A");
 
        for (String name : names) {
 
            System.out.println("Dept Name: " + name);
        }
        
        //Devuelve variable string con el valor que contenga A en el nombre del departamento
        
        //Dept Name: ACCOUNTING
        //Dept Name: RESEARCH
        //Dept Name: SALES
        //Dept Name: OPERATIONS
     
        ((ConfigurableApplicationContext)context).close();
    }
 
}