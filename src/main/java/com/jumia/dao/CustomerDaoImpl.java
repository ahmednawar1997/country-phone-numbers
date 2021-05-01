package com.jumia.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jumia.entity.FilterObject;
import com.jumia.mapper.CustomerMapper;
import com.jumia.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> getAll() {
		String sql = "SELECT * FROM customer";

		List<Customer> customers = jdbcTemplate.query(sql, customerMapper);
		return customers;
	}

	@Override
	public List<Customer> getAll(FilterObject filterObject) {
		int startRowNumber = (filterObject.getNavigationObject().getPage() - 1)  * filterObject.getNavigationObject().getRecordsPerPage();
		int endRowNumber = filterObject.getNavigationObject().getPage()	+ filterObject.getNavigationObject().getRecordsPerPage();
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER ( ORDER BY id ) AS RowNum, *" 
				+ " FROM customer"
				+ " )" 
				+ " WHERE RowNum >= " + startRowNumber + " AND RowNum < " + endRowNumber
				+ " ORDER BY RowNum";

		List<Customer> customers = jdbcTemplate.query(sql, customerMapper);
		return customers;
	}

}
