package com.reyun.api;

import redis.clients.jedis.Connection;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.reyun.api.exception.AppidNotValidException;
import com.reyun.api.exception.ConnectionException;
import com.reyun.api.model.Economy;
import com.reyun.api.model.Event;
import com.reyun.api.model.Heartbeat;
import com.reyun.api.model.Install;
import com.reyun.api.model.Loggedin;
import com.reyun.api.model.Payment;
import com.reyun.api.model.Quest;
import com.reyun.api.model.Register;
import com.reyun.api.model.Startup;
import com.reyun.api.util.ValidateUtil;

/**
 * @author ruijie liruijie@reyun.com
 */
public class ReyunAPI {

	private String appkey;

	private static Sender sender;
	
	private static ReyunAPI instance;
	
	private ReyunAPI(String appkey) {
		if (!ValidateUtil.isValid(appkey)) {
			throw new AppidNotValidException();
		}
		this.appkey = appkey;
	}
	
	/**
	 * 获取报送rest接口的ReyunAPI实例，appkey需要从热云后台申请
	 * @param appkey 游戏appkey
	 * @param timeout http连接超时时间
	 * @return ReyunAPI
	 */
	public static ReyunAPI getInstance(String appkey, int timeout) {
		if (null == instance) {
			syncInit(appkey);
		}
		if (null == sender) {
			syncHttpSender(timeout);
		}
		return instance;
	}
	
	/**
	 * 获取报送rest接口的ReyunAPI实例，appkey需要从热云后台申请，默认超时为2s
	 * @param appkey 游戏appkey
	 * @return ReyunAPI
	 */
	public static ReyunAPI getInstance(String appkey) {
		return getInstance(appkey, 2000);
	}
	
	/**
	 * 获取发送数据到redis的ReyunAPI实例，appkey需要从热云后台申请
	 * @param appkey 游戏appkey
	 * @param host redis host
	 * @param port redis port
	 * @param timeout redis连接超时时间
	 * @return ReyunAPI
	 * @throws JedisConnectionException
	 */
	public static ReyunAPI getInstanceWithBuffer(String appkey, String host, int port, int timeout) throws ConnectionException {
		if (null == instance) {
			syncInit(appkey);
		}
		if (null == sender) {
			try {
				Connection client = new Connection();
				client.setHost(host);
				client.setPort(port);
				client.setTimeout(timeout);
				client.connect();
				client.close();
			} catch (JedisConnectionException e) {
				throw new ConnectionException(e.getMessage(), e);
			}
			
			syncRedisSender(host, port, timeout);
		}
		return instance;
	}
	
	/**
	 * 获取发送数据到redis的ReyunAPI实例，appkey需要从热云后台申请，默认超时为2s
	 * @param appkey 游戏appkey
	 * @param host redis host
	 * @param port redis port
	 * @return ReyunAPI
	 * @throws ConnectionException
	 */
	public static ReyunAPI getInstanceWithBuffer(String appkey, String host, int port) throws ConnectionException {
		return getInstanceWithBuffer(appkey, host, port, 2000);
	}
	
	private static synchronized void syncInit(String appkey) {
        if (instance == null) {
            instance = new ReyunAPI(appkey);
        }
    }
	
	private static synchronized void syncHttpSender(int timeout) {
        if (sender == null) {
        	sender = new HttpSender(timeout);
        }
    }
	
	private static synchronized void syncRedisSender(String host, int port, int timeout) {
        if (sender == null) {
        	sender = new RedisSender(host, port, timeout);
        }
    }
	
	public Install createInstall() {
		return new Install(appkey, sender);
	}
	
	public Startup createStartup() {
		return new Startup(appkey, sender);
	}
	
	public Register createRegister() {
		return new Register(appkey, sender);
	}
	
	public Loggedin createLoggedin() {
		return new Loggedin(appkey, sender);
	}
	
	public Payment createPayment() {
		return new Payment(appkey, sender);
	}
	
	public Economy createEconomy() {
		return new Economy(appkey, sender);
	}
	
	public Quest createQuest() {
		return new Quest(appkey, sender);
	}
	
	public Event createEvent() {
		return new Event(appkey, sender);
	}
	
	public Heartbeat createHeartbeat() {
		return new Heartbeat(appkey, sender);
	}
}
