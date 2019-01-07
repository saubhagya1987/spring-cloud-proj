/**
 * 
 */
package com.nky.employee.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Narendra.Kumar
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeProducerStartup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeProducerStartup.class, args);
	}

}
