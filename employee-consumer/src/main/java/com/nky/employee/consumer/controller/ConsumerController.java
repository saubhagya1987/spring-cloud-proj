/**
 * 
 */
package com.nky.employee.consumer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Narendra.Kumar
 *
 */
@RestController
public class ConsumerController {
	
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public String getEmployee() throws RestClientException, IOException {

/*		String baseUrl = "http://localhost:8080/employee";	*/
		
		//List<ServiceInstance> instances=discoveryClient.getInstances("employee-producer");
		//ServiceInstance serviceInstance=instances.get(0);
		ServiceInstance serviceInstance=loadBalancer.choose("employee-zuul-service");
		
		System.out.println(serviceInstance.getUri());
		
		String baseUrl=serviceInstance.getUri().toString();
	
		baseUrl=baseUrl+"producer/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response.getBody(); 
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<Object>(headers);
	}
}
