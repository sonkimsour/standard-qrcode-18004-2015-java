package com.wingqr.core.constant;

public enum QRType {
	STATIC(11), DYNAMIC(12);
	private int code;
	
	private QRType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static QRType lookup(int code) {
		return code == 11 ? STATIC : DYNAMIC;
	}
}
