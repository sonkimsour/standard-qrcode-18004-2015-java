package com.wingqr.core.template;

import java.util.Map;

import com.wingqr.core.packager.QRPackager;

public interface QRTemplate<K extends Object> {
	
	public void addPackager(QRPackager<K> template);

	public QRPackager<K> getPackager(K fieldId);

	public Map<K, QRPackager<K>> getPackagers();
	
}
