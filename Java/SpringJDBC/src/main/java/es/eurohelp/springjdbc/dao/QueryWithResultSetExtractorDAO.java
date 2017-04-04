package es.eurohelp.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import es.eurohelp.springjdbc.model.Department;

@Repository
public class QueryWithResultSetExtractorDAO extends JdbcDaoSupport {
 
    @Autowired
    public QueryWithResultSetExtractorDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    private static final String BASE_SQL = //
            "Select d.Dept_Id, d.Dept_No, d.Dept_Name from Department d ";
 
    class DepartmentListResultSetExtractor implements ResultSetExtractor<List<Department>> {
 
        //@Override
        public List<Department> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Department> list = new ArrayList<Department>();
            while (rs.next()) {
                Long deptId = rs.getLong("Dept_Id");
                String deptNo = rs.getString("Dept_No");
                String deptName = rs.getString("Dept_Name");
                list.add(new Department(deptId, deptNo, deptName));
            }
            return list;
        }
 
    }
 
    class DepartmentResultSetExtractor implements ResultSetExtractor<Department> {
 
        //@Override
        public Department extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
                Long deptId = rs.getLong("Dept_Id");
                String deptNo = rs.getString("Dept_No");
                String deptName = rs.getString("Dept_Name");
                return new Department(deptId, deptNo, deptName);
            }
            return null;
        }
 
    }
 
    public List<Department> queryDepartments() {
        String sql = BASE_SQL //
                + " Where d.Dept_Id > ? ";
 
        DepartmentListResultSetExtractor rse = new DepartmentListResultSetExtractor();
 
        // <T> T query(String sql, ResultSetExtractor<T> rse, Object... args)
        List<Department> list = this.getJdbcTemplate().query(sql, rse, 40);
        return list;
    }
 
    public Department findDepartment(Long deptId) {
        String sql = BASE_SQL //
                + " Where d.Dept_Id = ? ";
 
        DepartmentResultSetExtractor rse = new DepartmentResultSetExtractor();
 
        // <T> T query(String sql, ResultSetExtractor<T> rse, Object... args)
        Department dept = this.getJdbcTemplate().query(sql, rse, 40);
        return dept;
    }
 
}