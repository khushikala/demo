package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.model.Employee;

@Service
public class EmployeeService {
     
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}

	
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}


	public Employee findEmployeeById(int id) {
		return employeeDao.findeEmployeeById(id);
		
	}


	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}


	

}
