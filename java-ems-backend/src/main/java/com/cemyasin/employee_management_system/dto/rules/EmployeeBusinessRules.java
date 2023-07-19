package com.cemyasin.employee_management_system.dto.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemyasin.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeBusinessRules {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void checkIfEmployeeEmailIdExists(String email) throws Exception {
		if(this.employeeRepository.existsByEmail(email)) {
			throw new Exception();
		}
	}
	
}
