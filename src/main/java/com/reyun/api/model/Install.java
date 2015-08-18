package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Install
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Install extends Model<Install> {

    public Install(String appid, int timeout) {
        super(appid, timeout);
        this.where = "install";
    }

    /**
     * 设置设备id
     * 
     * @param deviceid
     */
    public Install setDeviceid(String deviceid) {
        context.put("deviceid", deviceid);
        return this;
    }

    /**
     * 设置时间 yyyy-MM-dd HH:mm:ss
     * 
     * @param when
     * @return
     */
    public Install setWhen(String when) {
        this.when = when;
        return this;
    }

    /**
     * 设置渠道id
     * 
     * @param channelid
     */
    public Install setChannelid(String channelid) {
        context.put("channelid", channelid);
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in install");
        }
    }
}
