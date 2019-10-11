package com.stdqr.core.composit;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.TreeMap;

import com.stdqr.core.QRCodeField;
import com.stdqr.core.QRCodePackager;
import com.stdqr.core.packager.QRCodePackagerComposit;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodeFieldComposit<T> implements QRCodeField<T> {
	private Map<Integer, QRCodeField<?>> fields = new TreeMap<>();
	private int fieldId;
	private QRCodePackagerComposit packager;
	
	public QRCodeFieldComposit(int fieldId, QRCodePackager packager) {
		this.fieldId =  fieldId;
		this.packager = ((QRCodePackagerComposit) packager);
	}

	public final <V> void setValue(int fieldId, V value) {
		if(value != null) {
			this.fields.put(fieldId, new QRCodeFieldValue<>(fieldId, value, this.packager.get(fieldId)));
		}
	}

	@Override
	public final void write(ByteArrayOutputStream output) {
		for (Integer keySet : this.fields.keySet()) {
			this.fields.get(keySet).write(output);
		}
	}

	@Override
	public int getFieldId() {
		return this.fieldId;
	}
	
	@Override
	public int compareTo(QRCodeField<?> object) {
		return Integer.compare(this.fieldId, object.getFieldId());
	}

}
