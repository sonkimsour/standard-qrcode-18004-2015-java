package com.stdqr.constant;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public enum QRCodeType {
	STATIC(11), DYNAMIC(12);
	private int code;
	
	private QRCodeType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
