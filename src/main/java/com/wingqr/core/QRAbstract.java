package com.wingqr.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.wingqr.QRCode;
import com.wingqr.core.exception.QRException;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldValue;
import com.wingqr.core.packager.QRPackager;
import com.wingqr.core.template.QRTemplate;

public abstract class QRAbstract<K> implements QRCode {
	private Map<K, QRField<K>> fields;
	private QRTemplate<K> template;
	
	public QRAbstract(QRTemplate<K> template) {
		this.fields = new LinkedHashMap<>();
		this.template = template;
	}
	
	public final QRTemplate<K> getTemplate() {
		return template;
	}
	
	public final void addPackager(QRPackager<K> packager) {
		this.getTemplate().addPackager(packager);
	}
	
	public QRPackager<K> getPackager(K fieldId) {
		return this.template.getPackager(fieldId);
	}
	
	public final Map<K, QRPackager<K>> getPackagers() {
		return this.getTemplate().getPackagers();
	}
	
	public final void setField(QRField<K> field) {
		this.fields.put(field.getFieldId(), field);
	}
	
	public final QRField<K> getField(K fieldId) {
		return this.fields.get(fieldId);
	}

	public boolean hasField(K fieldId) {
		return this.fields.containsKey(fieldId);
	}
	
	public <V> void setValue(K fieldId, V value) {
		this.fields.put(fieldId, new QRFieldValue<K, V>(fieldId, value, this.getPackager(fieldId)));
	}

	public Object getValue(K fieldId) {
		return this.fields.get(fieldId).getValue();
	}

	public <V> void setValue(K fieldId, V value, QRPackager<K> packager) {
		this.fields.put(fieldId, new QRFieldValue<K, V>(fieldId, value, packager));
	}

	@Override
	public final String pack() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			return this.fields.isEmpty() ? null : this.build(this.fields, output);
		}catch(IOException ex) { 
			throw new QRException(ex); 
		}finally {
			try { output.close();
			} catch (IOException ex) {}
			output= null;
		}
	}
	
	@Override
	public void unpack(String qrString) {
		this.fields.clear();
		this.extract(qrString);
	}
	
	protected abstract void extract(String qrString);
	protected abstract String build(Map<K, QRField<K>> fields, ByteArrayOutputStream output) throws IOException;
}
