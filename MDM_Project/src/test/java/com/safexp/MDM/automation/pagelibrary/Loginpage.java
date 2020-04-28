package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;
import com.safexp.MDM.automation.Utility.UtilityClass;


public class Loginpage 
{
	Logger log=Logger.getLogger(Loginpage.class.getName());
	public void validLogin(String s1,String s2)
	{
		log.info("LoginPage:validLogin method");
		log.info("username is being entered");
		UtilityClass.fn_Input("Loginpage_usernm_Input", s1);
		log.info("password is being entered");
		UtilityClass.fn_Input("Loginpage_password_Input", s2);
		log.info("clicking on login button");
		UtilityClass.fn_Click("Loginpage_login_btn");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean status=UtilityClass.fn_isDisplayed("UsermanagementHome_BurgerMenu");
		if(status==true) {
		log.info("User logined successfully");
		}
		else
		{
			log.info("Username or password is incorrect");
			Verify.verify(false);
			
		}
	}
	

}











