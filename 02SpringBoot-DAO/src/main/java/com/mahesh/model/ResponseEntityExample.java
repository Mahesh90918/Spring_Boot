package com.mahesh.model;

public class ResponseEntityExample {
	int statuscode;
	Object msg;

	public ResponseEntityExample() {

	}

	public ResponseEntityExample(int statuscode, Object msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ResponseEntityExample [statuscode=" + statuscode + ", msg=" + msg + "]";
	}

}
