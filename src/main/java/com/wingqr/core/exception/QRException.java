package com.wingqr.core.exception;

import java.io.IOException;

public class QRException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public QRException(String message) {
		super(message);
	}

	public QRException(IOException ex) {
		super(ex);
	}

}
