package com.example.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UserDto;
import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeExample;
import com.example.employee.mapper.EmployeeMapper;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<EmployeeDto> getEmployeeList() throws Exception {
		List<EmployeeDto> empDtoList = null;
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andEmployeeIdIsNotNull();
		List<Employee> empList = employeeMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(empList)) {
			empDtoList = new ArrayList<>();
			for (Employee emp : empList) {
				empDtoList.add(convertDto(emp));
			}			
		}
		return empDtoList;
	}	

	public int addEmployee(EmployeeDto empDto) throws Exception {
		Employee emp = convertEntity(empDto);
		return employeeMapper.insert(emp);
	}

	public int updateEmployee(EmployeeDto empDto) throws Exception {
		Employee emp = convertEntity(empDto);
		return employeeMapper.updateByPrimaryKey(emp);
	}

	public EmployeeDto findByEmpId(long employeeId) throws Exception {
		EmployeeDto empDto = convertDto(employeeMapper.selectByPrimaryKey(employeeId));
		return empDto;
	}

	public int deleteEmployee(long id) throws Exception {
		return employeeMapper.deleteByPrimaryKey(id);
	}
	
	public int singUpEmployee(UserDto userDto) throws Exception {
		Employee emp = new Employee();
		emp.setEmployeeName(userDto.getUsername());
		emp.setPassword(userDto.getPassword());
		emp.setRole(userDto.getRole());
		return employeeMapper.insert(emp);
	}

	public EmployeeDto findByEmpName(String name) throws Exception {
		EmployeeDto empDto = null;
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andEmployeeNameEqualTo(name);
		List<Employee> empList = employeeMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(empList)) {
			empDto = convertDto(empList.get(0));
		}
		return empDto;
	}
	
	private EmployeeDto convertDto(Employee emp) {
		EmployeeDto empDto = new EmployeeDto(emp.getEmployeeId(),emp.getEmployeeName(), emp.getAddress(), emp.getGender(), emp.getRemark(), emp.getEmail(), emp.getPhone(), emp.getRole(), emp.getPassword());
		return empDto;
	}
	
	private Employee convertEntity(EmployeeDto empDto){
		Employee emp = new Employee();
		emp.setEmployeeName(empDto.getEmployeeName());
		emp.setEmail(empDto.getEmail());
		emp.setGender(empDto.getGender());
		emp.setPhone(empDto.getPhone());
		emp.setRemark(empDto.getRemark());
		emp.setAddress(empDto.getAddress());
		return emp;
	}

	public EmployeeDto findByUserName(String name) throws Exception {
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andEmployeeNameEqualTo(name);
		List<Employee> empList = employeeMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(empList)) {
			return convertDto(empList.get(0));
		}
		return null;
	}

}
