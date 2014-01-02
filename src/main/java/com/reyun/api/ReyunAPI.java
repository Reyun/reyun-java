package com.reyun.api;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.map.DefaultedMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONValue;

/**
 * Hello world!
 * 
 */
public class ReyunAPI {

	private Logger log = Logger.getLogger(ReyunAPI.class);

	/**
	 * 
	 * @param appkey
	 *            应用appkey，需要从reyun后台申请
	 */
	public ReyunAPI(String appkey) {

		this.appkey = appkey;
		mEventsEndpoint = Config.BASE_ENDPOINT + "/rest/";
	}

	/**
	 * 软件安装报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 * 
	 */
	public void install(String deviceid, String serverid, String channelid)
			throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		this.doHttpCall("install", data);
	}

	/**
	 * 用户启动软件报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param tz
	 *            时区
	 * @param devicetype
	 *            设备类型
	 * @param op
	 *            运营商.
	 * @param network
	 *            网络制式2G,3G,WIFI.
	 * @param os
	 *            操作系统.
	 * @param resolution
	 *            分辨率.
	 * @throws IOException
	 */
	public void startup(String deviceid, String serverid, String channelid,
			String tz, String devicetype, String op, String network, String os,
			String resolution) throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("tz", tz);
		data.put("devicetype", devicetype);
		data.put("op", op);
		data.put("network", network);
		data.put("os", os);
		data.put("resolution", resolution);

		this.doHttpCall("startup", data);
	}

	/**
	 * 用户注册账户报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param accountType
	 *            账户类型
	 * 
	 * @param gender
	 *            Gender.f 代表女，Gender.m 代表男，Gender.o 代表其它,Gender.unknown 未知
	 * @param age
	 *            用户年龄
	 * @throws IOException
	 */
	public void register(String deviceid, String who, String serverid,
			String channelid, String accountType, Gender gender, int age)
			throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("accountType", accountType);
		data.put("gender", String.valueOf(gender));
		data.put("age", age);
		this.doHttpCall("register", data);
	}

	/**
	 * 用户登陆报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @param level
	 *            用户等级
	 * @throws IOException
	 */
	public void loggedin(String deviceid, String who, String serverid,
			String channelid, int level) throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);

		this.doHttpCall("loggedin", data);
	}

	/**
	 * 用户充值报送接口
	 * 
	 * @param deviceid
	 *            设备唯一编号
	 * @param who
	 *            用户ID.
	 * @param transactionId
	 *            交易流水号
	 * @param paymentType
	 *            支付类型，例如支付宝，银联，苹果、谷歌官方等;如果是系统赠送的，paymentType为：FREE.
	 * @param currencyType
	 *            货币类型，按照国际标准组织ISO
	 *            4217中规范的3位字母，例如CNY人民币、USD美金等，详情,http://zh.wikipedia
	 *            .org/wiki/ISO_4217.
	 * @param currencyAmount
	 *            支付的真实货币的金额.
	 * @param virtualCoinAmount
	 *            通过充值获得的游戏内货币的数量
	 * @param iapName
	 *            游戏内购买道具的名称
	 * @param iapAmount
	 *            游戏内购买道具的数量
	 * @param serverid
	 *            服务器编号
	 * @param channelid
	 *            渠道编号
	 * @param level
	 *            用户等级
	 * @param age
	 *            年龄.
	 * @param gender
	 *            f 代表女，m 代表男，o 代表其它.
	 * @throws IOException
	 */
	public void payment(String deviceid, String who, String transactionId,
			String paymentType, String currencyType, int currencyAmount,
			int virtualCoinAmount, String iapName, int iapAmount,
			String serverid, String channelid, int level) throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("transactionId", transactionId);
		data.put("paymentType", paymentType);
		data.put("currencyType", currencyType);
		data.put("currencyAmount", currencyAmount);
		data.put("virtualCoinAmount", virtualCoinAmount);
		data.put("iapName", iapName);
		data.put("iapAmount", iapAmount);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);

		this.doHttpCall("payment", data);
	}

	/**
	 * 经济相关报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
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
	public void economy(String deviceid, String who, String itemName,
			int itemAmount, int itemTotalPrice, String serverid,
			String channelid, int level) throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("itemName", itemName);
		data.put("itemAmount", itemAmount);
		data.put("itemTotalPrice", itemTotalPrice);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);
		this.doHttpCall("economy", data);
	}

	/**
	 * 任务相关报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
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
	public void quest(String deviceid, String who, String questid,
			QuestStatus status, String type, String serverid, String channelid,
			int level) throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("questid", questid);
		data.put("queststatus", String.valueOf(status));
		data.put("questtype", type);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		data.put("level", level);
		this.doHttpCall("quest", data);
	}

	/**
	 * 自定义事件/多维分析报送接口。 每个事件，最多只能包含32组key：value
	 * 
	 * @param deviceid
	 *            设备唯一编号
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
	public void event(String deviceid, String who, String what,
			String serverid, String channelid, Map<String, Object> extra)
			throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("what", what);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		// data.put("context", extra);
		data.putAll(extra);
		this.doHttpCall("event", data);
	}

	/**
	 * 用户心跳报送接口。
	 * 
	 * @param deviceid
	 *            设备唯一编号
	 * @param who
	 *            用户ID.
	 * @param serverid
	 *            服务器编号.
	 * @param channelid
	 *            渠道编号.
	 * @throws IOException
	 */
	public void heartbeat(String deviceid, String who, String serverid,
			String channelid) throws IOException {
		DefaultedMap data = new DefaultedMap(_S_UNKNOWN_);
		data.put("deviceid", deviceid);
		data.put("who", who);
		data.put("serverid", serverid);
		data.put("channelid", channelid);
		this.doHttpCall("heartbeat", data);
	}

	private void doHttpCall(String method, DefaultedMap data)
			throws IOException {

		DefaultedMap postdata = new DefaultedMap(_S_UNKNOWN_);

		postdata.put("appid", this.appkey);
		postdata.put("who", data.get("who"));
		postdata.put("when", DateFormat.getDateTimeInstance()
				.format(new Date()));
		postdata.put("what", method);
		postdata.put("where", method);

		for (Object key : postdata.keySet()) {
			data.remove(key);
		}

		postdata.put("context", data);

		String dataString = JSONValue.toJSONString(postdata);
		this.sendData(method, dataString);
	}

	private void sendData(String method, String dataString)
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		String url = mEventsEndpoint + method;
		HttpPost post = new HttpPost(url);
		log.info(url);
		post.setHeader("Content-Type", "application/json;charset=utf8");
		StringEntity se = new StringEntity(dataString);
		post.setEntity(se);
		log.info(dataString);
		HttpResponse response = client.execute(post);
		log.info(method + "[" + response.getStatusLine().getStatusCode() + "]:"
				+ EntityUtils.toString(response.getEntity()));

	}

	public final String _S_UNKNOWN_ = "unknown";
	public final int _I_UNKNOWN_ = -1;

	private String appkey;

	private final String mEventsEndpoint;

	/**
	 * f 代表女，m 代表男，o 代表其它.
	 */
	public enum Gender {
		f, m, o, unknown;
	}

	/**
	 * 任务当前状况,完成:a 接受:c.
	 */
	public enum QuestStatus {
		a, c, f;
	}

}
