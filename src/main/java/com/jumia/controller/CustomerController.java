package com.jumia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.model.Customer;
import com.jumia.service.CustomerService;

@RestController

public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/customers")
	public List<Customer> list() {
		return service.getAll();
	}
}
