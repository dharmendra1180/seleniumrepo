package com.safexp.MDM.automation.pagelibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class NewTnCLandingPage 
{
	
	public void clickOnRadiotestOption()
	{
		UtilityClass.fn_Click("TnC_radiotestOption");
	}
	public void clickOnContinue()
	{
		JavascriptExecutor je = (JavascriptExecutor) UtilityClass.driver; 
		WebElement continuebtn=UtilityClass.getWebElement("TnC_ContinueButton");
		je.executeScript("arguments[0].scrollIntoView()",continuebtn);
		UtilityClass.fn_Click("TnC_ContinueButton");
	}
	public void clickOnTnCLink()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilityClass.fn_Click("TnCLink");
	}
	
	public void setTermsAndConditions()
	{
		//clickOnTnCLink();
	//	clickOnRadiotestOption();
		clickOnContinue();
	}

}
