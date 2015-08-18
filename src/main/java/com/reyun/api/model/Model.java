package com.reyun.api.model;

import java.io.IOException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.reyun.api.Result;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.exception.ReyunTimeoutException;
import com.reyun.api.util.HttpUtil;
import com.reyun.api.util.ValidateUtil;

public abstract class Model<T> {
    protected int timeout;
    
	protected String appid;
	
	protected String when;
	
	protected String who;
	
	protected String what;
	
	protected String where;
	
	protected Map<String, String> context = new HashMap<String, String>();
	
	protected Model(String appid, int timeout) {
		this.appid = appid;
		this.timeout = timeout;
	}
	
	@SuppressWarnings("unchecked")
    public T setContext(Map<String, String> context) {
	    this.context.putAll(context);
	    return (T)this;
	}
	
	protected abstract void validate() throws ParamRequiredException;
	
	@Override
	public String toString() {
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
     *          status      数据报送是否成功
     *          message     返回信息
	 * @throws ConnectException
	 * @throws ReyunTimeoutException
	 * @throws IOException
	 * @throws ParamRequiredException
	 */
	public Result post() throws ConnectException, ReyunTimeoutException, IOException, ParamRequiredException {
	    validate();
		return HttpUtil.post(this, timeout);
	}
}
