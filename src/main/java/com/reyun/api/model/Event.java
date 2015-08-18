package com.reyun.api.model;

import java.util.Map;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Event
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Event extends Model<Event> {

    public Event(String appid, int timeout) {
        super(appid, timeout);
        this.where = "event";
    }

    /**
     * 设置账户ID
     * 
     * @param who
     */
    public Event setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置自定义事件名
     * 
     * @param what
     */
    public Event setWhat(String what) {
        this.what = what;
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid
     */
    public Event setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置用户自定义参数
     * 
     * @param map
     */
    public Event setUserDefine(Map<String, String> map) {
        context.putAll(map);
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(who)) {
            throw new ParamRequiredException("who must be set in event");
        }
        if (!ValidateUtil.isValid(what)) {
            throw new ParamRequiredException("what must be set in event");
        }
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in event");
        }
    }
}
