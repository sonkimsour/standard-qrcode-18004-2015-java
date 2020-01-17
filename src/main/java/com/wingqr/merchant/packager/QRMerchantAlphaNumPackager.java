package com.wingqr.merchant.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;

public class QRMerchantAlphaNumPackager extends QRAbstractMerchantPackager {

	public QRMerchantAlphaNumPackager(Integer fieldId, int length, boolean required, String title, Integer... reference) {
		super(fieldId, QRValueType.ALPHANUM, length, required, title, reference);
	}
	
	@Override
	public QRField<Integer> decode(Integer fieldId, String value, QRPackager<Integer> packager) {
		return new QRFieldValue<Integer, String>(fieldId, value, packager);
	}

}
