package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public interface AbcDao extends JpaRepository<Employee, Integer> {

			
	
}
