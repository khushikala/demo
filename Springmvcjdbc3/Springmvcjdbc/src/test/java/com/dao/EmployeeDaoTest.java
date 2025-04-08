package com.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.Employee;
@ExtendWith(MockitoExtension.class)
public class EmployeeDaoTest {

	
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private EmployeeDao employeeDao;
	
	public void testGetAllEmployee_Success() {
		when(jdbcTemplate.query(any(String.class),any(RowMapper.class))).thenReturn(null);
		List <Employee> list =employeeDao.getAllEmployees();
		assertEquals(null, list);
		
		
	}
	

}
