package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.CumtomerRepository;
import com.example.demo.customer.Customer;

@RestController
public class HomeController {
	
	@Autowired
	CumtomerRepository repo;
	
	@GetMapping("/")
	public String greet() {
		return "hello";
	}

	@GetMapping("/cust")
	public Iterator<Customer> cust(){
		return  repo.findAll().iterator();
	}
}
