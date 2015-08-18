package com.reyun.api.model;

import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Event
 * 
 * @author liruijie@reyun.com
 */
public class Event extends Model<Event> {

    public Event(String appid, int timeout) {
        super(appid, timeout);
        this.where = "event";
    }

    /**
     * 设置账户ID
     * 
     * @param who 账户ID
     * @return Event
     */
    public Event setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置自定义事件名
     * 
     * @param what 自定义事件名
     * @return Event
     */
    public Event setWhat(String what) {
        this.what = what;
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid 服务器id
     * @return Event
     */
    public Event setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
        super.checkWho();
        if ( ! ValidateUtil.isValid(what)) {
            throw new ParamRequiredException("what must be set in event");
        }
    }
}
