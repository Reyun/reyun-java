package com.reyun.api;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reyun.api.enumeration.Gender;
import com.reyun.api.enumeration.QuestStatus;
import com.reyun.api.model.Economy;
import com.reyun.api.model.Event;
import com.reyun.api.model.Heartbeat;
import com.reyun.api.model.Install;
import com.reyun.api.model.Loggedin;
import com.reyun.api.model.Payment;
import com.reyun.api.model.Quest;
import com.reyun.api.model.Register;
import com.reyun.api.model.Startup;

public class ReyunAPITest {

	private static ReyunAPI api;
	
	@BeforeClass
	public static void init() {
		api = ReyunAPI.getInstance("1edf4b9540a5e83c0febf1f4ac407224");
	}
	
	/**
	 * 玩家首次打开应用统计测试
	 */
	@Test
	public void installTest() {
		Install install = api.createInstall();
		
		// required parameters
		install.setDeviceid("xxxxxxxxxx");
		
		// unrequired parameters
		install.setChannelid("appstore");
		
		Result result = api.post(install);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家打开应用统计测试
	 */
	@Test
	public void startupTest() {
		Startup startup = api.createStartup();
		
		// required parameters
		startup.setDeviceid("xxxxxxxxxx");
		
		// unrequired parameters
		startup.setChannelid("appstore");
		startup.setTZ("+8");
		startup.setDevicetype("ios");
		startup.setOP("cmcc");
		startup.setNetwork("3g");
		startup.setOS("ios");
		startup.setResolution("800*600");
		
		Result result = api.post(startup);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家服务器注册统计测试
	 */
	@Test
	public void registerTest() {
		Register register = api.createRegister();
		
		// required parameters
		register.setWho("Sylar");
		register.setDeviceid("xxxxxxxxxx");
		
		// unrequired parameters
		register.setAccounttype("qq");
		register.setGender(Gender.f);
		register.setAge(20);
		register.setServerid("测试一服");
		register.setChannelid("appstore");
		
		Result result = api.post(register);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家登陆统计测试
	 */
	@Test
	public void loggedinTest() {
		Loggedin loggedin = api.createLoggedin();
		
		// required parameters
		loggedin.setWho("Sylar");
		loggedin.setDeviceid("xxxxxxxxxx");
		
		// unrequired parameters
		loggedin.setServerid("测试一服");
		loggedin.setChannelid("appstore");
		loggedin.setLevel(11);
		
		Result result = api.post(loggedin);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家充值统计测试
	 */
	@Test
	public void paymentTest() {
		Payment payment = api.createPayment();
		
		// required parameters
		payment.setWho("Sylar");
		payment.setDeviceid("xxxxxxxxxx");
		payment.setTransactionid("0000001");
		payment.setPaymenttype("IAP");
		payment.setCurrencytype("CNY");
		payment.setCurrencyamount("100");
		payment.setVirtualcoinamount("10000");
		payment.setIapname("keys");
		payment.setIapamount("1");
		
		// unrequired parameters
		payment.setServerid("测试一服");
		payment.setChannelid("appstore");
		payment.setLevel(11);
		
		Result result = api.post(payment);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家游戏内虚拟交易统计测试
	 */
	@Test
	public void economyTest() {
		Economy economy = api.createEconomy();
		
		// required parameters
		economy.setWho("Sylar");
		economy.setDeviceid("xxxxxxxxxx");
		economy.setItemname("xxx");
		economy.setItemamount("10");
		economy.setItemtotalprice("1000");
		
		// unrequired parameters
		economy.setServerid("测试一服");
		economy.setChannelid("appstore");
		economy.setLevel(11);
		
		Result result = api.post(economy);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家的任务/关卡/副本统计测试
	 */
	@Test
	public void questTest() {
		Quest quest = api.createQuest();
		
		// required parameters
		quest.setWho("Sylar");
		quest.setDeviceid("xxxxxxxxxx");
		quest.setQuestid("第一关");
		quest.setQueststatus(QuestStatus.a);
		quest.setQuesttype("new");
		
		// unrequired parameters
		quest.setServerid("测试一服");
		quest.setChannelid("appstore");
		quest.setLevel(11);
		
		Result result = api.post(quest);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家自定义事件统计测试
	 */
	@Test
	public void eventTest() {
		Event  event = api.createEvent();

		// required parameters
		event.setWho("Sylar");
		event.setWhat("kill_boss");
		event.setDeviceid("xxxxxxxxxx");
		
		// unrequired parameters
		event.setServerid("测试一服");
		event.setChannelid("appstore");
		
		Map<String, String> extra = new HashMap<String, String>();
		extra.put("moneydrop", "100");
		extra.put("boosname", "diablo");
		
		event.setUserDefine(extra);
		
		Result result = api.post(event);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
	
	/**
	 * 玩家在线统计测试
	 */
	@Test
	public void heartbeatTest() {
		Heartbeat heartbeat = api.createHeartbeat();
		
		// required parameters
		heartbeat.setWho("Sylar");
		heartbeat.setDeviceid("xxxxxxxxxx");
		
		// unrequired parameters
		heartbeat.setServerid("测试一服");
		heartbeat.setChannelid("appstore");
		heartbeat.setLevel(11);
		
		Result result = api.post(heartbeat);
		
		assertTrue(result.getStatus());
		assertEquals(200, result.getHttpcode());
		
		System.out.println("requesturl: " + result.getRequestUrl());
		System.out.println("requestjson: " + result.getRequest());
		System.out.println("responsejson: " + result.getResponse());
	}
}
