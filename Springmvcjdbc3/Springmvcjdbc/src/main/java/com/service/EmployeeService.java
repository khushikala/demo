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

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
		
	}

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.addEmployee(employee);
		
	}

	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findeEmployeeById(id);
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(id);
	}
}
