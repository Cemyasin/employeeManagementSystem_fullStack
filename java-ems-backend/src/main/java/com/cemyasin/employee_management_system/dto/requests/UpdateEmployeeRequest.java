package com.cemyasin.employee_management_system.dto.requests;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;

public class UpdateEmployeeRequest {

	@NotFound
	@NotBlank
	private long id;
	
	@NotFound
	@NotBlank
	private String firstName;

	@NotFound
	@NotBlank
	private String lastName;

	@NotFound
	@NotBlank
	@Size(min=5)
	private String email;

	public UpdateEmployeeRequest() {
	}

	public UpdateEmployeeRequest(@NotBlank long id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String email) {
		this.setId(id);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
