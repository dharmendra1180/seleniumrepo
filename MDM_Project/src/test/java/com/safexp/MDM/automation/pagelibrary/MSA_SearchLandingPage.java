package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class MSA_SearchLandingPage {
	Logger log=Logger.getLogger(MSA_SearchLandingPage.class.getName());
	public boolean searchCustomer()
	{
		System.out.println("customer name is being entered");
		 UtilityClass.fn_Input("MSA_customername","DHARAMT2");
		 UtilityClass.fn_Click("MSA_searchbutton");
		 List<Integer> status=null;
		 boolean flag=false;
		 try {
			Thread.sleep(500);
			status=UtilityClass.fn_searchByElementTextInWebTable("MSA_customerListTable",1,"DHARAMT2");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Existence of customer is being verified");
		 if(status.size()==0)
		 {
			 System.out.println("customer does not exist");
			 flag=false;
			 
		 }
		 else
		 {
			 flag=true;
			 System.out.println("customer exist");
			 
		 }
		 return flag;
	}
	
	public void getSFXCodeOfMSACustomer(String customername)
	{
		UtilityClass.fn_Input("MSA_customername",customername);
		UtilityClass.fn_Click("MSA_searchbutton");
		List<Integer> rowlist=UtilityClass.fn_searchByElementTextInWebTable("MSA_customerListTable",1,customername);
		int n=rowlist.size();
		if(n!=0) 
		{	
			if(rowlist.size()!=1) {n=1;}
			String xpath=UtilityClass.OR.getProperty("MSA_customerListTable");
			String actualxpath=xpath+"["+n+"]/td[7]/button";
			//html/body/app-root/app-navigation/mat-sidenav-container/mat-sidenav-content/app-msa-opration/div/mat-card[2]/table/tbody/tr[1]/td[7]/button/span
			WebElement we=UtilityClass.driver.findElement(By.xpath(actualxpath));
			we.click();
		}
		String sfxcode=UtilityClass.getWebElement("MSA_SFXListTable").getText();
		System.out.println(sfxcode);
	}
	
	public void customerNotExist_ClickNewMSA()
	{
		boolean status=searchCustomer();
		if(status==false)
		{
			UtilityClass.fn_Click("");
		}
	}
	
	public void clickOnNewMSA_Button()
	{
		UtilityClass.fn_Click("NewMSA_Button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setCustomerName(String custname)
	{
		UtilityClass.fn_Input("MSA_customername",custname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
