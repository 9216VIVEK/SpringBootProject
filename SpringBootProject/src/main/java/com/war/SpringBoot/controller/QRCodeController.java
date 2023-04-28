package com.war.SpringBoot.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * <h1> Infinite Computer Solutions </h1>
 * @author Vivek S Rawat
 * @since April 26, 2023
 */


@RestController
@RequestMapping("/api/v1/QRCode")
public class QRCodeController {
	
	@GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> generateCode(@RequestParam String url){
		
		try {
			
//		    String encodedUrl = "https://chart.googleapis.com/chart?cht=qr&chs=300x300&chl=" + URLEncoder.encode(url, StandardCharsets.UTF_8);


			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 300, 300);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
	        byte[] pngBytes = outputStream.toByteArray();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_PNG);
	        headers.setContentLength(pngBytes.length);

	        return new ResponseEntity<>(pngBytes, headers, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}

}
