package com.war.SpringBoot.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public abstract class GenericQRCodeGenerator {
	
	public abstract String getUrl();
	
	public byte[] generateCode() throws IOException, WriterException{
		
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(getUrl(), BarcodeFormat.QR_CODE, 300, 300);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

	        return outputStream.toByteArray();
			
	}
}
