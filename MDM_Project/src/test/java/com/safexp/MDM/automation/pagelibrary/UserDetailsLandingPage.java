package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class UserDetailsLandingPage {
	Logger log=Logger.getLogger(UserDetailsLandingPage.class.getName());
	public void updateMobile(String mobile,String userid) 
	{
		System.out.println("user mobile is being modified");
		UtilityClass.fn_InputByAction("UserManagementpage_userMobile", mobile);
		//WebElement we=UtilityClass.driver.findElement(By.xpath("//*[@id='mat-expansion-panel-header-5']/span"));
		//we.click();
		UtilityClass.fn_Click("UserManagementpage_submitButton");
		UtilityClass.fn_Click("UsermanagementHome_user_Usermanagementmenu");
		//new UsermanagementLandingPage().searchByid(userid);
		
	}
	
	public void verify_updateMobile(String mobile)
	{
		UtilityClass.fn_validateString("UserManagementpage_userMobile",mobile);
	}

}
