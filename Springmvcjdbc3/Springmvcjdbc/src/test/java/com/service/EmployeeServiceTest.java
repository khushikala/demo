package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dao.EmployeeDao;
import com.model.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeDao employeeDao;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Test
	public void testGetAllEmployees_IfCheckSuccess() {
		
	when(employeeDao.getAllEmployees()).thenReturn(null);
	List<Employee> list =	employeeService.getAllEmployees();
	 assertEquals(null, list);
	}

}


//	@Test
//	public void testGetAllEmployees_IfCheckFail() {
		
//	when(employeeDao.getAllEmployees()).thenReturn(new Arraylist<>());
//	List<Employee> list =	employeeService.getAllEmployees();
//	 assertEquals(new Arraylist<>(), list);
//	}
//}
