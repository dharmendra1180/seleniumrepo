package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;
import com.safexp.MDM.automation.Utility.UtilityClass;

public class UsermanagementLandingPage {
	Logger log=Logger.getLogger(UsermanagementLandingPage.class.getName());
	public void searchByid(String userid)
	{
		UtilityClass.fn_clickByAction("UserManagementpage_userid_radioBT");
		UtilityClass.fn_Input("UserManagementpage_searchbox_input", userid);
		List<WebElement> we=UtilityClass.fn_getWebelements("UserManagementpage_userlistTable");
		if(we.size()!=0) {System.out.println("user is being searched");
		List<Integer> rowlist=UtilityClass.fn_searchByElementTextInWebTable("UserManagementpage_userlistTable",1,userid);
		if(rowlist.size()!=0) 
		{			
		UtilityClass.fn_clickOnSetOfDataInWebTable("UserManagementpage_userlistTable",rowlist,8);
		}else {System.out.println("user not found");}
		
		}else {System.out.println("invalid userid");}//Verify.verify(false);}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void useridNotFound_clickOnPlus(String userid)
	{
		
		searchByid(userid);
		UtilityClass.fn_Click("UserManagementpage_plusButton");
		System.out.println("clicked on plus button");
		
	}
	public void searchByUsername(String username)
	{
		UtilityClass.fn_clickByAction("UserManagementpage_name_radioBT");
		UtilityClass.fn_Input("UserManagementpage_searchbox_input", username);
		List<WebElement> we=UtilityClass.fn_getWebelements("UserManagementpage_userlistTable");
		if(we.size()!=0) {System.out.println("user is being searched to modify");
		List<Integer> rowlist=UtilityClass.fn_searchByElementTextInWebTable("UserManagementpage_userlistTable",2,username);
		if(rowlist.size()!=0) 
		{			
		UtilityClass.fn_clickOnSetOfDataInWebTable("UserManagementpage_userlistTable",rowlist,3);
		}
		
		}else {System.out.println("invalid username");Verify.verify(false);}
	}
	
	public void searchByAllAndUpdate()
	{
		UtilityClass.fn_clickByAction("UserManagementpage_All_radioBT");
		List<WebElement> we=UtilityClass.fn_getWebelements("UserManagementpage_userlistTable");
		if(we.size()!=0) 
		{
		UtilityClass.fn_clickOnCheckboxInWebTable("UserManagementpage_userlistTable", 1, 3);
		}else {Verify.verify(false);}
	}
		
	

}
