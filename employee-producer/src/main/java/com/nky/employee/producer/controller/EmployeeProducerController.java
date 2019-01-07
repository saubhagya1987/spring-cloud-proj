/**
 * 
 */
package com.nky.employee.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nky.employee.producer.model.Employee;

/**
 * @author Narendra.Kumar
 *
 */
@RestController
public class EmployeeProducerController {
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("Narendra");
		emp.setDesignation("Project Leader");
		emp.setEmpId("6985");
		emp.setSalary(300000);

		return emp;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public String sayHello() {
		return "Swagger Hello World";
	}
}
