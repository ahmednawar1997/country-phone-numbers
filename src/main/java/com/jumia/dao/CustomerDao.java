package com.jumia.dao;

import java.util.List;

import com.jumia.entity.Country;
import com.jumia.entity.FilterObject;
import com.jumia.model.Customer;

public interface CustomerDao {
	
	List<Customer> getAll();

	List<Customer> getAll(FilterObject filterObject);

	int count(FilterObject filterObject);
	
	int updateCountryAndState(int customerId, Country country, boolean state);

	void addCountryAndStateCols();

}
