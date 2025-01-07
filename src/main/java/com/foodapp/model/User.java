package com.foodapp.model;

public class User {
	private int uid;
	private String name,pswd,email,address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {
		super();
	}
	
	public User(String name, String pswd, String email, String address) {
		super();
		this.name = name;
		this.pswd = pswd;
		this.email = email;
		this.address = address;
	}
	public User(int uid,String name, String pswd, String email, String address) {
		super();
		this.uid=uid;
		this.name = name;
		this.pswd = pswd;
		this.email = email;
		this.address = address;
	}
	@Override
	public String toString() {
		return  name+" "+ pswd+"   "+ email+"   "+ address;
	}
	

}
