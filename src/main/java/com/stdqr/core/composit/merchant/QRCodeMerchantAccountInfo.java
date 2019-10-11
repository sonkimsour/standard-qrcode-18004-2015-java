package com.stdqr.core.composit.merchant;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodeMerchantAccountInfo {
	private String globallyUniqueId;
	private String accountNumber;
	private String loyaltyId;

	public String getGloballyUniqueId() {
		return globallyUniqueId;
	}

	public void setGloballyUniqueId(String globallyUniqueId) {
		this.globallyUniqueId = globallyUniqueId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLoyaltyId() {
		return loyaltyId;
	}

	public void setLoyaltyId(String loyaltyId) {
		this.loyaltyId = loyaltyId;
	}

}
