package com.SoftSages.Employee.Service;

import java.util.List;

import com.SoftSages.Employee.Model.Employee;

public interface EmployeeService {

	void addorUpdateEmployee(Employee employee) ;

	List<Employee> findAllEmployee();

	Employee findByEmployeeId(Long employeeId) ;

	int deleteByEmployeeId(Long employeeId) ;

}
