package com.business.model;

import java.util.Date;

public class ClientOfferModel {

	private int offerId;
	private int clientId;
	private String imageVideo;
	private String startDate;
	private String endDate;
	private String couponCode;
	private String websiteLink;
	private String temsAndCond;
	public int getOfferId() {
		return offerId;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getImageVideo() {
		return imageVideo;
	}
	public void setImageVideo(String imageVideo) {
		this.imageVideo = imageVideo;
	}
	
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getWebsiteLink() {
		return websiteLink;
	}
	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}
	public String getTemsAndCond() {
		return temsAndCond;
	}
	public void setTemsAndCond(String temsAndCond) {
		this.temsAndCond = temsAndCond;
	}
	@Override
	public String toString() {
		return "ClientOfferModel [offerId=" + offerId + ", clientId=" + clientId + ", imageVideo=" + imageVideo
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", couponCode=" + couponCode + ", websiteLink="
				+ websiteLink + ", temsAndCond=" + temsAndCond + "]";
	}
	
	
}
