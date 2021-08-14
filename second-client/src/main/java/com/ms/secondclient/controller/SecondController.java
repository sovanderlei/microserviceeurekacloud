package com.ms.secondclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
public class SecondController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/second/{price}")
	public String invokePaymentService(@PathVariable int price) {
		String url = "http://FIRST-CLIENT/first/" + price;
		String retorn = template.getForObject(url, String.class, Double.class, price);
		return "valor: "+retorn;
	}
	
}
