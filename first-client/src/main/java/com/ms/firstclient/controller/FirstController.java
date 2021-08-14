package com.ms.firstclient.controller;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class FirstController {

	@RequestMapping("/first/{temp}")
	public Double firstReturn(@PathVariable Double temp) {
		Double returnvalue = (temp * 9/5)+32;
		return returnvalue;
	}
	
	
	
}
