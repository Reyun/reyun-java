package com.reyun.until;

import java.util.HashMap;
import java.util.Iterator;

public class RYHashMap extends HashMap {

	public Object get(Object k, Object dv) {
		Object v = super.get(k);
		return ((v == null) && !this.containsKey(k)) ? dv : v;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Object key : this.keySet())
			sb.append(key + "\001" + String.valueOf(this.get(key)) + "\002");

		String enstr = sb.toString();
		enstr = enstr.substring(0, enstr.length() - 1);
		return enstr;
	}
}
