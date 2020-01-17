package com.wingqr.consumer.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.packager.QRAbstractPackager;

public abstract class QRAbstractConsumerPackager extends QRAbstractPackager<String> {
	private int minLength;
	
	public QRAbstractConsumerPackager(String fieldId, QRValueType valueType, boolean required, String title, String... reference) {
		this(fieldId, valueType, 0, required, title, reference);
	}
	
	public QRAbstractConsumerPackager(String fieldId, QRValueType valueType, int maxLength, boolean required, String title, String... reference) {
		this(fieldId, valueType, 0, maxLength, required, title, reference);
	}

	public QRAbstractConsumerPackager(String fieldId, QRValueType valueType, int minLength, int maxLength, boolean required, String title, String... reference) {
		super(fieldId, valueType, maxLength, required, title, reference);
		this.minLength = minLength;
	}
	
	public int getMinLength() {
		return minLength;
	}
	
	@Override
	public <V> byte[] encode(String fieldId, V value) {
		String result = this.getValueType().format(fieldId, value);
		return result.getBytes();
	}

}
