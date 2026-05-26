package com.wipro.odcp.service;
import java.util.*;

import com.wipro.odcp.entity.Campaign;
import com.wipro.odcp.entity.Contribution;
import com.wipro.odcp.entity.User;
import com.wipro.odcp.util.CampaignNotFoundException;
import com.wipro.odcp.util.InvalidContributionException;
import com.wipro.odcp.util.UserNotFoundException;







public class CrowdfundingService {
	
	private ArrayList<User> user = new ArrayList<User>();
	private ArrayList<Campaign> campaign = new ArrayList<Campaign>();
	private ArrayList<Contribution> contribution = new ArrayList<Contribution>();
	double remainingAmount ;
	
	//constructor
	public CrowdfundingService(ArrayList<User> users, ArrayList<Campaign> campaigns, ArrayList<Contribution> contributions) {
		this.user=users;
		this.campaign=campaigns;
		this.contribution=contributions;
		
	}
	
	public void addUser(User u) {
										
		
		
			for(User unew : user) {
				if(unew.getUserID().equals(u.getUserID())) {
				    System.out.println("userID already exist.");
					break;
				}
			    if(unew.getEmail().equals(u.getEmail())) {
					System.out.println("user email already  exist.");
					break;
				}
				else {
					user.add(u);
				}
			}
			
		}
	  
	  
	
	public User findUser(String userId) throws UserNotFoundException {
		
		for (User u : user) {
			if(u.getUserID().equals(userId)) {
				return u;
			}
//			else {
//				throw new UserNotFoundException();
//			}
		}
		return null; 
		
		
	}
	
	
	public void createCampaign(Campaign c) throws UserNotFoundException {
		
		//for loop to campare uid
		for(User u : user) {
			if(u.getUserID().equals(c.getOwnerId())) {
				System.out.println("Campaign"+c.getTitle()+" Created..");
				campaign.add(c);
			}
			else {
				System.out.println("User ID mismatch.Please check your UserID and try again");
			}
		}
		
	}
	
	public Campaign findCampaign(String 
			campaignId) throws CampaignNotFoundException{
		
		for( Campaign c : campaign){
			if (c.getCampaignId().equals(campaignId)) {
			
//				System.out.println("exist");
				return c;
			}
		}
		
		throw new CampaignNotFoundException();
		
	}
	
	//no return type
	public void contribute(String contributionId, 
			String userId, String campaignId, double 
			amount, String date) throws 
			UserNotFoundException, 
			CampaignNotFoundException, 
			InvalidContributionException {
		
		findUser(userId);
		findCampaign(campaignId);
			
		if(amount<=0) {
				
			throw new InvalidContributionException();
			
		}
	
		//unique contribution id
		for (Contribution c: contribution) {
			if(c.getContibutionId().equals(contributionId)) {
				System.out.println("Contribution id alread exist please choose new Contribution ID.");
			}
		}
		
	    Contribution contribute =new Contribution(contributionId,userId,campaignId,amount,date);
	    contribution.add(contribute);
	    
	    for(Campaign camp : campaign) {
	    	if(camp.getCampaignId().equals(campaignId)) {
	    		camp.setCollectedAmount(amount);
	    		remainingAmount=camp.getGoalAmount()-camp.getCollectedAmount();
	    	}
	    }
	    
	}
	

	
	public ArrayList<Contribution> getContributionsForCampaign(String campaignId)  {
    	for(Contribution con : contribution) {
    		if(con.getCampaignId(). equals(campaignId)) {
    			return contribution;
    			
    		}
    	
    	}
    	
		return null;
    	
    }
	
	public void closeCampaign(String 
			campaignId) {
		
		for (Campaign camp:campaign) {
			if(camp.getCampaignId().equals(campaignId)) {
				if(camp.getCollectedAmount()==camp.getGoalAmount()) {
					camp.setActive(false);
					camp.isActive();
//					System.out.println("Campaign "+camp.getTitle()+ " Closed.\r\n"
//							+ "No more Contribution needed ThankYou For your Support!!!");
			
				}
				
			}
		}
		
	}
	
	public String generateCampaignSummary(String campaignId) {
		
		String summary = null ;
		closeCampaign(campaignId);
	    for (Campaign cam:campaign) {
	    	if(cam.getCampaignId().equals(campaignId)) {
	    		
	    		summary=" CamapignId : " + cam.getCampaignId() + "\n Campaign owner Id :"+cam.getOwnerId()+"\n Campaign Title: "+ cam.getTitle()+" \n Campaign Description: "+cam.getDiscription()+"\n Goal amount: "+cam.getGoalAmount()+"\n Collected amount: "+
	    	cam.getCollectedAmount() +"\n Amount Still Needed: "+remainingAmount+"\n=====Campaign Contributions=====\n"+ getContributionsForCampaign(campaignId) + "\n ====Campaign Status==== \n " + cam.isActive();
	    	
	    	}
	    	
	    }
		

	    
	    return summary;
	    
	}
	
	
} 
	
	
	
	

