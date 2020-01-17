package com.wingqr.consumer.common.application;

import com.wingqr.consumer.common.QRAbstractDataTemplate;

public class QRApplicationTemplate extends QRAbstractDataTemplate {
	private QRApplicationSpecificTransparent applicationSpecificTransparent;

	public QRApplicationSpecificTransparent getApplicationSpecificTransparent() {
		return applicationSpecificTransparent;
	}

	public void setApplicationSpecificTransparent(QRApplicationSpecificTransparent applicationSpecificTransparent) {
		this.applicationSpecificTransparent = applicationSpecificTransparent;
	}

}
