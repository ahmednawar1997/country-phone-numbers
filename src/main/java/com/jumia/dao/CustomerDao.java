package com.jumia.dao;

import java.util.List;

import com.jumia.entity.FilterObject;
import com.jumia.model.Customer;

public interface CustomerDao {
	
	List<Customer> getAll();

	List<Customer> getAll(FilterObject filterObject);

}
