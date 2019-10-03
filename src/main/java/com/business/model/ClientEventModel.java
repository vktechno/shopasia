package com.business.model;

public class ClientEventModel {

	private int eventId;
	private int clientId;
	private String imageVideo;
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "ClientEventModel [eventId=" + eventId + ", clientId=" + clientId + ", imageVideo=" + imageVideo
				+ ", title=" + title + ", description=" + description + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
}
