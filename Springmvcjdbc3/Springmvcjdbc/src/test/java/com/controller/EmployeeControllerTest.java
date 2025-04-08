package com.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Employee;
import com.service.EmployeeService;

import ch.qos.logback.core.status.Status;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	
	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	private MockMvc mockMvc;
    
	@BeforeEach
	public void init() {
		 mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void testGetAllEmployees() throws Exception {
		
		when(employeeService.getAllEmployees()).thenReturn(null);
		
		mockMvc.perform(get("/employee/")).andExpect(status().isOk());
		
		mockMvc.perform(post("/employee/").content(getJsonOfMyObject())).andExpect(status().isOk());
		
		
	}
	
	private String getJsonOfMyObject() throws JsonProcessingException{
		Employee emp = new Employee();
		emp.setEmail("");
		emp.setFirstName("dsd");
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(emp);
	}

}
