package com.wipro.odcp.util;

public class CampaignNotFoundException extends Exception{

	public CampaignNotFoundException() {
		super("Given Campaign Id does not match our record.Please Enter a valid Campaign ID.");
	}
	

}
