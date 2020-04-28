package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.managerClasses.HybridFrameworkDriver;

public class NewRateCardLandingPage 
{
	Logger log=Logger.getLogger(NewRateCardLandingPage.class.getName());
	public void setBaseLocation(String branchlocation)
	{
		Actions act=new Actions(UtilityClass.driver);
		UtilityClass.fn_Input("baseLocationSearch",branchlocation);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilityClass.fn_clickByAction("baseLocationOptions");
	
		try {
			 Thread.sleep(2000);
			}catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void createRateCard(String zonematrix,String cmnt,String serviceoffering,String baselocation,String commandment)
	{
		setZoneMatrix(zonematrix);
		setComment(cmnt);
	  	setServiceOffering(serviceoffering);
		setBaseLocation(baselocation);
		setRateCardCommandment(commandment);	
		clickContinue();
		setRatecardName();
	}
	public void setRatecardName()
	{
		UtilityClass.fn_Click("ratecardheading");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> ls=UtilityClass.fn_getWebelements("ratecardiconlist");
		int n=ls.size();
		if(n==1)
		{
		WebElement wele=UtilityClass.driver.findElement(By.xpath("//div[@class='commercialboxflex']/div[1]/div/div/div/h6"));
		wele.click();
		}
		else 
		{
			WebElement wele=UtilityClass.driver.findElement(By.xpath("//div[@class='commercialboxflex']/div[1]/div["+n+"]/div/div/h6"));
			wele.click();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebElement we1=ls.get(n-1);
		//we1.click();
		

		String ratecardcode=UtilityClass.driver.findElement(By.name("rateCardCode")).getAttribute("value");
		System.out.println("ratecardcode:"+ratecardcode);
		UtilityClass.fn_Click("continueButton");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setComment(String cmnt)
	{
		UtilityClass.fn_Input("comment",cmnt);
		
	}
	public void clickContinue()
	{
		UtilityClass.fn_Click("continueButton");
	}
	public void setServiceOffering(String service)
	{
		UtilityClass.fn_Click("serviceOffering");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilityClass.fn_clickByAction("serviceOfferingOption");
		/*List<WebElement> serviceList=UtilityClass.fn_getWebelements("serviceOfferingOption");
		int listsize=serviceList.size();
		
		for(int i=0;i<listsize;i++)
		{
			WebElement we=serviceList.get(i);
			String s=we.getText();
			if(s.equals(service))
			{
			//	Actions ac=new Actions(UtilityClass.driver);
			//	ac.moveToElement(we).perform();
				we.click();
				break;
				
			}
		}*/
		
	}
	public void setZoneMatrix(String zone)
	{
		UtilityClass.fn_Click("zoneMatrix");
		List<WebElement> zoneoptions=UtilityClass.fn_getWebelements("zoneMatrix_options");
		int n=zoneoptions.size();
		for(int i=0;i<n;i++)
		{
			String s=zoneoptions.get(i).getText();
			if(s.equals(zone))
			{
				zoneoptions.get(i).click();break;
			}
		}
			
	}
	
	public void setRateCardCommandment(String commandment)
	{
		UtilityClass.fn_Click("commandement");
		 
		List<WebElement> commandmentoptions=UtilityClass.fn_getWebelements("commandement_options");
		int n=commandmentoptions.size();
		
		for(int i=0;i<n;i++)
		{
			WebElement we=commandmentoptions.get(i);
			String s=we.getAttribute("value");
			if(s.equals(commandment))
			{
				//Actions ac=new Actions(UtilityClass.driver);
				//ac.moveToElement(we).perform();
				we.click();
				break;
				
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
