package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class NewSLALandingPage 
{
	
			public void clickContinue()
			{
				UtilityClass.fn_Click("SLA_ContinueButton");
			}
			
			public void setTransitTime() 
			{ 
				UtilityClass.fn_Click("SLA_TransitTime_GrpB");
			}
			
			public void setSLACharges(String grpA,String grpB) 
			{ 
				List<WebElement> list=UtilityClass.fn_getWebelements("SLA_SLAcharges");
				int n=list.size();
				String[] s= {grpA,grpB};
				for(int i=0;i<n;i++)
				{
					WebElement we=list.get(i);
					we.clear();
					we.sendKeys(s[i]);
				}
			}
			
			public void submitSLA(String grpA,String grpB)
			{
				//setTransitTime();
				setSLACharges(grpA,grpB);
				clickContinue();
				
			}
			

}
