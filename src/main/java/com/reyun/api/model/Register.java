package com.reyun.api.model;

import com.reyun.api.enumeration.Gender;
import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;

/**
 * Register
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Register extends Model<Register> {

    public Register(String appid, int timeout) {
        super(appid, timeout);
        this.where = "register";
    }

    /**
     * 设置账户ID
     * 
     * @param who
     */
    public Register setWho(String who) {
        this.who = who;
        return this;
    }

    /**
     * 设置账户类型
     * 
     * @param accounttype
     */
    public Register setAccounttype(String accounttype) {
        context.put("accounttype", accounttype);
        return this;
    }

    /**
     * 设置账户性别 Gender.f 女, Gender.m 男, Gender.o 其它, Gender.unknown 未知
     * 
     * @param gender
     */
    public Register setGender(Gender gender) {
        context.put("gender", String.valueOf(gender));
        return this;
    }

    /**
     * 设置年龄
     * 
     * @param age
     */
    public Register setAge(int age) {
        context.put("age", String.valueOf(age));
        return this;
    }

    /**
     * 设置服务器id
     * 
     * @param serverid
     */
    public Register setServerid(String serverid) {
        context.put("serverid", serverid);
        return this;
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
        super.checkWho();
    }
}
