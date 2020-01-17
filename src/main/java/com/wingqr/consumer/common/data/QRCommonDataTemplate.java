package com.wingqr.consumer.common.data;

import com.wingqr.consumer.common.QRAbstractDataTemplate;

public class QRCommonDataTemplate extends QRAbstractDataTemplate {
	private QRCommonDataTransparent commonDataTransparent;

	public QRCommonDataTransparent getCommonDataTransparent() {
		return commonDataTransparent;
	}

	public void setCommonDataTransparent(QRCommonDataTransparent commonDataTransparent) {
		this.commonDataTransparent = commonDataTransparent;
	}

}
