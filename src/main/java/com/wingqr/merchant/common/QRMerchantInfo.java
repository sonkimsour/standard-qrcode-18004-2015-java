package com.wingqr.merchant.common;

import java.util.List;

public class QRMerchantInfo {
	private String merchantCategoryCode;
	private String countryCode;
	private String merchantName;
	private String merchantCity;
	private String postalCode;
	private QRMerchantLangauge localLangauge;
	private List<QRMerchantAccountInfo> accountInformation;
	private QRMerchantAdditionalData additionalData;

	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}

	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantCity() {
		return merchantCity;
	}

	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public QRMerchantLangauge getLocalLangauge() {
		return localLangauge;
	}

	public void setLocalLangauge(QRMerchantLangauge localLangauge) {
		this.localLangauge = localLangauge;
	}

	public List<QRMerchantAccountInfo> getAccountInformation() {
		return accountInformation;
	}

	public void setAccountInformation(List<QRMerchantAccountInfo> accountInformation) {
		this.accountInformation = accountInformation;
	}

	public QRMerchantAdditionalData getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(QRMerchantAdditionalData additionalData) {
		this.additionalData = additionalData;
	}

}
