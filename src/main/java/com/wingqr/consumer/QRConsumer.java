package com.wingqr.consumer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import com.wingqr.consumer.common.QRAbstractDataTemplate;
import com.wingqr.consumer.common.QRTrack2EquivalentData;
import com.wingqr.consumer.common.application.QRApplicationTemplate;
import com.wingqr.consumer.common.data.QRCommonDataTemplate;
import com.wingqr.consumer.packager.QRConsumerCompositPackager;
import com.wingqr.consumer.template.QRConsumerTemplate;
import com.wingqr.core.QRAbstract;
import com.wingqr.core.exception.QRException;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldComposit;
import com.wingqr.core.packager.QRPackager;
import com.wingqr.core.util.QRUtil;

public final class QRConsumer extends QRAbstract<String> {
	private static final String FIELD_SEPARATOR = "D";
	private static final String ENSURE_WHOLE_BYTES = "F";
	private static final String DATE4_PATTER = "YYMM";
	private static final int MAX_BYTE_LENGTH = 512;
	
	public QRConsumer() {
		super(new QRConsumerTemplate());
	}
	
	public void setVersion(String value) {
		this.setValue("85", value);
	}
	
	public QRConsumer addApplicationTemplate(QRApplicationTemplate template) {
		String field61 = "61", field63 = "63";
		if(template == null) {
			if(this.hasField(field61)) return this;
			else QRUtil.validateRequired("Application template", template);
		}
		QRFieldComposit<String> composit = this.bindAdditionalBERTLVCodedDataObjects(field61, template, this.getPackager(field61));
		this.setValue(field61, composit);
		if(template.getApplicationSpecificTransparent() != null) {
			composit.setValue(field63, this.bindAdditionalBERTLVCodedDataObjects(field63, template.getApplicationSpecificTransparent(), composit.getPackager(field63)));
		}
		return this;
	}
	
	public QRConsumer setCommonDataTemplate(QRCommonDataTemplate template) {
		if(template == null) return this;
		String field62 = "62", field64 = "64";
		QRFieldComposit<String> composit =  this.bindAdditionalBERTLVCodedDataObjects(field62, template, this.getPackager(field62));
		this.setValue(field62, composit);
		if(template.getCommonDataTransparent() != null) {
			composit.setValue(field64, this.bindAdditionalBERTLVCodedDataObjects(field64, template.getCommonDataTransparent(), composit.getPackager(field64)));
		}
		return this;
	}
	
	private <T extends QRAbstractDataTemplate> QRFieldComposit<String> bindAdditionalBERTLVCodedDataObjects(String fieldId, T template, QRPackager<String> packager) {
		QRUtil.validateRequired("Application dedicated file (ADF) name", template.getApplicationDefinitionFile());
		if(template.getTrack2EquivalentData() == null && template.getApplicationPAN() == null) throw new QRException("Either track 2 equivalent data must be present or application PAN must be present.");
		QRFieldComposit<String> composit = new QRFieldComposit<>(fieldId, this.getCompositPackager(packager));
		composit.setValue("4F", template.getApplicationDefinitionFile());
		composit.setValue("50", template.getApplicationLabel());
		composit.setValue("57", this.bindTrack2EquivalentData(template.getTrack2EquivalentData()));
		composit.setValue("5A", template.getApplicationPAN());
		composit.setValue("5F20", template.getCardholderName());
		composit.setValue("5F2D", template.getLanguagePreference());
		composit.setValue("5F50", template.getIssuerUrl());
		composit.setValue("9F08", template.getApplicationVersionNumber());
		composit.setValue("9F19", template.getTokenRequestorId());
		composit.setValue("9F24", template.getPaymentAccountReference());
		composit.setValue("9F25", template.getLast4DigitsOfPAN());
		return composit;
	}
	
	private String bindTrack2EquivalentData(QRTrack2EquivalentData track2EquivalentData) {
		if(track2EquivalentData == null) return null;
		StringBuffer sb = new StringBuffer();
		sb.append(track2EquivalentData.getAccountNumber());
		sb.append(FIELD_SEPARATOR);
		sb.append(QRUtil.formatDate(DATE4_PATTER, track2EquivalentData.getExpiryDate()));
		sb.append(track2EquivalentData.getServiceCode());
		sb.append(track2EquivalentData.getDiscretionaryData());
		sb.append(ENSURE_WHOLE_BYTES);
		return sb.toString();
	}
	
	@Override
	public QRPackager<String> getPackager(String fieldId) {
		return this.getTemplate().getPackager(fieldId);
	}

	private Map<String, QRPackager<String>> getCompositPackager(QRPackager<String> packager) {
		return ((QRConsumerCompositPackager) packager).getPackagers();
	}
	
	public <T> void setOtherTemplate(String fieldId, T value) {
		this.setValue(fieldId, value);
	}
	
	@Override
	protected void extract(String qrString) {
		
	}

	@Override
	protected String build(Map<String, QRField<String>> fields, ByteArrayOutputStream output) throws IOException {
		for (String keySet : fields.keySet()) fields.get(keySet).write(output);
		byte[] bytes = output.toByteArray();
		if(bytes.length > MAX_BYTE_LENGTH) throw new QRException(String.format("QRCode readers complying support %d bytes of data from the QRCode, actual: %d bytes", MAX_BYTE_LENGTH, bytes.length));
		return Base64.getEncoder().encodeToString(QRUtil.hexToBytes(new String(bytes)));
	}
}
