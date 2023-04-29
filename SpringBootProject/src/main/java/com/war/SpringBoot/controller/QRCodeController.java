package com.war.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.war.SpringBoot.service.GeneratePaymentQRCodeService;

/**
 * <h1> Infinite Computer Solutions </h1>
 * @author Vivek S Rawat
 * @since April 29, 2023
 */


@RestController
@RequestMapping("/api/v1/QRCode")
public class QRCodeController {
	
	@Autowired
	private GeneratePaymentQRCodeService qrCodeService;
	
	@GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<?> generateCode(
			@RequestParam String receiverUPI,
			@RequestParam String name,
			@RequestParam double amount){
		
		try {
			
			qrCodeService.setUrl(receiverUPI, name, amount);
			
			byte[] generateCode = qrCodeService.generateCode();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_PNG);
	        headers.setContentLength(generateCode.length);

	        return new ResponseEntity<>(generateCode, headers, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}

}
