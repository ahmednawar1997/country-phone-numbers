package com.jumia.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.jumia.entity.Country;

@Component
public class CountryFactory implements Factory {

	private final static String cameroonPattern = "\\(237\\)\\ ?[2368]\\d{7,8}$";
	private static final String ethiopiaPattern = "\\(251\\)\\ ?[1-59]\\d{8}$";
	private static final String moroccoPattern = "\\(212\\)\\ ?[5-9]\\d{8}$";
	private static final String mozambiquePattern = "\\(258\\)\\ ?[28]\\d{7,8}$";
	private static final String ugandaPattern = "\\(256\\)\\ ?\\d{9}$";

	@Override
	public Country extractCountry(String phone) {
		if (checkCountryRegex(phone, cameroonPattern))
			return Country.Cameroon;
		if (checkCountryRegex(phone, ethiopiaPattern))
			return Country.Ethiopia;
		if (checkCountryRegex(phone, moroccoPattern))
			return Country.Morocco;
		if (checkCountryRegex(phone, mozambiquePattern))
			return Country.Mozambique;
		if (checkCountryRegex(phone, ugandaPattern))
			return Country.Uganda;
		return Country.Error;
	}

	private boolean checkCountryRegex(String phone, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(phone);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

}
