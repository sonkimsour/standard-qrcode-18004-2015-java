package com.wingqr.consumer.template;

import com.wingqr.consumer.packager.QRConsumerAlphaNumPackager;
import com.wingqr.consumer.packager.QRConsumerBinaryPackager;
import com.wingqr.consumer.packager.QRConsumerCompositPackager;
import com.wingqr.consumer.packager.QRConsumerLLComNumPackager;
import com.wingqr.consumer.packager.QRConsumerNumericPackager;
import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.packager.QRPackager;
import com.wingqr.core.template.QRAbstractTemplate;

public class QRConsumerTemplate extends QRAbstractTemplate<String> {

	public QRConsumerTemplate() {
		this.addPackager(new QRConsumerBinaryPackager("85", 5, true, "Payload Format Indicator"));
		this.addPackager(this.bindApplicationTemplate("61", QRValueType.ALPHANUM, true, "Application Template"));
		this.addPackager(this.bindCommonDataTemplate("62", QRValueType.ALPHANUM, false, "Common Data Template"));
	}

	private QRPackager<String> bindApplicationTemplate(String fieldId, QRValueType valueType, boolean required, String title) {
		QRConsumerCompositPackager fieldDetails = new QRConsumerCompositPackager(fieldId, valueType, required, title);
		this.bindAdditionalBERTLVCodedDataObjects(fieldDetails, true);
		fieldDetails.addPackager(this.bindTransparentTemplate("63", QRValueType.ALPHANUM, false, "Application Specific Transparent Template"));
		return fieldDetails;
	}

	private QRPackager<String> bindCommonDataTemplate(String fieldId, QRValueType valueType, boolean required, String title) {
		QRConsumerCompositPackager fieldDetails = new QRConsumerCompositPackager(fieldId, valueType, required, title);
		this.bindAdditionalBERTLVCodedDataObjects(fieldDetails, false);
		fieldDetails.addPackager(this.bindTransparentTemplate("64", QRValueType.ALPHANUM, false, "Common Data Transparent Template"));
		return fieldDetails;
	}
	
	private QRPackager<String> bindTransparentTemplate(String fieldId, QRValueType valueType, boolean required, String title) {
		QRConsumerCompositPackager fieldDetails = new QRConsumerCompositPackager(fieldId, valueType, required, title);
		this.bindAdditionalBERTLVCodedDataObjects(fieldDetails, false);
		return fieldDetails;
	}
	
	private void bindAdditionalBERTLVCodedDataObjects(QRConsumerCompositPackager fieldDetails, boolean required) {
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("4F", 5, 16, required, "Application Dedicated File (ADF) Name"));
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("50", 1, 16, false, "Application Label"));
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("57", 19, false, "Track 2 Equivalent Data"));
		fieldDetails.addPackager(new QRConsumerLLComNumPackager("5A", 10, false, "Application PAN"));
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("5F20", 2, 26, false, "Cardholder Name"));
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("5F2D", 2, 8, false, "Language Preference"));
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("5F50", false, "Issuer URL"));
		fieldDetails.addPackager(new QRConsumerBinaryPackager("9F08", 2, false, "Application Version Number"));
		fieldDetails.addPackager(new QRConsumerNumericPackager("9F19", 6, false, "Token Requestor ID"));
		fieldDetails.addPackager(new QRConsumerAlphaNumPackager("9F24", 29, false, "Payment Account Reference"));
		fieldDetails.addPackager(new QRConsumerNumericPackager("9F25", 2, false, "Last 4 Digits of PAN"));
		fieldDetails.addPackager(new QRConsumerBinaryPackager("9F10", 32, false, "Issuer Application Data"));
		fieldDetails.addPackager(new QRConsumerBinaryPackager("9F26", 8, false, "Application Cryptogram"));
		fieldDetails.addPackager(new QRConsumerBinaryPackager("9F36", 2, false, "Application Transaction Counter (ATC)"));
		fieldDetails.addPackager(new QRConsumerBinaryPackager("9F37", 4, false, "Unpredictable Number"));
	}

}
