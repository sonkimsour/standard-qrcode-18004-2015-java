package com.wingqr.consumer.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.packager.QRAbstractCompositPackager;
import com.wingqr.core.packager.QRPackager;

public class QRConsumerCompositPackager extends QRAbstractCompositPackager<String> {

	public QRConsumerCompositPackager(String fieldId, QRValueType valueType, boolean required, String title, String... reference) {
		this(fieldId, valueType, 0, required, title, reference);
	}
	
	public QRConsumerCompositPackager(String fieldId, QRValueType valueType, int length, boolean required, String title, String... reference) {
		super(fieldId, valueType, length, required, title, reference);
	}
	
	@Override
	public QRField<String> decode(String fieldId, String value, QRPackager<String> packager) {
		return null;
	}
	
}
