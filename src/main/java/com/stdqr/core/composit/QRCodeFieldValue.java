package com.stdqr.core.composit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.stdqr.core.QRCodeField;
import com.stdqr.core.QRCodePackager;
import com.stdqr.exception.QRCodeException;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public final class QRCodeFieldValue<T> implements QRCodeField<T> {
	private int fieldId;
	private T value;
	private QRCodePackager packager;
	
	public QRCodeFieldValue(int fieldId, T value, QRCodePackager packager) {
		if(value == null) throw new QRCodeException("Field value must not be null");
		this.fieldId = fieldId;
		this.value = value;
		this.packager = packager;
	}
	
	@Override
	public int getFieldId() {
		return this.fieldId;
	}

	@Override
	public void write(ByteArrayOutputStream output) {
		try {
			output.write(this.packager.pack(this.fieldId, this.value));
		} catch (IOException ex) {
			throw new QRCodeException(ex);
		}
	}

	@Override
	public int compareTo(QRCodeField<?> object) {
		return Integer.compare(this.fieldId, object.getFieldId());
	}
	
}
