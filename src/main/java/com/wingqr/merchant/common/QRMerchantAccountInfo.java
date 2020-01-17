package com.wingqr.merchant.common;

import java.util.HashMap;
import java.util.Map;

import com.wingqr.merchant.constant.MechantType;

public final class QRMerchantAccountInfo {
	private Integer fieldId;
	private Map<Integer, String> child;

	public QRMerchantAccountInfo(Integer fieldId, String merchantId) {
		this.child = new HashMap<>();
		this.fieldId = fieldId;
		this.child.put(0, merchantId);
	}
	
	public Integer getFieldId() {
		return fieldId;
	}
	
	public MechantType getMerchantType() {
		return MechantType.lookup(this.getFieldId());
	}
	
	public String getMerchantId() {
		return this.child.get(0);
	}
	
	public Map<Integer, String> getChild() {
		return child;
	}
	
	public QRMerchantAccountInfo addChild(Integer fieldId, String value) {
		this.child.put(fieldId, value);
		return this;
	}
	
}
