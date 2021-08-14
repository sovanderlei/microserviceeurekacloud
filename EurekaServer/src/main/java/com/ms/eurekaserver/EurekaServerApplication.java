package com.ms.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**class Microservice  Eureka Server controller the servers.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/

@SpringBootApplication
@EnableEurekaServer 
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
