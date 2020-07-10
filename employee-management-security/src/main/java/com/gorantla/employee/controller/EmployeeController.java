package com.gorantla.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import com.gorantla.employee.entities.Employee;
import com.gorantla.employee.exception.ResourceNotFoundException;
import com.gorantla.employee.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/emp/")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@PostMapping(value = "/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		logger.debug("createEmployee.............. started");
		System.out.println("createEmployee..................................." + employee);
		return employeeService.createEmployee(employee);
		// logger.debug("createEmployee ............. ended");
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println(
				"get Employees........................................." + employeeService.getEmployees().size());
		for (Employee e : employeeService.getEmployees()) {
			System.out.println(e);
		}
		return employeeService.getEmployees();
	}

	@RequestMapping(value = "/")
	public String sayHello() {
		return "sayHello from Spring boot ";
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeByNo(@PathVariable(value = "eno") Integer eno)
			throws ResourceNotFoundException {
		System.out.println("Get employee by no " + eno);
		Optional < Employee > optional = Optional.ofNullable(employeeService.getEmployeeByNo(eno))
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + eno));
		if (optional.isPresent()) {
            System.out.println("Persists : "+optional.get());
            System.out.println("Get employee by id " + optional.get());   
        }
		return ResponseEntity.ok().body(optional.get());
	}

	@DeleteMapping("/deleteEmployee/{eno}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "eno") Integer eno) throws ResourceNotFoundException {
		
		System.out.println("deleteEmployee " + eno);
		Optional < Employee > optional =  Optional.ofNullable(employeeService.getEmployeeByNo(eno)).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found for this id :: " + eno));

		if (optional.isPresent()) {
            System.out.println("Persists : "+optional.get());
            employeeService.deleteEmployee(optional.get());
        } else {
            System.out.printf("No employee found with id %d%n", eno);
        }
		
		System.out.println("deleted  Employee---------------------------------------" + eno);
		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);

	}

	@PutMapping("/updateEmployee/{eno}/{emailId:.+}")
	public Employee updateEmployee(@PathVariable(value = "eno") Integer eno,@PathVariable(value = "emailId") String emailId) throws ResourceNotFoundException {
		
		System.out.println("updateEmployee " + eno);
		Optional < Employee > optional =  Optional.ofNullable(employeeService.getEmployeeByNo(eno)).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found for this id :: " + eno));
		Employee e = null;
		if (optional.isPresent()) {
            System.out.println("Persists : "+optional.get());
            e = optional.get();
            e.setEmailId(emailId);
            e = employeeService.updateEmployee(optional.get());
        } 
		
		System.out.println("deleted  Employee---------------------------------------" + eno);
		return e;

	}

}
