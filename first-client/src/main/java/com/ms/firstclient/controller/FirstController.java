package com.ms.firstclient.controller;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**class Microservice  client of server - endpoint for another microservice to use
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/
@RestController 
public class FirstController {

	/***
	 * endpoint for another microservice to use
	 * @param temp
	 * @return
	 */
	@RequestMapping("/first/{temp}")
	public Double firstReturn(@PathVariable Double temp) {
		Double returnvalue = (temp * 9/5)+32;
		return returnvalue;
	}
	
	
	
}
