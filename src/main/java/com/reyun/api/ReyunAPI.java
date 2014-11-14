package com.reyun.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.reyun.api.exception.AppidNotValidException;
import com.reyun.api.model.Economy;
import com.reyun.api.model.Event;
import com.reyun.api.model.Heartbeat;
import com.reyun.api.model.Install;
import com.reyun.api.model.Loggedin;
import com.reyun.api.model.Model;
import com.reyun.api.model.Payment;
import com.reyun.api.model.Quest;
import com.reyun.api.model.Register;
import com.reyun.api.model.Startup;
import com.reyun.api.util.ValidateUtil;

/**
 * 
 * @author ruijie liruijie0603@126.com
 * @date 2014-11-14
 */
public class ReyunAPI {

	private Logger log = Logger.getLogger(ReyunAPI.class);
	
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

	private static ReyunAPI instance;
	
	/**
	 * 
	 * @param appkey
	 *            应用appkey，需要从reyun后台申请
	 */
	private ReyunAPI(String appkey) {
		if (!ValidateUtil.isValid(appkey)) {
			throw new AppidNotValidException();
		}
		this.appkey = appkey;
		mEventsEndpoint = Config.BASE_ENDPOINT + "rest/";
	}
	
	public static ReyunAPI getInstance(String appkey) {
		if (null == instance) {
			instance = new ReyunAPI(appkey);
		}
		return instance;
	}
	
	public Install createInstall() {
		return new Install(appkey);
	}
	
	public Startup createStartup() {
		return new Startup(appkey);
	}
	
	public Register createRegister() {
		return new Register(appkey);
	}
	
	public Loggedin createLoggedin() {
		return new Loggedin(appkey);
	}
	
	public Payment createPayment() {
		return new Payment(appkey);
	}
	
	public Economy createEconomy() {
		return new Economy(appkey);
	}
	
	public Quest createQuest() {
		return new Quest(appkey);
	}
	
	public Event createEvent() {
		return new Event(appkey);
	}
	
	public Heartbeat createHeartbeat() {
		return new Heartbeat(appkey);
	}
	
	public void request(Model model) {
		try {
			model.validate();
			
			CloseableHttpClient client = HttpClients.createDefault();
			String url = mEventsEndpoint + model.method();
			HttpPost post = new HttpPost(url);
			log.info(url);
			
			post.setHeader("Content-Type", "application/json;charset=utf8");
			
			StringEntity se = new StringEntity(JSON.toJSONString(model));
			
			post.setEntity(se);
//			log.info(dataString);
			HttpResponse response = client.execute(post);
//			log.info(model.getWhat() + "[" + response.getStatusLine().getStatusCode() + "]:"
//					+ EntityUtils.toString(response.getEntity()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
