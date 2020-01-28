package com.wingqr.merchant;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wingqr.core.QRAbstract;
import com.wingqr.core.constant.QRType;
import com.wingqr.core.exception.QRException;
import com.wingqr.core.field.QRField;
import com.wingqr.core.field.QRFieldComposit;
import com.wingqr.core.packager.QRPackager;
import com.wingqr.core.util.QRUtil;
import com.wingqr.merchant.common.QRMerchantAccountInfo;
import com.wingqr.merchant.common.QRMerchantAdditionalData;
import com.wingqr.merchant.common.QRMerchantInfo;
import com.wingqr.merchant.common.QRMerchantLangauge;
import com.wingqr.merchant.packager.QRMerchantAlphaNumPackager;
import com.wingqr.merchant.packager.QRMerchantCompositPackager;
import com.wingqr.merchant.template.QRMerchantTemplate;

public final class QRMerchant extends QRAbstract<Integer> {
	private static final int FIELD_CHECKSUM = 63;
	
	public QRMerchant() {
		super(new QRMerchantTemplate());
	}
	
	public void setVersion(String value) {
		this.setValue(0, value);
	}
	
	public String getVersion() {
		return String.valueOf(this.getValue(0));
	}
	
	public void setType(QRType type) {
		this.setValue(1, type.getCode());
	}
	
	public QRType getType() {
		return QRType.lookup((int) this.getValue(1));
	}
	
	public void setTransactionCurrency(String currency) {
		QRUtil.validateRequired("Transaction currency", currency);
		this.setValue(53, Currency.getInstance(currency).getNumericCode());
	}
	
	public String getTransactionCurrency() {
		int currencyCode = (int) this.getValue(53);
		Set<Currency> currencies = Currency.getAvailableCurrencies();
        for (Currency currency : currencies) {
        	if (currency.getNumericCode() == currencyCode) {
        		return currency.getSymbol();
        	}
        }
        throw new QRException("Unable to decode currency code " + currencyCode);
	}
	
	public void setTransactionAmount(BigDecimal amount) {
		QRUtil.validateRequired("Transaction amount", amount);
		this.setValue(54, amount);
	}
	
	public BigDecimal getTransactionAmount() {
		return (BigDecimal) this.getValue(54);
	}
	
	public void setTip(String tip) {
		this.setValue(55, tip);
	}
	
	public String getTip() {
		return (String) this.getValue(55);
	}
	
	public void setMerchantInfo(QRMerchantInfo merchantInfo) {
		int field62 = 62, field64 = 64;
		this.bindAccountInformationField(merchantInfo.getAccountInformation());
		QRUtil.validateRequired("Merchant category code", merchantInfo.getMerchantCategoryCode());
		this.setValue(52, merchantInfo.getMerchantCategoryCode());
		QRUtil.validateRequired("Merchant country code", merchantInfo.getCountryCode());
		this.setValue(58, merchantInfo.getCountryCode());
		QRUtil.validateRequired("Merchant name", merchantInfo.getMerchantName());
		this.setValue(59, merchantInfo.getMerchantName());
		QRUtil.validateRequired("Merchant city", merchantInfo.getMerchantCity());
		this.setValue(60, merchantInfo.getMerchantCity());
		this.bindMerchantPostalCode(merchantInfo.getPostalCode());
		this.bindMerchantAdditionalData(field62, merchantInfo.getAdditionalData());
		this.bindLocalLangauge(field64, merchantInfo.getLocalLangauge());
	}
	
	public QRMerchantInfo getMerchantInfo() {
		QRMerchantInfo merchantInfo = new QRMerchantInfo();
		merchantInfo.setAccountInformation(this.decodeAccountInformation());
		merchantInfo.setMerchantCategoryCode(String.valueOf(this.getValue(52)));
		merchantInfo.setCountryCode((String) this.getValue(58));
		merchantInfo.setMerchantName((String) this.getValue(59));
		merchantInfo.setMerchantCity((String) this.getValue(60));
		merchantInfo.setPostalCode((String) this.getValue(61));
		merchantInfo.setAdditionalData(this.decodeAdditionalData(62));
		merchantInfo.setLocalLangauge(this.decodeLocalLangauge(64));
		return merchantInfo;
	}
	
	private List<QRMerchantAccountInfo> decodeAccountInformation() {
		List<QRMerchantAccountInfo> merchantAccountInfos = new ArrayList<>();
		for(int i = 2; i < 52; i++) {
			QRField<Integer> field = this.getField(i);
			if(field != null) {
				if(field instanceof QRFieldComposit) {
					QRFieldComposit<Integer> composit = (QRFieldComposit<Integer>) field;
					Map<Integer, QRField<Integer>> fields = composit.getValue();
					QRMerchantAccountInfo accountInfo = new QRMerchantAccountInfo(i, (String) fields.get(0).getValue());
					for(Integer key : fields.keySet()) {
						if(key != 0) accountInfo.addChild(key, (String) fields.get(key).getValue());
					}
					merchantAccountInfos.add(accountInfo);
				}else merchantAccountInfos.add(new QRMerchantAccountInfo(i, (String) field.getValue()));
			}
		}
		return merchantAccountInfos;
	}
	
	private QRMerchantAdditionalData decodeAdditionalData(Integer fieldId) {
		if(this.hasField(fieldId)) {
			QRFieldComposit<Integer> composit = (QRFieldComposit<Integer>) this.getField(fieldId);
			QRMerchantAdditionalData additionalData = new QRMerchantAdditionalData();
			Map<Integer, QRField<Integer>> fields = composit.getValue();
			for(Integer key : fields.keySet()) {
				if(key == 1) additionalData.setBillNumber((String) fields.get(key).getValue());
				if(key == 2) additionalData.setMobileNumber((String) fields.get(key).getValue());
				if(key == 3) additionalData.setStoreLabel((String) fields.get(key).getValue());
				if(key == 4) additionalData.setLoyaltyNumber((String) fields.get(key).getValue());
				if(key == 5) additionalData.setReferenceLabel((String) fields.get(key).getValue());
				if(key == 6) additionalData.setCustomerLabel((String) fields.get(key).getValue());
				if(key == 7) additionalData.setTerminalLabel((String) fields.get(key).getValue());
				if(key == 8) additionalData.setPurposeOfTransaction((String) fields.get(key).getValue());
				if(key == 9) additionalData.setAdditionalConsumerData((String) fields.get(key).getValue());
			}
			return additionalData;
		}
		return null;
	}
	
	private QRMerchantLangauge decodeLocalLangauge(Integer fieldId) {
		if(this.hasField(fieldId)) {
			QRFieldComposit<Integer> composit = (QRFieldComposit<Integer>) this.getField(fieldId);
			QRMerchantLangauge localLangauge = new QRMerchantLangauge();
			Map<Integer, QRField<Integer>> fields = composit.getValue();
			for(Integer key : fields.keySet()) {
				if(key == 0) localLangauge.setLanguage((String) fields.get(key).getValue());
				if(key == 1) localLangauge.setMerchantName((String) fields.get(key).getValue());
				if(key == 2) localLangauge.setMerchantCityName((String) fields.get(key).getValue());
			}
			return localLangauge;
		}
		return null;
	}

	private void bindMerchantPostalCode(String postalCode) {
		if(postalCode != null && !postalCode.isEmpty()) {
			this.setValue(61, postalCode);
		}
	}

	private void bindAccountInformationField(List<QRMerchantAccountInfo> accountInfos) {
		QRUtil.validateRequired("Merchant account information", accountInfos);
		for(QRMerchantAccountInfo accountInfo : accountInfos) {
			this.bindQRMerchantAccountInfo(accountInfo);
		}
	}
	
	private final void bindQRMerchantAccountInfo(QRMerchantAccountInfo accountInfo) {
		if(accountInfo.getChild() == null || accountInfo.getChild().isEmpty()) {
			this.setValue(accountInfo.getFieldId(), accountInfo.getMerchantId());
		}else {
			Integer fieldId = accountInfo.getFieldId();
			Map<Integer, QRPackager<Integer>> packagers = this.getPackagers(fieldId);
			QRFieldComposit<Integer> composit = new QRFieldComposit<>(fieldId, packagers);
			for(Integer key: accountInfo.getChild().keySet()) {
				String value = accountInfo.getChild().get(key);
				QRPackager<Integer> packager = packagers.get(key);
				if(packager == null) {
					packager = new QRMerchantAlphaNumPackager(key, value.length(), false, "Acquirer Defined Field");
				}
				composit.setValue(key, value, packager);
			}
			this.setValue(fieldId, composit);
		}
	}

	private void bindMerchantAdditionalData(int fieldId, QRMerchantAdditionalData additionalData) {
		if(additionalData != null) {
			QRFieldComposit<Integer> composit = new QRFieldComposit<>(fieldId, this.getPackagers(fieldId));
			composit.setValue(1, additionalData.getBillNumber());
			composit.setValue(2, additionalData.getMobileNumber());
			composit.setValue(3, additionalData.getStoreLabel());
			composit.setValue(4, additionalData.getLoyaltyNumber());
			composit.setValue(5, additionalData.getReferenceLabel());
			composit.setValue(6, additionalData.getCustomerLabel());
			composit.setValue(7, additionalData.getTerminalLabel());
			composit.setValue(8, additionalData.getPurposeOfTransaction());
			composit.setValue(9, additionalData.getAdditionalConsumerData());
			this.setValue(fieldId, composit);
		}
	}

	private void bindLocalLangauge(int fieldId, QRMerchantLangauge localLangauge) {
		if(localLangauge != null) {
			QRFieldComposit<Integer> composit = new QRFieldComposit<>(fieldId, this.getPackagers(fieldId));
			QRUtil.validateRequired("Local language preference", localLangauge.getLanguage());
			composit.setValue(0, localLangauge.getLanguage());
			composit.setValue(1, localLangauge.getMerchantName());
			composit.setValue(2, localLangauge.getMerchantCityName());
			this.setValue(fieldId, composit);
		}
	}
	
	public Map<Integer, QRPackager<Integer>> getPackagers(Integer fieldId) {
		return ((QRMerchantCompositPackager) this.getPackager(fieldId)).getPackagers();
	}

	public <T> void setValue(Integer fieldId, T value) {
		if(fieldId != FIELD_CHECKSUM) super.setValue(fieldId, value);
	}
	
	@Override
	protected void extract(String qrString) {
		Integer fieldId = Integer.parseInt(qrString.substring(0, 2));
		Integer length = Integer.parseInt(qrString.substring(2, 4));
		QRPackager<Integer> packager = this.getPackager(fieldId);
		this.setField(packager.decode(fieldId, qrString.substring(4, 4 + length), packager));
		qrString = qrString.substring(4 + length);
		if(qrString != null && !qrString.isEmpty()) {
			this.extract(qrString);
		}
	}

	@Override
	protected String build(ByteArrayOutputStream output) throws IOException {
		output.write(String.format("%02d%02d", FIELD_CHECKSUM, this.getPackager(FIELD_CHECKSUM).getLength()).getBytes());
		String checksum = QRUtil.getCRC(output.toString());
		output.write(checksum.getBytes());
		return QRUtil.byteToHex(output.toByteArray());
	}

}
