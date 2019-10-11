package com.stdqr.constant;

import java.math.BigDecimal;

import com.stdqr.core.composit.QRCodeFieldComposit;
import com.stdqr.exception.QRCodeException;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public enum QRCodeValueType {
	NUMERIC, ALPHA, ALPHANUM, AMOUNT;
	private static final int DEFAULT_MAX_LENGTH = 99;

	public <T> String format(int fieldId, T value) {
		if(value instanceof String) {
			return this.format(fieldId, (String) value);
		}else if(value instanceof Integer) {
			return this.format(fieldId, (Integer) value);
		}else if(value instanceof BigDecimal) {
			return this.format(fieldId, (BigDecimal) value);
		}else if(value instanceof QRCodeFieldComposit) {
			return this.format(fieldId, (QRCodeFieldComposit<?>) value);
		}
		throw new QRCodeException("Unsupported value type " + value.getClass().getName());
	}
	
	public String format(int fieldId, String value) {
		int length = value.length();
		if (length > DEFAULT_MAX_LENGTH) {
			throw new QRCodeException("Field " + fieldId + " contants alpha numberic value is larger than intended length " + DEFAULT_MAX_LENGTH + ", actual " + value);
		}
		if(this == ALPHA) {
			if(value.matches("^[-'a-zA-Z\\u4e00-\\u9eff]{1,20}$")) {
				return String.format("%02d%02d%s", fieldId, length, value);
			}
			throw new QRCodeException("Alphabet characters only, actual " + value);
		}
		return String.format("%02d%02d%s", fieldId, length, value);
	}

	public String format(int fieldId, Integer value) {
		if(this == ALPHANUM || this == ALPHA) return this.format(fieldId, Integer.toString(value));
		else if(this == AMOUNT) return this.format(fieldId, new BigDecimal(value));
		else if(this == NUMERIC) {
			return String.format("%02d%02d%d", fieldId, value.toString().length(), value);
		}
		throw new QRCodeException("Cannot format value as " + this);
	}
	
	public String format(int fieldId, BigDecimal value) {
		if(this == NUMERIC) return this.format(fieldId, value.intValue());
		else if(this == ALPHANUM || this == ALPHA) return this.format(fieldId, value.toString());
		else if(this == AMOUNT) {
			return this.format(fieldId, new String(value.toString()));
		}
		throw new QRCodeException("Cannot format value as " + this);
	}

}
