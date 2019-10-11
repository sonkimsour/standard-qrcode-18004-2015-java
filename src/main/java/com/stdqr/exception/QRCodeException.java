package com.stdqr.exception;

import java.io.IOException;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public class QRCodeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public QRCodeException(String message) {
		super(message);
	}

	public QRCodeException(IOException ex) {
		super(ex);
	}

}
