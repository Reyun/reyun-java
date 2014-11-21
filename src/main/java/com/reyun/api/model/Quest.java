package com.reyun.api.model;

import com.reyun.api.Sender;
import com.reyun.api.enumeration.QuestStatus;
import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

public class Quest extends Model {

	public Quest(String appid, Sender sender) {
		super(appid, sender);
		this.where = "quest";
	}
	
	/**
	 * 设置设备id
	 * @param deviceid
	 */
	public Quest setDeviceid(String deviceid) {
		context.put("deviceid", deviceid);
		return this;
	}
	
	/**
	 * 设置时间
	 * 		yyyy-MM-dd HH:mm:ss
	 * @param when
	 * @return
	 */
	public Quest setWhen(String when) {
		this.when = when;
		return this;
	}
	
	/**
	 * 设置账户ID
	 * @param who
	 */
	public Quest setWho(String who) {
		this.who = who;
		return this;
	}
	
	/**
	 * 设置当前任务/关卡/副本的编号或名称
	 * @param questid
	 */
	public Quest setQuestid(String questid) {
		context.put("questid", questid);
		return this;
	}
	
	/**
	 * 设置当前任务/关卡/副本的状态
	 * 		开始:a, 完成:c, 失败:f
	 * @param queststatus
	 */
	public Quest setQueststatus(QuestStatus queststatus) {
		context.put("queststatus", String.valueOf(queststatus));
		return this;
	}
	
	/**
	 * 设置当前任务/关卡/副本的类型
	 * 	例如：
	 * 		新手任务:new, 主线任务:main, 支线任务:sub
	 * 	开发者也可以根据自己游戏的特点自定义类型
	 * @param questtype
	 */
	public Quest setQuesttype(String questtype) {
		context.put("questtype", questtype);
		return this;
	}
	
	/**
	 * 设置服务器id
	 * @param serverid
	 */
	public Quest setServerid(String serverid) {
		context.put("serverid", serverid);
		return this;
	}
	
	/**
	 * 设置渠道id
	 * @param channelid
	 */
	public Quest setChannelid(String channelid) {
		context.put("channelid", channelid);
		return this;
	}
	
	/**
	 * 设置账户等级
	 * @param level
	 */
	public Quest setLevel(int level) {
		context.put("level", String.valueOf(level));
		return this;
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
