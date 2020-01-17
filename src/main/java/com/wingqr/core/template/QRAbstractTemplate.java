package com.wingqr.core.template;

import java.util.HashMap;
import java.util.Map;

import com.wingqr.core.exception.QRException;
import com.wingqr.core.packager.QRPackager;

public abstract class QRAbstractTemplate<K extends Object> implements QRTemplate<K> {
	private Map<K, QRPackager<K>> pakagers = new HashMap<>();

	@Override
	public void addPackager(QRPackager<K> template) {
		this.pakagers.put((K) template.getFieldId(), template);
	}

	@Override
	public QRPackager<K> getPackager(K fieldId) {
		if(this.pakagers.containsKey(fieldId)) {
			return (QRPackager<K>) this.pakagers.get(fieldId);
		}
		throw new QRException("Invalid fieldId " + fieldId);
	}
	
	@Override
	public Map<K, QRPackager<K>> getPackagers() {
		return this.pakagers;
	}
	
}
