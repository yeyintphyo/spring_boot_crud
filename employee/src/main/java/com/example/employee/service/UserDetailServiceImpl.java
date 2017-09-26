package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UserDto;
import com.example.employee.entity.Employee;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final EmployeeDao empDao;
	
	@Autowired
	public UserDetailServiceImpl(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = null;
		try {
			EmployeeDto curruser = empDao.findByUserName(username);
	        user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(), true, 
	        		true, true, true, AuthorityUtils.createAuthorityList(curruser.getRole()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return user;
	}

}
