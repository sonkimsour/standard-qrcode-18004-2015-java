package com.wingqr.merchant.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.packager.QRAbstractPackager;

public abstract class QRAbstractMerchantPackager extends QRAbstractPackager<Integer> {

	public QRAbstractMerchantPackager(Integer fieldId, QRValueType valueType, int length, boolean required, String title, Integer... reference) {
		super(fieldId, valueType, length, required, title, reference);
	}
	
	@Override
	public <V> byte[] encode(Integer fieldId, V value) {
		String result = this.getValueType().format(fieldId, value);
		return result.getBytes();
	}
	
}
