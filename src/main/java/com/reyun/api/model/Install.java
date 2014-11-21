package com.reyun.api.model;

import com.reyun.api.Sender;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Install extends Model {

	public Install(String appid, Sender sender) {
		super(appid, sender);
		this.where = "install";
	}
	
	/**
	 * 设置设备id
	 * @param deviceid
	 */
	public Install setDeviceid(String deviceid) {
		context.put("deviceid", deviceid);
		return this;
	}
	
	/**
	 * 设置时间
	 * 		yyyy-MM-dd HH:mm:ss
	 * @param when
	 * @return
	 */
	public Install setWhen(String when) {
		this.when = when;
		return this;
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public Install setChannelid(String channelid) {
		context.put("channelid", channelid);
		return this;
	}

	@Override
	protected void validate() {
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in install");
		}
	}
}
