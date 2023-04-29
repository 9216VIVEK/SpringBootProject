package com.war.SpringBoot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
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
