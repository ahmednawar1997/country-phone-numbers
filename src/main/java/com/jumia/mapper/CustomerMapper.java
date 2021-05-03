package com.jumia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jumia.entity.Country;
import com.jumia.model.Customer;

@Component
public class CustomerMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setPhoneNumber(rs.getString("phone"));
		customer.setCountry(Country.valueOf(rs.getString("country")));
		customer.setValid(rs.getBoolean("isValid"));
		return customer;
	}
}
