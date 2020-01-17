package com.wingqr.core.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;

public interface QRPackager<K> {
	
	public K getFieldId();
	
	public QRValueType getValueType();
	
	public int getLength();
	
	public boolean isRequired();

	public String getTitle();
	
	public K[] getReferences();
	
	public <V> byte[] encode(K fieldId, V value);

	public QRField<K> decode(K fieldId, String value, QRPackager<K> packager);

}
