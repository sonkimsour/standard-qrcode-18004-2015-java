package com.wingqr.core.field;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.TreeMap;

import com.wingqr.core.packager.QRPackager;

public class QRFieldComposit<K> implements QRField<K> {
	private Map<K, QRField<K>> fields = new TreeMap<>();
	private Map<K, QRPackager<K>> packagers;
	private K fieldId;
	
	public QRFieldComposit(K fieldId, Map<K, QRPackager<K>> packagers) {
		this.fieldId =  fieldId;
		this.packagers = packagers;
	}
	
	public QRPackager<K> getPackager(K fieldId) {
		return packagers.get(fieldId);
	}
	
	public Map<K, QRPackager<K>> getPackagers() {
		return packagers;
	}
	
	public final void setField(QRField<K> field) {
		this.fields.put(field.getFieldId(), field);
	}

	public final <V> void setValue(K fieldId, V value) {
		this.fields.put(fieldId, new QRFieldValue<>(fieldId, value, this.packagers.get(fieldId)));
	}

	public final <V> void setValue(K fieldId, V value, QRPackager<K> packager) {
		this.fields.put(fieldId, new QRFieldValue<>(fieldId, value, packager));
	}

	@Override
	public final void write(ByteArrayOutputStream output) {
		for (K keySet : this.fields.keySet()) {
			this.fields.get(keySet).write(output);
		}
	}

	@Override
	public K getFieldId() {
		return this.fieldId;
	}

	@Override
	public Map<K, QRField<K>> getValue() {
		return this.fields;
	}

}
