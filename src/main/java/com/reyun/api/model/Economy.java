package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Economy
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Economy extends Model<Economy> {

    public Economy(String appid, int timeout) {
        super(appid, timeout);
        this.where = "economy";
    }

    /**
     * 设置账户ID
     * 
     * @param who
     */
    public Economy setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置游戏内虚拟物品名称/ID
     * 
     * @param itemname
     */
    public Economy setItemname(String itemname) {
        context.put("itemname", itemname);
        return this;
    }

    /**
     * 设置交易的数量
     * 
     * @param itemamount
     */
    public Economy setItemamount(String itemamount) {
        context.put("itemamount", itemamount);
        return this;
    }

    /**
     * 设置交易的总价
     * 
     * @param itemtotalprice
     */
    public Economy setItemtotalprice(String itemtotalprice) {
        context.put("itemtotalprice", itemtotalprice);
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid
     */
    public Economy setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置账户等级
     * 
     * @param level
     */
    public Economy setLevel(int level) {
        context.put("level", String.valueOf(level));
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(who)) {
            throw new ParamRequiredException("who must be set in economy");
        }
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in economy");
        }
        if (!ValidateUtil.isValid(context.get("itemname"))) {
            throw new ParamRequiredException("itemname must be set in economy");
        }
        if (!ValidateUtil.isValid(context.get("itemamount"))) {
            throw new ParamRequiredException("itemamount must be set in economy");
        }
        if (!ValidateUtil.isValid(context.get("itemtotalprice"))) {
            throw new ParamRequiredException("itemtotalprice must be set in economy");
        }
    }
}
