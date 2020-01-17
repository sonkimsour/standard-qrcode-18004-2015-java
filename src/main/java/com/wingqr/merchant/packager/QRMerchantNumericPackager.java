package com.wingqr.merchant.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;

public class QRMerchantNumericPackager extends QRAbstractMerchantPackager {

	public QRMerchantNumericPackager(Integer fieldId, int length, boolean required, String title, Integer... reference) {
		super(fieldId, QRValueType.NUMERIC, length, required, title, reference);
	}
	
	@Override
	public QRField<Integer> decode(Integer fieldId, String value, QRPackager<Integer> packager) {
		return new QRFieldValue<Integer, Integer>(fieldId, Integer.parseInt(value), packager);
	}

}
