package com.wingqr.core.packager;

import com.wingqr.core.constant.QRValueType;

public abstract class QRAbstractPackager<K> implements QRPackager<K> {
	private K fieldId;
	private QRValueType valueType;
	private int length;
	private boolean required;
	private String title;
	private K[] references;

	public QRAbstractPackager(K fieldId, QRValueType valueType, int length, boolean required, String title, K[] references) {
		this.fieldId = fieldId;
		this.valueType = valueType;
		this.length = length;
		this.required = required;
		this.title = title;
		this.references = references;
	}

	@Override
	public K getFieldId() {
		return fieldId;
	}

	public QRValueType getValueType() {
		return valueType;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public boolean isRequired() {
		return required;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public K[] getReferences() {
		return references;
	}

}
