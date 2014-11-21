package com.reyun.api;

import java.net.SocketTimeoutException;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.reyun.api.exception.ConnectionException;
import com.reyun.api.exception.TimeoutException;
import com.reyun.api.model.Model;

public class HttpSender extends Sender {

	private final String mEventsEndpoint = "http://log.reyun.com/receive/rest/";
	
	private int timeout;
	
	public HttpSender(int timeout) {
		this.timeout = timeout;
	}
	
	@Override
	public Result post(Model model) throws ConnectionException, TimeoutException {
		Result result = new Result();
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			String url = mEventsEndpoint + model.method();
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json;charset=utf8");
			
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
			post.setConfig(requestConfig);
			
			String request = model.toString();
			StringEntity se = new StringEntity(request);
			post.setEntity(se);
			HttpResponse response = client.execute(post);
			
			String responseStr = EntityUtils.toString(response.getEntity());
			
			JSONObject responseJSON = JSON.parseObject(responseStr);
			
			JSONObject resultJSON = new JSONObject();
			resultJSON.put("url", url);
			resultJSON.put("requestStr", request);
			resultJSON.put("httpcode", response.getStatusLine().getStatusCode());
			resultJSON.put("responseStr", responseStr);
			
			result.setMessage(resultJSON.toJSONString());
			
			if (responseJSON.getIntValue("status") == 0) {
				result.setStatus(true);
			} else {
				result.setStatus(false);
			}
		} catch (SocketTimeoutException e) {
			result.setStatus(false);
			result.setMessage(e.getMessage());
			throw new TimeoutException(e.getMessage(), e);
		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage(e.getMessage());
			throw new ConnectionException(e.getMessage(), e);
		}
		
		return result;
	}
}
