package com.stdqr.core;

import java.io.ByteArrayOutputStream;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public interface QRCodeField<T> extends Comparable<QRCodeField<?>> {

	public int getFieldId();
	
	public void write(ByteArrayOutputStream output);
	
}
