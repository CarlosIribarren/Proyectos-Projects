package es.eurohelp.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import es.eurohelp.springjdbc.model.Department;
 

@Repository
public class QueryWithRowMapperDAO extends JdbcDaoSupport {

   @Autowired
   public QueryWithRowMapperDAO(DataSource dataSource) {
       this.setDataSource(dataSource);
   }

   private static final String BASE_SQL = //
           "Select d.Dept_Id, d.Dept_No, d.Dept_Name from Department d ";

   class DepartmentRowMapper implements RowMapper<Department> {

       //@Override
       public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
           Long deptId = rs.getLong("Dept_Id");
           String deptNo = rs.getString("Dept_No");
           String deptName = rs.getString("Dept_Name");
           return new Department(deptId, deptNo, deptName);
       }
       
   }

   public List<Department> queryDepartment() {
       String sql = BASE_SQL //
               + " Where d.Dept_Id > ? ";

       DepartmentRowMapper rowMapper = new DepartmentRowMapper();
       Object[] args = new Object[] { 20 };

       List<Department> list = this.getJdbcTemplate().query(sql, args, rowMapper);
       return list;
   }

}
