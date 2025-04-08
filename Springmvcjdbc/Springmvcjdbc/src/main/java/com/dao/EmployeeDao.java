package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Employee;
import com.model.EmployeeRowMapper;

@Repository
public class EmployeeDao {
       
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  
	  public List<Employee> getAllEmployees(){
		  String query = "SELECT * from employees";
		  RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		  List<Employee> list =jdbcTemplate.query(query, rowMapper);
		  return list;
	  }


	  public void updateEmployee(Employee employee) {
			String query = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, job_title=? WHERE employee_id=?";
			jdbcTemplate.update(query, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
					employee.getPhone(), employee.getJobTitle(), employee.getEmployeeId());

		}
	  
	  public void addEmployee(Employee employee) {
			String query = "INSERT INTO employees(employee_id, first_name, last_name, email, phone, job_title) VALUES(?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(query, employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
					employee.getEmail(), employee.getPhone(), employee.getJobTitle());

		}


	public Employee findeEmployeeById(int id) {
		String query = "SELECT * FROM employees WHERE employee_id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(query, rowMapper, id);

		return employee;
	}


	public void deleteEmployee(int id) {
		String query = "DELETE FROM employees WHERE employee_id=?";
		jdbcTemplate.update(query, id);
	}


	
	  
}
