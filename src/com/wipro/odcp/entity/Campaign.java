package com.wipro.odcp.entity;

public class Campaign {
	
      private String campaignId;
      private String ownerId;
      private String title;
      private String discription;
      private double goalAmount;
      private double collectedAmount;
      private boolean active;
      
      
      
      
      
	

	  public Campaign(String campaignId, String ownerId, String title, String discription, double goalAmount,
			double collectedAmount, boolean active) {
		
		this.campaignId = campaignId;
		this.ownerId = ownerId;
		this.title = title;
		this.discription = discription;
		this.goalAmount = goalAmount;
		this.collectedAmount = collectedAmount;
		this.active = active;
	}
	 






	









	  public String getCampaignId() {
		  return campaignId;
	  }
	  
	  public String getOwnerId() {
		  return ownerId;
	  } 
	  
	  public String getTitle() {
		  return title;
	  }
	  
	  public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	  public void setOwnerId(String ownerId) {
		  this.ownerId = ownerId;
	  }

	  public void setTitle(String title) {
		  this.title = title;
	  }

	  public void setDiscription(String discription) {
		  this.discription = discription;
	  }

	  public void setGoalAmount(double goalAmount) {
		  this.goalAmount = goalAmount;
	  }

	

	 
	  public void setCollectedAmount(double collectedAmount) {
		this.collectedAmount = collectedAmount;
	}

















	  public String getDiscription() {
		  return discription;
	  }
	  
	  public double getGoalAmount() {
		  return goalAmount;
	  }
	  
	  public double getCollectedAmount() {
		  return collectedAmount;
	  }
	  
	  public boolean isActive() {
		  return active;
	  } 
	  
	  public void setActive(boolean active) {
		  this.active = active;
	  }

      
      
            
      
}
