package com.tap.controller;

public class Secure {	
	//ENCRYPTION
	public static String encrypt(String str) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			sb.append((char)(ch+2));
		}
		return sb.toString();
	}
	
	//DECRYPTION
	public static String decrypt(String str) {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			sb.append((char)(ch-2));
		}
		return sb.toString();
	}	
}
