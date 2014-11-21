package com.reyun.api;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.alibaba.fastjson.JSONObject;
import com.reyun.api.exception.ConnectionException;
import com.reyun.api.exception.TimeoutException;
import com.reyun.api.model.Model;

public class RedisSender extends Sender {

	private JedisPool pool;
	
	private String host;
	private int port;
	
	public RedisSender(String host, int port, int timeout) {
		pool = new JedisPool(new JedisPoolConfig(), host, port, timeout);
		this.host = host;
		this.port = port;
	}
	
	@Override
	public Result post(Model model) throws ConnectionException, TimeoutException {
		Result result = new Result();
		try {
			Jedis jedis = pool.getResource();
			Pipeline pipeline = jedis.pipelined();
			
			JSONObject json = new JSONObject();
			json.put("method", model.method());
			json.put("data", model.toString());
			json.put("retry", 0);
			
			String dataStr = json.toJSONString();
			
			pipeline.rpush("reyun", dataStr);
			pipeline.sync();
			
			pool.returnResource(jedis);
			
			JSONObject resultJSON = new JSONObject();
			resultJSON.put("data", dataStr);
			resultJSON.put("result", "rpush the data to redis " + host + ":" + port);
			
			result.setStatus(true);
			result.setMessage(resultJSON.toJSONString());
		} catch (JedisConnectionException e) {
			result.setStatus(false);
			result.setMessage(e.getMessage());
			throw new ConnectionException(e.getMessage(), e);
		}
		
		return result;
	}
}
