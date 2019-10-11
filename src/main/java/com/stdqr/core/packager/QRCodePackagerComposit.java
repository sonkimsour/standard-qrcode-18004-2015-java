package com.stdqr.core.packager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.stdqr.constant.QRCodeValueType;
import com.stdqr.core.QRCodePackager;
import com.stdqr.core.composit.QRCodeFieldComposit;
import com.stdqr.exception.QRCodeException;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodePackagerComposit extends QRCodeAbstractPackager {
	private Map<Integer, QRCodePackager> packagers;

	public QRCodePackagerComposit(int fieldId, QRCodeValueType valueType, int length, boolean required, String title, int... reference) {
		super(fieldId, valueType, length, required, title, reference);
		this.packagers = new HashMap<>();
	}

	public QRCodePackagerComposit add(QRCodeSimplePackager qrCodePackagerDetails) {
		this.packagers.put(qrCodePackagerDetails.getFieldId(), qrCodePackagerDetails);
		return this;
	}
	
	public QRCodePackager get(int fieldId) {
		return this.packagers.get(fieldId);
	}
	
	@Override
	public <T> byte[] pack(int fieldId, T value) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		QRCodeFieldComposit<?> composit = (QRCodeFieldComposit<?>) value;
		try {
			composit.write(result);
			output.write(QRCodeValueType.ALPHANUM.format(fieldId, new String(result.toByteArray())).getBytes());
		}catch(IOException ex) {
			throw new QRCodeException(ex);
		}
		return output.toByteArray();
	}

}
