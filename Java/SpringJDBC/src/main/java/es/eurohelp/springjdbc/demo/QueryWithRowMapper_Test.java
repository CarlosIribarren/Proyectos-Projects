package es.eurohelp.springjdbc.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.eurohelp.springjdbc.config.AppConfiguration;
import es.eurohelp.springjdbc.dao.QueryWithRowMapperDAO;
import es.eurohelp.springjdbc.model.Department;

public class QueryWithRowMapper_Test {
 
    
    public static void main(String[] args) throws SQLException {
 
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
 
        QueryWithRowMapperDAO dao = context.getBean(QueryWithRowMapperDAO.class);
 
        List<Department> list = dao.queryDepartment() ;
        
        for(Department dept: list)  {
            System.out.println("DeptNo: "+ dept.getDeptNo()+" - DeptName: "+ dept.getDeptName());
        }
        
        //DeptNo: D30 - DeptName: SALES
        //DeptNo: D40 - DeptName: OPERATIONS
        //DeptNo: D41 - DeptName: HR
        //DeptNo: D42 - DeptName: INV
        
        ((ConfigurableApplicationContext)context).close();
    }
    
}
