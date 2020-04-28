package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class BillingLandingPage 
{
	Logger log=Logger.getLogger(BillingLandingPage.class.getName());
			
	public void submitBillingPage(String aliasname,String subtype,String subtypeinput,String billingcycle,String paymentterm,String toa,String tod,String billformat,String billingby )
	{
		//clickOnBillingLevel_DetailedLink();
		log.info("BillingLandingPage:submitBillingPage method");
		clickOnBillingLevel();
		setAliasName(aliasname);
		clickOnBillingsubLevel();
		setBillingsubType(subtype);
		setSubTypeInputVal(subtypeinput);
		clickOnBillingDetails();
		setBillingCycle(billingcycle);
		setBillingPaymentTerm(paymentterm);
		setBillingTurnOverAmt(toa);
		setBillingTodBasedOn(tod);
		setBillingFormat(billformat);
		setBillingBy(billingby);
					
	}
	public void BillingAssignBranch(String billingbranch )
	{
		log.info("setting bill assign branch");
		UtilityClass.fn_Click("Billing_billingBranch");
		UtilityClass.fn_Input("Billing_billingBranchpopupInput",billingbranch);
		UtilityClass.fn_Click("Billing_billingBranchPopupSearchIcon");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilityClass.fn_Click("Billing_billingBranchPopupSelectBranch");
		clickOnSave();
	}
	public void BillingSubmissionBranch(String submissionbranch )
	{
		log.info("setting submission branch");
		UtilityClass.fn_Click("Billing_submissionBranch");
		UtilityClass.fn_Input("Billing_submissionBranchPopupInput",submissionbranch);
		UtilityClass.fn_Click("Billing_submissionBranchPopupSearchIcon");
		UtilityClass.fn_Click("Billing_submissionBranchPopupSelectBranch");
		clickOnSave();
	}
	public void BillingCollectionBranch(String collectionbranch )
	{
		log.info("setting collection branch");
		UtilityClass.fn_Click("Billing_collectionBranch");
		UtilityClass.fn_Input("Billing_collectionBranchPopupInput",collectionbranch);
		UtilityClass.fn_Click("Billing_collectionBranchPopupSearchIcon");
		UtilityClass.fn_Click("Billing_collectionBranchPopupSelectBranch");
		clickOnSave();
	}
	
	public void setExcludeBillingDate(String date)
	{
		String[] dt=date.split("-");
		String day=dt[0];
		String month=dt[1].toUpperCase();
		String year=dt[2];
		UtilityClass.fn_Click("Billing_excludeBillingDate_CalIcon");
		UtilityClass.fn_Click("Billing_excludeBillingDate_yeardropdown");
		List<WebElement> yearList=UtilityClass.fn_getWebelements("Billing_excludeBillingDate_selectyear");
		int listsize=yearList.size();
		for(int i=0;i<listsize;i++)
		{
			String s=yearList.get(i).getText();
			if(s.equals(year))
			{
				Actions ac=new Actions(UtilityClass.driver);
				ac.moveToElement(yearList.get(i)).click().build().perform();break;
				
			}
		}
		List<WebElement> monthList=UtilityClass.fn_getWebelements("Billing_excludeBillingDate_selectmonth");
		int n=monthList.size();
		for(int i=0;i<n;i++)
		{
			String s=monthList.get(i).getText();
			if(s.equals(month))
			{
				Actions ac=new Actions(UtilityClass.driver);
				ac.moveToElement(monthList.get(i)).click().build().perform();break;
			
			}
		}
		List<WebElement> dayList=UtilityClass.fn_getWebelements("Billing_excludeBillingDate_selectday");
		int  d=dayList.size();
		for(int i=0;i<d;i++)
		{			
			String s=dayList.get(i).getText();
			if(s.equals(day))
			{
				Actions ac=new Actions(UtilityClass.driver);
				ac.moveToElement(dayList.get(i)).click().build().perform();break;

			}
		}
		

	}

	public void setBillingByDetails(String billingbranch,String submissionbranch,String collectionbranch,String gstin,String minbillamt,String tan,String ebillemail,String bdmemail,String commemail,String addr1,String addr2,String addr3,String GBCategory)
	{
		BillingAssignBranch(billingbranch);
		BillingSubmissionBranch(submissionbranch);
		BillingCollectionBranch(collectionbranch);
		log.info("Providing GSTIN value");
		UtilityClass.fn_Input("Billing_GSTIN",gstin);
		log.info("providing minimum bill amount");
		UtilityClass.fn_Input("Billing_MinBillAmt",minbillamt);
		log.info("providing TAN");
		UtilityClass.fn_Input("Billing_TAN",tan);
		log.info("providing e-bill emailid");
		UtilityClass.fn_Input("Ebill_emailid",ebillemail);
		//log.info("BDM-emailid");
		//UtilityClass.fn_Input("BDM_emailid",bdmemail);
		log.info("communication emailid");
		UtilityClass.fn_Input("Communication_emailid",commemail);
		setGBCategory(GBCategory);
		setBillingAddress(addr1,addr2,addr3);
		//UtilityClass.fn_Click("Billing_excludeBillingYESRadioOption");
		//setExcludeBillingDate("23-APR-2020");
		//UtilityClass.fn_Click("Billing_excludeBillingNORadioOption");


	
		}
	  public void setBillingAddress(String addr1,String addr2,String addr3)
	  {
		  log.info("BillingLandingPage:setBillingAddress method");
		  log.info("clicking on plus to add addresses");
		  UtilityClass.fn_Click("Billing_billToAddress");
		  log.info("providing first address");
		  UtilityClass.fn_Input("Billing_billToAddress1",addr1);
		  log.info("providing second address");
		  UtilityClass.fn_Input("Billing_billToAddress2",addr2);
		  log.info("providing third address");
		  UtilityClass.fn_Input("Billing_billToAddress3",addr3);
		  log.info("clicking on save button");
		  UtilityClass.fn_Click("Billing_billToAddressSave");
		  
		  
	  }
	public void setGBCategory(String category)
	{
		log.info("clicking on billing GBcategory dropdown");
		UtilityClass.fn_Click("Billing_GBcategory");
		log.info("list of GBcategory is being fetched");
		List<WebElement> serviceList=UtilityClass.fn_getWebelements("Billing_GBcategoryOptions");
		int listsize=serviceList.size();
		log.info("Expected GBcategory is searched in list");
		for(int i=0;i<listsize;i++)
		{
			WebElement we=serviceList.get(i);
			String s=we.getText();
			if(s.equals(category))
			{
				log.info("found expected GBcategory and is being clicked");
			//	Actions ac=new Actions(UtilityClass.driver);
			//	ac.moveToElement(we).perform();
				we.click();
				break;
				
			}else {log.info("Expected GBcategory is not matched");}
		}
	}
		




	public void clickOnBillingLevel_DetailedLink()
	{
		log.info("clicking on Detailed link of billing page");
		UtilityClass.fn_Click("BillingLevel_DetailedLink");
	}
			public void clickOnBillingLevel()
			{
				log.info("clicking on billing level option");
				UtilityClass.fn_Click("BillingLevel");
			}
			
			public void setAliasName(String name)
			{
				log.info("Alias name is being entered");
				UtilityClass.fn_Input("BillingLevel_MSA_aliasName", name);
			}
			
			public void clickOnBillingsubLevel()
			{
				log.info("clicking on billing sublevel option");
				UtilityClass.fn_Click("BillingsubLevel_MSA");
			}
			
			public void setBillingsubType(String subtype)
			{
				log.info("clicking on billing subType dropdown");
				UtilityClass.fn_clickByAction("BillingsubType_MSA");
				log.info("list of billing subtype is being fetched");
				List<WebElement> deliveryList=UtilityClass.fn_getWebelements("BillingsubTypeOptions_MSA");
				int listsize=deliveryList.size();
				log.info("search of subtype in the list is being done ");
				for(int i=0;i<listsize;i++)
				{
					
					String s=deliveryList.get(i).getText();
					if(s.equals(subtype))
					{
						log.info("billing subtype matched with expected");
						WebElement we=deliveryList.get(i);
						Actions ac=new Actions(UtilityClass.driver);
						ac.moveToElement(we).perform();
						log.info("billing subtype is being clicked ");
						ac.click().perform();
						break;
					}
					else {log.info("billing subtype not matched with expected");}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			public void setSubTypeInputVal(String val)
			{
				log.info("providing value to subtype inputbox");
				UtilityClass.fn_Input("BillingsubTypeInputVal_MSA", val);
			}
			public void clickOnBillingDetails()
			{
				log.info("clicking on billing details link");
				UtilityClass.fn_Click("BillingDetails_MSA");
			}
			public void setBillingCycle(String val)
			{
				log.info("clicking cycle option");
				UtilityClass.fn_clickByAction("BillingCycle_MSA");
				log.info("list of billing cycle is being fetched");
				List<WebElement> deliveryList=UtilityClass.fn_getWebelements("BillingCycleOption_MSA");
				int listsize=deliveryList.size();
				log.info("looking expected billing cycle into list");
				for(int i=0;i<listsize;i++)
				{
					String s=deliveryList.get(i).getText();
					if(s.equals(val))
					{
						log.info("expexted billing cycle found and is being clicked");
						WebElement we=deliveryList.get(i);
						Actions ac=new Actions(UtilityClass.driver);
						ac.moveToElement(we).perform();
						we.click();
						break;
					}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			public void setBillingPaymentTerm(String val)
			{
				log.info("billing paymentterm is being clicked");
				UtilityClass.fn_clickByAction("BillingPaymentTerm_MSA");
				log.info("list of billing payment term is being fetched");
				List<WebElement> deliveryList=UtilityClass.fn_getWebelements("BillingPaymentTermOption_MSA");
				int listsize=deliveryList.size();
				log.info("looking expected billing payment term into list ");
				for(int i=0;i<listsize;i++)
				{
					String s=deliveryList.get(i).getText();
					if(s.equals(val))
					{
						log.info("Expected billing payment term is found and is being clicked");
						WebElement we=deliveryList.get(i);
						Actions ac=new Actions(UtilityClass.driver);
						ac.moveToElement(we).perform();
						ac.click().perform();
						break;
					}else {log.info("Expected billing payment term is not matched");}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			
			public void setBillingTurnOverAmt(String val)
			{
				log.info("providing value to BillingTurnOverAmt input field");
				UtilityClass.fn_Input("BillingTurnOverAmt_MSA", val);
			}
			
			public void setBillingTodBasedOn(String val)
			{
				log.info("clicking on BillingTodBasedOn dropdown");
				UtilityClass.fn_clickByAction("BillingTodBasedOn_MSA");
				log.info("list of BillingTodBasedOnOption is being fetched");
				List<WebElement> deliveryList=UtilityClass.fn_getWebelements("BillingTodBasedOnOption_MSA");
				int listsize=deliveryList.size();
				log.info("looking expected value into list");
				for(int i=0;i<listsize;i++)
				{
					String s=deliveryList.get(i).getText();
					if(s.equals(val))
					{
						log.info("Expected is found and is being clicked");
						WebElement we=deliveryList.get(i);
						Actions ac=new Actions(UtilityClass.driver);
						ac.moveToElement(we).perform();
						ac.click().perform();
						break;
					}else {log.info("Expected is not matched");}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			public void setBillingFormat(String val)
			{
				log.info("clicking on billing format dropdown");
				UtilityClass.fn_clickByAction("BillingFormat_MSA");
				log.info("list of billing format is being fetched");
				List<WebElement> deliveryList=UtilityClass.fn_getWebelements("BillingFormatOption_MSA");
				int listsize=deliveryList.size();
				log.info("looking expected billing format into list");
				for(int i=0;i<listsize;i++)
				{
					
					String s=deliveryList.get(i).getText();
					if(s.equals(val))
					{
						log.info("found expected billing format and is being clicked");
						WebElement we=deliveryList.get(i);
						Actions ac=new Actions(UtilityClass.driver);
						ac.moveToElement(we).perform();
						we.click();
						break;
					}else {log.info("Expected billing format is not matched");}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			public void setBillingBy(String val)
			{
				log.info("clicking billingby dropdown");
				UtilityClass.fn_clickByAction("BillingBy_MSA");
				log.info("list of billingby options is being  fetched");
				List<WebElement> deliveryList=UtilityClass.fn_getWebelements("BillingByOption_MSA");
				int listsize=deliveryList.size();
				log.info("expected billingby option is being searched in list");
				for(int i=0;i<listsize;i++)
				{
					String s=deliveryList.get(i).getText();
					if(s.equals(val))
					{
						log.info("found expected option and is being clicked");
						WebElement we=deliveryList.get(i);
						Actions ac=new Actions(UtilityClass.driver);
						ac.moveToElement(we).perform();
						we.click();
						break;
					}else {log.info("expected option is not matched");}
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			public void validateSFXcode(String sfxcode)
			{
				log.info("validating sfxcode present on billing page");
				UtilityClass.fn_validateText("SFXcodeOnBillingPage",sfxcode);
			}
			public void clickOnNext()
			{
				log.info("clicking on Next button of billing page");
				UtilityClass.fn_Click("BillingNextButton");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			public void clickOnSave()
			{
				UtilityClass.fn_Click("Billing_billingBranchSelectSavebt");
			}
			

}
