package com.rc.publicrestrooms.error.exception;

import com.rc.publicrestrooms.error.ErrorCode;

import java.io.Serial;

public class BusinessException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 1614542236477807379L;
	private final ErrorCode errorCode;
	private final Object data;

	public BusinessException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
		this.data = null;
	}

	public BusinessException(ErrorCode errorCode){
		super(errorCode.getMessage());
		this.errorCode = errorCode;
		this.data = null;
	}

	public BusinessException(ErrorCode errorCode, Object data){
		super(errorCode.getMessage());
		this.errorCode = errorCode;
		this.data = data;
	}

	public ErrorCode getErrorCode(){
		return errorCode;
	}

	public Object getData(){
		return data;
	}

}
