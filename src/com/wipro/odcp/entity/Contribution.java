package com.wipro.odcp.entity;

public class Contribution {
      
	private String contibutionId;
	private String userId;
	private String campaignId;
	private double amount;
	private String date;
	
	
	public Contribution(String contibutionId, String userId, String campaignId, double amount, String date) {
		this.contibutionId = contibutionId;
		this.userId = userId;
		this.campaignId = campaignId;
		this.amount = amount;
		this.date = date;
	}
	
	
	public String getContibutionId() {
		return contibutionId;
	}
	
	public void setContibutionId(String contibutionId) {
		this.contibutionId = contibutionId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}
	
	

	public String getCampaignId() {
		return campaignId;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDate() {
		return date;
	}
	
	
	
}
