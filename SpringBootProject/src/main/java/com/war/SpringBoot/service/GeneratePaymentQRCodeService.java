package com.war.SpringBoot.service;

import org.springframework.stereotype.Service;

@Service
public class GeneratePaymentQRCodeService extends GenericQRCodeGenerator {

	private String url; 
	
	@Override
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String receiverUPI,String name,double amount) {
		this.url = "upi://pay?pa="+receiverUPI+"&pn="+name+"&cu=INR&am="+amount;
	}

}
