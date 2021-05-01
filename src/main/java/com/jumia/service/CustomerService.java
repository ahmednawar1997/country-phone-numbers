package com.jumia.service;

import java.util.List;

import com.jumia.entity.FilterObject;
import com.jumia.model.Customer;

public interface CustomerService {

	List<Customer> getAll();
	
	List<Customer> getAll(FilterObject filterObject);
}
