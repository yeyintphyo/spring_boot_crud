package com.example.employee.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.UserDto;
import com.example.employee.service.EmployeeService;


@Controller
public class EmployeeController {

	
	private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
    @RequestMapping(value = "signup")
    public String addStudent(Model model){
    	model.addAttribute("userDto", new UserDto());
        return "signup";
    }	
	
    @RequestMapping(value = "add")
    public String empRegistration(Model model){
    	List<String> gender = new ArrayList<>();
    	gender.add("Male");
    	gender.add("Female");
    	model.addAttribute("employeeDto", new EmployeeDto());
    	model.addAttribute("gender",gender);
        return "employeeRegistration";
    }	
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(EmployeeDto empDto, BindingResult bindingResult){
    	if (!bindingResult.hasErrors()) {
            try {
    	    	if (employeeService.findByEmpName(empDto.getEmployeeName()) == null) {
    	    		employeeService.addEmployee(empDto);
    	    	}
    	    	else {
        			bindingResult.rejectValue("username", "error.userexists", "Username already exists");    	
        			return "signup";		    		
    	    	}        	
    		} catch (Exception e) {
    			e.printStackTrace();
    		}    		
    	} else {
    		return "add";
    	}
    	return "redirect:/employeeList";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model){
    	try {
			model.addAttribute("employeeDto", employeeService.findByEmpId(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "updateEmployee";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(EmployeeDto empDto, BindingResult bindingResult){
    	if (!bindingResult.hasErrors()) {
            try {
    			employeeService.updateEmployee(empDto);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}    		
    	} else {
    		return "/edit/"+empDto.getEmployeeId();
    	}

    	return "redirect:/employeeList";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long empId, Model model) {
    	try {
			employeeService.deleteEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:/employeeList";
    }      
        
    /**
     * List all employee.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/employeeList")
    public String list(Model model) {
        try { 
        	List<EmployeeDto> employeeList = employeeService.getEmployeeList();
			model.addAttribute("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "employeeList";
    }
    
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) throws Exception {
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (userDto.getPassword().equals(userDto.getPasswordCheck())) { // check password match		
	    		String pwd = userDto.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
		    	userDto.setPassword(hashPwd);
		    	userDto.setRole("USER");
		    	if (employeeService.findByEmpName(userDto.getUsername()) == null) {
		    		employeeService.singUpEmployee(userDto);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "error.userexists", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "error.pwdmatch", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    } 
}
