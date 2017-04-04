package es.eurohelp.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class QueryWithRowCallbackHandlerDAO extends JdbcDaoSupport {
 
    @Autowired
    public QueryWithRowCallbackHandlerDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    public void queryEmployee() {
        String sql = "Select e.Emp_Id, e.Emp_No, e.Emp_Name,e.Salary from Employee e "//
                + " Where e.Salary > ? ";
 
        RowCallbackHandler handler = new RowCallbackHandler() {
 
            //@Override
            public void processRow(ResultSet rs) throws SQLException {
                Long empId = rs.getLong("Emp_Id");
                String empNo = rs.getString(2);
                System.out.println(" ---------------- ");
                System.out.println("EmpId:" + empId);
                System.out.println("EmpNo:" + empNo);
            }
            
            //------
            //EmpId:7839
            //EmpNo:E7839
            //------
            //EmpId:7566
            //EmpNo:E7566
            //------
 
 
        };
        // query(String sql, RowCallbackHandler rch, Object... args)
        this.getJdbcTemplate().query(sql, handler, 2800);
    }
 
}