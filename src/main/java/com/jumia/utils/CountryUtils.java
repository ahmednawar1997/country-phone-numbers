package com.jumia.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.jumia.entity.Country;

@Component
public class CountryUtils {

	public static final String cameroonPattern = "\\(237\\)\\ ?[2368]\\d{7,8}$";
	public static final String ethiopiaPattern = "\\(251\\)\\ ?[1-59]\\d{8}$";
	public static final String moroccoPattern = "\\(212\\)\\ ?[5-9]\\d{8}$";
	public static final String mozambiquePattern = "\\(258\\)\\ ?[28]\\d{7,8}$";
	public static final String ugandaPattern = "\\(256\\)\\ ?\\d{9}$";

	private static final String CAMEROON_CODE = "237";
	private static final String ETHIOPIA_CODE = "251";
	private static final String MOROCCO_CODE = "212";
	private static final String MOZAMBIQUE_CODE = "258";
	private static final String UGANDA_CODE = "256";

	public static boolean validateCountry(String phone) {
		List<String> validRegexList = getValidRegex();
		for (String pattern : validRegexList) {
			if (checkCountryRegex(phone, pattern))
				return true;
		}
		return false;
	}
	
	public static Country getCountry(String phone) {
		String countryCode = extractCountryCode(phone);
		return getCountryByCode(countryCode);
	}
	
	private static List<String> getValidRegex(){
		List<String> validRegexList = new ArrayList<String>();
		validRegexList.add(cameroonPattern);
		validRegexList.add(ethiopiaPattern);
		validRegexList.add(moroccoPattern);
		validRegexList.add(mozambiquePattern);
		validRegexList.add(ugandaPattern);
		return validRegexList;
	}

	private static Country getCountryByCode(String countryCode) {
		switch (countryCode) {
		case CAMEROON_CODE:
			return Country.Cameroon;
		case ETHIOPIA_CODE:
			return Country.Ethiopia;
		case MOROCCO_CODE:
			return Country.Morocco;
		case MOZAMBIQUE_CODE:
			return Country.Mozambique;
		case UGANDA_CODE:
			return Country.Uganda;
		default:
			return Country.Error;
		}
	}

	private static String extractCountryCode(String phone) {
		Pattern pattern = Pattern.compile("\\(\\d{3}\\)*");
		Matcher matcher = pattern.matcher(phone);
		if(matcher.find()) {
			String countryCode = matcher.group();
			return countryCode.substring(1, countryCode.length()-1);
		}
		return "000";
	}

	private static boolean checkCountryRegex(String phone, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(phone);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

}
