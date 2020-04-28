package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class NewCommercialSurfaceLandingPage {
	
	
	public void submitCommercialSurface(String chargeby,String prodcategory,String Arate,String Afreight,String Brate,String Bfreight,String Crate,String Cfreight,String Drate,String Dfreight)
	{
		//clickOnCommercialSurface_GSTFlag();
		//clickOnCommercialSurface_slabRequired();
		setCommercialSurface_ChargeBy(chargeby);
		setCommercialSurface_ProdCategory(prodcategory);
		clickOnCommercialSurface_GSTFlag();
		setZonalGroup(Arate,Afreight,Brate,Bfreight,Crate,Cfreight,Drate,Dfreight);
		clickOnCommercialSurface_safextensionFlag();
		//clickOnCommercialSurface_roundOff5or10();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnCommercialSurface_Continue_bt();
	//	selectCommercialCard();
	}
	public void clickOnCommercialSurface_roundOff5or10()
	{
		UtilityClass.fn_Click("CommercialSurface_roundOff5or10");
	}
	public void clickOnCommercialSurface_GSTFlag()
	{
		
		UtilityClass.fn_Click("CommercialSurface_GSTFlag");
	}
	
	public void	clickOnCommercialSurface_slabRequired()
	{
		UtilityClass.fn_Click("CommercialSurface_slabRequired");
		
	}
	public void clickOnCommercialSurface_safextensionFlag()
	{
		UtilityClass.fn_Click("CommercialSurface_safextensionFlag");
	}
	public void setCommercialSurface_ChargeBy(String chargeby)
	{
		UtilityClass.fn_Click("CommercialSurface_ChargeBy");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> commandmentoptions=UtilityClass.fn_getWebelements("CommercialSurface_ChargeByOptions");
		int n=commandmentoptions.size();
		
		for(int i=0;i<n;i++)
		{
			WebElement we=commandmentoptions.get(i);
			String s=we.getText();
			if(s.equals(chargeby))
			{
				//Actions ac=new Actions(UtilityClass.driver);
				//ac.moveToElement(we).perform();
				we.click();
				break;
				
			}
		}
	
	}
	public void setCommercialSurface_ProdCategory(String prodcategory)
	{
		UtilityClass.fn_Click("CommercialSurface_ProdCategory");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> commandmentoptions=UtilityClass.fn_getWebelements("CommercialSurface_ProdCategoryoptions");
		int n=commandmentoptions.size();
		
		for(int i=0;i<n;i++)
		{
			WebElement we=commandmentoptions.get(i);
			String s=we.getText();
			if(s.equals(prodcategory))
			{
				//Actions ac=new Actions(UtilityClass.driver);
				//ac.moveToElement(we).perform();
				we.click();
				break;
				
			}
		}
	
		
	}
	
	public void setZonalGroup(String Arate,String Afreight,String Brate,String Bfreight,String Crate,String Cfreight,String Drate,String Dfreight)
	{
		
		List<WebElement> zonaloptions=UtilityClass.fn_getWebelements("CommercialSurface_ZonalGrp");
		int n=zonaloptions.size();
		String[] zonalval= {Arate,Afreight,Brate,Bfreight,Crate,Cfreight,Drate,Dfreight};
		for(int i=0;i<n;i++)
		{
			WebElement we=zonaloptions.get(i);
			we.clear();
			we.sendKeys(zonalval[i]);
				
		}
	}
		public void selectCommercialCard()
		{
			UtilityClass.fn_Click("CommercialSurfaceLink");
			List<WebElement> ls=UtilityClass.fn_getWebelements("CommercialSurfaceCardList");
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
			WebElement wele=UtilityClass.driver.findElement(By.xpath("//form[@name='commSurface']/div/div[1]/div["+n+"]/div/div/h6"));
			String commercialcardcode=wele.getText();
			System.out.println("commercialcardcode:"+commercialcardcode);
			wele.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UtilityClass.fn_Click("CommercialSurfaceLink");
		}
	
	
	public void clickOnCommercialSurface_SaveAndCreateNew_bt()
	{
	  UtilityClass.fn_Click("CommercialSurface_SaveAndCreateNew_bt");
	}  
	public void clickOnCommercialSurface_Continue_bt()
	{
	  UtilityClass.fn_Click("CommercialSurface_Continue_bt");
	}


}
