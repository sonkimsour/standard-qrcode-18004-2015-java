package com.wingqr.core.field;

import java.io.ByteArrayOutputStream;

public interface QRField<K> {

	public K getFieldId();
	
	public Object getValue();
	
	public void write(ByteArrayOutputStream output);
	
}
