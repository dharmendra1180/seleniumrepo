package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class OpportunityLandingPage 
{
	Logger log=Logger.getLogger(OpportunityLandingPage.class.getName());
	public void createOpportunity(String bussinesstype,String Csigndate,String Cstartdate,String Cenddate,String folio,String segment,String subsegment)
	
	{
		setBussinessType(bussinesstype);
		setContractSignDate(Csigndate);
		setContractStartDate(Cstartdate);
		setContractEndDate(Cenddate);
		setFolio(folio);
		setSegment(segment);
		setSubSegment(subsegment);
		clickNext();
		//clickNext();
	}
	public void clickNext()
	{
		log.info("Next button is clicked");
		UtilityClass.fn_Click("Opportunity_NextButton");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setFolio(String folio)
	{
		log.info("folio is being entered");
		UtilityClass.fn_Input("customer_creditpage2_folio",folio);
	}
	public void setSegment(String segment)
	{	
		log.info("clicking on segment dropdown");
		UtilityClass.fn_Click("customer_creditpage2_segment");
		log.info("selecting segment ");
		List<WebElement> segmentList=UtilityClass.fn_getWebelements("customer_creditpage2_segment_options");
		int listsize=segmentList.size();
		for(int i=0;i<listsize;i++)
		{
			String s=segmentList.get(i).getText();
			if(s.equals(segment))
			{
				Actions ac=new Actions(UtilityClass.driver);
				ac.moveToElement(segmentList.get(i)).click().build().perform();break;
				
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setSubSegment(String subsegment)
	{
		log.info("clicking on subsegment dropdown");
		UtilityClass.fn_clickByAction("customer_creditpage2_subsegment");
		log.info("selecting sub segment");
		List<WebElement> subsegmentList=UtilityClass.fn_getWebelements("customer_creditpage2_subsegment_options");
		int listsize=subsegmentList.size();
		for(int i=0;i<listsize;i++)
		{
			String s=subsegmentList.get(i).getText();
			if(s.equals(subsegment))
			{
				WebElement we=subsegmentList.get(i);
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
	public void setContractSignDate(String date)
	{
		String[] dt=date.split("-");
		String day=dt[0];
		String month=dt[1].toUpperCase();
		String year=dt[2];
		log.info("clicking on signdate");
		UtilityClass.fn_Click("customer_creditpage2_contractsigndate");
		log.info("selecting year");
		UtilityClass.fn_Click("customer_creditpage2_contractsigndate_selectyeardropdown");
		List<WebElement> yearList=UtilityClass.fn_getWebelements("customer_creditpage2_contractsigndate_selectyear");
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
		log.info("selecting month");
		List<WebElement> monthList=UtilityClass.fn_getWebelements("customer_creditpage2_contractsigndate_selectmonth");
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
		log.info("selecting day");
		List<WebElement> dayList=UtilityClass.fn_getWebelements("customer_creditpage2_contractsigndate_selectdate");
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
	public void setContractStartDate(String date)
	{
			String[] dt=date.split("-");
			String day=dt[0];
			String month=dt[1].toUpperCase();
			String year=dt[2];
			log.info("clicking on start date");
			UtilityClass.fn_Click("customer_creditpage2_contractstartdate");
			UtilityClass.fn_Click("customer_creditpage2_contractstartdate_selectyeardropdown");
			log.info("selecting year");
			List<WebElement> yearList=UtilityClass.fn_getWebelements("customer_creditpage2_contractstartdate_selectyear");
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
			log.info("selecting month");
			List<WebElement> monthList=UtilityClass.fn_getWebelements("customer_creditpage2_contractstartdate_selectmonth");
			int n=monthList.size();
			for(int i=0;i<n;i++)
			{
				String s=monthList.get(i).getText();
				if(s.equals(month))
				{
					monthList.get(i).click();break;
				}
			}
			log.info("selecting day");
			List<WebElement> dayList=UtilityClass.fn_getWebelements("customer_creditpage2_contractstartdate_selectdate");
			int  d=dayList.size();
			for(int i=0;i<d;i++)
			{
				String s=dayList.get(i).getText();
				if(s.equals(day))
				{
					dayList.get(i).click();break;
				}
			}
	}
	public void setContractEndDate(String date)
	{
		String[] dt=date.split("-");
		String day=dt[0];
		String month=dt[1].toUpperCase();
		String year=dt[2];
		log.info("clicking on end date");
		UtilityClass.fn_Click("customer_creditpage2_contractenddate");
		UtilityClass.fn_Click("customer_creditpage2_contractenddate_selectyeardropdown");
		log.info("selecting year");
		List<WebElement> yearList=UtilityClass.fn_getWebelements("customer_creditpage2_contractendtdate_selectyear");
		int listsize=yearList.size();
		for(int i=0;i<listsize;i++)
		{
			String s=yearList.get(i).getText();
			if(s.equals(year))
			{
				yearList.get(i).click();break;
			}
		}
		log.info("selecting month");
		List<WebElement> monthList=UtilityClass.fn_getWebelements("customer_creditpage2_contractenddate_selectmonth");
		int n=monthList.size();
		for(int i=0;i<n;i++)
		{
			String s=monthList.get(i).getText();
			if(s.equals(month))
			{
				monthList.get(i).click();break;
			}
		}
		log.info("selecting day");
		List<WebElement> dayList=UtilityClass.fn_getWebelements("customer_creditpage2_contractenddate_selectdate");
		int  d=dayList.size();
		for(int i=0;i<d;i++)
		{
			String s=dayList.get(i).getText();
			if(s.equals(day))
			{
				dayList.get(i).click();break;
			}
		}

		
	}
	public void validateSFXcode(String sfxcode)
	{
		log.info("sfxcode is being validated");
		UtilityClass.fn_validateText("SFXcodeOnOpportunityPage",sfxcode);
	}
	
	
	public void verifyOpportunityCreation()
	{
		//2. opportunity status moved to Draft
	//	3. User is able to select the opportunity type
	//	4. User is able to enter all the values for the fields
	//	5. Opportunity should be created for the new MSA created.
	}
	
	public void setBussinessType(String bussinesstype)
	{
		log.info("clicking on bussiness type dropdown");
		UtilityClass.fn_Click("bussiness_type");
		List<WebElement> businesstypeOptions=UtilityClass.fn_getWebelements("bussiness_type_options");
		log.info("selecting bussiness type");
		int n=businesstypeOptions.size();
		for(int i=0;i<n;i++)
		{
			String s=businesstypeOptions.get(i).getText();
			if(s.equals(bussinesstype))
			{
				businesstypeOptions.get(i).click();break;
			}
		}
		
	}

}
