package com.reyun.api.model;

import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;

/**
 * Heartbeat
 * 
 * @author liruijie@reyun.com
 */
public class Heartbeat extends Model<Heartbeat> {

    public Heartbeat(String appid, int timeout) {
        super(appid, timeout);
        this.where = "heartbeat";
    }

    /**
     * 设置账户ID
     * 
     * @param who 账户ID
     * @return Heartbeat
     */
    public Heartbeat setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid 服务器id
     * @return Heartbeat
     */
    public Heartbeat setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置账户等级
     * 
     * @param level 账户等级
     * @return Heartbeat
     */
    public Heartbeat setLevel(int level) {
        context.put("level", String.valueOf(level));
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
        super.checkWho();
    }
}
