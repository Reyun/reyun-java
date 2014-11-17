package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Loggedin extends Model {

	public Loggedin(String appid) {
		super(appid);
		this.where = "loggedin";
	}

	/**
	 * 设置账户ID
	 * @param who
	 */
	public void setWho(String who) {
		this.who = who;
	}
	
	/**
	 * 设置服务器id
	 * @param serverid
	 */
	public void setServerid(String serverid) {
		context.put("serverid", serverid);
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public void setChannelid(String channelid) {
		context.put("channelid", channelid);
	}
	
	/**
	 * 设置账户等级
	 * @param level
	 */
	public void setLevel(int level) {
		context.put("level", String.valueOf(level));
	}
	
	@Override
	protected void validate() {
		if (!ValidateUtil.isValid(who)) {
			throw new ParamRequiredException("who must be set in loggedin");
		}
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in loggedin");
		}
	}
}
