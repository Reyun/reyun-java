package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Startup extends Model {

	public Startup(String appid) {
		super(appid);
		this.where = "startup";
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public void setChannelid(String channelid) {
		context.put("channelid", channelid);
	}
	
	/**
	 * 设置时区
	 * @param tz
	 */
	public void setTZ(String tz) {
		context.put("tz", tz);
	}
	
	/**
	 * 设置设备类型
	 * @param devicetype
	 */
	public void setDevicetype(String devicetype) {
		context.put("devicetype", devicetype);
	}
	
	/**
	 * 设置运营商
	 * @param op
	 */
	public void setOP(String op) {
		context.put("op", op);
	}
	
	/**
	 * 设置网络制式
	 * 		2G,3G,WIFI
	 * @param network
	 */
	public void setNetwork(String network) {
		context.put("network", network);
	}
	
	/**
	 * 设置操作系统
	 * @param os
	 */
	public void setOS(String os) {
		context.put("os", os);
	}
	
	/**
	 * 设置分辨率
	 * @param resolution
	 */
	public void setResolution(String resolution) {
		context.put("resolution", resolution);
	}

	@Override
	public void validate() {
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in startup");
		}
	}
}
