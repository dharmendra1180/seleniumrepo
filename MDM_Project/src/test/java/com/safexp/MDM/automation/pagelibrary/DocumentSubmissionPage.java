package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class DocumentSubmissionPage 
{
	Logger log=Logger.getLogger(DocumentSubmissionPage.class.getName()); 
	public void DocumentSubmission_doctype(String service)
		{
			try 
			{
			log.info("clicking on document type dropdown");	
			UtilityClass.fn_Click("DocumentSubmission_doctype");
			Thread.sleep(2000);
			//WebDriverWait wait=new WebDriverWait(UtilityClass.driver,30);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option")));
			log.info("list of document type is being fetched");
			List<WebElement> serviceList=UtilityClass.fn_getWebelements("DocumentSubmission_doctypeOption");
			
			int listsize=serviceList.size();
			log.info("expected document type is being searched in list");
			for(int i=0;i<listsize;i++)
			{
				WebElement we=serviceList.get(i);
				String s=we.getText();
				if(s.equals(service))
				{
					log.info("expected document type is being selected");
					//Actions ac=new Actions(UtilityClass.driver);
					//ac.moveToElement(we).perform();
					Thread.sleep(2000);
					we.click();
					break;
					
				}else {log.info("document type not matched");}
			}
			}catch(Exception e) {}
		}
			
	public void DocumentSubmission_docSubtype(String service)
	{
		try {
			log.info("clicking on document subtype dropdown");
		UtilityClass.fn_Click("DocumentSubmission_docSubtype");
		Thread.sleep(2000);
	//	WebDriverWait wait=new WebDriverWait(UtilityClass.driver,30);
	//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option")));
		log.info("list of document subtype is being fetched");
		List<WebElement> serviceList=UtilityClass.fn_getWebelements("DocumentSubmission_docSubtypeOption");
		int listsize=serviceList.size();
		log.info("expected document subtype is being searched in list");
		for(int i=0;i<listsize;i++)
		{
			WebElement we=serviceList.get(i);
			String s=we.getText();
			if(s.equals(service))
			{
				log.info("expected document type is being selected");
			//	Actions ac=new Actions(UtilityClass.driver);
			//	ac.moveToElement(we).perform();
				Thread.sleep(2000);
				we.click();
				break;
				
			}else {log.info("document type not matched");}
		}
		}catch(Exception e) {}
	}
	
	public void DocumentSubmission_Entitytype(String service)
	{
		try {
			log.info("clicking on entity type dropdown");
		UtilityClass.fn_Click("DocumentSubmission_Entitytype");
		Thread.sleep(2000);
		//WebDriverWait wait=new WebDriverWait(UtilityClass.driver,30);
	//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cdk-overlay-pane']/div/div/mat-option")));
		log.info("list of entity type is being fetched");
		List<WebElement> serviceList=UtilityClass.fn_getWebelements("DocumentSubmission_EntitytypeOption");
		int listsize=serviceList.size();
		log.info("expected entity type is being searched in list");
		for(int i=0;i<listsize;i++)
		{
			WebElement we=serviceList.get(i);
			String s=we.getText();
			if(s.equals(service))
			{
				log.info("expected entity type is being selected");
			//	Actions ac=new Actions(UtilityClass.driver);
			//	ac.moveToElement(we).perform();
				Thread.sleep(2000);
				we.click();
				break;
				
			}else {log.info("entity type not matched");}
		}
		}catch(Exception e) {}
	}
	
public void clickOnPreview()
{
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("clicking on preview button");
	UtilityClass.fn_Click("DocumentSubmission_PreviewButton");
}
public void getSFXCodeFromSFXGeneratedPopupMessage()
{
	String sfxcode=UtilityClass.getTextOnElement("SFXCodeGeneratedMessage");
	log.info("generated sfxcode:"+sfxcode);
	log.info("clicking on popup OK button");
	UtilityClass.fn_Click("SFXCodeGeneratedpopupOKbutton");
}
public void validateSFXcode(String sfxcode)
{
	log.info("sfxcode is being validated");
	UtilityClass.fn_validateText("SFXcodeOnDocumentUploadPage",sfxcode);
}
public void clickOnPreviewPageSubmit()
{
	log.info("clicking on preview page submit button");
	UtilityClass.fn_Click("PreviewPageSubmit");
}			

public void setDocumentDetails(String doctype,String docsubtype,String entitytype)
{
	DocumentSubmission_doctype(doctype);
	DocumentSubmission_docSubtype(docsubtype);
	DocumentSubmission_Entitytype(entitytype);
	clickOnPreview();
	clickOnPreviewPageSubmit();
	getSFXCodeFromSFXGeneratedPopupMessage();
}

			

	    
	

}
