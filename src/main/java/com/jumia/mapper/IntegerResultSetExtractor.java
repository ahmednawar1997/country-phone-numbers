package com.jumia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

public class IntegerResultSetExtractor implements ResultSetExtractor<Integer> {

	@Override
	public Integer extractData(final ResultSet rs) throws SQLException {
		rs.next();
		return rs.getInt(1);
	}

}
