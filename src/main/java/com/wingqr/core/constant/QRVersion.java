package com.wingqr.core.constant;

public enum QRVersion {
	MERCHANT("01"), CONSUMER("CPV01");
	private String code;

	private QRVersion(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
