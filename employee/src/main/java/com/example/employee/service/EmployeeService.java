package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UserDto;

public interface EmployeeService {
	public int addEmployee(EmployeeDto empDto) throws Exception;
	public int updateEmployee(EmployeeDto empDto) throws Exception;
	public int deleteEmployee(long id) throws Exception;
	public EmployeeDto findByEmpId(long id) throws Exception;
	public EmployeeDto findByEmpName(String name) throws Exception;
	public List<EmployeeDto> getEmployeeList () throws Exception;	
	public int singUpEmployee(UserDto empDto) throws Exception;
}
