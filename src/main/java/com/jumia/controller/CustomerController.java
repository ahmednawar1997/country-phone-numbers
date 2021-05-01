package com.jumia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.entity.FilterObject;
import com.jumia.entity.NavigationObject;
import com.jumia.model.Customer;
import com.jumia.service.CustomerService;

@RestController

public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public List<Customer> list(@RequestParam int page, @RequestParam int numPerPage) {
		NavigationObject navigationObject = new NavigationObject(page, numPerPage);
		FilterObject filterObject = new FilterObject(navigationObject, "name", "country", true);
		
		return service.getAll(filterObject);
	}
}
