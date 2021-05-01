package com.jumia.utils;

import com.jumia.entity.Country;

public interface Factory {
	Country extractCountry(String phone);

}
