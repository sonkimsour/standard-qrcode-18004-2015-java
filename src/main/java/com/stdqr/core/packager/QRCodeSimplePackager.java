package com.stdqr.core.packager;

import com.stdqr.constant.QRCodeValueType;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public final class QRCodeSimplePackager extends QRCodeAbstractPackager {
	public QRCodeSimplePackager(int fieldId, QRCodeValueType valueType, int length, boolean required, String title, int... reference) {
		super(fieldId, valueType, length, required, title, reference);
	}

	@Override
	public <T> byte[] pack(int fieldId, T value) {
		String result = this.getValueType().format(fieldId, value);
		return result.getBytes();
	}

}
