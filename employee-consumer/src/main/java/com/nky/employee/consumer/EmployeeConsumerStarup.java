/**
 * 
 */
package com.nky.employee.consumer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.nky.employee.consumer.controller.ConsumerController;

/**
 * @author Narendra.Kumar
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeConsumerStarup {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws RestClientException 
	 */
	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx =SpringApplication.run(EmployeeConsumerStarup.class, args);
		
		//ApplicationContext ctx = SpringApplication.run(EmployeeConsumerStarup.class, args);
		for(int i=0;i<1000;i++) {
		ConsumerController consumerControllerClient=ctx.getBean(ConsumerController.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getEmployee();
		}
		
		


	}
	@Bean
	public  ConsumerController  consumerController()
	{
		return  new ConsumerController();
	}
}
