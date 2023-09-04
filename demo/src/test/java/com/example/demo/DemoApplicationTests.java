package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.CumtomerRepository;
import com.example.demo.customer.Customer;

@SpringBootTest
class DemoApplicationTests {

	
	@Autowired
	CumtomerRepository customerRepo;
	
	@Test
	void findbyname() {
		List<Customer> list = customerRepo.findByName("이순신");
		System.out.println(list);
		assertEquals("이순신", list.get(0).getName());
	}
	
	//@Test
	void findall() {
		Iterable<Customer> list= customerRepo.findAll();

		Iterator<Customer>iter= list.iterator();
		
		while(list.iterator().hasNext()){
			Customer cust= iter.next();
			System.out.println(cust.getName());
		}
	}
	
	
	
	//@Test
	void save() {
		Customer cust =new Customer();
		cust.setName("이순신");
		cust.setPhone("010-1111");
		Customer result=customerRepo.save(cust);
		assertEquals(cust.getName(), result.getName());
	}

}
