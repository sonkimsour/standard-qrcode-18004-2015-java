package com.wingqr.test;

import java.util.Base64;
import java.util.Date;

import com.wingqr.consumer.QRConsumer;
import com.wingqr.consumer.common.QRTrack2EquivalentData;
import com.wingqr.consumer.common.application.QRApplicationTemplate;
import com.wingqr.consumer.common.data.QRCommonDataTemplate;
import com.wingqr.core.constant.QRVersion;
import com.wingqr.core.util.QRUtil;

public class QRConsumerTest {

	public static void main(String[] args) {
		QRConsumer qrcode = new QRConsumer();
		qrcode.setVersion(QRVersion.CONSUMER.getCode());
		qrcode.addApplicationTemplate(bindApplicationTemplate1());
		//qrcode.addApplicationTemplate(bindApplicationTemplate2());
		///qrcode.setCommonDataTemplate(bindCommonDataTemplate());
		System.out.println("***************** QRCODE DETAILS *****************");
		System.out.println("BASE64: " + qrcode.pack());
		System.out.println("HEX: " + QRUtil.byteToHex(Base64.getDecoder().decode(qrcode.pack())));
		System.out.println("**************************************************");
	}

	private static QRApplicationTemplate bindApplicationTemplate1() {
		QRApplicationTemplate template = new QRApplicationTemplate();
		template.setApplicationDefinitionFile("A0000000555555");
		template.setTrack2EquivalentData(bindTrack2EquivalentData());
		return template;
	}

	private static QRTrack2EquivalentData bindTrack2EquivalentData() {
		QRTrack2EquivalentData track2EquivalentData = new QRTrack2EquivalentData();
		track2EquivalentData.setAccountNumber("1234567890123458");
		track2EquivalentData.setExpiryDate(new Date());
		track2EquivalentData.setServiceCode("201");
		track2EquivalentData.setDiscretionaryData("12345");
		return track2EquivalentData;
	}

	private static QRApplicationTemplate bindApplicationTemplate2() {
		return null;
	}

	private static QRCommonDataTemplate bindCommonDataTemplate() {
		return null;
	}
	
}
