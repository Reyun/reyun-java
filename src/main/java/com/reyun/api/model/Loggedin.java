package com.reyun.api.model;

import com.reyun.api.Sender;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Loggedin extends Model {

	public Loggedin(String appid, Sender sender) {
		super(appid, sender);
		this.where = "loggedin";
	}

	/**
	 * 设置设备id
	 * @param deviceid
	 */
	public Loggedin setDeviceid(String deviceid) {
		context.put("deviceid", deviceid);
		return this;
	}
	
	/**
	 * 设置时间
	 * 		yyyy-MM-dd HH:mm:ss
	 * @param when
	 * @return
	 */
	public Loggedin setWhen(String when) {
		this.when = when;
		return this;
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public Loggedin setWho(String who) {
		this.who = who;
		return this;
	}
	
	/**
	 * 设置服务器id
	 * @param serverid
	 */
	public Loggedin setServerid(String serverid) {
		context.put("serverid", serverid);
		return this;
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public Loggedin setChannelid(String channelid) {
		context.put("channelid", channelid);
		return this;
	}
	
	/**
	 * 设置账户等级
	 * @param level
	 */
	public Loggedin setLevel(int level) {
		context.put("level", String.valueOf(level));
		return this;
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
