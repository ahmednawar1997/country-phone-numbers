package com.jumia.dao;

import java.sql.Types;
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
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER ( ORDER BY id ) AS RowNum, *" + " FROM customer";

		// sql = addFilterCriteria(filterObject, sql);
		sql += " )" + " WHERE RowNum BETWEEN " + filterObject.getNavigationObject().getStartRowNumber() + " AND "
				+ filterObject.getNavigationObject().getEndRowNumber() + " ORDER BY RowNum";

		List<Customer> customers = jdbcTemplate.query(sql, customerMapper);
		return customers;
	}

	@Override
	public int count(FilterObject filterObject) {
		String sql = "SELECT COUNT(*) FROM customer ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

//	private String addFilterCriteria(FilterObject filterObject, String sql) {
//		if (filterObject.getCountry() != null) {
//			sql += " WHERE country=" + filterObject.getCountry();
//		}
//		if (filterObject.getState()) {
//			sql += " WHERE phone REGEXP '" + CountryFactory.cameroonPattern;
//			sql += "' OR phone REGEXP  '" + CountryFactory.ethiopiaPattern;
//			sql += "' OR phone REGEXP  '" + CountryFactory.moroccoPattern;
//			sql += "' OR phone REGEXP  '" + CountryFactory.mozambiquePattern;
//			sql += "' OR phone REGEXP  '" + CountryFactory.ugandaPattern + "'";
//		}
//		return sql;		
//	}

}
