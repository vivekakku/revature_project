package com.bank_app.validation;

import org.apache.log4j.Logger;

public class Validation {
	
	private static Logger log = Logger.getLogger(Validation.class);
	
	public static boolean isValidCustId(String cust_id1)
	{
		if(cust_id1!=null && cust_id1.matches("[a-z]{5}"))
				return true;
				
		else
		{
			log.info("please check your customer id");
			return false;
		}
	}
	
	public static boolean isValidCustName(String cust_name)
	{
		if(cust_name!=null && cust_name.matches("[a-z]{10}"))
				return true;
				
		else
		{
			log.info("please check your customer name");
			return false;
		}
	}
	
	public static boolean isValidCustGender(String cust_gender)
	{
		if(cust_gender!=null && cust_gender.matches("[a-z]{6}"))
			return true;
		else
		{
			log.info("please check your gender");
			return false;
		}
	}
	
	public static boolean isValidCustEmailId(String cust_emailId)
	{
		if(cust_emailId != null && cust_emailId.matches(
				"^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"))
			return true;
		else
		{
			log.info("please check your email id");
			return false;
		}
	}
	
	public static boolean isValidCustPhno(String cust_phno)
	{
		if(cust_phno!=null && cust_phno.matches("[0-9]{10}"))
			return true;
		else
		{
			log.info("please check your number");
			return false;
		}
}
	public static boolean isValidCustPwd(String cust_pwd)
	{
		if(cust_pwd!=null && cust_pwd.matches("[a-z]{6}"))
			return true;
		else
		{
			log.info("please check your password");
			return false;
		}
	}
}
