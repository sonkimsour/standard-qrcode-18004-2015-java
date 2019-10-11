package com.stdqr.constant;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public enum QRCodeVersion {
	V1("01");
	private String textValue;
	
	private QRCodeVersion(String textValue) {
		this.textValue = textValue;
	}
	
	public String getTextValue() {
		return textValue;
	}
}
