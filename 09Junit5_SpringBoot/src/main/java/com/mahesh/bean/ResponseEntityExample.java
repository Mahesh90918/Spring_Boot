package com.mahesh.bean;

public class ResponseEntityExample {
	private int statusCode;
	private Object msg;

	public ResponseEntityExample() {
		// TODO Auto-generated constructor stub
	}

	public ResponseEntityExample(int statusCode, Object msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResponseEntityExample" + " [statusCode=" + statusCode + ", msg=" + msg + "]";
	}

}
