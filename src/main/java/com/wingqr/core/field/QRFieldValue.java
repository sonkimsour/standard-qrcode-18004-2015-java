package com.wingqr.core.field;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.wingqr.core.exception.QRException;
import com.wingqr.core.packager.QRPackager;

public final class QRFieldValue<K, V> implements QRField<K> {
	private K fieldId;
	private V value;
	private QRPackager<K> packager;
	
	public QRFieldValue(K fieldId, V value, QRPackager<K> packager) {
		this.fieldId = fieldId;
		this.value = value;
		this.packager = packager;
	}
	
	@Override
	public final K getFieldId() {
		return this.fieldId;
	}
	
	@Override
	public final V getValue() {
		return value;
	}
	
	public final QRPackager<K> getPackager() {
		return packager;
	}
	
	@Override
	public final void write(ByteArrayOutputStream output) {
		try {
			if(this.packager == null) throw new QRException("Unable to find packager for fieldId " + this.fieldId + ", with value " + this.value);
			if(this.packager.isRequired() && this.value == null) throw new QRException("The fieldId " + this.fieldId + " is required, but the value is null"); 
			if(this.value != null) output.write(this.packager.encode(this.fieldId, this.value));
		} catch (IOException ex) {
			throw new QRException(ex);
		}
	}
	
}
