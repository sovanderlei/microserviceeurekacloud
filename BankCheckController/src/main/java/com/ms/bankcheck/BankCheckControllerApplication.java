package com.ms.bankcheck;

/**class Microservice  to demonstrate how to merge images and work with QRCode.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ms.bankcheck.controller.CheckBkController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableEurekaClient
public class BankCheckControllerApplication {

	private static final Logger loggers = LoggerFactory.getLogger(BankCheckControllerApplication.class);
	
	
	public static void main(String[] args) {
		 
		loggers.info("System Start"); 
		SpringApplication.run(BankCheckControllerApplication.class, args);
		
		CheckBkController checkbk = new CheckBkController(loggers, args);
		checkbk.MonitoringOriginFolder();
		
	}

}
