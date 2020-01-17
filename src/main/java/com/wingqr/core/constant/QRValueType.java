package com.wingqr.core.constant;

import java.math.BigDecimal;

import com.wingqr.core.exception.QRException;
import com.wingqr.core.util.QRUtil;

public enum QRValueType {
	NUMERIC, ALPHA, ALPHANUM, AMOUNT, BINARY, LLCOMNUM;
	private static final int DEFAULT_MAX_LENGTH = 99;
	
	public <V, K> String format(K fieldId, V value) {
		if(fieldId instanceof Integer) return this.format((int) fieldId, value);
		if(fieldId instanceof String) return this.format((String) fieldId, value);
		throw new QRException("Unsupported fieldId " + fieldId + ", with value type " + value == null ? "null" : value.getClass().getName());
	}

	public <V> String format(String fieldId, V value) {
		if(value instanceof String) {
			return this.format(fieldId, ((String) value));
		}else if(value instanceof Integer) {
			return this.format(fieldId, ((Integer) value).toString());
		}
		throw new QRException("Unsupported fieldId " + fieldId + ", with value type " + value == null ? "null" : value.getClass().getName());
	}
	
	public String format(String fieldId, String value) {
		if(this == ALPHANUM || this == NUMERIC) {
			return String.format("%s%02x%s", fieldId, value.length() / 2, value);
		}else if(this == BINARY) {
			byte[] bytes = value.getBytes();
			return String.format("%s%02x%s", fieldId, bytes.length, QRUtil.byteToHex(bytes));
		}else if(this == LLCOMNUM) {
			int length = value.length();
			if(length < 16) value += new String(new char[16 - length]).replace("\0", "F");
			return String.format("%s%02x%s", fieldId, value.length() / 2, value);
		}
		throw new QRException("Cannot format value as " + this);
	}
	
	public <V> String format(Integer fieldId, V value) {
		if(value instanceof String) {
			return this.format(fieldId, (String) value);
		}else if(value instanceof Integer) {
			return this.format(fieldId, (Integer) value);
		}else if(value instanceof BigDecimal) {
			return this.format(fieldId, (BigDecimal) value);
		}
		throw new QRException("Unsupported fieldId " + fieldId + ", with value type " + value == null ? "null" : value.getClass().getName());
	}
	
	public String format(Integer fieldId, String value) {
		int length = value.length();
		if (length > DEFAULT_MAX_LENGTH) {
			throw new QRException("Field " + fieldId + " contants alpha numberic value is larger than intended length " + DEFAULT_MAX_LENGTH + ", actual " + value);
		}
		if(this == ALPHA) {
			if(value.matches("^[-'a-zA-Z\\u4e00-\\u9eff]{1,20}$")) {
				return String.format("%02d%02d%s", fieldId, length, value);
			}
			throw new QRException("Alphabet characters only, actual " + value);
		}
		return String.format("%02d%02d%s", fieldId, length, value);
	}

	public String format(Integer fieldId, Integer value) {
		if(this == ALPHANUM || this == ALPHA) return this.format(fieldId, Integer.toString(value));
		else if(this == AMOUNT) return this.format(fieldId, new BigDecimal(value));
		else if(this == NUMERIC) {
			return String.format("%02d%02d%d", fieldId, value.toString().length(), value);
		}
		throw new QRException("Cannot format value as " + this);
	}
	
	public String format(Integer fieldId, BigDecimal value) {
		if(this == NUMERIC) return this.format(fieldId, value.intValue());
		else if(this == ALPHANUM || this == ALPHA) return this.format(fieldId, value.toString());
		else if(this == AMOUNT) {
			return this.format(fieldId, new String(value.toString()));
		}
		throw new QRException("Cannot format value as " + this);
	}

}
