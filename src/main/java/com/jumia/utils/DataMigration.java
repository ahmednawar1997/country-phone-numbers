package com.jumia.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jumia.dao.CustomerDao;
import com.jumia.model.Customer;

@Component
public class DataMigration {

	@Autowired
	private CustomerDao customerDao;

	//@EventListener(ApplicationReadyEvent.class)
	public void migrateDataOnStartup() {

		customerDao.addCountryAndStateCols();

		List<Customer> customers = customerDao.getAll();
		for (Customer customer : customers) {
			customerDao.updateCountryAndState(customer.getId(), CountryUtils.getCountry(customer.getPhoneNumber()),
					CountryUtils.validateCountry(customer.getPhoneNumber()));

		}
		System.out.println("Migration Done");
	}

}