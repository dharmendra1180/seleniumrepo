package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class CreditContractHomePage {
	Logger log=Logger.getLogger(CreditContractHomePage.class.getName());
	public void clickOnMSA_MenuOption()
	{
		log.info("clicking MSA menu option");
		UtilityClass.fn_Click("MSA_menuOption");
	}
	public void clickOnMSA_Button()
	{
		log.info("clicking MSA button");
		UtilityClass.fn_Click("MSA_Button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void clickOnOppotunity()
	{
		clickOnMenu();
		log.info("clicking on opportunity menuoption");
		UtilityClass.fn_Click("Opportunity_menuOption");
	}
	public void clickOnContract()
	{
		clickOnMenu();
		log.info("clicking on contract menu option");
		UtilityClass.fn_clickByAction("Contract_MenuOption");
		
		
	}
	public void clickOnTopCustomerName()
	{
		//clickOnMenu();
		//UtilityClass.fn_Click("Contract_MenuOption");
		//UtilityClass.fn_Click("firstcustomerName_Link");
		//searchCustomer();
		
		
	}
	public void searchCustomer(String customername)
	{
		log.info("customername is being entered to search");
		UtilityClass.fn_Input("searchCustomername",customername);
		log.info("search the name in customer table");
		List<Integer> rowlist=UtilityClass.fn_searchByElementTextInWebTable("customernamelist",1,customername);
		if(rowlist.size()!=0) 
		{			
			log.info("name found and is being clicked ");	
			 UtilityClass.fn_clickOnSetOfDataInWebTable1("customernamelist",rowlist,1);
		}
	}
	public void clickOnService()
	{
		clickOnMenu();
		log.info("click on service menu option");
		UtilityClass.fn_Click("Service_menuOption");
	}
	
	public void searchContractByMSAorSFX()
	{
		JavascriptExecutor js = (JavascriptExecutor)UtilityClass.driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		UtilityClass.fn_Click("CreditContractHomePage_ContractRadioOption");
		UtilityClass.fn_Click("CreditContractHomePage_SearchContract");
	}
	public void clickOnBilling()
	{
		clickOnMenu();
		log.info("clicking on billing menu option");
		UtilityClass.fn_Click("Billing_menuOption");
	}
	public void clickOnRatecard()
	{
		clickOnMenu();
		log.info("clicking ratecard menu option");
		UtilityClass.fn_Click("Ratecard_menuOption");
	}
	public void clickOnMenu()
	{
		log.info("clicking on Propeli menu option");
		UtilityClass.fn_clickByAction("Propeli_Menu");
	}
	
}
