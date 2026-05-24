package com.wipro.odcp.util;

public class InvalidContributionException extends Exception {
    
	  public InvalidContributionException() {
		  super("The amount must be postive please enter a valid amount..");
	  }
}
