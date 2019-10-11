package com.stdqr.core;

import com.stdqr.constant.QRCodeValueType;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public interface QRCodePackager {
	
	public int getFieldId();
	
	public QRCodeValueType getValueType();
	
	public int getLength();
	
	public boolean isRequired();

	public String getTitle();
	
	public int[] getReferences();
	
	public <T> byte[] pack(int fieldId, T value);

}
