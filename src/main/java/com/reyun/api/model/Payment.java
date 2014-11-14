package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Payment extends Model {

	public Payment(String appid) {
		super(appid);
		this.where = "payment";
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public void setWho(String who) {
		this.who = who;
	}
	
	/**
	 * 设置交易的流水号
	 * @param transactionid
	 */
	public void setTransactionid(String transactionid) {
		context.put("transactionid", transactionid);
	}
	
	/**
	 * 设置支付类型
	 * 		如支付宝,银联,苹果,谷歌官方等
	 * 		如果是系统赠送则为free
	 * @param paymenttype
	 */
	public void setPaymenttype(String paymenttype) {
		context.put("paymenttype", paymenttype);
	}
	
	/**
	 * 设置货币类型
	 * 		按照国际标准组织ISO4217中规范的3位字母
	 * 		如CNY人民币,USD美金
	 * @param currencytype
	 */
	public void setCurrencytype(String currencytype) {
		context.put("currencytype", currencytype);
	}
	
	/**
	 * 设置支付金额
	 * @param currencyamount
	 */
	public void setCurrencyamount(String currencyamount) {
		context.put("currencyamount", currencyamount);
	}
	
	/**
	 * 设置通过充值获得的游戏内货币数量
	 * @param virtualcoinamount
	 */
	public void setVirtualcoinamount(String virtualcoinamount) {
		context.put("virtualcoinamount", virtualcoinamount);
	}
	
	/**
	 * 设置游戏内购买道具的名称
	 * @param iapname
	 */
	public void setIapname(String iapname) {
		context.put("iapname", iapname);
	}
	
	/**
	 * 设置游戏内购买道具的数量
	 * @param iapamount
	 */
	public void setIapamount(String iapamount) {
		context.put("iapamount", iapamount);
	}
	
	/**
	 * 设置服务器id
	 * @param serverid
	 */
	public void setServerid(String serverid) {
		context.put("serverid", serverid);
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public void setChannelid(String channelid) {
		context.put("channelid", channelid);
	}
	
	/**
	 * 设置账户等级
	 * @param level
	 */
	public void setLevel(int level) {
		context.put("level", String.valueOf(level));
	}

	@Override
	public void validate() {
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
