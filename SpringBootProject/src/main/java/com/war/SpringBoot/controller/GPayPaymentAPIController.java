package com.war.SpringBoot.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.war.SpringBoot.service.GooglePayService;

@RestController
@RequestMapping("/api/v1/googlePay")
public class GPayPaymentAPIController {
	
	@Autowired
	GooglePayService googlePayService;
	
	@GetMapping("/makePayment")
	public ResponseEntity<?> makePayment(
			@RequestParam String mobileNo,
			@RequestParam double amount){
		
		HashMap<String,String> responseData = new HashMap<>();
		
		try {
			googlePayService.makePayment(mobileNo, amount);
		} catch (Exception e) {
			responseData.put("status", "ERROR");
			responseData.put("statusmsg",e.getMessage());
			return new ResponseEntity<>(responseData,HttpStatus.EXPECTATION_FAILED);
		}
        
		return ResponseEntity.ok("");
	}

}
