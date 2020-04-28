package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class NewCommandmentLandingPage {

	public void setRRFlag1()
	{
		JavascriptExecutor je = (JavascriptExecutor) UtilityClass.driver; 
		WebElement firsttab=UtilityClass.getWebElement("firsttable");
		je.executeScript("arguments[0].scrollIntoView()",firsttab);
		String xpath=UtilityClass.OR.getProperty("Commandment_RRFlag1");
		List<WebElement> rows=UtilityClass.fn_getWebelements("Commandment_RRFlag1");
		String beforeXpath=xpath+"[";
		String afterXpath="]/td[3]/div/mat-radio-group[1]/mat-radio-button/label/div[1]/div[1]";
		int totalrecords=rows.size();
		Actions act=new Actions(UtilityClass.driver);
		String actualXpath=null;
		WebElement we=null;
		for(int i=1;i<=totalrecords;i++)
		{    
			actualXpath=beforeXpath+i+afterXpath;
			we=UtilityClass.driver.findElement(By.xpath(actualXpath));
			act=new Actions(UtilityClass.driver);
			act.moveToElement(we).perform();
			act.click(we).perform();
			//je.executeScript("arguments[0].scrollIntoView()",we);
		}
	}
	public void setRRFlag2()
	{
		JavascriptExecutor je = (JavascriptExecutor) UtilityClass.driver; 
		WebElement sectab=UtilityClass.getWebElement("secondtable");
		je.executeScript("arguments[0].scrollIntoView()",sectab);
		String xpath=UtilityClass.OR.getProperty("Commandment_RRFlag2");
		
		List<WebElement> rows=UtilityClass.fn_getWebelements("Commandment_RRFlag2");
		String beforeXpath=xpath+"[";
		String afterXpath="]/td[3]/div/mat-radio-group[2]/mat-radio-button/label/div[1]/div[1]";
		int totalrecords=rows.size();
		
		for(int i=1;i<=6;i=i+2)
		{    
			String actualXpath=beforeXpath+i+afterXpath;
			WebElement we=UtilityClass.driver.findElement(By.xpath(actualXpath));
			//UtilityClass.driver.switchTo().defaultContent();
			Actions act=new Actions(UtilityClass.driver);
			act.moveToElement(we).perform();
			act.click(we).perform();
			//je.executeScript("arguments[0].scrollIntoView()",we);			
		}
		
		String twelthrecord="//form[@name='saveCommandment']/div[1]/div[2]/table/tbody/tr[12]/td[3]/div/mat-radio-group[2]/mat-radio-button/label/div[1]/div[1]";
		WebElement row=UtilityClass.driver.findElement(By.xpath(twelthrecord));
		je.executeScript("arguments[0].scrollIntoView()",row);
		for(int i=15;i<=totalrecords;i++)
		{    
			String actualXpath=beforeXpath+i+afterXpath;
			WebElement we=UtilityClass.driver.findElement(By.xpath(actualXpath));
			//UtilityClass.driver.switchTo().defaultContent();
			Actions act=new Actions(UtilityClass.driver);
			act.moveToElement(we).perform();
			act.click(we).perform();
			//je.executeScript("arguments[0].scrollIntoView()",we);
			
			
		}
	}
	public void clickOnSaveAndDraft()
	{
		UtilityClass.fn_Click("Commandment_SaveAsDraft_bt");
	}
	public void clickOnNext()
	{
		UtilityClass.fn_Click("Commandment_Next_bt");
	}
	public void clickOnCommandment()
	{
		UtilityClass.fn_Click("CommandmentLink");
		
	}
	
	public void setCommandment()
	{
		//clickOnCommandment();
		//UtilityClass.fn_Click("CommandmentLink");
		
		
		List<WebElement> ls=UtilityClass.fn_getWebelements("CommandmentCardList");
		int n=ls.size();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	WebElement wele=ls.get(n-1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	wele.click();
		WebElement wele=UtilityClass.driver.findElement(By.xpath("/html/body/app-root/app-navigation/mat-sidenav-container/mat-sidenav-content/app-ratecard/div/mat-card/div[1]/mat-accordion/mat-expansion-panel[3]/div/div/mat-card-content/div/div/div["+n+"]/div/div/h6"));
		String commercialcardcode=wele.getText();
		//System.out.println("commercialcardcode:"+commercialcardcode);
		wele.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UtilityClass.fn_Click("CommercialSurfaceLink");
		
		//setRRFlag1();
		//setRRFlag2();
		clickOnNext();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UtilityClass.fn_Click("CommandmentLink");
	}
}
