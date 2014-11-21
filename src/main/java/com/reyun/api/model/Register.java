package com.reyun.api.model;

import com.reyun.api.Sender;
import com.reyun.api.enumeration.Gender;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Register extends Model {

	public Register(String appid, Sender sender) {
		super(appid, sender);
		this.where = "register";
	}
	
	/**
	 * 设置设备id
	 * @param deviceid
	 */
	public Register setDeviceid(String deviceid) {
		context.put("deviceid", deviceid);
		return this;
	}
	
	/**
	 * 设置时间
	 * 		yyyy-MM-dd HH:mm:ss
	 * @param when
	 * @return
	 */
	public Register setWhen(String when) {
		this.when = when;
		return this;
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public Register setWho(String who) {
		this.who = who;
		return this;
	}
	
	/**
	 * 设置账户类型
	 * @param accounttype
	 */
	public Register setAccounttype(String accounttype) {
		context.put("accounttype", accounttype);
		return this;
	}
	
	/**
	 * 设置账户性别
	 * 		Gender.f 女, Gender.m 男, Gender.o 其它, Gender.unknown 未知
	 * @param gender
	 */
	public Register setGender(Gender gender) {
		context.put("gender", String.valueOf(gender));
		return this;
	}
	
	/**
	 * 设置年龄
	 * @param age
	 */
	public Register setAge(int age) {
		context.put("age", String.valueOf(age));
		return this;
	}
	
	/**
	 * 设置服务器id
	 * @param serverid
	 */
	public Register setServerid(String serverid) {
		context.put("serverid", serverid);
		return this;
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public Register setChannelid(String channelid) {
		context.put("channelid", channelid);
		return this;
	}

	@Override
	protected void validate() {
		if (!ValidateUtil.isValid(who)) {
			throw new ParamRequiredException("who must be set in register");
		}
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in register");
		}
	}
}
