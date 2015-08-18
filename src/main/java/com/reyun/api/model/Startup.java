package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

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
     * 设置设备id
     * 
     * @param deviceid
     */
    public Startup setDeviceid(String deviceid) {
        context.put("deviceid", deviceid);
        return this;
    }

    /**
     * 设置时间 yyyy-MM-dd HH:mm:ss
     * 
     * @param when
     * @return
     */
    public Startup setWhen(String when) {
        this.when = when;
        return this;
    }

    /**
     * 设置渠道id
     * 
     * @param channelid
     */
    public Startup setChannelid(String channelid) {
        context.put("channelid", channelid);
        return this;
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
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in startup");
        }
    }
}
