package com.wingqr.consumer.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;

public class QRConsumerBinaryPackager extends QRAbstractConsumerPackager {

	public QRConsumerBinaryPackager(String fieldId, boolean required, String title, String... reference) {
		this(fieldId, 0, required, title, reference);
	}
	
	public QRConsumerBinaryPackager(String fieldId, int maxLength, boolean required, String title, String... reference) {
		this(fieldId, 0, maxLength, required, title, reference);
	}

	public QRConsumerBinaryPackager(String fieldId, int minLength, int maxLength, boolean required, String title, String... reference) {
		super(fieldId, QRValueType.BINARY, minLength, maxLength, required, title, reference);
	}

	@Override
	public QRField<String> decode(String fieldId, String value, QRPackager<String> packager) {
		return new QRFieldValue<String, byte[]>(fieldId, value.getBytes(), packager);
	}
	
}
