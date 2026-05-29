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
	
	@Override
	    public String toString() {

	        return "ContibutionId: "+contibutionId+"\n UserId: "+userId+"\n campaignId:"+campaignId+"\n amount:"+amount+"\n date: "+date;
	    }
	}
	
	

	
	

