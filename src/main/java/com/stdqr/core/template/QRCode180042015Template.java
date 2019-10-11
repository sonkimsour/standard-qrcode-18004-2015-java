package com.stdqr.core.template;

import java.util.HashMap;
import java.util.Map;

import com.stdqr.constant.QRCodeValueType;
import com.stdqr.core.QRCodePackager;
import com.stdqr.core.QRCodeTemplate;
import com.stdqr.core.packager.QRCodePackagerComposit;
import com.stdqr.core.packager.QRCodeSimplePackager;
import com.stdqr.exception.QRCodeException;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public final class QRCode180042015Template implements QRCodeTemplate {
	private Map<Integer, QRCodePackager> fields = new HashMap<>();
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends QRCodePackager> T get(int fieldId) {
		if(this.fields.containsKey(fieldId)) {
			return (T) this.fields.get(fieldId);
		}
		throw new QRCodeException("Invalid fieldId " + fieldId);
	}
	
	@Override
	public <T extends QRCodePackager> void add(T template) {
		this.fields.put(template.getFieldId(), template);
	}
	
	public QRCode180042015Template() {
		this.add(new QRCodeSimplePackager(0, QRCodeValueType.NUMERIC, 2, true, "Payload Format Indicator"));
		this.add(new QRCodeSimplePackager(1, QRCodeValueType.NUMERIC, 2, false, "Point of Initiation Method"));
		this.add(new QRCodeSimplePackager(2, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Visa"));
		this.add(new QRCodeSimplePackager(3, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Visa"));
		this.add(new QRCodeSimplePackager(4, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Mastercard"));
		this.add(new QRCodeSimplePackager(5, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Mastercard"));
		this.add(new QRCodeSimplePackager(6, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(7, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(8, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(9, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Discover"));
		
		this.add(new QRCodeSimplePackager(10, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Discover"));
		this.add(new QRCodeSimplePackager(11, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Amex"));
		this.add(new QRCodeSimplePackager(12, QRCodeValueType.ALPHANUM, 99, false, "Reserved for Amex"));
		this.add(new QRCodeSimplePackager(13, QRCodeValueType.ALPHANUM, 99, false, "Reserved for JCB"));
		this.add(new QRCodeSimplePackager(14, QRCodeValueType.ALPHANUM, 99, false, "Reserved for JCB"));
		this.add(new QRCodeSimplePackager(15, QRCodeValueType.ALPHANUM, 99, false, "Reserved for UnionPay"));
		this.add(new QRCodeSimplePackager(16, QRCodeValueType.ALPHANUM, 99, false, "Reserved for UnionPay"));
		this.add(new QRCodeSimplePackager(17, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(18, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(19, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		
		this.add(new QRCodeSimplePackager(20, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(21, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(22, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(23, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(24, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(25, QRCodeValueType.ALPHANUM, 99, false, "Reserved by EMVCo"));
		this.add(new QRCodeSimplePackager(26, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(27, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(28, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(this.bindMerchantInformationTemplate29(29, QRCodeValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		
		this.add(new QRCodeSimplePackager(30, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(this.bindMerchantInformationTemplate31(31, QRCodeValueType.ALPHANUM, 99, false, "Merchant Account Information"));
		this.add(new QRCodeSimplePackager(32, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(33, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(34, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(35, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(36, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(37, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(38, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(39, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		
		this.add(new QRCodeSimplePackager(40, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(41, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(42, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(43, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(44, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(45, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(46, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(47, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(48, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(49, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		
		this.add(new QRCodeSimplePackager(50, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(51, QRCodeValueType.ALPHANUM, 99, false, "Templates reserved for additional payment networks"));
		this.add(new QRCodeSimplePackager(52, QRCodeValueType.NUMERIC, 4, true, "Merchant Category Code"));
		this.add(new QRCodeSimplePackager(53, QRCodeValueType.NUMERIC, 3, true, "Transaction Currency"));
		this.add(new QRCodeSimplePackager(54, QRCodeValueType.AMOUNT, 13, true, "Transaction Amount"));
		this.add(new QRCodeSimplePackager(55, QRCodeValueType.NUMERIC, 2, false, "Tip or Convenience Indicator"));
		this.add(new QRCodeSimplePackager(56, QRCodeValueType.AMOUNT, 13, false, "Value of Convenience Fee Fixed", 55));
		this.add(new QRCodeSimplePackager(57, QRCodeValueType.AMOUNT, 5, false, "Value of Convenience Fee Percentage", 55));
		this.add(new QRCodeSimplePackager(58, QRCodeValueType.ALPHANUM, 2, true, "Country Code"));
		this.add(new QRCodeSimplePackager(59, QRCodeValueType.ALPHANUM, 25, true, "Merchant Name"));

		this.add(new QRCodeSimplePackager(60, QRCodeValueType.ALPHANUM, 15, true, "Merchant City"));
		this.add(new QRCodeSimplePackager(61, QRCodeValueType.ALPHANUM, 10, false, "Postal Code"));
		this.add(this.bindAdditionalDataFieldTemplate(62, QRCodeValueType.ALPHA, 25, false, "Additional Data Field Template"));
		this.add(new QRCodeSimplePackager(63, QRCodeValueType.ALPHANUM, 4, true, "Cyclic Redundancy Check (CRC)"));
		this.add(this.bindMerchantInformationLanguageTemplate(64, QRCodeValueType.ALPHA, 99, true, "Merchant Information Language Template"));
		this.add(this.bindUnreservedTemplate(91, QRCodeValueType.ALPHANUM, 99, true, "Unreserved template"));
	}
	
	private QRCodePackager bindMerchantInformationTemplate29(int fieldId, QRCodeValueType valueType, int length, boolean required, String title) {
		QRCodePackagerComposit fieldDetails = new QRCodePackagerComposit(fieldId, valueType, length, required, title);
		fieldDetails.add(new QRCodeSimplePackager(0, QRCodeValueType.ALPHANUM, 12, false, "Globally Unique Identifier"));
		fieldDetails.add(new QRCodeSimplePackager(5, QRCodeValueType.ALPHANUM, 10, false, "Merchant Account Information"));
		return fieldDetails;
	}

	private QRCodePackager bindMerchantInformationTemplate31(int fieldId, QRCodeValueType valueType, int length, boolean required, String title) {
		QRCodePackagerComposit fieldDetails = new QRCodePackagerComposit(fieldId, valueType, length, required, title);
		fieldDetails.add(new QRCodeSimplePackager(0, QRCodeValueType.ALPHANUM, 12, false, "Globally Unique Identifier"));
		fieldDetails.add(new QRCodeSimplePackager(3, QRCodeValueType.ALPHANUM, 10, false, "Merchant Account Information"));
		return fieldDetails;
	}

	private QRCodePackager bindAdditionalDataFieldTemplate(int fieldId, QRCodeValueType valueType, int length, boolean required, String title) {
		QRCodePackagerComposit fieldDetails = new QRCodePackagerComposit(fieldId, valueType, length, required, title);
		fieldDetails.add(new QRCodeSimplePackager(1, QRCodeValueType.ALPHANUM, 25, false, "Bill Number"));
		fieldDetails.add(new QRCodeSimplePackager(2, QRCodeValueType.ALPHANUM, 25, false, "Mobile Number"));
		fieldDetails.add(new QRCodeSimplePackager(3, QRCodeValueType.ALPHANUM, 25, false, "Store Label"));
		fieldDetails.add(new QRCodeSimplePackager(4, QRCodeValueType.ALPHANUM, 25, false, "Loyalty Number"));
		fieldDetails.add(new QRCodeSimplePackager(5, QRCodeValueType.ALPHANUM, 25, false, "Reference Label"));
		fieldDetails.add(new QRCodeSimplePackager(6, QRCodeValueType.ALPHANUM, 25, false, "Customer Label"));
		fieldDetails.add(new QRCodeSimplePackager(7, QRCodeValueType.ALPHANUM, 25, false, "Terminal Label"));
		fieldDetails.add(new QRCodeSimplePackager(8, QRCodeValueType.ALPHANUM, 25, false, "Purpose of Transaction"));
		fieldDetails.add(new QRCodeSimplePackager(9, QRCodeValueType.ALPHANUM, 3, false, "Additional Consumer Data Request"));
		return fieldDetails;
	}
	
	private QRCodePackager bindMerchantInformationLanguageTemplate(int fieldId, QRCodeValueType valueType, int length, boolean required, String title) {
		QRCodePackagerComposit fieldDetails = new QRCodePackagerComposit(fieldId, valueType, length, required, title);
		fieldDetails.add(new QRCodeSimplePackager(0, QRCodeValueType.ALPHANUM, 2, true, "Local Language Preference"));
		fieldDetails.add(new QRCodeSimplePackager(1, QRCodeValueType.ALPHA, 25, true, "Merchant Name Alternate Language"));
		fieldDetails.add(new QRCodeSimplePackager(2, QRCodeValueType.ALPHA, 15, false, "Merchant City Alternate Language"));
		return fieldDetails;
	}
	
	private QRCodePackager bindUnreservedTemplate(int fieldId, QRCodeValueType valueType, int length, boolean required, String title) {
		QRCodePackagerComposit fieldDetails = new QRCodePackagerComposit(fieldId, valueType, length, required, title);
		fieldDetails.add(new QRCodeSimplePackager(0, QRCodeValueType.ALPHANUM, 2, true, "Globally Unique Identifier"));
		fieldDetails.add(new QRCodeSimplePackager(7, QRCodeValueType.ALPHANUM, 2, true, "Merchant Loyalty Identifier"));
		return fieldDetails;
	}
	
}
