package com.reyun.api.model;

import java.io.IOException;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.reyun.api.Result;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.exception.ReyunTimeoutException;
import com.reyun.api.util.HttpUtil;
import com.reyun.api.util.ValidateUtil;

/**
 * Model
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
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

    /**
     * 设置设备id
     * 
     * @param deviceid
     * @return
     */
    @SuppressWarnings("unchecked")
    public T setDeviceid(String deviceid) {
        context.put("deviceid", deviceid);
        return (T) this;
    }
    
    /**
     * 设置时间
     * 
     * @param when
     * @return
     */
    @SuppressWarnings("unchecked")
    public T setWhen(Date when) {
        this.when = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(when);
        return (T) this;
    }

    /**
     * 设置渠道id
     * 
     * @param channelid
     */
    @SuppressWarnings("unchecked")
    public T setChannelid(String channelid) {
        context.put("channelid", channelid);
        return (T)this;
    }
    
    @SuppressWarnings("unchecked")
    public T setContext(Map<String, String> context) {
        this.context.putAll(context);
        return (T) this;
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
     * 
     * @param model
     * @return Result
     *          status 数据报送是否成功
     *          message 返回信息
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
