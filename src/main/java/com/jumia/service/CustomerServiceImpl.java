package com.jumia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.dao.CustomerDao;
import com.jumia.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
