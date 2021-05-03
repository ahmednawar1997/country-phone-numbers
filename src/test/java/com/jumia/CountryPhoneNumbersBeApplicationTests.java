package com.jumia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jumia.entity.Country;
import com.jumia.entity.FilterObject;
import com.jumia.entity.NavigationObject;
import com.jumia.model.Customer;
import com.jumia.service.CustomerService;

@SpringBootTest
class CountryPhoneNumbersBeApplicationTests {

	@Autowired
	private CustomerService customerService;

	@Test
	void countCustomers() {
		NavigationObject navigationObject = new NavigationObject(1, 25);
		FilterObject filterObject = new FilterObject(navigationObject, "", null);
		int count = customerService.count(filterObject);
		assertThat(count).isEqualTo(41);
	}

	@Test
	void fetchCustomers() {
		NavigationObject navigationObject = new NavigationObject(0, 100);
		FilterObject filterObject = new FilterObject(navigationObject, "Cameroon", false);
		List<Customer> customers = customerService.getAll(filterObject);
		assertThat(customers.size()).isEqualTo(customerService.count(filterObject));
	}

	@Test
	void searchCustomers() {
		NavigationObject navigationObject = new NavigationObject(0, 100);
		FilterObject filterObject = new FilterObject(navigationObject, "Cameroon", false);
		List<Customer> customers = customerService.getAll(filterObject);
		assertThat(customers.size()).isEqualTo(customerService.count(filterObject));
	}

	@Test
	void checkCountry() {
		NavigationObject navigationObject = new NavigationObject(0, 100);
		FilterObject filterObject = new FilterObject(navigationObject, "Cameroon", false);
		Customer customer = customerService.getAll(filterObject).get(0);
		assertThat(customer.getCountry()).isEqualTo(Country.Cameroon);
	}

	@Test
	void checkPagination() {
		NavigationObject navigationObject = new NavigationObject(0, 33);
		FilterObject filterObject = new FilterObject(navigationObject, "", null);
		List<Customer> customers = customerService.getAll(filterObject);
		assertThat(customers.size()).isEqualTo(33);
	}

	@Test
	void checkFirstCustomer() {
		NavigationObject navigationObject = new NavigationObject(0, 100);
		FilterObject filterObject = new FilterObject(navigationObject, "", null);
		Customer customer = customerService.getAll(filterObject).get(0);
		assertThat(customer.getId()).isEqualTo(0);
	}

}
