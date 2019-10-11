package com.stdqr.util;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public final class QRCodeUtil {
	private static final int POLYNOMIAL = 0x1021;

	private QRCodeUtil() {
		throw new UnsupportedOperationException();
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
		int crc = 0xFFFF;
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

}
