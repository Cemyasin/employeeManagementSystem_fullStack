package com.cemyasin.employee_management_system.dto.requests;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateEmployeeRequest {

	
	@NotBlank
	private String firstName;

	
	@NotBlank
	private String lastName;

	
	@NotBlank
	@Size(min=5)
	private String email;

	public CreateEmployeeRequest() {
	}

	public CreateEmployeeRequest(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
