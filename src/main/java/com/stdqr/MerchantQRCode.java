package com.stdqr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.TreeMap;

import com.stdqr.constant.QRCodeType;
import com.stdqr.constant.QRCodeVersion;
import com.stdqr.core.QRCodeField;
import com.stdqr.core.QRCodeTemplate;
import com.stdqr.core.composit.QRCodeFieldComposit;
import com.stdqr.core.composit.QRCodeFieldValue;
import com.stdqr.core.composit.merchant.QRCodeMerchantAccountInfo;
import com.stdqr.core.composit.merchant.QRCodeMerchantAdditionalData;
import com.stdqr.core.composit.merchant.QRCodeMerchantInfo;
import com.stdqr.core.composit.merchant.QRMerchantLangauge;
import com.stdqr.core.template.QRCode180042015Template;
import com.stdqr.exception.QRCodeException;
import com.stdqr.util.QRCodeUtil;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public final class MerchantQRCode {
	private static final int FIELD_CHECKSUM = 63;
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	private QRCodeTemplate template = new QRCode180042015Template();
	private Map<Integer, QRCodeField<?>> fields = new TreeMap<>();
	private String checksum;
	private String qrcode;

	public MerchantQRCode setVersion(QRCodeVersion version) {
		this.setValue(0, version.getTextValue());
		return this;
	}
	
	public MerchantQRCode setType(QRCodeType type) {
		this.setValue(1, type.getCode());
		return this;
	}
	
	public MerchantQRCode setTransactionCurrency(String currency) {
		this.setValue(53, Currency.getInstance(currency).getNumericCode());
		return this;
	}
	
	public MerchantQRCode setTransactionAmount(BigDecimal amount) {
		this.setValue(54, amount);
		return this;
	}
	
	public MerchantQRCode setTip(String tip) {
		this.setValue(55, tip);
		return this;
	}
	
	public MerchantQRCode setTemplate(QRCodeTemplate template) {
		this.template = template;
		return this;
	}
	
	public MerchantQRCode setMerchantInfo(QRCodeMerchantInfo merchantInfo) {
		int field29 = 29, field31 = 31, field62 = 62, field64 = 64, field91 = 91;
		this.setValue(field29, this.bindAccountInformationField29(field29, merchantInfo.getAccountInformationField29()));
		this.setValue(field31, this.bindAccountInformationField31(field31, merchantInfo.getAccountInformationField31()));
		this.setValue(52, merchantInfo.getMerchantCategoryCode());
		this.setValue(58, merchantInfo.getCountryCode());
		this.setValue(59, merchantInfo.getMerchantName());
		this.setValue(60, merchantInfo.getMerchantCity());
		this.setValue(field62, this.bindMerchantAdditionalData(field62, merchantInfo.getAdditionalData()));
		this.setValue(field64, this.bindLocalLangauge(field64, merchantInfo.getLocalLangauge()));
		this.setValue(field91, this.bindAccountInformationField91(field91, merchantInfo.getAccountInformationField91()));
		return this;
	}
	
	private QRCodeFieldComposit<?> bindAccountInformationField29(int fieldId, QRCodeMerchantAccountInfo accountInfo) {
		QRCodeFieldComposit<?> composit = new QRCodeFieldComposit<>(fieldId, this.template.get(fieldId));
		composit.setValue(0, accountInfo.getGloballyUniqueId());
		composit.setValue(5, accountInfo.getAccountNumber());
		return composit;
	}

	private QRCodeFieldComposit<?> bindAccountInformationField31(int fieldId, QRCodeMerchantAccountInfo accountInfo) {
		QRCodeFieldComposit<?> composit = new QRCodeFieldComposit<>(fieldId, this.template.get(fieldId));
		composit.setValue(0, accountInfo.getGloballyUniqueId());
		composit.setValue(3, accountInfo.getAccountNumber());
		return composit;
	}
	
	private QRCodeFieldComposit<?> bindAccountInformationField91(int fieldId, QRCodeMerchantAccountInfo accountInfo) {
		QRCodeFieldComposit<?> composit = new QRCodeFieldComposit<>(fieldId, this.template.get(fieldId));
		composit.setValue(0, accountInfo.getGloballyUniqueId());
		composit.setValue(7, accountInfo.getLoyaltyId());
		return composit;
	}
	
	private Object bindMerchantAdditionalData(int fieldId, QRCodeMerchantAdditionalData additionalData) {
		QRCodeFieldComposit<?> composit = new QRCodeFieldComposit<>(fieldId, this.template.get(fieldId));
		composit.setValue(1, additionalData.getBillNumber());
		composit.setValue(2, additionalData.getMobileNumber());
		composit.setValue(3, additionalData.getStoreLabel());
		composit.setValue(4, additionalData.getLoyaltyNumber());
		composit.setValue(5, additionalData.getReferenceLabel());
		composit.setValue(6, additionalData.getCustomerLabel());
		composit.setValue(7, additionalData.getTerminalLabel());
		composit.setValue(8, additionalData.getPurposeOfTransaction());
		composit.setValue(9, additionalData.getAdditionalConsumerData());
		return composit;
	}

	private QRCodeFieldComposit<?> bindLocalLangauge(int fieldId, QRMerchantLangauge localLangauge) {
		QRCodeFieldComposit<?> composit = new QRCodeFieldComposit<>(fieldId, this.template.get(fieldId));
		composit.setValue(0, localLangauge.getLanguage());
		composit.setValue(1, localLangauge.getMerchantName());
		composit.setValue(2, localLangauge.getMerchantCityName());
		return composit;
	}

	public MerchantQRCode setField(QRCodeField<?> field) {
		if(field.getFieldId() != FIELD_CHECKSUM) {
			this.fields.put(field.getFieldId(), field);
		}
		return this;
	}

	public <T> MerchantQRCode setValue(int fieldId, T value) {
		if(fieldId != FIELD_CHECKSUM) {
			this.fields.put(fieldId, new QRCodeFieldValue<T>(fieldId, value, this.template.get(fieldId)));
		}
		return this;
	}

	public String getChecksum() {
		if(this.checksum == null) this.build();
		return checksum;
	}
	
	public String getQRCode() {
		if(this.qrcode == null) this.build();
		return this.qrcode;
	}

	public void build() {
		for (Integer keySet : this.fields.keySet()) this.fields.get(keySet).write(this.output);
		try {
			this.output.write(String.format("%02d%02d", FIELD_CHECKSUM, this.template.get(FIELD_CHECKSUM).getLength()).getBytes());
			String checksum = QRCodeUtil.getCRC(this.output.toString());
			this.checksum = checksum;
			this.output.write(checksum.getBytes());
			this.qrcode = QRCodeUtil.byteToHex(this.output.toByteArray());
		}catch(IOException ex) { throw new QRCodeException(ex); }
	}

}
