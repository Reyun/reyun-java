package com.reyun.api.model;

import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Economy
 * 
 * @author liruijie@reyun.com
 */
public class Economy extends Model<Economy> {

    public Economy(String appid, int timeout) {
        super(appid, timeout);
        this.where = "economy";
    }

    /**
     * 设置账户ID
     * 
     * @param who 账户ID
     * @return Economy
     */
    public Economy setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置游戏内虚拟物品名称/ID
     * 
     * @param itemname 游戏内虚拟物品名称/ID
     * @return Economy
     */
    public Economy setItemname(String itemname) {
        context.put("itemname", itemname);
        return this;
    }

    /**
     * 设置交易的数量
     * 
     * @param itemamount 交易的数量
     * @return Economy
     */
    public Economy setItemamount(String itemamount) {
        context.put("itemamount", itemamount);
        return this;
    }

    /**
     * 设置交易的总价
     * 
     * @param itemtotalprice 交易的总价
     * @return Economy
     */
    public Economy setItemtotalprice(String itemtotalprice) {
        context.put("itemtotalprice", itemtotalprice);
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid 服务器id
     * @return Economy
     */
    public Economy setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置账户等级
     * 
     * @param level 账户等级
     * @return Economy
     */
    public Economy setLevel(int level) {
        context.put("level", String.valueOf(level));
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
        super.checkWho();
        if ( ! ValidateUtil.isValid(context.get("itemname"))) {
            throw new ParamRequiredException("itemname must be set in economy");
        }
        if ( ! ValidateUtil.isValid(context.get("itemamount"))) {
            throw new ParamRequiredException("itemamount must be set in economy");
        }
        if ( ! ValidateUtil.isValid(context.get("itemtotalprice"))) {
            throw new ParamRequiredException("itemtotalprice must be set in economy");
        }
    }
}
