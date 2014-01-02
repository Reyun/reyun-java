package com.reyun.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.reyun.api.ReyunAPI;
import com.reyun.api.ReyunAPI.Gender;
import com.reyun.api.ReyunAPI.QuestStatus;

public class ReyunAPIExample {

	public static void main(String[] args) throws IOException {

		String who = "Sylar";
		String serverid = "测试一服";
		String channelid = "appstore";
		String deviceid = "xxxxxxxxxx";

		ReyunAPI api = new ReyunAPI("1edf4b9540a5e83c0febf1f4ac407224");
		// api.install(deviceid,serverid,channelid);
		// api.startup(deviceid,serverid,channelid,"+8","ios","cmcc","3g","ios","800*600");
		// api.register(deviceid,who, serverid, channelid,"qq",Gender.f,19);
		// api.loggedin(deviceid,who, serverid, channelid,11);
		// api.payment(deviceid,who, "0000001", "IAP", "CNY", 100, 10000,
		// "keys", 1,api._S_UNKNOWN_, api._S_UNKNOWN_, 32);

		// api.economy(deviceid, who, "xxx", 10, 1000, serverid, channelid, 3);
		// api.quest(deviceid,who, "第一关", QuestStatus.a, serverid, channelid,
		// "xxx", 1);

//		Map<String, Object> extra = new HashMap<String, Object>();
//		extra.put("haha", 99);
//		extra.put("java", "asdf");
//		api.event(deviceid, who, "javaclient", serverid, channelid, extra);
		
		 api.heartbeat(deviceid,who, serverid, channelid);

	}
}
