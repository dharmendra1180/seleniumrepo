package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class RateCardLandingPage {
	Logger log=Logger.getLogger(RateCardLandingPage.class.getName());
	public void addNewRateCard(String RCsigndate,String RCstartdate,String RCenddate,String zonematrix,String cmnt,String serviceoffering,String baselocation,String commandment)
	{
		UtilityClass.fn_Click("customer_creditpage4_ratecard_addnew");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnSave()
	{
		
	}
	
	public void submitService(String service)
	{
		// setServiceLine(service);
	//	 setServiceOffering();
		 clickOnSave();
		
	}
	
	public void clickOnCommercialSurface() 
	{
		//UtilityClass.fn_Click("CommercialSurfaceLink");
		clickOnCommercialSurface_addNew();
	}
	public void clickOnCommercialSurface_addNew()
	{
		UtilityClass.fn_Click("CommercialSurface_addNew");
	}
	
	public void clickOnCommandment()
	{
		UtilityClass.fn_Click("CommandmentLink");
	}
	
	public void clickOnTnCLink()
	{
		UtilityClass.fn_Click("TnCLink");
	}
	public void clickOnSLALink()
	{
		UtilityClass.fn_Click("SLALink");
	}
	public void clickOnVMILink()
	{
		UtilityClass.fn_Click("VMILink");
	}
	public void clickOnBranchLink()
	{
		UtilityClass.fn_Click("BranchLink");
	}

    public void clickNext()
    {
    	UtilityClass.fn_Click("ratecardpageSubmit");
    }
    public void validateSFXcode(String sfxcode)
	{
		UtilityClass.fn_validateText("SFXcodeOnRateCardPage",sfxcode);
	}

}
