package es.eurohelp.springjdbc.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.eurohelp.springjdbc.config.AppConfiguration;
import es.eurohelp.springjdbc.dao.QueryForListReturnListMapDAO;

public class QueryForListReturnListMap_Test {
	 
    public static void main(String[] args) throws SQLException {
 
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
 
        QueryForListReturnListMapDAO dao = context.getBean(QueryForListReturnListMapDAO.class);
 
        // Map<String columnName, Object value)
        List<Map<String, Object>> list = dao.queryForList_ListMap2();
 
        for (Map<String, Object> map : list) {
            System.out.println("-----");
            for (String key : map.keySet()) {
                System.out.println("Key: " + key + " - value: " + map.get(key));
            }
        }
        
        //Devuelve Map con (clave, valor) de los campos solicitados
        
        //------
        //Key: EMP_ID - value: 7839
        //Key: EMP_NO - value: E7839
        //Key: EMP_NAME - value: KING
        //------
        //Key: EMP_ID - value: 7566
        //Key: EMP_NO - value: E7566
        //Key: EMP_NAME - value:JONES
        //--------
        
        ((ConfigurableApplicationContext)context).close();
    }
 
}