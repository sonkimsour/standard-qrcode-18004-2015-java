package com.wingqr.core.packager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.exception.QRException;
import com.wingqr.core.field.QRFieldComposit;

public abstract class QRAbstractCompositPackager<K> extends QRAbstractPackager<K> {
	private Map<K, QRPackager<K>> packagers = new HashMap<>();
	private int minLength;
	
	public QRAbstractCompositPackager(K fieldId, QRValueType valueType, boolean required, String title, K[] reference) {
		this(fieldId, valueType, 0, required, title, reference);
	}
	
	public QRAbstractCompositPackager(K fieldId, QRValueType valueType, int maxLength, boolean required, String title, K[] reference) {
		this(fieldId, valueType, 0, maxLength, required, title, reference);
	}
	
	public QRAbstractCompositPackager(K fieldId, QRValueType valueType, int minLength, int maxLength, boolean required, String title, K[] reference) {
		super(fieldId, valueType, maxLength, required, title, reference);
		this.minLength = minLength;
	}
	
	public int getMinLength() {
		return minLength;
	}

	public QRAbstractCompositPackager<K> addPackager(QRPackager<K> packager) {
		this.packagers.put(packager.getFieldId(), packager);
		return this;
	}
	
	public Map<K, QRPackager<K>> getPackagers() {
		return packagers;
	}
	
	@Override
	public <V> byte[] encode(K fieldId, V value) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		QRFieldComposit<?> composit = (QRFieldComposit<?>) value;
		try {
			composit.write(result);
			output.write(QRValueType.ALPHANUM.format(fieldId, new String(result.toByteArray())).getBytes());
		}catch(IOException ex) {
			throw new QRException(ex);
		}
		return output.toByteArray();
	}

}
