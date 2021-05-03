package com.jumia.setter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.jumia.entity.FilterObject;

public class CustomerSetter implements PreparedStatementSetter {

	private FilterObject filterObject;
	private boolean isCount = false;

	public CustomerSetter(FilterObject filterObject, boolean isCount) {
		super();
		this.filterObject = filterObject;
		this.isCount = isCount;
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		int i = 0;
		if (filterObject.getCountry() != null && !filterObject.getCountry().equals("")) {
			ps.setString(++i, filterObject.getCountry());
		}

		if (filterObject.getState() != null) {
			ps.setBoolean(++i, filterObject.getState());
		}

		if (!isCount) {
			ps.setInt(++i, filterObject.getNavigationObject().getStartRowNumber());
			ps.setInt(++i, filterObject.getNavigationObject().getEndRowNumber());
		}
	}

}
