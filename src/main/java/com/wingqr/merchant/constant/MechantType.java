package com.wingqr.merchant.constant;

import java.util.Arrays;

public enum MechantType {
	VISA(new Integer[] {2, 3}),
	MASTERCARD(new Integer[] {4, 5}),
	DISCOVER(new Integer[] {9, 10}),
	AMEX(new Integer[] {11, 12}),
	JCB(new Integer[] {13, 14}),
	UNIONPAY(new Integer[] {15, 16}),
	LOCAL(new Integer[] {26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51});
	private Integer[] fieldIds;
	
	MechantType(Integer[] fieldIds) {
		this.fieldIds = fieldIds;
	}
	
	public Integer[] getFieldIds() {
		return fieldIds;
	}
	
	public static MechantType lookup(int fieldId) {
		for(MechantType type : MechantType.values()) {
			Integer[] fieldIds = type.getFieldIds();
			if(Arrays.asList(fieldIds).contains(fieldId)) {
				return type;
			}
		}
		return null;
	}
}
