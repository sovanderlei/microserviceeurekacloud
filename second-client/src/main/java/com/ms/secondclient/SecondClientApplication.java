package com.ms.secondclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**class Microservice  client of server.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/

@SpringBootApplication
@EnableEurekaClient
public class SecondClientApplication {

	@Bean
	@LoadBalanced 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecondClientApplication.class, args);
	}

}
