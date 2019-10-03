package com.business.model;

import java.util.Date;

public class ClientDetailsModel {

	private int clientId;
	private int catId;
	private int subCatId;
	private String businessName;
	private String contactNo;
	private String landLineNo;
	private String bussOpenDate;
	private String bussOpenDays;
	private String bussOpenTime;
	private String email;
	private String password;
	private String image;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getLandLineNo() {
		return landLineNo;
	}
	public void setLandLineNo(String landLineNo) {
		this.landLineNo = landLineNo;
	}
	public String getBussOpenDate() {
		return bussOpenDate;
	}
	public void setBussOpenDate(String bussOpenDate) {
		this.bussOpenDate = bussOpenDate;
	}
	public String getBussOpenDays() {
		return bussOpenDays;
	}
	public void setBussOpenDays(String bussOpenDays) {
		this.bussOpenDays = bussOpenDays;
	}
	public String getBussOpenTime() {
		return bussOpenTime;
	}
	public void setBussOpenTime(String bussOpenTime) {
		this.bussOpenTime = bussOpenTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ClientDetailsModel [clientId=" + clientId + ", catId=" + catId + ", subCatId=" + subCatId
				+ ", businessName=" + businessName + ", contactNo=" + contactNo + ", landLineNo=" + landLineNo
				+ ", bussOpenDate=" + bussOpenDate + ", bussOpenDays=" + bussOpenDays + ", bussOpenTime=" + bussOpenTime
				+ ", email=" + email + ", password=" + password + ", image=" + image + ", getClientId()="
				+ getClientId() + ", getCatId()=" + getCatId() + ", getSubCatId()=" + getSubCatId()
				+ ", getBusinessName()=" + getBusinessName() + ", getContactNo()=" + getContactNo()
				+ ", getLandLineNo()=" + getLandLineNo() + ", getBussOpenDate()=" + getBussOpenDate()
				+ ", getBussOpenDays()=" + getBussOpenDays() + ", getBussOpenTime()=" + getBussOpenTime()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getImage()=" + getImage()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
