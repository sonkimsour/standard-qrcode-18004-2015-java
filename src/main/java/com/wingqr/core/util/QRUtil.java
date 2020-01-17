package com.wingqr.core.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wingqr.core.exception.QRException;

public final class QRUtil {
	private static final int POLYNOMIAL = 0x1021;
	
	private QRUtil() {
		throw new UnsupportedOperationException();
	}
	
	public static void validateRequired(String fieldName, Object value) {
		if(value == null) throw new QRException(String.format("%s is required", fieldName));
		if(value instanceof String) {
			if(((String) value).isEmpty()) throw new QRException(String.format("%s may not empty", fieldName));
		}else if(value instanceof BigDecimal) {
			if(((BigDecimal) value).compareTo(BigDecimal.ZERO) <= 0) throw new QRException(String.format("Invalid %s", fieldName));
		}
	}
	
	public static byte[] hexToBytes(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			int index = i * 2;
			int value = Integer.parseInt(hex.substring(index, index + 2), 16);
			bytes[i] = (byte) value;
		}
		return bytes;
	}

	public static String byteToHex(byte[] bytes) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			buffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return buffer.toString().toUpperCase();
	}

	public static String getCRC(String content) {
		int crc = 0xffff;
		byte[] bytes = content.getBytes();
		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				boolean bit = ((b >> (7 - i) & 1) == 1);
				boolean c15 = ((crc >> 15 & 1) == 1);
				crc <<= 1;
				if (c15 ^ bit)
					crc ^= POLYNOMIAL;
			}
		}
		crc &= 0xffff;
		return Integer.toHexString(crc).toUpperCase();
	}
	
	public static String binaryToString(String bin) {
		return hexToString(binaryToHex(bin));
	}
	
	public static String binaryToHex(String binary) {
		StringBuffer hex = new StringBuffer("");
		String division = "";
		String bitmap = "";
		for (int i = 0; i < binary.length(); i += 4) {
			division = binary.substring(i, i + 4);
			int dec = Integer.valueOf(division, 2).intValue();
			bitmap = Integer.toHexString(dec);
			hex.append(bitmap);
		}
		return hex.toString().toUpperCase();
	}
	
	public static String hexToBinary(String hex) {
		String hexChar, binChar, binary = "";
		int len = hex.length() / 2;
		for (int i = 0; i < len; i++) {
			hexChar = hex.substring(2 * i, 2 * i + 2);
			int conv_int = Integer.parseInt(hexChar, 16);
			binChar = Integer.toBinaryString(conv_int);
			binChar = zeroPadBinChar(binChar);
			if (i == 0)
				binary = binChar;
			else
				binary = binary + binChar;
		}
		return binary;
	}
	
	private static String zeroPadBinChar(String binChar) {
		int len = binChar.length();
		if (len == 8)
			return binChar;
		String pad = "0";
		for (int i = 1; i < 8 - len; i++)
			pad = pad + "0";
		return pad + binChar;
	}
	
	public static String hexToString(String hex) {
		StringBuilder text = new StringBuilder();
		String hexChar;
		char ptChar;
		int len = hex.length() / 2;
		for (int i = 0; i < len; i++) {
			hexChar = hex.substring(2 * i, 2 * i + 2);
			ptChar = (char) Integer.parseInt(hexChar, 16);
			text.append(ptChar);
		}
		return text.toString();
	}

	public static String formatDate(String pattern, Date expiryDate) {
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(expiryDate);
	}

	public static String byteToBinary(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
		for (int i = 0; i < Byte.SIZE * bytes.length; i++)
			sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
		return sb.toString();
	}
	
	public static String stringToBinary(String text) {
		return hexToBinary(stringToHex(text));
	}
	
	public static String stringToHex(String text) {
		String hex = "";
		for (int i = 0; i < text.length(); i++) {
			String hex_char = Integer.toHexString(text.charAt(i));
			if (i == 0)
				hex = hex_char;
			else
				hex = hex + hex_char;
		}
		return hex;
	}

}
