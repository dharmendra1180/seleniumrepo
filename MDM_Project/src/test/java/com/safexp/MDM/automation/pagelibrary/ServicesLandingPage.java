package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class ServicesLandingPage {
	Logger log=Logger.getLogger(ServicesLandingPage.class.getName());
	
	public void setServiceLine(String serviceline)
	{
		
		WebElement we=UtilityClass.getWebElement("customer_creditpage3_serviceline");
		
		Actions ac=new Actions(UtilityClass.driver);
		ac.moveToElement(we).perform();
		log.info("clicking on service line dropdown");
		we.click();
		List<WebElement> serviceoptions=UtilityClass.fn_getWebelements("customer_creditpage3_serviceline_option");
		int n=serviceoptions.size();
		for(int i=0;i<n;i++)
		{
			String s=serviceoptions.get(i).getText();
			if(s.equals("DISTRIBUTION"))
			{
				log.info("selecting service line");
				WebElement we1=serviceoptions.get(i);
				ac.moveToElement(we1).perform();
				we1.click();
				break;
				
			}else {log.info("service line is not matched");}
		}
	}
	
	public void setServiceOffering(String serviceoffer)
	{
		String str[]=null;
		if(serviceoffer.contains(","))
		{
			log.info("preparing the list of service offering");
			str=serviceoffer.split(",");
		}
		else
		{
			try {
				str=new String[1];
			str[0]=serviceoffer;}catch(Exception e) {}
		}
		int options=str.length;
		List<WebElement> serviceoptions=UtilityClass.fn_getWebelements("service_offering");
		int n=serviceoptions.size();
		log.info("service offering is being selected");
		for(int j=0;j<options;j++)
		{
			String option=str[j];
			for(int i=0;i<n;i++)
			{
				WebElement wb=serviceoptions.get(i);
				String s=wb.getText();
				
				System.out.println(s);	
				if(s.equals(option))
				{
					Actions ac=new Actions(UtilityClass.driver);
					ac.moveToElement(wb).perform();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ac.click().perform();
					//wb.click();
				}
			}
		}
		
		
	}
	
	public void clickOnSave()
	{
		log.info("next button is clicked");
		UtilityClass.fn_Click("Service_next_button");
	}
	
	//public void submitService(String service)
	public void submitService(String serviceline,String serviceoffer)
	{
		setServiceLine(serviceline);
		setServiceOffering(serviceoffer);
		clickOnSave();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void validateSFXcode(String sfxcode)
	{
		log.info("sfxcode is being validated");
		UtilityClass.fn_validateText("SFXcodeOnServicePage",sfxcode);
	}
}