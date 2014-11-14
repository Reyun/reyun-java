package com.reyun.api.model;

import com.reyun.api.ReyunAPI.Gender;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Register extends Model {

	public Register(String appid) {
		super(appid);
		this.where = "register";
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public void setWho(String who) {
		this.who = who;
	}
	
	/**
	 * 设置账户类型
	 * @param accounttype
	 */
	public void setAccounttype(String accounttype) {
		context.put("accounttype", accounttype);
	}
	
	/**
	 * 设置账户性别
	 * 		Gender.f 女, Gender.m 男, Gender.o 其它, Gender.unknown 未知
	 * @param gender
	 */
	public void setGender(Gender gender) {
		context.put("gender", String.valueOf(gender));
	}
	
	/**
	 * 设置年龄
	 * @param age
	 */
	public void setAge(int age) {
		context.put("age", String.valueOf(age));
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

	@Override
	public void validate() {
		if (!ValidateUtil.isValid(who)) {
			throw new ParamRequiredException("who must be set in register");
		}
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in register");
		}
	}
}
