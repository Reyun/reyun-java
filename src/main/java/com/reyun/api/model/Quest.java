package com.reyun.api.model;

import com.reyun.api.ReyunAPI.QuestStatus;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Quest extends Model {

	public Quest(String appid) {
		super(appid);
		this.where = "quest";
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public void setWho(String who) {
		this.who = who;
	}
	
	/**
	 * 设置当前任务/关卡/副本的编号或名称
	 * @param questid
	 */
	public void setQuestid(String questid) {
		context.put("questid", questid);
	}
	
	/**
	 * 设置当前任务/关卡/副本的状态
	 * 		开始:a, 完成:c, 失败:f
	 * @param queststatus
	 */
	public void setQueststatus(QuestStatus queststatus) {
		context.put("queststatus", String.valueOf(queststatus));
	}
	
	/**
	 * 设置当前任务/关卡/副本的类型
	 * 	例如：
	 * 		新手任务:new, 主线任务:main, 支线任务:sub
	 * 	开发者也可以根据自己游戏的特点自定义类型
	 * @param questtype
	 */
	public void setQuesttype(String questtype) {
		context.put("questtype", questtype);
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
	protected void validate() {
		if (!ValidateUtil.isValid(who)) {
			throw new ParamRequiredException("who must be set in quest");
		}
		if (!ValidateUtil.isValid(context.get("deviceid"))) {
			throw new ParamRequiredException("deviceid must be set in quest");
		}
		if (!ValidateUtil.isValid(context.get("questid"))) {
			throw new ParamRequiredException("questid must be set in quest");
		}
		if (!ValidateUtil.isValid(context.get("queststatus"))) {
			throw new ParamRequiredException("queststatus must be set in quest");
		}
		if (!ValidateUtil.isValid(context.get("questtype"))) {
			throw new ParamRequiredException("questtype must be set in quest");
		}
	}
}
