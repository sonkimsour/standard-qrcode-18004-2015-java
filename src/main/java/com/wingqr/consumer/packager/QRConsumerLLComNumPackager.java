package com.wingqr.consumer.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;

public class QRConsumerLLComNumPackager extends QRAbstractConsumerPackager {

	public QRConsumerLLComNumPackager(String fieldId, int maxLength, boolean required, String title, String... reference) {
		super(fieldId, QRValueType.LLCOMNUM, 0, maxLength, required, title, reference);
	}

	@Override
	public QRField<String> decode(String fieldId, String value, QRPackager<String> packager) {
		return new QRFieldValue<String, String>(fieldId, value, packager);
	}
	
}
