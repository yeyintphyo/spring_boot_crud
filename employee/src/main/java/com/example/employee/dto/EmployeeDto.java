package com.example.employee.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long employeeId;
    @NotEmpty
    @Size(min=5, max=30)
	private String employeeName;
    @Size(max=100)
	private String address;
    @NotEmpty
	private String gender;
    @Size(max=250)
	private String remark;
    @NotEmpty
    @Email
	private String email;
    @Pattern(regexp="(^$|[0-9]{10})")
	private String phone;
    private String role;
    private String password;
	
	public EmployeeDto() {
	}

	public EmployeeDto(Long employeeId, String employeeName, String address, String gender, String remark, String email, String phone) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
		this.gender = gender;
		this.remark = remark;
		this.email = email;
		this.phone = phone;
	}
	
	public EmployeeDto(Long employeeId, String employeeName, String address, String gender, String remark, String email, String phone, String role, String password) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
		this.gender = gender;
		this.remark = remark;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.password = password;
	}	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
