package com.reyun.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.reyun.api.ReyunAPI;
import com.reyun.api.ReyunAPI.Gender;
import com.reyun.api.ReyunAPI.TaskState;

public class ReyunAPIExample {

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

		Map extra = new HashMap();
		extra.put("haha", 99);
		extra.put("java", "asdf");
		api.event(who, "javaclient", extra, serverid, channelid);
		api.payment(who, "0000001", "IAP", "CNY", 100, 10000, "keys", 1,
				api._S_UNKNOWN_, api._S_UNKNOWN_, 7, 21, Gender.f);
		api.economy(who, "xxx", 10, 1000, serverid, channelid, 3);
		api.task(who, "第一关", TaskState.a, serverid, channelid, "xxx", 1);

	}
}
