package com.SoftSages.Employee.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SoftSages.Employee.Model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmployeeDao() {

	}

	public void createTable() {
		String query = "CREATE TABLE IF NOT EXISTS Employee_Data(EMPLOYEE_ID BIGINT(6) PRIMARY KEY NOT NULL AUTO_INCREMENT,EMPLOYEE_NAME varchar(50) NOT NULL,GENDER  ENUM ('MALE','FEMALE','TRANSGENDER') NOT NULL,EMAIL Varchar(30) NOT NULL,EMPLOYEE_CODE varchar(20) NOT NULL,SALARY varchar(20) NOT NULL,DEPARTMENT_NAME varchar(50) NOT NUll )";
		this.jdbcTemplate.update(query);
	}

	public int saveEmployee(Employee e) {
		return jdbcTemplate.update(
				"INSERT INTO  Employee_Data (EMPLOYEE_NAME,GENDER,EMAIL,EMPLOYEE_CODE,SALARY,DEPARTMENT_NAME) VALUES (?, ?, ?,?,?,?)",
				new Object[] { e.getEmployeeName(), e.getGender(), e.getEmail(), e.getEmployeeCode(), e.getSalary(),e.getDepartmentName() });
	}

	public int updateEmployee(Employee e) {
		return jdbcTemplate.update(
				"UPDATE  Employee_Data SET EMPLOYEE_NAME = ?, GENDER = ?, EMAIL = ?,EMPLOYEE_CODE=?,SALARY=?,DEPARTMENT_NAME=? WHERE EMPLOYEE_ID = ?",
				new Object[] { e.getEmployeeName(), e.getGender(), e.getEmail(), e.getEmployeeCode(), e.getSalary(),e.getDepartmentName(),
						e.getEmployeeId() });
	}

	public List<Employee> findAllEmployee() {
		return jdbcTemplate.query("SELECT * FROM Employee_Data", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public Employee findByEmployeeId(Long employeeId) {
		return jdbcTemplate.queryForObject("SELECT * FROM Employee_Data WHERE EMPLOYEE_ID=?",
				new BeanPropertyRowMapper<Employee>(Employee.class), employeeId);
	}

	public int deleteByEmployeeId(Long employeeId) {
		return jdbcTemplate.update("DELETE FROM Employee_Data WHERE EMPLOYEE_ID=?", employeeId);
	}
	
	public int updateEmployeeCode(Employee e) {
		return jdbcTemplate.update(
				"UPDATE  Employee_Data SET EMPLOYEE_CODE=? WHERE EMPLOYEE_ID = ?",
				new Object[] {e.getEmployeeCode(),e.getEmployeeId() });
	}
}
