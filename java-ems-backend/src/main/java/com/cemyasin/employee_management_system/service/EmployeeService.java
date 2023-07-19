package com.cemyasin.employee_management_system.service;

import java.util.List;

import com.cemyasin.employee_management_system.dto.requests.UpdateEmployeeRequest;
import com.cemyasin.employee_management_system.dto.requests.CreateEmployeeRequest;
import com.cemyasin.employee_management_system.dto.response.GetAllEmployeesResponse;
import com.cemyasin.employee_management_system.dto.response.GetByIdEmployeeResponse;



public interface EmployeeService {

	List<GetAllEmployeesResponse> getAll();
	void add(CreateEmployeeRequest createBrandRequest) throws Exception;
	void update(UpdateEmployeeRequest updateBrandRequest);
	void delete(long id);
	GetByIdEmployeeResponse getById(long id);
}
