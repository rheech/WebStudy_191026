package com.comduck.common;

public class Common {
	
	public static String nullCheck(String s, String r) {
		if (s == null || s.equals("")) {
			return r;
		} else {
			return s;
		}
	}
	
	static public int nullCheck(Integer i, int r) {
		if (i == null)
			return r;
		else
			return i.intValue();
	}

	
}
