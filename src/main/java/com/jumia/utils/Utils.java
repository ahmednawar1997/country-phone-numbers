package com.jumia.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	private final static String cameroonPattern ="\\(237\\)\\ ?[2368]\\d{7,8}$";
	private static final String ethiopiaPattern ="\\(251\\)\\ ?[1-59]\\d{8}$";
	private static final String moroccoPattern ="\\(212\\)\\ ?[5-9]\\d{8}$";
	private static final String mozambiquePattern ="\\(258\\)\\ ?[28]\\d{7,8}$";
	private static final String ugandaPattern ="\\(256\\)\\ ?\\d{9}$";
	
	public static boolean isPhoneValid(String phone) {
		Pattern pattern = Pattern.compile(cameroonPattern);
	    Matcher matcher = pattern.matcher(phone);
	    boolean matchFound = matcher.find();		
		return matchFound;		
	}
	
	public String extractCountry(String phone) {
		return phone;
		
	}

}
