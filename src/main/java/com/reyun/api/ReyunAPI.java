package com.reyun.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.reyun.until.RYHashMap;

/**
 * Hello world!
 * 
 */
public class ReyunAPI {

	/**
	 * 
	 * @param appkey
	 *            应用appkey，需要从reyun后台申请
	 */
	public ReyunAPI(String appkey) {
		this.appkey = appkey;
		mEventsEndpoint = Config.BASE_ENDPOINT + "/receive/receive";
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 * @param devicetype
	 *            设备类型.
	 * @param deviceid
	 *            设备唯一编号.
	 * @param op
	 *            运营商.
	 * @param network
	 *            网络制式2G,3G,WIFI.
	 * @param os
	 *            操作系统.
	 * @param resolution
	 *            分辨率.
	 */
	public void profile(String tz, String devicetype, String deviceid,
			String op, String network, String os, String resolution) {
		profiles.put("tz", tz);
		profiles.put("devicetype", devicetype);
		profiles.put("deviceid", deviceid);
		profiles.put("op", op);
		profiles.put("network", network);
		profiles.put("os", os);
		profiles.put("resolution", resolution);
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 * @param devicetype
	 *            设备类型.
	 * @param deviceid
	 *            设备唯一编号.
	 * @param op
	 *            运营商.
	 * @param network
	 *            网络制式2G,3G,WIFI.
	 * @param os
	 *            操作系统.
	 */
	public void profile(String tz, String devicetype, String deviceid,
			String op, String network, String os) {
		this.profile(tz, devicetype, deviceid, op, network, os, _S_UNKNOWN_);
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 * @param devicetype
	 *            设备类型.
	 * @param deviceid
	 *            设备唯一编号.
	 * @param op
	 *            运营商.
	 * @param network
	 *            网络制式2G,3G,WIFI.
	 */
	public void profile(String tz, String devicetype, String deviceid,
			String op, String network) {
		this.profile(tz, devicetype, deviceid, op, network, _S_UNKNOWN_);
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 * @param devicetype
	 *            设备类型.
	 * @param deviceid
	 *            设备唯一编号.
	 * @param op
	 *            运营商.
	 */
	public void profile(String tz, String devicetype, String deviceid, String op) {
		this.profile(tz, devicetype, deviceid, op, _S_UNKNOWN_);
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 * @param devicetype
	 *            设备类型.
	 * @param deviceid
	 *            设备唯一编号.
	 */
	public void profile(String tz, String devicetype, String deviceid) {
		this.profile(tz, devicetype, deviceid, _S_UNKNOWN_);
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 * @param devicetype
	 *            设备类型.
	 */
	public void profile(String tz, String devicetype) {
		this.profile(tz, devicetype, _S_UNKNOWN_);
	}

	/**
	 * 设备基础属性。
	 * 
	 * @param tz
	 *            时区.
	 */
	public void profile(String tz) {
		this.profile(tz, _S_UNKNOWN_);
	}

	/**
	 * 设备基础属性。
	 */
	public void profile() {
		this.profile("+8");
	}

	/**
	 * 软件安装报送接口。
	 * 
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void install(String channelid) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("channelid", channelid);
		this.doHttpCall("install", data);
	}

	/**
	 * 软件安装报送接口。
	 * 
	 * @throws IOException
	 */
	public void install() throws IOException {
		this.install(_S_UNKNOWN_);
	}

	/**
	 * 用户注册账户报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param gender
	 *            Gender.f 代表女，Gender.m 代表男，Gender.o 代表其它.
	 * @throws IOException
	 */
	public void reged(String who, String serverid, String channelid,
			Gender gender) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("gender", gender);
		this.doHttpCall("reged", data);
	}

	/**
	 * 用户注册账户报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void reged(String who, String serverid, String channelid)
			throws IOException {
		this.reged(who, serverid, channelid, Gender.o);
	}

	/**
	 * 用户注册账户报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void reged(String who, String serverid) throws IOException {
		this.reged(who, serverid, _S_UNKNOWN_);
	}

	/**
	 * 用户注册账户报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @throws IOException
	 */
	public void reged(String who) throws IOException {
		this.reged(who, _S_UNKNOWN_);
	}

	/**
	 * 用户启动软件报送接口。
	 * 
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void startup(String channelid) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("channelid", channelid);
		this.doHttpCall("startup", data);
	}

	/**
	 * 用户启动软件报送接口。
	 * 
	 * @throws IOException
	 */
	public void startup() throws IOException {
		this.startup(_S_UNKNOWN_);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @param birthday
	 *            2013-10-10.
	 * @param gender
	 *            Gender.f 代表女，Gender.m 代表男，Gender.o 代表其它.
	 * @throws IOException
	 */
	public void loggedin(String who, String serverid, String channelid,
			int level, String birthday, Gender gender) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);
		data.put("birthday", birthday);
		data.put("gender", gender);
		this.doHttpCall("loggedin", data);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @param birthday
	 *            2013-10-10.
	 * @throws IOException
	 */
	public void loggedin(String who, String serverid, String channelid,
			int level, String birthday) throws IOException {
		this.loggedin(who, serverid, channelid, level, birthday, Gender.o);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @throws IOException
	 */
	public void loggedin(String who, String serverid, String channelid,
			int level) throws IOException {
		this.loggedin(who, serverid, channelid, level, _S_UNKNOWN_);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void loggedin(String who, String serverid, String channelid)
			throws IOException {
		this.loggedin(who, serverid, channelid, _I_UNKNOWN_);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void loggedin(String who, String serverid) throws IOException {
		this.loggedin(who, serverid, _S_UNKNOWN_);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @throws IOException
	 */
	public void loggedin(String who) throws IOException {
		this.loggedin(who, _S_UNKNOWN_);
	}

	/**
	 * 用户心跳报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void heartbeat(String who, String serverid, String channelid)
			throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		this.doHttpCall("hb", data);
	}

	/**
	 * 用户心跳报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void heartbeat(String who, String serverid) throws IOException {
		this.heartbeat(who, serverid, _S_UNKNOWN_);
	}

	/**
	 * 用户心跳报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @throws IOException
	 */
	public void heartbeat(String who) throws IOException {
		this.heartbeat(who, _S_UNKNOWN_);
	}

	/**
	 * 用户游戏时常报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param sst
	 *            开始时间，格式2013-10-10 15:43:22
	 * @param set
	 *            结束时间，格式2013-10-10 16:22:01
	 * @param stt
	 *            持续时常(set-sst)单位秒
	 * @throws IOException
	 */
	public void session(String who, String serverid, String channelid,
			String sst, String set, int stt) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("sst", sst);
		data.put("set", set);
		data.put("stt", stt);
		this.doHttpCall("session", data);
	}

	/**
	 * 用户游戏时常报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param sst
	 *            开始时间，格式2013-10-10 15:43:22
	 * @param set
	 *            结束时间，格式2013-10-10 16:22:01
	 * @throws IOException
	 */
	public void session(String who, String serverid, String channelid,
			String sst, String set) throws IOException {
		this.session(who, serverid, channelid, sst, set, _I_UNKNOWN_);
	}

	/**
	 * 用户游戏时常报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param sst
	 *            开始时间，格式2013-10-10 15:43:22
	 * @throws IOException
	 */
	public void session(String who, String serverid, String channelid,
			String sst) throws IOException {
		this.session(who, serverid, channelid, sst, _S_UNKNOWN_);
	}

	/**
	 * 用户游戏时常报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void session(String who, String serverid, String channelid)
			throws IOException {
		this.session(who, serverid, channelid, _S_UNKNOWN_);
	}

	/**
	 * 用户游戏时常报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void session(String who, String serverid) throws IOException {
		this.session(who, serverid, _S_UNKNOWN_);
	}

	/**
	 * 用户游戏时常报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @throws IOException
	 */
	public void session(String who) throws IOException {
		this.session(who, _S_UNKNOWN_);
	}

	/**
	 * 自定义事件/多维分析报送接口。 每个事件，最多只能包含32组key：value
	 * 
	 * @param who
	 *            用户ID.
	 * @param what
	 *            事件名称.
	 * @param extra
	 *            服务器编号.
	 * @param serverid
	 *            渠道编号.
	 * @param channelid
	 *            自定义事件属性
	 * @throws IOException
	 */
	public void event(String who, String what, Map extra, String serverid,
			String channelid) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		this.profiles.put("what", what);
		data.putAll(extra);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		this.doHttpCall(what, data);
	}

	/**
	 * 自定义事件/多维分析报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param what
	 *            事件名称.
	 * @param extra
	 *            服务器编号.
	 * @param serverid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void event(String who, String what, Map extra, String serverid)
			throws IOException {
		this.event(who, what, extra, serverid, _S_UNKNOWN_);
	}

	/**
	 * 自定义事件/多维分析报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param what
	 *            事件名称.
	 * @param extra
	 *            服务器编号.
	 * @throws IOException
	 */
	public void event(String who, String what, Map extra) throws IOException {
		this.event(who, what, extra, _S_UNKNOWN_);
	}

	/**
	 * 自定义事件/多维分析报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param what
	 *            事件名称.
	 * @throws IOException
	 */
	public void event(String who, String what) throws IOException {
		this.event(who, what, new HashMap());
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param amount
	 *            用户成功充值，充值的金额
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @param birthday
	 *            2013-10-10.
	 * @param gender
	 *            Gender.f 代表女，Gender.m 代表男，Gender.o 代表其它.
	 * @throws IOException
	 */
	public void payment(String who, int amount, String serverid,
			String channelid, int level, String birthday, Gender gender)
			throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("amount", amount);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);
		data.put("birthday", birthday);
		data.put("gender", gender);
		this.doHttpCall("payment", data);
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param amount
	 *            用户成功充值，充值的金额
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @param birthday
	 *            2013-10-10.
	 * @throws IOException
	 */
	public void payment(String who, int amount, String serverid,
			String channelid, int level, String birthday) throws IOException {
		this.payment(who, amount, serverid, channelid, level, birthday,
				Gender.o);
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param amount
	 *            用户成功充值，充值的金额
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void payment(String who, int amount, String serverid,
			String channelid, int level) throws IOException {
		this.payment(who, amount, serverid, channelid, level, _S_UNKNOWN_);
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param amount
	 *            用户成功充值，充值的金额
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void payment(String who, int amount, String serverid,
			String channelid) throws IOException {
		this.payment(who, amount, serverid, channelid, _I_UNKNOWN_);
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param amount
	 *            用户成功充值，充值的金额
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void payment(String who, int amount, String serverid)
			throws IOException {
		this.payment(who, amount, serverid, _S_UNKNOWN_);
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param amount
	 *            用户成功充值，充值的金额
	 * @throws IOException
	 */
	public void payment(String who, int amount) throws IOException {
		this.payment(who, amount, _S_UNKNOWN_);
	}

	/**
	 * 用户充值报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @throws IOException
	 */
	public void payment(String who) throws IOException {
		this.payment(who, _I_UNKNOWN_);
	}

	/**
	 * 经济相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param name
	 *            用户虚拟交易对象的名称.
	 * @param num
	 *            用户在此次虚拟交易中的，交易的物品的数量.
	 * @param totalprice
	 *            用户此次虚拟交易过程中的交易额.
	 * @param type
	 *            用户此次虚拟交易的类型,系统产出:SP 购买获得:BP 消费:C .
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @throws IOException
	 */
	public void economy(String who, String name, int num, int totalprice,
			EconomyType type, String serverid, String channelid, int level)
			throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("name", name);
		data.put("num", num);
		data.put("totalprice", totalprice);
		data.put("type", type);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);
		this.doHttpCall("economy", data);
	}

	/**
	 * 经济相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param name
	 *            用户虚拟交易对象的名称.
	 * @param num
	 *            用户在此次虚拟交易中的，交易的物品的数量.
	 * @param totalprice
	 *            用户此次虚拟交易过程中的交易额.
	 * @param type
	 *            用户此次虚拟交易的类型,系统产出:SP 购买获得:BP 消费:C .
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void economy(String who, String name, int num, int totalprice,
			EconomyType type, String serverid, String channelid)
			throws IOException {
		this.economy(who, name, num, totalprice, type, serverid, channelid,
				_I_UNKNOWN_);
	}

	/**
	 * 经济相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param name
	 *            用户虚拟交易对象的名称.
	 * @param num
	 *            用户在此次虚拟交易中的，交易的物品的数量.
	 * @param totalprice
	 *            用户此次虚拟交易过程中的交易额.
	 * @param type
	 *            用户此次虚拟交易的类型,系统产出:SP 购买获得:BP 消费:C .
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void economy(String who, String name, int num, int totalprice,
			EconomyType type, String serverid) throws IOException {
		this.economy(who, name, num, totalprice, type, serverid, _S_UNKNOWN_);
	}

	/**
	 * 经济相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param name
	 *            用户虚拟交易对象的名称.
	 * @param num
	 *            用户在此次虚拟交易中的，交易的物品的数量.
	 * @param totalprice
	 *            用户此次虚拟交易过程中的交易额.
	 * @param type
	 *            用户此次虚拟交易的类型,系统产出:Economy.sp 购买获得:Economy.bp 消费:Economy.c .
	 * @throws IOException
	 */
	public void economy(String who, String name, int num, int totalprice,
			EconomyType type) throws IOException {
		this.economy(who, name, num, totalprice, type, _S_UNKNOWN_);
	}

	/**
	 * 任务相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param id
	 *            任务的id.
	 * @param state
	 *            任务状态，接受:TastState.a； 完成:TastState.c
	 * @param type
	 *            任务类型.main：主线任务，new:主线，sub支线
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级.
	 * @throws IOException
	 */
	public void task(String who, String id, TaskState state, String type,
			String serverid, String channelid, int level) throws IOException {
		RYHashMap data = new RYHashMap();
		data.put("who", who);
		data.put("id", id);
		data.put("state", state);
		data.put("type", type);
		data.put("type", type);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);
		this.doHttpCall("task", data);
	}

	/**
	 * 任务相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param id
	 *            任务的id.
	 * @param state
	 *            任务状态，接受:TastState.a； 完成:TastState.c
	 * @param type
	 *            任务类型. main：主线任务，new:主线，sub支线
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */

	public void task(String who, String id, TaskState state, String type,
			String serverid, String channelid) throws IOException {
		this.task(who, id, state, type, serverid, channelid, _I_UNKNOWN_);
	}

	/**
	 * 任务相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param id
	 *            任务的id.
	 * @param state
	 *            任务状态，接受:TastState.a； 完成:TastState.c
	 * @param type
	 *            任务类型. main：主线任务，new:主线，sub支线
	 * @param serverid
	 *            服务器编号.
	 * @throws IOException
	 */
	public void task(String who, String id, TaskState state, String type,
			String serverid) throws IOException {
		this.task(who, id, state, type, serverid, _S_UNKNOWN_);
	}

	/**
	 * 任务相关报送接口。
	 * 
	 * @param who
	 *            用户ID.
	 * @param id
	 *            任务的id.
	 * @param state
	 *            任务状态，接受:TastState.a； 完成:TastState.c
	 * @param type
	 *            任务类型.  main：主线任务，new:主线，sub支线
	 * @throws IOException
	 */
	public void task(String who, String id, TaskState state, String type)
			throws IOException {
		this.task(who, id, state, type, _S_UNKNOWN_);
	}

	private void doHttpCall(String method, RYHashMap data) throws IOException {
		if (!method.equalsIgnoreCase("event")) {
			data.putAll(this.profiles);
		}
		RYHashMap postdata = new RYHashMap();

		postdata.put("appid", this.appkey);
		postdata.put("who", data.get("who", _S_UNKNOWN_));
		postdata.put("when", DateFormat.getDateTimeInstance()
				.format(new Date()));
		postdata.put("what", data.get("what", method));
		postdata.put("where", data.get("where", method));

		for (Object key : postdata.keySet()) {
			if (data.get(key) != null)
				data.remove(key);
		}

		postdata.put("context", data.toString());

		String dataString = getPostParamString(postdata);
		// System.out.println(dataString);
		this.sendData(dataString);
	}

	private void sendData(String dataString) throws IOException {
		URL endpoint = new URL(mEventsEndpoint);
		URLConnection conn = endpoint.openConnection();
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset=utf8");

		OutputStream postStream = null;
		try {
			postStream = conn.getOutputStream();
			postStream.write(dataString.getBytes());
		} finally {
			if (postStream != null) {
				postStream.close();
			}
		}

		InputStream responseStream = null;
		String response = null;
		try {
			responseStream = conn.getInputStream();
			response = slurp(responseStream);
		} finally {
			if (responseStream != null) {
				responseStream.close();
			}
		}
		// System.out.println(response);
	}

	private String getPostParamString(Map params) {
		if (params.size() == 0)
			return "";

		StringBuffer buf = new StringBuffer();
		Iterator keys = params.keySet().iterator();
		while (keys.hasNext()) {
			buf.append(buf.length() == 0 ? "" : "&");
			String key = (String) keys.next();
			buf.append(key).append("=").append(params.get(key));
		}
		return buf.toString();
	}

	private String slurp(InputStream in) throws IOException {
		final StringBuilder out = new StringBuilder();
		InputStreamReader reader = new InputStreamReader(in, "utf8");

		char[] readBuffer = new char[BUFFER_SIZE];
		int readCount = 0;
		do {
			readCount = reader.read(readBuffer);
			if (readCount > 0) {
				out.append(readBuffer, 0, readCount);
			}
		} while (readCount != -1);

		return out.toString();
	}

	private String appkey;
	private RYHashMap profiles = new RYHashMap();

	private final String mEventsEndpoint;
	private final String _S_UNKNOWN_ = "unknown";
	private final int _I_UNKNOWN_ = -1;
	private final int BUFFER_SIZE = 50;

	/**
	 * f 代表女，m 代表男，o 代表其它.
	 */
	private enum Gender {
		f, m, o;
	}

	/**
	 * 用户此次虚拟交易的类型,系统产出:sp 购买获得:bp 消费:c .
	 */
	private enum EconomyType {
		sp, bp, c;
	}

	/**
	 * 任务当前状况,完成:a 接受:c.
	 */
	private enum TaskState {
		a, c;
	}

	public static void main(String[] args) throws IOException {
		String who = "Sylar";
		String serverid = "测试一服";
		String channelid = "appstore";

		ReyunAPI api = new ReyunAPI("1edf4b9540a5e83c0febf1f4ac407224");
		api.profile("+8", "大黄蜂", "qweqweadfasdqw", "cmcc", "WIFI",
				"android 4.4", "480*320");
		api.install(channelid);
		api.startup(channelid);
		api.reged(who, serverid, channelid);
		api.loggedin(who, serverid, channelid);
		api.heartbeat(who, serverid, channelid);
		api.session(who, serverid, channelid, "2013-10-10 15:43:22",
				"2013-10-10 16:22:01", 1024);

		Map extra = new HashMap();
		extra.put("haha", 99);
		extra.put("java", "asdf");
		api.event(who, "javaclient", extra, serverid, channelid);
		api.payment(who, 50, serverid, channelid, 2, "2001-10-10", Gender.m);
		api.economy(who, "xxx", 10, 1000, EconomyType.bp, serverid, channelid,
				3);
		api.task(who, "第一关", TaskState.a, serverid, channelid, "xxx", 1);
	}
}
