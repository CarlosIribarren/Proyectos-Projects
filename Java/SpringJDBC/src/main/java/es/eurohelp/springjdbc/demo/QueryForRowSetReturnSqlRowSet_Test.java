package es.eurohelp.springjdbc.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import es.eurohelp.springjdbc.config.AppConfiguration;
import es.eurohelp.springjdbc.dao.QueryForRowSetReturnSqlRowSetDAO;

public class QueryForRowSetReturnSqlRowSet_Test {
	 
    public static void main(String[] args) throws SQLException {
 
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
 
        QueryForRowSetReturnSqlRowSetDAO dao = context.getBean(QueryForRowSetReturnSqlRowSetDAO.class);
 
        // SqlRowSet
        SqlRowSet rowSet = dao.queryForRowSet_SqlRowSet();
 
        while (rowSet.next()) {
            
            System.out.println("-----");
            Long empId = rowSet.getLong("Emp_Id"); // Index = 1
            String empNo = rowSet.getString(2); // Index = 2
            String empName = rowSet.getString("Emp_Name"); // Index = 3
 
            System.out.println("EmpID: " + empId + ", EmpNo: " + empNo + ", EmpName:" + empName);
        }
        
        //Devuelve Row con los campos solicitados
        
        //-----
        //EmpID: 7839, EmpNo: E7839, EmpName:KING
        //-----
        //EmpID: 7566. EmpNo: E7566. EmpName:JONES
        //-----
        //EmpID: 7902, EmpNo: E7902, EmpName:FORD
        //-----
        //EmpID: 7698, EmpNo: E7698, EmpName:BLAKE
        
        ((ConfigurableApplicationContext)context).close();
 
    }
    
}
