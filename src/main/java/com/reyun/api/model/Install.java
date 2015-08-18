package com.reyun.api.model;

import com.reyun.api.exception.ParamRequiredException;
import com.reyun.api.util.ValidateUtil;

/**
 * Install
 * 
 * @author liruijie@reyun.com
 * @date 2015年8月18日
 */
public class Install extends Model<Install> {

    public Install(String appid, int timeout) {
        super(appid, timeout);
        this.where = "install";
    }

    @Override
    protected void validate() throws ParamRequiredException {
        if (!ValidateUtil.isValid(context.get("deviceid"))) {
            throw new ParamRequiredException("deviceid must be set in install");
        }
    }
}
