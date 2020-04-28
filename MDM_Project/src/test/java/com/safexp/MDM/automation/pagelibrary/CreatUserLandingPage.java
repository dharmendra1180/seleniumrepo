package com.safexp.MDM.automation.pagelibrary;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.base.Verify;
import com.safexp.MDM.automation.Utility.UtilityClass;

public class CreatUserLandingPage {
	Logger log=Logger.getLogger(CreatUserLandingPage.class.getName());
	public void validateUserIdInAD(String userid)
	{	
		log.info("CreatUserLandingPage:validateUserIdInAD method");
		log.info("userid is being entered");
		UtilityClass.fn_Input("CreateUserLanding_UID_IN",userid);
		UtilityClass.fn_applyTAB("CreateUserLanding_UID_IN");
		log.info("looking for error message ");
		boolean status=UtilityClass.fn_isDisplayed("CreateUserLanding_userid_errormsg");
		if(status)
		{
			log.info("userid Not found in AD!; Enter valid userid");
			UtilityClass.fn_setFocusOnElement("CreateUserLanding_UID_IN");
		}
		if(!status)
		{
			Verify.verify(false);
		}
		
		
	}
	public void enterUserID(String userid)
	{	
		log.info("userid is being entered");
		UtilityClass.fn_Input("CreateUserLanding_UID_IN",userid);
		UtilityClass.fn_applyTAB("CreateUserLanding_UID_IN");
		log.info("looking for error message ");
		boolean status=UtilityClass.fn_isDisplayed("CreateUserLanding_userid_errormsg");
		if(status)
		{
			log.info("userid Not found in AD!; Enter valid userid");
			UtilityClass.fn_setFocusOnElement("CreateUserLanding_UID_IN");
			Verify.verify(false);
		}
		
		
		
	}
	public void enterUserName(String s)
	{
		log.info("username is being entered ");
		UtilityClass.fn_Input("CreateUserLanding_UNM_IN", s);
	}
	public void enterEmailID(String s)
	{
		log.info("user emailid is being entered ");
		UtilityClass.fn_Input("CreateUserLanding_UMAIL_IN", s);
		UtilityClass.fn_applyTAB("CreateUserLanding_UMAIL_IN");
		boolean status=UtilityClass.fn_isDisplayed("CreateUserLanding_emailid_errormsg");
		if(status)
		{
			log.info("Should be in format like SFX@SAFEXPRESS.COM");
			UtilityClass.fn_setFocusOnElement("CreateUserLanding_UMAIL_IN");
		}
		
	}
	public void enterContact(String s)
	{
		log.info("mobile number is being entered ");
		UtilityClass.fn_Input("CreateUserLanding_UMOBILE_IN", s);
		UtilityClass.fn_applyTAB("CreateUserLanding_UMOBILE_IN");
		boolean status=UtilityClass.fn_isDisplayed("CreateUserLanding_usermobile_errormsg");
		if(status)
		{
			log.info(" Mobile number should be 10 digit only.");
			UtilityClass.fn_setFocusOnElement("CreateUserLanding_UMOBILE_IN");
		}
		
	}
	public void enterCategory(String s)
	{
		log.info("clicking on category dropdown");
		UtilityClass.fn_clickByAction("CreateUserLanding_UCATEGORY_IN");
		if(s.equals("EMPLOYEE"))
		{
			log.info("selecting EMPLOYEE category");
			UtilityClass.fn_Click("CreateUserLanding_UCATEGORY_EMPLOYEE");
		}
		else if(s.equals("ASSOCIATE")) {log.info("selecting Associate category");UtilityClass.fn_Click("CreateUserLanding_UCATEGORY_ASSOCIATE");}
	}
	public void enterRole(String s)
	{
		log.info("clicking on select role dropdown");
		UtilityClass.fn_Click("CreateUserLanding_URole_IN");
		log.info("clicking on role search");
		UtilityClass.fn_Click("CreateUserLanding_URole_Search_IN");
		log.info("role is being searched");
		UtilityClass.fn_Input("CreateUserLanding_URole_Search_IN","ROLE1");
		Actions act=new Actions(UtilityClass.driver);
		act.sendKeys(Keys.ENTER).perform();
		UtilityClass.fn_Click("CreateUserLanding_URole_IN");
		log.info("role selected");
	}
	public void enterDepartment(String s)
	{
		log.info("clicking on department dropdown");
		UtilityClass.fn_clickByAction("CreateUserLanding_DepartmentName");
		if(s.equalsIgnoreCase("HR"))
		{
			log.info("HR department is being selected ");
			UtilityClass.fn_Click("CreateUserLanding_DepartmentName_HR");
		}
		else if(s.equalsIgnoreCase("FIN"))
		{
			log.info("FIN department is being selected ");
			UtilityClass.fn_Click("CreateUserLanding_DepartmentName_FIN");
		}
		
	}
	public void enterDefaultBranch(String branch)
	{  
		log.info("Default branch is being entered");
		UtilityClass.fn_Click("CreateUserLanding_UBranch_IN");
		
		UtilityClass.fn_Click("CreateUserLanding_UBranch_AdvanceSearch");
		UtilityClass.fn_clickByAction("UserAdvanceSearch_popup_Select");
		List<WebElement> serviceList=UtilityClass.fn_getWebelements("UserAdvanceSearch_popup_SelectOptions");
		int listsize=serviceList.size();
		
		for(int i=0;i<listsize;i++)
		{
			WebElement we=serviceList.get(i);
			String s=we.getText();
			if(s.equals("NAME"))
			{
				we.click();
				break;
				
			}
		}
		UtilityClass.fn_Input("UserAdvanceSearch_popup_searchbox_byname","CRT");
		UtilityClass.fn_clickByAction("UserAdvanceSearch_popup_searchIcon");
		UtilityClass.fn_Click("UserAdvanceSearch_popup_radioAfterselect");
		UtilityClass.fn_Click("UserAdvanceSearch_popup_submit_BT");
		UtilityClass.fn_Click("CreateUserLanding_UBranch_IN");
	}
	
	
	public void enterPrivillageBranch(String s1)
	{ 
		log.info("privillage branch is being entered");
		UtilityClass.fn_Click("CreateUserLanding_UPrBranch_IN");
		UtilityClass.scrollToElementIntoView("CreateUserLanding_UPrBranch_AdvanceSearch");
		UtilityClass.fn_Click("CreateUserLanding_UPrBranch_AdvanceSearch");
		UtilityClass.fn_clickByAction("UserAdvanceSearchBy__PrBranch_popup_select");
		List<WebElement> serviceList=UtilityClass.fn_getWebelements("UserAdvanceSearchBy__PrBranch_popup_selectoptions");
		int listsize=serviceList.size();
		
		for(int i=0;i<listsize;i++)
		{
			WebElement we=serviceList.get(i);
			String s=we.getText();
			if(s.equals("NAME"))
			{
				we.click();
				break;
				
			}
		}
		UtilityClass.fn_Input("UserAdvanceSearch_PrBranch_popup_searchbox_byname","CHENNAI");
		UtilityClass.fn_clickByAction("UserAdvanceSearch_PrBranch_popup_searchIcon");
		UtilityClass.fn_Click("UserAdvanceSearch_PrBranch_popup_selectAfterSearchIconClickked");
		UtilityClass.fn_clickByAction("UserAdvanceSearch_PrBranch_popup_submit_BT");
		UtilityClass.fn_Click("CreateUserLanding_UPrBranch_IN");
	
	}
	
	
	public void clickOnSubmit()
	{
		log.info("clicking on submit button");
		UtilityClass.scrollToElementIntoView("CreateUserLanding_submitbutton");
		UtilityClass.fn_Click("CreateUserLanding_submitbutton");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public void checkCreatedUserInList()
	{
		String s=UtilityClass.getdataofWebTable("UsermanagementHome_WebTable");
		log.info(s);
		//UtilityClass.validateString(s);
	}
	
	public void newUserCreationWithManditoryFields(String id,String name,String email,String mobile,String category)
	{
		enterUserID(id);
		enterUserName(name);
		enterEmailID(email);
		enterContact(mobile);
		enterCategory(category);
		clickOnSubmit();
	}
	public void newUserCreationWithAllFields(String id,String name,String email,String mobile,String category,String department)
	{
		log.info("userid is being entered");
		enterUserID(id);
		log.info("username is being entered");
		enterUserName(name);
		log.info("emailid is being entered");
		enterEmailID(email);
		log.info("mobile is being entered");
		enterContact(mobile);
		log.info("category is being entered");
		enterCategory(category);
		log.info("department is being entered");
		enterDepartment(department);
		log.info("DefaultBranch is being entered");
		enterDefaultBranch("");
		log.info("Privillage Branch is being entered");
	    //enterPrivillageBranch("");
		log.info("Role is being entered");
		enterRole("");
		clickOnSubmit();
	}
	
	public void searchDefaultBranch(String branch)
	{
		enterDefaultBranch(branch);
		clickOnSubmit();
	}
		
	public void searchPrivillageBranch(String branch)
	{
		enterPrivillageBranch(branch);
		clickOnSubmit();
	}
	
	
}


