package com.wingqr.merchant.packager;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldComposit;
import com.wingqr.core.packager.QRAbstractCompositPackager;
import com.wingqr.core.packager.QRPackager;

public class QRMerchantCompositPackager extends QRAbstractCompositPackager<Integer> {

	public QRMerchantCompositPackager(Integer fieldId, QRValueType valueType, int length, boolean required, String title, Integer... reference) {
		super(fieldId, valueType, length, required, title, reference);
	}
	
	@Override
	public QRField<Integer> decode(Integer parentId, String qrString, QRPackager<Integer> packager) {
		QRFieldComposit<Integer> composit = new QRFieldComposit<>(parentId, this.getPackagers());
		this.extract(qrString, composit);
		return composit;
	}

	protected void extract(String qrString, QRFieldComposit<Integer> composit) {
		Integer fieldId = Integer.parseInt(qrString.substring(0, 2));
		Integer length = Integer.parseInt(qrString.substring(2, 4));
		QRPackager<Integer> packager = composit.getPackager(fieldId);
		String value = qrString.substring(4, 4 + length);
		if(packager == null) {
			packager = new QRMerchantAlphaNumPackager(fieldId, value.length(), false, "Acquirer Defined Field");
		}
		composit.setField(packager.decode(fieldId, value, packager));
		qrString = qrString.substring(4 + length);
		if(qrString != null && !qrString.isEmpty()) {
			this.extract(qrString, composit);
		}
	}
	
}
