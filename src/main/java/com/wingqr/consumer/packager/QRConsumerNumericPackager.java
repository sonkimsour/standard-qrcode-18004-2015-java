package com.wingqr.consumer.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;

public class QRConsumerNumericPackager extends QRAbstractConsumerPackager {

	public QRConsumerNumericPackager(String fieldId, boolean required, String title, String... reference) {
		this(fieldId, 0, required, title, reference);
	}
	
	public QRConsumerNumericPackager(String fieldId, int maxLength, boolean required, String title, String... reference) {
		this(fieldId, 0, maxLength, required, title, reference);
	}

	public QRConsumerNumericPackager(String fieldId, int minLength, int maxLength, boolean required, String title, String... reference) {
		super(fieldId, QRValueType.NUMERIC, minLength, maxLength, required, title, reference);
	}

	@Override
	public QRField<String> decode(String fieldId, String value, QRPackager<String> packager) {
		return new QRFieldValue<String, Integer>(fieldId, Integer.parseInt(value), packager);
	}
	
}
