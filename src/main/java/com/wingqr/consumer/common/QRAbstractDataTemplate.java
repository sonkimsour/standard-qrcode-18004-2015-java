package com.wingqr.consumer.common;

public abstract class QRAbstractDataTemplate {
	private String applicationDefinitionFile;
	private String applicationLabel;
	private QRTrack2EquivalentData track2EquivalentData;
	private String applicationPAN;
	private String cardholderName;
	private String languagePreference;
	private String issuerUrl;
	private String applicationVersionNumber;
	private String tokenRequestorId;
	private String paymentAccountReference;
	private String last4DigitsOfPAN;
	private String issuerApplicationData;
	private String applicationCryptogram;
	private String applicationTransactionCounter;
	private String unpredictableNumber;

	public String getApplicationDefinitionFile() {
		return applicationDefinitionFile;
	}

	public void setApplicationDefinitionFile(String applicationDefinitionFile) {
		this.applicationDefinitionFile = applicationDefinitionFile;
	}

	public String getApplicationLabel() {
		return applicationLabel;
	}

	public void setApplicationLabel(String applicationLabel) {
		this.applicationLabel = applicationLabel;
	}

	public QRTrack2EquivalentData getTrack2EquivalentData() {
		return track2EquivalentData;
	}

	public void setTrack2EquivalentData(QRTrack2EquivalentData track2EquivalentData) {
		this.track2EquivalentData = track2EquivalentData;
	}

	public String getApplicationPAN() {
		return applicationPAN;
	}

	public void setApplicationPAN(String applicationPAN) {
		this.applicationPAN = applicationPAN;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getLanguagePreference() {
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public String getIssuerUrl() {
		return issuerUrl;
	}

	public void setIssuerUrl(String issuerUrl) {
		this.issuerUrl = issuerUrl;
	}

	public String getApplicationVersionNumber() {
		return applicationVersionNumber;
	}

	public void setApplicationVersionNumber(String applicationVersionNumber) {
		this.applicationVersionNumber = applicationVersionNumber;
	}

	public String getTokenRequestorId() {
		return tokenRequestorId;
	}

	public void setTokenRequestorId(String tokenRequestorId) {
		this.tokenRequestorId = tokenRequestorId;
	}

	public String getPaymentAccountReference() {
		return paymentAccountReference;
	}

	public void setPaymentAccountReference(String paymentAccountReference) {
		this.paymentAccountReference = paymentAccountReference;
	}

	public String getLast4DigitsOfPAN() {
		return last4DigitsOfPAN;
	}

	public void setLast4DigitsOfPAN(String last4DigitsOfPAN) {
		this.last4DigitsOfPAN = last4DigitsOfPAN;
	}

	public String getIssuerApplicationData() {
		return issuerApplicationData;
	}

	public void setIssuerApplicationData(String issuerApplicationData) {
		this.issuerApplicationData = issuerApplicationData;
	}

	public String getApplicationCryptogram() {
		return applicationCryptogram;
	}

	public void setApplicationCryptogram(String applicationCryptogram) {
		this.applicationCryptogram = applicationCryptogram;
	}

	public String getApplicationTransactionCounter() {
		return applicationTransactionCounter;
	}

	public void setApplicationTransactionCounter(String applicationTransactionCounter) {
		this.applicationTransactionCounter = applicationTransactionCounter;
	}

	public String getUnpredictableNumber() {
		return unpredictableNumber;
	}

	public void setUnpredictableNumber(String unpredictableNumber) {
		this.unpredictableNumber = unpredictableNumber;
	}

}
