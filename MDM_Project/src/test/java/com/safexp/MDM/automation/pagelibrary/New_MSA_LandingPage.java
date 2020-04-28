package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class New_MSA_LandingPage {
	Logger log=Logger.getLogger(New_MSA_LandingPage.class.getName());
	public void createNewMSA(String name,String mobile,String addr,String landline,String pincodestate,String pincodecity,String poc,String pannum,String GSTN,String sla,String acctype,String segment,String subsegment,String loc,String monthlypotential)
	{	
		log.info("New_MSA_LandingPage:createNewMSA method");
		setCustomerName(name);
		setMobile(mobile);
		setRegisterAddr(addr);
		setLandline(landline);
		setPincode(pincodestate,pincodecity);
		setContactPerson(poc);
		setPan(pannum);
		setGSTN(GSTN);
		setSLA(sla);
		setAccountType(acctype);
		//setMonthlyPotential(monthlypotential);
		setSegment(segment);
		setSubSegment(subsegment);
		setBaseLocation(loc);
		clickOnPlusIcon();
	}
	public void clickOnConsignerConsigneeDiv()
	{
		log.info("clicking on consigner/consignee division");
		UtilityClass.fn_Click("NewMSApage_ConsigerConsigneeDiv");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setCustomerName(String name)
	{
		log.info("customer name is being entered");
		UtilityClass.fn_Input("NewMSApage_custname",name);
	}
	public void setPincode(String pincodestate,String pincodecity)
	{
		try {
		log.info("clicking on pincode input");
		UtilityClass.fn_Click("NewMSApage_pincode");
		log.info("selecting state");
		UtilityClass.fn_SelectByVisibleText("NewMSApage_pincode_selectstate","NewMSApage_pincode_stateOption", pincodestate);
		log.info("selecting city");
		UtilityClass.fn_SelectByVisibleText("NewMSApage_pincode_selectcity","NewMSApage_pincode_cityOption", pincodecity);
		log.info("selecting pincode");
		UtilityClass.fn_Click("NewMSApage_selectpincode");
		log.info("clicking on submit button");
		UtilityClass.fn_Click("NewMSApage_submitpincodebtn");
		}catch(Exception e) {}

	}
	public void setMonthlyPotential(String mp)
	{
		UtilityClass.fn_Input("NewMSApage_monthlyPotential",mp);
	}
	public void setRegisterAddr(String addr)
	{
		log.info("Registered address is being entered");
		UtilityClass.fn_Input("NewMSApage_registerAddr",addr);
	}
	
	public void setMobile(String name)
	{
		log.info("mobile number is being entered");
		UtilityClass.fn_Input("NewMSApage_mobileno",name);
	}
	
	public void setLandline(String number)
	{
		log.info("landline number is being entered");
		UtilityClass.fn_Input("NewMSApage_landlineno",number);
	}
	public void setGroupCode(String name)
	{
		UtilityClass.fn_Input("NewMSApage_groupcode",name);
	}
	
	public void setContactPerson(String name)
	{
		log.info("");
		UtilityClass.fn_Input("NewMSApage_contactperson",name);
	}
	public void setPan(String name)
	{
		log.info("pan number is being entered");
		UtilityClass.fn_Input("NewMSApage_pannum",name);
	}
	
	public void setGSTN(String gstn)
	{
		log.info("GSTIN is being entered");
		UtilityClass.fn_Input("NewMSApage_GSTN",gstn);
	}
	public void setSLA(String sla)
	{
		log.info("sla is being entered");
		UtilityClass.fn_Input("NewMSApage_sla",sla);
	}
	
	public void clickOnPlusIcon()
	{
		log.info("plusicon is being clicked");
		UtilityClass.fn_Click("NewMSApage_consignerconsigneeplusicon");
	}
	
	
	public void setAccountType(String acctype)
	{
		log.info("clicking on Account type dropdown");
		UtilityClass.fn_Click("NewMSApage_accType");
		log.info("list of account type is being fetched");
		List<WebElement> segmentlist=UtilityClass.fn_getWebelements("NewMSApage_accTypeoptions");
		int listsize=segmentlist.size();
		log.info("expected account is being searched");
		for(int i=0;i<listsize;i++)
		{
			String s=segmentlist.get(i).getText();
			//System.out.println(s);
			if(s.equals(acctype))
			{
				log.info("expected account type is found and is being clicked");
				segmentlist.get(i).click();break;
			}else {log.info("expected account type is not matched");}
		}

	}
	public void setSegment(String segment)
	{
		log.info("clicking on segment dropdown");
		Actions act=new Actions(UtilityClass.driver);
		WebElement we=UtilityClass.getWebElement("NewMSApage_segmentdropdown");
		act.moveToElement(we).perform();
		we.click();
	//	UtilityClass.fn_clickByAction("NewMSApage_segmentdropdown");
	//	UtilityClass.fn_clickByAction("NewMSApage_segmentdropdown");
		log.info("segment options list is being fetched");
		List<WebElement> segmentlist=UtilityClass.fn_getWebelements("NewMSApage_segmentoptions");
		int listsize=segmentlist.size();
		log.info("expected segment is being searched in list");
		for(int i=0;i<listsize;i++)
		{
			String s=segmentlist.get(i).getText();
			//System.out.println(s);
			if(s.equals(segment))
			{
				log.info("expected segment is found and is being clicked");
				act.moveToElement(segmentlist.get(i)).perform();
				segmentlist.get(i).click();break;
			}else {log.info("expected segment is not matched");}
		}

	}
	public void setSubSegment(String subsegment)
	{	
		log.info("clicking on subsegment dropdown");
		Actions act=new Actions(UtilityClass.driver);
		WebElement we=UtilityClass.getWebElement("NewMSApage_subsegmentdropdown");
		act.moveToElement(we).perform();
		we.click();
		log.info("list of subsegment is being fetched");
		List<WebElement> subsegmentlist=UtilityClass.fn_getWebelements("NewMSApage_subsegmentoptions");
		int listsize=subsegmentlist.size();
		log.info("subsegment is being searched in list");
		for(int i=0;i<listsize;i++)
		{
			String s=subsegmentlist.get(i).getText();
			//System.out.println(s);
			if(s.equals(subsegment))
			{
				log.info("subsegment found and is being clicked");
				act.moveToElement(subsegmentlist.get(i)).perform();
				subsegmentlist.get(i).click();break;
			}
		}
	
	}
	public void setBaseLocation(String branch)
	{
		log.info("baselocation is being entered");
		Actions act=new Actions(UtilityClass.driver);
		UtilityClass.fn_Input("NewMSApage_baselocsearchInput",branch);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> branchlist=UtilityClass.fn_getWebelements("NewMSApage_baselocOptions");
		int listsize=branchlist.size();
		for(int i=0;i<listsize;i++)
		{
			String s=branchlist.get(i).getText();
			//System.out.println(s);
			if(s.equals(branch))
			{
				act.moveToElement(branchlist.get(i)).perform();
				branchlist.get(i).click();break;
			}
		}
		
	}
	
	public void verifyMSAcreation()
	{
		
	}
	public void selectBaseLocation(String location) 
	{
		UtilityClass.fn_clickByAction("customer_creditpage_baselocation_search");
		UtilityClass.fn_Input("customer_creditpage_baselocation_advanceSearch",location);
		UtilityClass.fn_Click("advancesearch_icon");
		UtilityClass.fn_Click("select_radio");
		UtilityClass.fn_Click("save_button");
		
	}
	
	public void clickNext()
	{
		log.info("clicking on Next button");
		UtilityClass.fn_Click("next_button");
	}
	public void clickOnPlusicon()
	{
		log.info("clicking on plusicon button");
		UtilityClass.fn_Click("credit_contract_plusicon");
	}
	public void clickOnSaveAsDraft()
	{
		
	}
	public void setAllDetails(String loc,String sla)
	{
		selectBaseLocation(loc);
		setSLA(sla);
		clickOnPlusicon();
		//clickNext();
	}


}
