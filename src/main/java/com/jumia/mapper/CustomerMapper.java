package com.jumia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jumia.model.Customer;
import com.jumia.utils.CountryFactory;

@Component
public class CustomerMapper implements RowMapper<Customer> {

	@Autowired
	CountryFactory countryFactory;
	
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setPhoneNumber(rs.getString("phone"));
		return customer;
	}
}
