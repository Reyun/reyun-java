package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Economy extends Model {

	public Economy(String appid) {
		super(appid);
		this.where = "economy";
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public void setWho(String who) {
		this.who = who;
	}
	
	/**
	 * 设置游戏内虚拟物品名称/ID
	 * @param transactionid
	 */
	public void setItemname(String itemname) {
		context.put("itemname", itemname);
	}
	
	/**
	 * 设置交易的数量
	 * @param itemamount
	 */
	public void setItemamount(String itemamount) {
		context.put("itemamount", itemamount);
	}
	
	/**
	 * 设置交易的总价
	 * @param itemtotalprice
	 */
	public void setItemtotalprice(String itemtotalprice) {
		context.put("itemtotalprice", itemtotalprice);
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
