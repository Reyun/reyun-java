package com.reyun.api;

import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.reyun.api.model.Event;
import com.reyun.api.model.Install;

public class ReyunAPITest {

	private static ReyunAPI api;
	
	@BeforeClass
	public static void init() {
		api = ReyunAPI.getInstance("1edf4b9540a5e83c0febf1f4ac407224");
	}
	
	@Test
	public void fastJSONTest() {
		Install  install = api.createInstall();
//		install.setWho("testwho");
//		install.setChannelid("testchannel");
		install.setDeviceid("testdevice");
		install.setChannelid("channelid");
		System.out.println(JSON.toJSONString(install));
	}
	
	@Test
	public void installTest() {
		Install install = api.createInstall();
		install.setDeviceid("1");
		api.request(install);
	}
	
	@Test
	public void startupTest() {
		
	}
	
	@Test
	public void registerTest() {
		
	}
	
	@Test
	public void loggedinTest() {
		
	}
	
	@Test
	public void paymentTest() {
		
	}
	
	@Test
	public void economyTest() {
		
	}
	
	@Test
	public void questTest() {
		
	}
	
	@Test
	public void eventTest() {
		Event  event = api.createEvent();
//		install.setWho("testwho");
//		install.setChannelid("testchannel");
		event.setWhat("testdevice");
		System.out.println(JSON.toJSONString(event));
	}
	
	@Test
	public void heartbeatTest() {
		
	}
}
