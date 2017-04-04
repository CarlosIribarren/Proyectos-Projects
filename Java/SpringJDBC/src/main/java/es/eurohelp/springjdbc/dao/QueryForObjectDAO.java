package es.eurohelp.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import es.eurohelp.springjdbc.model.Department;
 
@Repository
public class QueryForObjectDAO extends JdbcDaoSupport {
 
    @Autowired
    public QueryForObjectDAO(DataSource dataSource) {
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
 
    public Department getDepartment(String deptNo) {
        try {
            String sql = BASE_SQL //
                    + " Where d.Dept_No = ? ";
 
            DepartmentRowMapper rowMapper = new DepartmentRowMapper();
            Object[] args = new Object[] { deptNo };
 
            Department dept = this.getJdbcTemplate().queryForObject(sql, args, rowMapper);
            return dept;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
    public String getDeptNameById(Long deptId) {
        try {
            String sql = "Select d.Dept_Name from Department d "//
                    + " Where d.Dept_Id = ?";
            Object[] args = new Object[] { deptId };
 
            String deptName = this.getJdbcTemplate().queryForObject(sql, String.class, args);
            return deptName;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
    public Date getEmpHireDateById(Long empId) {
        try {
            String sql = "Select e.Hire_Date from Employee e "//
                    + " Where e.Emp_Id = ?";
            Object[] args = new Object[] { empId };
            int[] argTypes = new int[] { Types.BIGINT };
 
            Date hireDate = this.getJdbcTemplate().queryForObject(sql, args, argTypes, Date.class);
            return hireDate;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
}
