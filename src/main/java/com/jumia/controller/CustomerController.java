package com.jumia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.model.Customer;
import com.jumia.service.CustomerService;

@RestController

public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public List<Customer> list(@RequestParam int page, @RequestParam int numPerPage) {
		System.out.println(page);
		System.out.println(numPerPage);
		return service.getAll();
	}
}
