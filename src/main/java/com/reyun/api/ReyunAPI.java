package com.reyun.api;

import com.reyun.api.exception.AppidNotValidException;
import com.reyun.api.model.Economy;
import com.reyun.api.model.Event;
import com.reyun.api.model.Heartbeat;
import com.reyun.api.model.Install;
import com.reyun.api.model.Loggedin;
import com.reyun.api.model.Payment;
import com.reyun.api.model.Quest;
import com.reyun.api.model.Register;
import com.reyun.api.model.Startup;
import com.reyun.api.util.ValidateUtil;

/**
 * reyun java sdk
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月15日
 */
public class ReyunAPI {

    private String appkey;

    private int timeout;

    private static ReyunAPI instance;

    private ReyunAPI(String appkey, int timeout) throws AppidNotValidException {
        if ( ! ValidateUtil.isValid(appkey)) {
            throw new AppidNotValidException();
        }
        this.appkey = appkey;
        this.timeout = timeout;
    }

    /**
     * 获取报送rest接口的ReyunAPI实例，appkey需要从热云后台申请，默认超时为2s
     * 
     * @param appkey
     *            游戏appkey
     * @return ReyunAPI
     */
    public static final ReyunAPI getInstance(String appkey) throws AppidNotValidException {
        return getInstance(appkey, 2000);
    }

    /**
     * 获取报送rest接口的ReyunAPI实例，appkey需要从热云后台申请
     * 
     * @param appkey
     *            游戏appkey
     * @param timeout
     *            http连接超时时间
     * @return ReyunAPI
     */
    public static final ReyunAPI getInstance(String appkey, int timeout) throws AppidNotValidException {
        if (null == instance) {
            syncInit(appkey, timeout);
        }
        return instance;
    }

    private static synchronized void syncInit(String appkey, int timeout) throws AppidNotValidException {
        if (instance == null) {
            instance = new ReyunAPI(appkey, timeout);
        }
    }

    public Install createInstall() {
        return new Install(appkey, timeout);
    }

    public Startup createStartup() {
        return new Startup(appkey, timeout);
    }

    public Register createRegister() {
        return new Register(appkey, timeout);
    }

    public Loggedin createLoggedin() {
        return new Loggedin(appkey, timeout);
    }

    public Payment createPayment() {
        return new Payment(appkey, timeout);
    }

    public Economy createEconomy() {
        return new Economy(appkey, timeout);
    }

    public Quest createQuest() {
        return new Quest(appkey, timeout);
    }

    public Event createEvent() {
        return new Event(appkey, timeout);
    }

    public Heartbeat createHeartbeat() {
        return new Heartbeat(appkey, timeout);
    }
}
