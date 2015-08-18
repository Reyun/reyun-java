package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Heartbeat
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Heartbeat extends Model<Heartbeat> {

    public Heartbeat(String appid, int timeout) {
        super(appid, timeout);
        this.where = "heartbeat";
    }

    /**
     * 设置账户ID
     * 
     * @param who
     */
    public Heartbeat setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid
     */
    public Heartbeat setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置账户等级
     * 
     * @param level
     */
    public Heartbeat setLevel(int level) {
        context.put("level", String.valueOf(level));
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(who)) {
            throw new ParamRequiredException("who must be set in heartbeat");
        }
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in heartbeat");
        }
    }
}
