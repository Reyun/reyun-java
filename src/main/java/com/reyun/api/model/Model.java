package com.reyun.api.model;

import java.util.HashMap;
import java.util.Map;

import com.reyun.api.util.ValidateUtil;

public abstract class Model {

	protected String appid;
	
	protected String when;
	
	protected String who;
	
	protected String what;
	
	protected String where;
	
	protected Map<String, String> context = new HashMap<String, String>();
	
	protected Model(String appid) {
		this.appid = appid;
	}
	
	public abstract void validate();
	
	/**
	 * 设置设备id
	 * @param deviceid
	 */
	public void setDeviceid(String deviceid) {
		context.put("deviceid", deviceid);
	}
	
	public void setWhen(String when) {
		this.when = when;
	}
	
	public String method() {
		return where;
	}
	
	public String getAppid() {
		return appid;
	}

	public String getWhen() {
		return when;
	}

	public String getWho() {
		return who;
	}
	
	public String getWhat() {
		return what;
	}

	public Map<String, String> getContext() {
		if (ValidateUtil.isValid(context)) {
			return context;
		} else {
			return null;
		}
	}
}
