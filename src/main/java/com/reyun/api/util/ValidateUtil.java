package com.reyun.api.util;

import java.util.Collection;
import java.util.Map;

public class ValidateUtil {
	
	/**
	 * 判断string是否有效
	 */
	public static boolean isValid(String str){
		if(str == null || "".equals(str.trim())){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 判断集合的有效性
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col){
		if(col == null || col.isEmpty()){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 判断map的有效性
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Map map){
		if(map == null || map.isEmpty()){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 判断数组有效性
	 */
	public static boolean isValid(Object[] arr){
		if(arr == null || arr.length == 0){
			return false ;
		}
		return true ;
	}
	
	/**
	 * 判断对象有效性
	 * @param obj
	 * @return boolean
	 */
	public static boolean isValid(Object obj){
		if(obj == null ){
			return false ;
		}
		return true ;
	}
}
