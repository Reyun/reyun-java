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

import com.reyun.api.exception.AppidNotValidException;
import com.reyun.api.exception.SystemException;
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
 * @author ruijie liruijie@reyun.com
 * @date 2014-11-14
 */
public class ReyunAPI {

	private Logger log = Logger.getLogger(ReyunAPI.class);
	
	private String appkey;

	private final String mEventsEndpoint;

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
			CloseableHttpClient client = HttpClients.createDefault();
			String url = mEventsEndpoint + model.method();
			HttpPost post = new HttpPost(url);
			log.info(url);
			
			post.setHeader("Content-Type", "application/json;charset=utf8");
			
			StringEntity se = new StringEntity(model.toJSONString());
			
			post.setEntity(se);
			HttpResponse response = client.execute(post);
//			log.info(model.getWhat() + "[" + response.getStatusLine().getStatusCode() + "]:"
//					+ EntityUtils.toString(response.getEntity()));
		} catch (UnsupportedEncodingException e) {
			throw new SystemException(e.getMessage(), e);
		} catch (ClientProtocolException e) {
			throw new SystemException(e.getMessage(), e);
		} catch (IOException e) {
			throw new SystemException(e.getMessage(), e);
		}
	}
}
