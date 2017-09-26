package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UserDto;

@Service(value="EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public int addEmployee(EmployeeDto empDto) throws Exception {
		return employeeDao.addEmployee(empDto);
	}

	public int updateEmployee(EmployeeDto empDto) throws Exception {
		return employeeDao.updateEmployee(empDto);
	}

	public EmployeeDto findByEmpId(long id) throws Exception {
		return employeeDao.findByEmpId(id);
	}

	public List<EmployeeDto> getEmployeeList() throws Exception {
		return employeeDao.getEmployeeList();
	}

	public int deleteEmployee(long id) throws Exception {
		return employeeDao.deleteEmployee(id);
	}
	
	public int singUpEmployee(UserDto userDto) throws Exception {
		return employeeDao.singUpEmployee(userDto);
	}

	public EmployeeDto findByEmpName(String name) throws Exception {
		return employeeDao.findByEmpName(name);
	}
}
