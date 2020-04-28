package com.safexp.MDM.automation.pagelibrary;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class NewVMILandingPage 
{
	public void clickOnContinue()
	{
		UtilityClass.fn_Click("VMI_ContinueButton");
	}
	public void submitVMI()
	{
	clickOnContinue();
	}
}
