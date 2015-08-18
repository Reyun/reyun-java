package com.reyun.api.model;

import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;

/**
 * Loggedin
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Loggedin extends Model<Loggedin> {

    public Loggedin(String appid, int timeout) {
        super(appid, timeout);
        this.where = "loggedin";
    }

    /**
     * 设置账户ID
     * 
     * @param who
     */
    public Loggedin setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid
     */
    public Loggedin setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置账户等级
     * 
     * @param level
     */
    public Loggedin setLevel(int level) {
        context.put("level", String.valueOf(level));
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
        super.checkWho();
    }
}
