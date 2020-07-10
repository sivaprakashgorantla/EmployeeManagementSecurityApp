package com.gorantla.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gorantla.employee.dao.EmployeeDAO;
import com.gorantla.employee.entities.Employee;
import java.util.Optional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(employee);
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeDAO.findAll();
	}

	public  Optional<Employee>  getEmployeeByNo(Integer eno) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(eno);
	}
	
	public void deleteEmployee(Employee emp) {
		employeeDAO.delete(emp);
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stubretur
		return employeeDAO.save(employee);
		
	}
	
}
