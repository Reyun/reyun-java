package com.reyun.api.model;

import com.reyun.api.exception.ContextSizeTooLongException;
import com.reyun.api.exception.ParamRequiredException;

/**
 * Install
 * 
 * @author liruijie@reyun.com
 */
public class Install extends Model<Install> {

    public Install(String appid, int timeout) {
        super(appid, timeout);
        this.where = "install";
    }

    @Override
    protected void validate() throws ParamRequiredException, ContextSizeTooLongException {
        super.validate();
    }
}
