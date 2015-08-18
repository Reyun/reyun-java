package com.reyun.api.util;

import java.util.Collection;
import java.util.Map;

public class ValidateUtil {
	
    /**
     * Determine a string whether effective
     * 
     * @param str the string to be validate
     * @return whether the string is valid
     */
	public static boolean isValid(String str) {
		if (str == null || "".equals(str.trim())) {
			return false ;
		}
		return true ;
	}
	
	/**
     * Determine a Collection whether effective
     * 
     * @param col the Collection to be validate
     * @return whether the Collection is valid
     */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col) {
		if (col == null || col.isEmpty()) {
			return false ;
		}
		return true ;
	}
	
	/**
     * Determine a Map whether effective
     * 
     * @param map the Map to be validate
     * @return whether the Map is valid
     */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Map map) {
		if (map == null || map.isEmpty()) {
			return false ;
		}
		return true ;
	}
	
	/**
     * Determine an Array whether effective
     * 
     * @param arr the Array to be validate
     * @return whether the Array is valid
     */
	public static boolean isValid(Object[] arr) {
		if (arr == null || arr.length == 0) {
			return false ;
		}
		return true ;
	}
	
	/**
	 * Determine an Object whether effective
	 * 
	 * @param obj the Object to be validate
	 * @return whether the Object is valid
	 */
	public static boolean isValid(Object obj) {
		if (obj == null ) {
			return false ;
		}
		return true ;
	}
}
