package com.cemyasin.employee_management_system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cemyasin.employee_management_system.dto.requests.CreateEmployeeRequest;
import com.cemyasin.employee_management_system.dto.requests.UpdateEmployeeRequest;
import com.cemyasin.employee_management_system.dto.response.GetAllEmployeesResponse;
import com.cemyasin.employee_management_system.dto.response.GetByIdEmployeeResponse;
import com.cemyasin.employee_management_system.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private final EmployeeService employeeService;


	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<GetAllEmployeesResponse> getAllEmployee() {
		return employeeService.getAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateEmployeeRequest employeeRequest) throws Exception {
		this.employeeService.add(employeeRequest);
	}

	@PutMapping
	public void update(@RequestBody UpdateEmployeeRequest employeeRequest) {
		this.employeeService.update(employeeRequest);
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		this.employeeService.delete(id);
	}

	@GetMapping("/{id}")
	public GetByIdEmployeeResponse getById(@PathVariable long id) {
		return this.employeeService.getById(id);
	}
}
