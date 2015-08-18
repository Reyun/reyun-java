package com.reyun.api.model;

import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;

/**
 * Startup
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Startup extends Model<Startup> {

    public Startup(String appid, int timeout) {
        super(appid, timeout);
        this.where = "startup";
    }

    /**
     * 设置时区
     * 
     * @param tz
     */
    public Startup setTZ(String tz) {
        context.put("tz", tz);
        return this;
    }

    /**
     * 设置设备类型
     * 
     * @param devicetype
     */
    public Startup setDevicetype(String devicetype) {
        context.put("devicetype", devicetype);
        return this;
    }

    /**
     * 设置运营商
     * 
     * @param op
     */
    public Startup setOP(String op) {
        context.put("op", op);
        return this;
    }

    /**
     * 设置网络制式 2G,3G,WIFI
     * 
     * @param network
     */
    public Startup setNetwork(String network) {
        context.put("network", network);
        return this;
    }

    /**
     * 设置操作系统
     * 
     * @param os
     */
    public Startup setOS(String os) {
        context.put("os", os);
        return this;
    }

    /**
     * 设置分辨率
     * 
     * @param resolution
     */
    public Startup setResolution(String resolution) {
        context.put("resolution", resolution);
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
    }
}
