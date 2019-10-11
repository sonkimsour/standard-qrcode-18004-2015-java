package com.stdqr.core.composit.merchant;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodeMerchantAdditionalData {
	private String billNumber;
	private String mobileNumber;
	private String storeLabel;
	private String loyaltyNumber;
	private String referenceLabel;
	private String customerLabel;
	private String terminalLabel;
	private String purposeOfTransaction;
	private String additionalConsumerData;

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStoreLabel() {
		return storeLabel;
	}

	public void setStoreLabel(String storeLabel) {
		this.storeLabel = storeLabel;
	}

	public String getLoyaltyNumber() {
		return loyaltyNumber;
	}

	public void setLoyaltyNumber(String loyaltyNumber) {
		this.loyaltyNumber = loyaltyNumber;
	}

	public String getReferenceLabel() {
		return referenceLabel;
	}

	public void setReferenceLabel(String referenceLabel) {
		this.referenceLabel = referenceLabel;
	}

	public String getCustomerLabel() {
		return customerLabel;
	}

	public void setCustomerLabel(String customerLabel) {
		this.customerLabel = customerLabel;
	}

	public String getTerminalLabel() {
		return terminalLabel;
	}

	public void setTerminalLabel(String terminalLabel) {
		this.terminalLabel = terminalLabel;
	}

	public String getPurposeOfTransaction() {
		return purposeOfTransaction;
	}

	public void setPurposeOfTransaction(String purposeOfTransaction) {
		this.purposeOfTransaction = purposeOfTransaction;
	}

	public String getAdditionalConsumerData() {
		return additionalConsumerData;
	}

	public void setAdditionalConsumerData(String additionalConsumerData) {
		this.additionalConsumerData = additionalConsumerData;
	}

}
