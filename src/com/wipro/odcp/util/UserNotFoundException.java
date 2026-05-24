package com.wipro.odcp.util;

public class UserNotFoundException extends Exception {
	 
	public UserNotFoundException() {
		super("User Not Avilable In Records.Please Enter the Valid UserID.");
	}
}
