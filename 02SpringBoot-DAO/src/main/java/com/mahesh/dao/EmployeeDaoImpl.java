package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mahesh.model.Employee;
import com.mahesh.queries.EmployeeQueries;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Employee employee) {
		jdbcTemplate.update(EmployeeQueries.INSERT_QUERY,
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsalary(), employee.getEmail() });
	}

	@Override
	public void delete(Integer eid) {
		jdbcTemplate.update(EmployeeQueries.DELETE_BY_ID, new Object[] { eid });

	}

	@Override
	public void updateEmp(Employee employee) {
		jdbcTemplate.update(EmployeeQueries.UPDATE,
				new Object[] { employee.getEname(), employee.getEsalary(), employee.getEmail(), employee.getEid() });
	}

	@Override
	public Employee findById(Integer eid) {
		return (Employee) jdbcTemplate.queryForObject(EmployeeQueries.FIND_BY_ID, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEid(rs.getInt(1));
				employee.setEname(rs.getString(2));
				employee.setEsalary(rs.getDouble(3));
				employee.setEmail(rs.getString(4));
				return employee;
			}
		}, new Object[] { eid });

	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query(EmployeeQueries.FIND_ALL, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEid(rs.getInt(1));
				employee.setEname(rs.getString(2));
				employee.setEsalary(rs.getDouble(3));
				employee.setEmail(rs.getString(4));
				return employee;
			}
		});
	}

}
