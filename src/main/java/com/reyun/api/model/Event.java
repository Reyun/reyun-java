package com.reyun.api.model;

import java.util.Map;

import com.reyun.api.Sender;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Event extends Model {

	public Event(String appid, Sender sender) {
		super(appid, sender);
		this.where = "event";
	}
	
	/**
	 * 设置设备id
	 * @param deviceid
	 */
	public Event setDeviceid(String deviceid) {
		context.put("deviceid", deviceid);
		return this;
	}
	
	/**
	 * 设置时间
	 * 		yyyy-MM-dd HH:mm:ss
	 * @param when
	 * @return
	 */
	public Event setWhen(String when) {
		this.when = when;
		return this;
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public Event setWho(String who) {
		this.who = who;
		return this;
	}
	
	/**
	 * 设置自定义事件名
	 * @param what
	 */
	public Event setWhat(String what) {
		this.what = what;
		return this;
	}
	
	/**
	 * 设置服务器id
	 * @param serverid
	 */
	public Event setServerid(String serverid) {
		context.put("serverid", serverid);
		return this;
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public Event setChannelid(String channelid) {
		context.put("channelid", channelid);
		return this;
	}
	
	/**
	 * 设置用户自定义参数
	 * @param map
	 */
	public Event setUserDefine(Map<String, String> map) {
		context.putAll(map);
		return this;
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
