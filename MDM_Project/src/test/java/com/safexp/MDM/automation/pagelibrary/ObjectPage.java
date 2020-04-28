package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class ObjectPage {
	Logger log=Logger.getLogger(ObjectPage.class.getName());
	public void verifyObject() {
		String s=UtilityClass.getdataofWebTable("FirstObjectFromSearchList_td");
		System.out.println(s);
		UtilityClass.fn_Click("FirstObjectViewFromSearchList_td");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement we=UtilityClass.getWebElement("ObjectDetailsPage_ObjectName_Input");
		String s1=UtilityClass.fn_getTextfromDisabledElement(we);
		System.out.println(s1);
		if(s.equalsIgnoreCase(s1))
		{
			System.out.println("object verified");
		}
		else
		{
			System.out.println("object not verified");
		}
	}

}
