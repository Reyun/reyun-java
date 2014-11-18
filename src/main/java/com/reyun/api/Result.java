package com.reyun.api;

public class Result {

	private boolean status;
	
	private String requestUrl;
	
	private String response;
	
	private String request;
	
	private int httpcode;
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getHttpcode() {
		return httpcode;
	}

	public void setHttpcode(int httpcode) {
		this.httpcode = httpcode;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
