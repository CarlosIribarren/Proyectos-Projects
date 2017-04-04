package es.eurohelp.springjdbc.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.eurohelp.springjdbc.config.AppConfiguration;
import es.eurohelp.springjdbc.dao.QueryWithRowCallbackHandlerDAO;

public class QueryWithRowCallbackHandler_Test {
 
    
    public static void main(String[] args) throws SQLException {
 
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
 
        QueryWithRowCallbackHandlerDAO dao = context.getBean(QueryWithRowCallbackHandlerDAO.class);
 
        dao.queryEmployee();
        
        ((ConfigurableApplicationContext)context).close();
    }
    
}