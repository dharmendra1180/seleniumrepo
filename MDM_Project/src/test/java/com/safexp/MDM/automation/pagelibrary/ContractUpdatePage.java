package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class ContractUpdatePage
{
	Logger log=Logger.getLogger(ContractUpdatePage.class.getName());
	public void clickOn_GeneralEdit()
	{
		log.info("clicking on GeneralEdit button");
		UtilityClass.fn_Click("GeneralEditButton");
	}
}
