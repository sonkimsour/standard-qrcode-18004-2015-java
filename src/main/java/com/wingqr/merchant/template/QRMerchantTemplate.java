package com.wingqr.merchant.template;

import com.wingqr.core.constant.QRValueType;
import com.wingqr.core.template.QRAbstractTemplate;
import com.wingqr.merchant.packager.QRMerchantAlphaNumPackager;
import com.wingqr.merchant.packager.QRMerchantAlphaPackager;
import com.wingqr.merchant.packager.QRMerchantAmountPackager;
import com.wingqr.merchant.packager.QRMerchantCompositPackager;
import com.wingqr.merchant.packager.QRMerchantNumericPackager;

public final class QRMerchantTemplate extends QRAbstractTemplate<Integer> {
	
	public QRMerchantTemplate() {
		this.addPackager(new QRMerchantNumericPackager(0, 2, true, "Payload Format Indicator"));
		this.addPackager(new QRMerchantNumericPackager(1, 2, false, "Point of Initiation Method"));
		this.addPackager(new QRMerchantAlphaNumPackager(2, 99, false, "Reserved for Visa"));
		this.addPackager(new QRMerchantAlphaNumPackager(3, 99, false, "Reserved for Visa"));
		this.addPackager(new QRMerchantAlphaNumPackager(4, 99, false, "Reserved for Mastercard"));
		this.addPackager(new QRMerchantAlphaNumPackager(5, 99, false, "Reserved for Mastercard"));
		this.addPackager(new QRMerchantAlphaNumPackager(6, 99, false, "Reserved by EMVCo"));
		this.addPackager(new QRMerchantAlphaNumPackager(9, 99, false, "Reserved for Discover"));
		this.addPackager(new QRMerchantAlphaNumPackager(10, 99, false, "Reserved for Discover"));
		this.addPackager(new QRMerchantAlphaNumPackager(11, 99, false, "Reserved for Amex"));
		this.addPackager(new QRMerchantAlphaNumPackager(12, 99, false, "Reserved for Amex"));
		this.addPackager(new QRMerchantAlphaNumPackager(13, 99, false, "Reserved for JCB"));
		this.addPackager(new QRMerchantAlphaNumPackager(14, 99, false, "Reserved for JCB"));
		this.addPackager(new QRMerchantAlphaNumPackager(15, 99, false, "Reserved for UnionPay"));
		this.addPackager(new QRMerchantAlphaNumPackager(16, 99, false, "Reserved for UnionPay"));
		this.addPackager(new QRMerchantAlphaNumPackager(17, 99, false, "Reserved by EMVCo"));
		this.addPackager(this.bindMerchantInformation(26, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(27, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(28, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(29, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(30, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(31, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(32, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(33, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(34, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(35, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(36, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(37, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(38, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(39, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(40, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(41, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(42, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(43, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(44, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(45, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(46, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(47, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(48, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(49, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(50, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(this.bindMerchantInformation(51, QRValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.addPackager(new QRMerchantNumericPackager(52, 4, true, "Merchant Category Code"));
		this.addPackager(new QRMerchantNumericPackager(53, 3, true, "Transaction Currency"));
		this.addPackager(new QRMerchantAmountPackager(54, 13, true, "Transaction Amount"));
		this.addPackager(new QRMerchantNumericPackager(55, 2, false, "Tip or Convenience Indicator", 56, 57));
		this.addPackager(new QRMerchantAmountPackager(56, 13, false, "Value of Convenience Fee Fixed"));
		this.addPackager(new QRMerchantAmountPackager(57, 5, false, "Value of Convenience Fee Percentage"));
		this.addPackager(new QRMerchantAlphaNumPackager(58, 2, true, "Country Code"));
		this.addPackager(new QRMerchantAlphaNumPackager(59, 25, true, "Merchant Name"));
		this.addPackager(new QRMerchantAlphaNumPackager(60, 15, true, "Merchant City"));
		this.addPackager(new QRMerchantAlphaNumPackager(61, 10, false, "Postal Code"));
		this.addPackager(this.bindAdditionalDataFieldTemplate(62, QRValueType.ALPHA, 25, false, "Additional Data Field Template"));
		this.addPackager(new QRMerchantAlphaNumPackager(63, 4, true, "Cyclic Redundancy Check (CRC)"));
		this.addPackager(this.bindMerchantInformationLanguageTemplate(64, QRValueType.ALPHA, 99, true, "Merchant Information Language Template"));
	}

	private QRMerchantCompositPackager bindMerchantInformation(int fieldId, QRValueType valueType, int length, boolean required, String title) {
		QRMerchantCompositPackager fieldDetails = new QRMerchantCompositPackager(fieldId, valueType, length, required, title);
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(0, 12, false, "Globally Unique Identifier"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(5, 10, false, "Merchant Account Information"));
		return fieldDetails;
	}

	private QRMerchantCompositPackager bindAdditionalDataFieldTemplate(int fieldId, QRValueType valueType, int length, boolean required, String title) {
		QRMerchantCompositPackager fieldDetails = new QRMerchantCompositPackager(fieldId, valueType, length, required, title);
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(1, 25, false, "Bill Number"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(2, 25, false, "Mobile Number"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(3, 25, false, "Store Label"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(4, 25, false, "Loyalty Number"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(5, 25, false, "Reference Label"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(6, 25, false, "Customer Label"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(7, 25, false, "Terminal Label"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(8, 25, false, "Purpose of Transaction"));
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(9, 3, false, "Additional Consumer Data Request"));
		return fieldDetails;
	}
	
	private QRMerchantCompositPackager bindMerchantInformationLanguageTemplate(int fieldId, QRValueType valueType, int length, boolean required, String title) {
		QRMerchantCompositPackager fieldDetails = new QRMerchantCompositPackager(fieldId, valueType, length, required, title);
		fieldDetails.addPackager(new QRMerchantAlphaNumPackager(0, 2, true, "Local Language Preference"));
		fieldDetails.addPackager(new QRMerchantAlphaPackager(1, 25, true, "Merchant Name Alternate Language"));
		fieldDetails.addPackager(new QRMerchantAlphaPackager(2, 15, false, "Merchant City Alternate Language"));
		return fieldDetails;
	}
	
}
