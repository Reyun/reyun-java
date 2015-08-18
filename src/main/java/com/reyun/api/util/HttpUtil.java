package com.reyun.api.util;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.reyun.api.Result;
import com.reyun.api.exception.ReyunTimeoutException;
import com.reyun.api.model.Model;

/**
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月17日
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final String mEventsEndpoint = "http://log.reyun.com/receive/rest/";

    private static HttpClientBuilder httpBulder;
    private static PoolingHttpClientConnectionManager connectionManager;

    static {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(500);
        connectionManager.setDefaultMaxPerRoute(500);
        httpBulder = HttpClients.custom();
        httpBulder.setConnectionManager(connectionManager);

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                PoolStats stats = connectionManager.getTotalStats();
                logger.debug(stats.toString());
            }
        }, 5, 30, TimeUnit.SECONDS);
    }

    @SuppressWarnings("rawtypes")
    public static final Result post(Model model, int timeout) throws ConnectException, ReyunTimeoutException, IOException {
        Result result = new Result();

        try {
            CloseableHttpClient client = httpBulder.build();
            String url = mEventsEndpoint + model.method();

            HttpPost post = new HttpPost(url);
            post.setHeader("Content-Type", "application/json;charset=UTF-8");

            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
            post.setConfig(requestConfig);

            String request = model.toString();
            StringEntity se = new StringEntity(request, Charset.forName("UTF-8"));
            post.setEntity(se);

            CloseableHttpResponse response = client.execute(post);

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

            response.close();
        } catch (ConnectTimeoutException | SocketTimeoutException e) {
            throw new ReyunTimeoutException(e);
        } catch (ConnectException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return result;
    }
}
