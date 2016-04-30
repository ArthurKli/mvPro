package com.admin.bean;

public class BaseMsg {
	private static final long serialVersionUID = 1L;
	
	private int rtnCode;
	
	private String msg;


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setMsgAndCode(String msg, int code){
		this.msg = msg;
		this.setRtnCode(code);
	}

	public int getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(int rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
}
