package com.cemyasin.employee_management_system.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemyasin.employee_management_system.core.utilities.mappers.ModelMapperService;
import com.cemyasin.employee_management_system.dto.requests.CreateEmployeeRequest;
import com.cemyasin.employee_management_system.dto.requests.UpdateEmployeeRequest;
import com.cemyasin.employee_management_system.dto.response.GetAllEmployeesResponse;
import com.cemyasin.employee_management_system.dto.response.GetByIdEmployeeResponse;
import com.cemyasin.employee_management_system.dto.rules.EmployeeBusinessRules;
import com.cemyasin.employee_management_system.exception.ResourceNotFoundException;
import com.cemyasin.employee_management_system.model.Employee;
import com.cemyasin.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeManager implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService,
			EmployeeBusinessRules employeeBusinessRules) {
		this.employeeRepository = employeeRepository;
		this.modelMapperService = modelMapperService;
		this.employeeBusinessRules = employeeBusinessRules;
	}

	private ModelMapperService modelMapperService;
	private EmployeeBusinessRules employeeBusinessRules;

	@Override
	public List<GetAllEmployeesResponse> getAll() {
		List<Employee> employees = employeeRepository.findAll();

		List<GetAllEmployeesResponse> getAllEmployeesResponses = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeesResponse.class))
				.collect(Collectors.toList());
		return getAllEmployeesResponses;
	}

	@Override
	public void add(CreateEmployeeRequest createBrandRequest) throws Exception {

		this.employeeBusinessRules.checkIfEmployeeEmailIdExists(createBrandRequest.getEmail());
		
		Employee employee=this.modelMapperService.forRequest().map(createBrandRequest, Employee.class);
		this.employeeRepository.save(employee);
	}

	@Override
	public void update(UpdateEmployeeRequest updateBrandRequest) {
		Employee employee=this.modelMapperService.forRequest().map(updateBrandRequest, Employee.class);
		this.employeeRepository.save(employee);
	}

	@Override
	public void delete(long id) {

		this.employeeRepository.deleteById(id);
	}

	@Override
	public GetByIdEmployeeResponse getById(long id) {
		Employee employee=this.employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id :"+id));
		GetByIdEmployeeResponse getByIdEmployeeResponse = this.modelMapperService.forResponse().map(employee, GetByIdEmployeeResponse.class);
		return getByIdEmployeeResponse;
	}

}
