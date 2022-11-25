package com.SoftSages.Employee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.SoftSages.Employee.Dao.EmployeeDao;

@SpringBootApplication
@EnableScheduling
public class SoftSagesEmployeeCrudApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(SoftSagesEmployeeCrudApplication.class);

	@Autowired
	private EmployeeDao employeeDao;

	public static void main(String[] args) {
		SpringApplication.run(SoftSagesEmployeeCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Create table Processing Started ");
		this.employeeDao.createTable();
		logger.info("Create table Successfully Done!!");

	}
	 
}
