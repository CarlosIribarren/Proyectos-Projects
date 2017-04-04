package es.eurohelp.springjdbc.demo;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.eurohelp.springjdbc.config.AppConfiguration;
import es.eurohelp.springjdbc.dao.QueryForObjectDAO;
import es.eurohelp.springjdbc.model.Department;
 
public class QueryForObject_Test {
 
    public static void main(String[] args) throws SQLException {
 
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
 
        QueryForObjectDAO dao = context.getBean(QueryForObjectDAO.class);
 
        System.out.println(" ------------- ");
        Department dept = dao.getDepartment("D20");
 
        if (dept != null) {
            System.out.println("DeptNo: " + dept.getDeptNo() + " - DeptName: " + dept.getDeptName());
        } else {
            System.out.println("Department not found!");
        }
        System.out.println(" ------------- ");
 
        String deptName = dao.getDeptNameById(30L);
        System.out.println("Dept Name by Id 30: " + deptName);
 
        System.out.println(" ------------- ");
 
        Date hireDate = dao.getEmpHireDateById(7839L);
        System.out.println("HireDate by EmpId 7839: " + hireDate);
        
        ((ConfigurableApplicationContext)context).close();
 
    }
 
}