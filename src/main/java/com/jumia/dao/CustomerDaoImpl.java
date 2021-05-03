package com.jumia.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jumia.entity.Country;
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
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER ( ORDER BY id ) AS RowNum, *" + " FROM customer";
		sql += " WHERE country = ?";
		sql += " AND isValid = ?";
		sql += " )";
		sql += " WHERE RowNum BETWEEN ? AND ?  ORDER BY RowNum";

		List<Customer> customers = jdbcTemplate.query(sql, customerMapper,
				new Object[] { filterObject.getCountry(), filterObject.getState(),
						filterObject.getNavigationObject().getStartRowNumber(),
						filterObject.getNavigationObject().getEndRowNumber() });
		return customers;
	}

	@Override
	public int count(FilterObject filterObject) {
		String sql = "SELECT COUNT(*) FROM customer ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int updateCountryAndState(int customerId, Country country, boolean state) {

		String sql = "UPDATE customer SET country = ?, isValid = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { country, state, customerId });
	}

	@Override
	public void addCountryAndStateCols() {

		String addCountrySql = "ALTER TABLE customer ADD country varchar(255) Null";
		String addStateSql = "ALTER TABLE customer ADD isValid BIT NUll";

		jdbcTemplate.execute(addCountrySql);
		jdbcTemplate.execute(addStateSql);
	}
}
