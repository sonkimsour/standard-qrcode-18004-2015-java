package com.stdqr.test;

import java.math.BigDecimal;

import com.stdqr.MerchantQRCode;
import com.stdqr.constant.QRCodeType;
import com.stdqr.constant.QRCodeVersion;
import com.stdqr.core.composit.merchant.QRCodeMerchantAccountInfo;
import com.stdqr.core.composit.merchant.QRCodeMerchantAdditionalData;
import com.stdqr.core.composit.merchant.QRCodeMerchantInfo;
import com.stdqr.core.composit.merchant.QRMerchantLangauge;
import com.stdqr.util.QRCodeUtil;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodeTest {

	public static void main(String[] args) {
		MerchantQRCode qrcode = new MerchantQRCode()
			.setVersion(QRCodeVersion.V1)
			.setType(QRCodeType.DYNAMIC)
			.setMerchantInfo(bindMerchantInfo())
			.setTransactionAmount(new BigDecimal("23.72"))
			.setTransactionCurrency("CNY")
			.setTip("01");
		System.out.println("***************** QRCODE DETAILS *****************");
		System.out.println("CHECKSUM: " + qrcode.getChecksum());
		System.out.println("QRCODE: " + new String(QRCodeUtil.hexToBytes(qrcode.getQRCode())));
		System.out.println("**************************************************");
	}

	private static QRCodeMerchantInfo bindMerchantInfo() {
		QRCodeMerchantInfo merchantInfo = new QRCodeMerchantInfo();
		merchantInfo.setMerchantCategoryCode("4111");
		merchantInfo.setCountryCode("CN");
		merchantInfo.setMerchantName("Best Transport");
		merchantInfo.setMerchantCity("Beijing");
		merchantInfo.setLocalLangauge(bindLangaugeTemplate());
		merchantInfo.setAccountInformationField29(bindMerchantAccountInformation29());
		merchantInfo.setAccountInformationField31(bindMerchantAccountInformation31());
		merchantInfo.setAccountInformationField91(bindMerchantAccountInformation91());
		merchantInfo.setAdditionalData(bindAdditionalData());
		return merchantInfo;
	}

	private static QRMerchantLangauge bindLangaugeTemplate() {
		QRMerchantLangauge langauge = new QRMerchantLangauge();
		langauge.setLanguage("ZH");
		langauge.setMerchantName("最佳运输");
		langauge.setMerchantCityName("北京");
		return langauge;
	}

	private static QRCodeMerchantAccountInfo bindMerchantAccountInformation29() {
		QRCodeMerchantAccountInfo merchantInfo = new QRCodeMerchantAccountInfo();
		merchantInfo.setGloballyUniqueId("D15600000000");
		merchantInfo.setAccountNumber("A93FO3230Q");
		return merchantInfo;
	}
	
	private static QRCodeMerchantAccountInfo bindMerchantAccountInformation31() {
		QRCodeMerchantAccountInfo merchantInfo = new QRCodeMerchantAccountInfo();
		merchantInfo.setGloballyUniqueId("D15600000001");
		merchantInfo.setAccountNumber("12345678");
		return merchantInfo;
	}
	
	private static QRCodeMerchantAccountInfo bindMerchantAccountInformation91() {
		QRCodeMerchantAccountInfo merchantInfo = new QRCodeMerchantAccountInfo();
		merchantInfo.setGloballyUniqueId("A011223344998877");
		merchantInfo.setLoyaltyId("12345678");
		return merchantInfo;
	}
	
	private static QRCodeMerchantAdditionalData bindAdditionalData() {
		QRCodeMerchantAdditionalData additionalData = new QRCodeMerchantAdditionalData();
		additionalData.setStoreLabel("1234");
		additionalData.setCustomerLabel("Jonh");
		additionalData.setTerminalLabel("A6008667");
		additionalData.setAdditionalConsumerData("ME");
		return additionalData;
	}
	
}
