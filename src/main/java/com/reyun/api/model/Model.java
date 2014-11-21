package com.reyun.api.model;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.reyun.api.Result;
import com.reyun.api.Sender;
import com.reyun.api.exception.ConnectionException;
import com.reyun.api.exception.TimeoutException;
import com.reyun.api.util.ValidateUtil;

public abstract class Model {

	private Sender sender;
	
	protected String appid;
	
	protected String when;
	
	protected String who;
	
	protected String what;
	
	protected String where;
	
	protected Map<String, String> context = new HashMap<String, String>();
	
	protected Model(String appid, Sender sender) {
		this.appid = appid;
		this.sender = sender;
	}
	
	protected abstract void validate();
	
	@Override
	public String toString() {
		validate();
		return JSON.toJSONString(this);
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
	
	/**
	 * 数据报送
	 * @param model
	 * @return Result
	 * 			status		数据报送是否成功
	 * 			message		返回信息
	 * @throws ConnectionException
	 * @throws TimeoutException
	 */
	public Result post() throws ConnectionException, TimeoutException {
		return sender.post(this);
	}
}
