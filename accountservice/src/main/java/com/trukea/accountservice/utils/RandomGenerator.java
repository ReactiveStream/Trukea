package com.trukea.accountservice.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {
	
	public static final String ALPHABETS_SEQUENCE="qazxswe@dcvfrtg#bnhyujmkiolp$";
	public static final String NUMBER_SEQUENCE="9348257631";
	
	
	
	
	public static String generateOtpCode(int length) {
		String otpcode="";
		Random random=new Random();
		
		 for(int i=1;i<=length;i++) {
			 
			 char c=NUMBER_SEQUENCE.charAt(random.nextInt(10));
			 otpcode=otpcode+c;
		 }
		 System.out.println(otpcode);
		 return otpcode;
		
	}
	
	public static  String generateEmailVerificationCode(int length) {
		String emailverificationcode="";
		Random random=new Random();
		for(int i=1;i<=length;i++) {
		   char c=ALPHABETS_SEQUENCE.charAt(random.nextInt(29));
		   emailverificationcode=emailverificationcode+c;
		}
		 System.out.println(emailverificationcode);
		return emailverificationcode;
		
	}

}
