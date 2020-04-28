package com.safexp.MDM.automation.pagelibrary;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class PreOpportunityLandingPage 
{
	public void setOpportunityName(String opportunityname)
	{
		UtilityClass.fn_Input("PreOpportunityPage_opportunityName_Input", opportunityname);
	}
	public void clickOnSubmit()
	{
		UtilityClass.fn_Click("PreOpportunityPage_Submit_bt");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
