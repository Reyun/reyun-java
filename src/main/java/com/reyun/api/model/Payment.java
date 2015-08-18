package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Payment
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Payment extends Model<Payment> {

    public Payment(String appid, int timeout) {
        super(appid, timeout);
        this.where = "payment";
    }

    /**
     * 设置账户ID
     * 
     * @param who
     */
    public Payment setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置交易的流水号
     * 
     * @param transactionid
     */
    public Payment setTransactionid(String transactionid) {
        context.put("transactionid", transactionid);
        return this;
    }

    /**
     * 设置支付类型 如支付宝,银联,苹果,谷歌官方等 如果是系统赠送则为free
     * 
     * @param paymenttype
     */
    public Payment setPaymenttype(String paymenttype) {
        context.put("paymenttype", paymenttype);
        return this;
    }

    /**
     * 设置货币类型 按照国际标准组织ISO4217中规范的3位字母 如CNY人民币,USD美金
     * 
     * @param currencytype
     */
    public Payment setCurrencytype(String currencytype) {
        context.put("currencytype", currencytype);
        return this;
    }

    /**
     * 设置支付金额
     * 
     * @param currencyamount
     */
    public Payment setCurrencyamount(String currencyamount) {
        context.put("currencyamount", currencyamount);
        return this;
    }

    /**
     * 设置通过充值获得的游戏内货币数量
     * 
     * @param virtualcoinamount
     */
    public Payment setVirtualcoinamount(String virtualcoinamount) {
        context.put("virtualcoinamount", virtualcoinamount);
        return this;
    }

    /**
     * 设置游戏内购买道具的名称
     * 
     * @param iapname
     */
    public Payment setIapname(String iapname) {
        context.put("iapname", iapname);
        return this;
    }

    /**
     * 设置游戏内购买道具的数量
     * 
     * @param iapamount
     */
    public Payment setIapamount(String iapamount) {
        context.put("iapamount", iapamount);
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid
     */
    public Payment setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    /**
     * 设置账户等级
     * 
     * @param level
     */
    public Payment setLevel(int level) {
        context.put("level", String.valueOf(level));
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(who)) {
            throw new ParamRequiredException("who must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("transactionid"))) {
            throw new ParamRequiredException("transactionid must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("paymenttype"))) {
            throw new ParamRequiredException("paymenttype must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("currencytype"))) {
            throw new ParamRequiredException("currencytype must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("currencyamount"))) {
            throw new ParamRequiredException("currencyamount must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("virtualcoinamount"))) {
            throw new ParamRequiredException("virtualcoinamount must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("iapname"))) {
            throw new ParamRequiredException("iapname must be set in payment");
        }
        if (!ValidateUtil.isValid(context.get("iapamount"))) {
            throw new ParamRequiredException("iapamount must be set in payment");
        }
    }
}
