package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value= {"/","/list"},method = RequestMethod.GET)
	public ModelAndView getAllEmployees() {
		System.out.println("controller");
		ModelAndView model=new ModelAndView();
		List<Employee> list = employeeService.getAllEmployees();
		
		model.addObject("employee_list",list);
		model.setViewName("employee_list");
		return model;
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		ModelAndView modelAndView = new ModelAndView();

		Employee employee = new Employee();
		modelAndView.addObject("employeeForm", employee);

		modelAndView.setViewName("employee_form");
		return modelAndView;
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("employeeForm") Employee employee) {
		if (employee.getEmployeeId() != null) {
			employeeService.updateEmployee(employee);
		} else {
			employeeService.addEmployee(employee);
		}

		return new ModelAndView("redirect:/employee/list");
	}
	

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable int id) {
		ModelAndView model = new ModelAndView();

		Employee employee = employeeService.findEmployeeById(id);
		model.addObject("employeeForm", employee);

		model.setViewName("employee_form");
		return model;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);

		return new ModelAndView("redirect:/employee/list");
	}
	
	
	
	
}
