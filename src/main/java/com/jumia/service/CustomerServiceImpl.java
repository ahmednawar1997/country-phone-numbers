package com.jumia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.dao.CustomerDao;
import com.jumia.entity.FilterObject;
import com.jumia.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	public List<Customer> getAll(FilterObject filterObject) {
		return customerDao.getAll(filterObject);
	}

	@Override
	public int count(FilterObject filterObject) {
		return customerDao.count(filterObject);
	}

	
}
