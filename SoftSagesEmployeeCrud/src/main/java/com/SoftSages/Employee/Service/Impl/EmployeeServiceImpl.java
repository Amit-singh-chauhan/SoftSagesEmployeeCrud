package com.SoftSages.Employee.Service.Impl;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;

import com.SoftSages.Employee.Dao.EmployeeDao;
import com.SoftSages.Employee.Model.Employee;
import com.SoftSages.Employee.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;

	// Add Employee and update Employee
	@Override
	public void addorUpdateEmployee(Employee employee) {
		if (isNull(employee.getEmployeeId())) {
			employeeDao.saveEmployee(employee);
		} else {
			employeeDao.updateEmployee(employee);
		}

	}

	// Fetch All Employee
	@Override
	public List<Employee> findAllEmployee() {
		return employeeDao.findAllEmployee();
	}

	// Fetch Employee By Employee ID
	@Override
	public Employee findByEmployeeId(Long employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}

	// Delete Employee By Employee ID
	@Override
	public int deleteByEmployeeId(Long employeeId) {
		return employeeDao.deleteByEmployeeId(employeeId);
	}

	// Every 2 minutes Employee code change Method
	@Scheduled(fixedRateString = "#{2 * 60000}")
	public void ChangeEmployeeCode() {

		logger.info("Every 2 Minutes Update All Employee Code");
		List<Employee> emp = employeeDao.findAllEmployee();

		for (Employee employee : emp) {

			int length = employee.getEmployeeCode().length();
			String employeeCode = String.valueOf(OTP(length));
			employee.setEmployeeCode(employeeCode);
			employeeDao.updateEmployeeCode(employee);
		}

	}

	static char[] OTP(int len) {
		// Using numeric values
		String numbers = "0123456789";

		// Using random method
		Random rndm_method = new Random();

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {

			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

}
