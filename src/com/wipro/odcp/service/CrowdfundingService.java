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
	
	
	//constructor
	public CrowdfundingService(ArrayList<User> users, ArrayList<Campaign> campaigns, ArrayList<Contribution> contributions) {
		this.user=users;
		this.campaign=campaigns;
		this.contribution=contributions;
		
	}
	
	public void addUser(User u) {
		
		
		
			for(User unew : user) {
				if(unew.getUserID().equals(u.getUserID())) {
				
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
		}
		
		throw new UserNotFoundException();
	}
	
	
	public void createCampaign(Campaign c) throws UserNotFoundException {
		System.out.println("Campaign"+c.getTitle()+" Created..");
		campaign.add(c);
	}
	
	public Campaign findCampaign(String 
			campaignId) throws 
			CampaignNotFoundException{
		
		for( Campaign c : campaign){
			if (c.getCampaignId().equals(campaignId)) {
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
	
		
		for (Contribution c: contribution) {
			if(c.getContibutionId().equals(contributionId)) {
				System.out.println("Contribution id alread exist please choose new Contribution ID.");
			}
		}
		
	    Contribution contribute =new Contribution(contributionId,userId,campaignId,amount,date);
	    contribution.add(contribute);
		
	    
	}
	
	public ArrayList<Contribution> getContributionsForCampaign(String campaignId)  {
    	for(Contribution con : contribution) {
    		if(con.getCampaignId().equalsIgnoreCase(campaignId)) {
    			return contribution;
    		}
    	}
    	return null;
    	
    }
	
	public String generateCampaignSummary(String campaignId) {
		
		String summary = null ;
	    for (Campaign cam:campaign) {
	    	if(cam.getCampaignId().equals(campaignId)) {
	    		summary="CamapignId : " + cam.getCampaignId() + "\n Campaign owner Id :"+cam.getOwnerId()+"\n Campaign Title: "+ cam.getTitle()+" \n Campaign Description: "+cam.getDiscription()+"\n Goal amount: "+cam.getGoalAmount()+"\n Collected amount: "+ cam.getCollectedAmount() ;
	    	}
	    	
	    }
	    return summary;
	}
	
	
	
	


	 
} 
	
	
	
	

