package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class ExistingSFXPage 
{
	public void clickOnEdit()
	{
		Logger log=Logger.getLogger(ExistingSFXPage.class.getName());
		UtilityClass.fn_Click("SFX_EditIcon");
	}
	

}
