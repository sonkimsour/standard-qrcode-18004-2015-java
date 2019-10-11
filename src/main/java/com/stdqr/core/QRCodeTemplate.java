package com.stdqr.core;

/**
 * 
 * @author Kimsour
 * @email sonkimsour@gmail.com
 *
 */
public interface QRCodeTemplate {
	
	public <T extends QRCodePackager> void add(T template);

	public <T extends QRCodePackager> T get(int fieldId);
	
}
