package com.SoftSages.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SoftSages.Employee.Model.Employee;
import com.SoftSages.Employee.Service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	public static final String ADD_EMPLOYEE_SUCCESS = "Employee added Successfully in the system.";
	public static final String UPDATE_EMPLOYEE_SUCCESS = "Employee updated Successfully in the system.";
	public static final String DELETE_EMPLOYEE_SUCCESS = "Employee Deleted Successfully in the system.";

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add-employee")
	public  ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		 employeeService.addorUpdateEmployee(employee);
		return  new ResponseEntity<String>(ADD_EMPLOYEE_SUCCESS, HttpStatus.OK);
	}

	@PutMapping("/update-employee")
	public  ResponseEntity<String> updateEmployee(@RequestBody Employee employee)  {
		employeeService.addorUpdateEmployee(employee);
		return new ResponseEntity<String>(UPDATE_EMPLOYEE_SUCCESS, HttpStatus.OK);
	}

	@GetMapping("/fetch_All_employees")
	public List<Employee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

	@GetMapping("/fetch_employee_by_Id")
	public Employee findByEmployeeId(@RequestParam Long employeeId)  {
		return employeeService.findByEmployeeId(employeeId);
	}

	@DeleteMapping("/delete_employee_by_Id")
	public ResponseEntity<String> deleteByEmployeeId(@RequestParam Long employeeId)  {
		employeeService.deleteByEmployeeId(employeeId);
		 return new ResponseEntity<String>(DELETE_EMPLOYEE_SUCCESS, HttpStatus.OK);
	}
}