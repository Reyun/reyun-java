package com.reyun.api;

import com.reyun.api.exception.ConnectionException;
import com.reyun.api.exception.TimeoutException;
import com.reyun.api.model.Model;

public abstract class Sender {

	public abstract Result post(Model model) throws ConnectionException, TimeoutException;
}
