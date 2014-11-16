package com.reyun.api.model;

import java.util.Map;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Event extends Model {

	public Event(String appid) {
		super(appid);
		this.where = "event";
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public void setWho(String who) {
		this.who = who;
	}
	
	/**
	 * 设置自定义事件名
	 * @param what
	 */
	public void setWhat(String what) {
		this.what = what;
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
	 * 设置用户自定义参数
	 * @param map
	 */
	public void setUserDefine(Map<String, String> map) {
		context.putAll(map);
	}

	@Override
	protected void validate() {
		if (!ValidateUtil.isValid(who)) {
			throw new ParamRequiredException("who must be set in event");
		}
		if (!ValidateUtil.isValid(what)) {
			throw new ParamRequiredException("what must be set in event");
		}
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in event");
		}
	}
}
