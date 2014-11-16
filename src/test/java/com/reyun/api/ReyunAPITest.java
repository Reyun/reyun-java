package com.reyun.api;

import org.junit.BeforeClass;
import org.junit.Test;

import com.reyun.api.model.Event;
import com.reyun.api.model.Install;

public class ReyunAPITest {

	private static ReyunAPI api;
	
	@BeforeClass
	public static void init() {
		api = ReyunAPI.getInstance("1edf4b9540a5e83c0febf1f4ac407224");
	}
	
	@Test
	public void installTest() {
		Install install = api.createInstall();
		install.setDeviceid("1");
		install.setChannelid("testchannel");
		System.out.println(install);
//		api.request(install);
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
		System.out.println(event);
	}
	
	@Test
	public void heartbeatTest() {
		
	}
}
