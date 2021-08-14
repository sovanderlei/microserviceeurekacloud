package com.ms.firstclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**class Microservice  client of server.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/

@SpringBootApplication
@EnableEurekaClient
public class FirstClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstClientApplication.class, args);
	}

}
