package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class Usermanagement_Home extends BaseClass {
	Logger log=Logger.getLogger(Usermanagement_Home.class.getName());
	public void clickOnPlusIcon()
	{
		UtilityClass.fn_Click("UsermanagementHomeCreateUser_PlusIcon_BT");
	}
	
	public void verifyForUserCreation(String expectedVal)
	{   String actual=UtilityClass.getdataofWebTable("UsermanagementHome_WebTable");
		//UtilityClass.validateString(actual);
	}
	
	public void clickOnBurgerMenu()
	{
		UtilityClass.fn_Click("UsermanagementHome_BurgerMenu");
	}
	
	public void clickOnUserManagementInBurgerMenu()
	{
		//WebElement we=UtilityClass.getWebElement("UsermanagementHome_Usermanagementmenu_BurgerMenu");
		//we.click();
		UtilityClass.fn_Click("UsermanagementHome_Usermanagementmenu_BurgerMenu");
	}
	public void clickOnUserInUsermanagementInBurgerMenu()
	{
		System.out.println("clicking on user menu option");
		//clickOnBurgerMenu();
		clickOnUserManagementInBurgerMenu();
		UtilityClass.fn_Click("UsermanagementHome_user_Usermanagementmenu");
		System.out.println("clicked on user menu option");
	
	}
	public void clickOnRoleInUsermanagementInBurgerMenu()
	{	System.out.println("clicking on role menu option");
		//clickOnBurgerMenu();
		clickOnUserManagementInBurgerMenu();
		UtilityClass.fn_Click("UsermanagementHome_role_Usermanagementmenu");
		System.out.println("clicked on role menu option");
	}
	public void clickOnObjectInUsermanagementInBurgerMenu()
	{
		System.out.println("clicking on object menu option");
		//clickOnBurgerMenu();
		//clickOnUserManagementInBurgerMenu();
		UtilityClass.fn_clickByAction("UsermanagementHome_object_Usermanagementmenu");
		System.out.println("clicked on object menu option");
		

	}
}
