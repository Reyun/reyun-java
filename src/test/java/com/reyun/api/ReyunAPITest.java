package com.reyun.api;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reyun.api.enumeration.Gender;
import com.reyun.api.enumeration.QuestStatus;
import com.reyun.api.exception.ConnectionException;
import com.reyun.api.exception.TimeoutException;

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
		Result result = null;
		try {
			result = api.createInstall()
		
			// required parameters
			.setDeviceid("xxxxxxxxxx")
			
			// unrequired parameters
			.setChannelid("appstore")
			
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家打开应用统计测试
	 */
	@Test
	public void startupTest() {
		Result result = null;
		try {
			result = api.createStartup()
			
			// required parameters
			.setDeviceid("xxxxxxxxxx")
			
			// unrequired parameters
			.setChannelid("appstore")
			.setTZ("+8")
			.setDevicetype("ios")
			.setOP("cmcc")
			.setNetwork("3g")
			.setOS("ios")
			.setResolution("800*600")
			
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家服务器注册统计测试
	 */
	@Test
	public void registerTest() {
		Result result = null;
		try {
			result = api.createRegister()
			
			// required parameters
			.setWho("Sylar")
			.setDeviceid("xxxxxxxxxx")
			
			// unrequired parameters
			.setAccounttype("qq")
			.setGender(Gender.f)
			.setAge(20)
			.setServerid("测试一服")
			.setChannelid("appstore")
		
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家登陆统计测试
	 */
	@Test
	public void loggedinTest() {
		Result result = null;
		try {
			result = api.createLoggedin()
			
			// required parameters
			.setWho("Sylar")
			.setDeviceid("xxxxxxxxxx")
			
			// unrequired parameters
			.setServerid("测试一服")
			.setChannelid("appstore")
			.setLevel(11)
		
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家充值统计测试
	 */
	@Test
	public void paymentTest() {
		Result result = null;
		try {
			result = api.createPayment()
			
			// required parameters
			.setWho("Sylar")
			.setDeviceid("xxxxxxxxxx")
			.setTransactionid("0000001")
			.setPaymenttype("IAP")
			.setCurrencytype("CNY")
			.setCurrencyamount("100")
			.setVirtualcoinamount("10000")
			.setIapname("keys")
			.setIapamount("1")
			
			// unrequired parameters
			.setServerid("测试一服")
			.setChannelid("appstore")
			.setLevel(11)
			
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家游戏内虚拟交易统计测试
	 */
	@Test
	public void economyTest() {
		Result result = null;
		try {
			result = api.createEconomy()
			
			// required parameters
			.setWho("Sylar")
			.setDeviceid("xxxxxxxxxx")
			.setItemname("xxx")
			.setItemamount("10")
			.setItemtotalprice("1000")
			
			// unrequired parameters
			.setServerid("测试一服")
			.setChannelid("appstore")
			.setLevel(11)
		
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家的任务/关卡/副本统计测试
	 */
	@Test
	public void questTest() {
		Result result = null;
		try {
			result = api.createQuest()
			
			// required parameters
			.setWho("Sylar")
			.setDeviceid("xxxxxxxxxx")
			.setQuestid("第一关")
			.setQueststatus(QuestStatus.a)
			.setQuesttype("new")
			
			// unrequired parameters
			.setServerid("测试一服")
			.setChannelid("appstore")
			.setLevel(11)
			
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家自定义事件统计测试
	 */
	@Test
	public void eventTest() {
		Result result = null;
		try {
			Map<String, String> extra = new HashMap<String, String>();
			extra.put("moneydrop", "100");
			extra.put("boosname", "diablo");
			
			result = api.createEvent()
	
			// required parameters
			.setWho("Sylar")
			.setWhat("kill_boss")
			.setDeviceid("xxxxxxxxxx")
			
			// unrequired parameters
			.setServerid("测试一服")
			.setChannelid("appstore")
			.setUserDefine(extra)
		
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
	
	/**
	 * 玩家在线统计测试
	 */
	@Test
	public void heartbeatTest() {
		Result result = null;
		try {
			result = api.createHeartbeat()
			
			// required parameters
			.setWho("Sylar")
			.setDeviceid("xxxxxxxxxx")
			
			// unrequired parameters
			.setServerid("测试一服")
			.setChannelid("appstore")
			.setLevel(11)
			
			.post();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		assertTrue(result.getStatus());
		
		System.out.println(result.getMessage());
	}
}
