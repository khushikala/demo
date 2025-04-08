package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("employee_id"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setEmail(rs.getString("email"));
		employee.setPhone(rs.getString("phone"));
		employee.setJobtitle(rs.getString("job_title")); 
		employee.setSex(rs.getString("sex"));
		employee.setCountry(rs.getString("country"));
		employee.setFirstAttempt(rs.getBoolean("firstAttempt"));
		
		return employee;
	}

}
