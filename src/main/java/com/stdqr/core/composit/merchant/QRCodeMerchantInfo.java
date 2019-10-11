package com.stdqr.core.composit.merchant;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodeMerchantInfo {
	private String merchantCategoryCode;
	private String countryCode;
	private String merchantName;
	private String merchantCity;
	private QRMerchantLangauge localLangauge;
	private QRCodeMerchantAccountInfo accountInformationField29;
	private QRCodeMerchantAccountInfo accountInformationField31;
	private QRCodeMerchantAccountInfo accountInformationField91;
	private QRCodeMerchantAdditionalData additionalData;

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

	public QRMerchantLangauge getLocalLangauge() {
		return localLangauge;
	}

	public void setLocalLangauge(QRMerchantLangauge localLangauge) {
		this.localLangauge = localLangauge;
	}

	public QRCodeMerchantAccountInfo getAccountInformationField29() {
		return accountInformationField29;
	}

	public void setAccountInformationField29(QRCodeMerchantAccountInfo accountInformationField29) {
		this.accountInformationField29 = accountInformationField29;
	}

	public QRCodeMerchantAccountInfo getAccountInformationField31() {
		return accountInformationField31;
	}

	public void setAccountInformationField31(QRCodeMerchantAccountInfo accountInformationField31) {
		this.accountInformationField31 = accountInformationField31;
	}

	public QRCodeMerchantAccountInfo getAccountInformationField91() {
		return accountInformationField91;
	}

	public void setAccountInformationField91(QRCodeMerchantAccountInfo accountInformationField91) {
		this.accountInformationField91 = accountInformationField91;
	}

	public QRCodeMerchantAdditionalData getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(QRCodeMerchantAdditionalData additionalData) {
		this.additionalData = additionalData;
	}

}
