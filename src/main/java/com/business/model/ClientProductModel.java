package com.business.model;

public class ClientProductModel {

	private int proId;
	private int clientId;
	private String imageVideo;
	private String title;
	private String description;
	private int price;
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getImageVideo() {
		return imageVideo;
	}
	public void setImageVideo(String imageVideo) {
		this.imageVideo = imageVideo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ClientProductModel [proId=" + proId + ", clientId=" + clientId + ", imageVideo=" + imageVideo
				+ ", title=" + title + ", description=" + description + ", price=" + price + "]";
	}
	
	
}
