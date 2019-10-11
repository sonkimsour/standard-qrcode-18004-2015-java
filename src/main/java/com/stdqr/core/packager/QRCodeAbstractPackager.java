package com.stdqr.core.packager;

import com.stdqr.constant.QRCodeValueType;
import com.stdqr.core.QRCodePackager;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public abstract class QRCodeAbstractPackager implements QRCodePackager {
	private int fieldId;
	private QRCodeValueType valueType;
	private int length;
	private boolean required;
	private String title;
	private int[] references;

	public QRCodeAbstractPackager(int fieldId, QRCodeValueType valueType, int length, boolean required, String title, int... references) {
		this.fieldId = fieldId;
		this.valueType = valueType;
		this.length = length;
		this.required = required;
		this.title = title;
		this.references = references;
	}

	@Override
	public int getFieldId() {
		return fieldId;
	}

	public QRCodeValueType getValueType() {
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
	public int[] getReferences() {
		return references;
	}

}
