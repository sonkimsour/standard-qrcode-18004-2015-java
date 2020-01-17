package com.wingqr.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wingqr.core.constant.QRType;
import com.wingqr.core.constant.QRVersion;
import com.wingqr.core.util.QRUtil;
import com.wingqr.merchant.QRMerchant;
import com.wingqr.merchant.common.QRMerchantAccountInfo;
import com.wingqr.merchant.common.QRMerchantInfo;
import com.wingqr.merchant.common.QRMerchantLangauge;

public class QRMerchantTest {

	public static void main(String[] args) {
		QRMerchant qrcode = new QRMerchant();
		qrcode.setVersion(QRVersion.MERCHANT.getCode());
		qrcode.setType(QRType.STATIC);
		qrcode.setMerchantInfo(bindMerchantInfo());
		qrcode.setTransactionAmount(new BigDecimal("23.72"));
		qrcode.setTransactionCurrency("USD");
		//qrcode.setTip("01");
		System.out.println("******************* QRCODE DETAILS *********************");
		System.out.println("QRCODE: " + ((qrcode.pack() != null) ? new String(QRUtil.hexToBytes(qrcode.pack())) : null));
		qrcode.unpack("00020101021129430025hangsoung_chann_1980@wing0110A93FO3230Q520459995303840540523.725802KH5915Hangsoung Chann6010Phnom Penh61051200064230002EN0104Wing0205Money630457C9");
		QRMerchantInfo merchantInfo = qrcode.getMerchantInfo();
		displayTransactionDetails(qrcode);
		displayMerchantDetails(merchantInfo);
		displayAccountDetails(merchantInfo);
		displayAditionalData(merchantInfo);
		displayLangauge(merchantInfo);
		System.out.println("********************************************************");
	}

	private static void displayTransactionDetails(QRMerchant qrcode) {
		System.out.println("***************** TRANSACTION DETAILS ******************");
		System.out.println("Version: " + qrcode.getVersion());
		System.out.println("Type: " + qrcode.getType());
		System.out.println("Transaction amount: " + qrcode.getTransactionAmount());
		System.out.println("Transaction currency: " + qrcode.getTransactionCurrency());
	}

	private static void displayMerchantDetails(QRMerchantInfo merchantInfo) {
		System.out.println("***************** MERCHANT DETAILS ********************");
		System.out.println("Mercahnt name: " + merchantInfo.getMerchantName());
		System.out.println("Mercahnt city: " + merchantInfo.getMerchantCity());
		System.out.println("Mercahnt country code: " + merchantInfo.getCountryCode());
		System.out.println("Mercahnt category code: " + merchantInfo.getMerchantCategoryCode());
		System.out.println("Mercahnt postal code: " + merchantInfo.getPostalCode());
	}
	
	private static void displayAccountDetails(QRMerchantInfo merchantInfo) {
		System.out.println("***************** ACCOUNT INFORMATION ******************");
		List<QRMerchantAccountInfo> accountInfos = merchantInfo.getAccountInformation();
		for(QRMerchantAccountInfo accountInfo : accountInfos) {
			System.out.println("Merchant type: " + accountInfo.getMerchantType());
			System.out.println("Merchant id: " + accountInfo.getMerchantId());
		}
	}

	private static void displayAditionalData(QRMerchantInfo merchantInfo) {
		System.out.println("******************* ADITIONAL DATA *********************");
		
	}
	
	private static void displayLangauge(QRMerchantInfo merchantInfo) {
		System.out.println("***************** LANGAUGE INFORMATION *****************");
		QRMerchantLangauge langauge = merchantInfo.getLocalLangauge();
		System.out.println("Language: " + langauge.getLanguage());
		System.out.println("Merchant name: " + langauge.getMerchantName());
		System.out.println("Merchant city name: " + langauge.getMerchantCityName());
	}

	private static QRMerchantInfo bindMerchantInfo() {
		QRMerchantInfo merchantInfo = new QRMerchantInfo();
		merchantInfo.setMerchantCategoryCode("5999");
		merchantInfo.setCountryCode("KH");
		merchantInfo.setMerchantName("Hangsoung Chann");
		merchantInfo.setMerchantCity("Phnom Penh");
		merchantInfo.setPostalCode("12000");
		merchantInfo.setLocalLangauge(bindLangaugeTemplate());
		merchantInfo.setAccountInformation(bindMerchantAccountInformation());
		return merchantInfo;
	}

	private static QRMerchantLangauge bindLangaugeTemplate() {
		QRMerchantLangauge langauge = new QRMerchantLangauge();
		langauge.setLanguage("EN");
		langauge.setMerchantName("Wing");
		langauge.setMerchantCityName("Money");
		return langauge;
	}

	private static List<QRMerchantAccountInfo> bindMerchantAccountInformation() {
		List<QRMerchantAccountInfo> merchantInfos = new ArrayList<>();
		merchantInfos.add(bindLocalMerchantInfo());
		return merchantInfos;
	}

	private static QRMerchantAccountInfo bindLocalMerchantInfo() {
		QRMerchantAccountInfo merchantInfo = new QRMerchantAccountInfo(29, "hangsoung_chann_1980@wing");
		merchantInfo.addChild(1, "A93FO3230Q");
		return merchantInfo;
	}
	
}
