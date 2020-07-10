package com.gorantla.employee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gorantla.employee.entities.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

}
