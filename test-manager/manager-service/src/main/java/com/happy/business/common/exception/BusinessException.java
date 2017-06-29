package com.happy.business.common.exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	private int code = 9999;
	private String systemMessage;

	public BusinessException() {
		super();
	}

	public BusinessException(String mesg) {
		super(mesg);
	}

	public BusinessException(int code, String mesg) {
		super(mesg);
		this.code = code;
	}

	public BusinessException(String systemMessage, Exception ex) {
		this(9999, systemMessage, ex);
	}

	public BusinessException(int code, String mesg, Throwable rootCause) {
		super(mesg);
		this.code = code;
		rootCause.printStackTrace();
	}

	public int getCode() {
		return code;
	}

	public String getSystemMessage() {
		return systemMessage;
	}

}