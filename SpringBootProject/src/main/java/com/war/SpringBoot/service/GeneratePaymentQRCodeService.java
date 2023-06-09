package com.war.SpringBoot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


/**
 * <h1> Infinite Computer Solutions </h1>
 * @author Vivek S Rawat
 * @since April 29, 2023
 */

@Service
@Scope("prototype")
public class GeneratePaymentQRCodeService extends GenericQRCodeGenerator {

	public void setUrl(String receiverUPI,String name,double amount) {
		String url = "upi://pay?pa="+receiverUPI+"&pn="+name+"&cu=INR&am="+amount;
		this.setUrl(url);
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	};
}
