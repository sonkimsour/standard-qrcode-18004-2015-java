package com.wingqr.merchant.packager;

import java.math.BigDecimal;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;

public class QRMerchantAmountPackager extends QRAbstractMerchantPackager {

	public QRMerchantAmountPackager(Integer fieldId, int length, boolean required, String title, Integer... reference) {
		super(fieldId, QRValueType.AMOUNT, length, required, title, reference);
	}
	
	@Override
	public QRField<Integer> decode(Integer fieldId, String value, QRPackager<Integer> packager) {
		return new QRFieldValue<Integer, BigDecimal>(fieldId, new BigDecimal(value), packager);
	}

}
