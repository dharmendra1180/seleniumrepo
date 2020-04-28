package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class Consigner_ConsigneePage 
{
	Logger log=Logger.getLogger(Consigner_ConsigneePage.class.getName());
			
public void clickOnSave()
{
	log.info("clicking on save button");
	UtilityClass.fn_Click("consignor_consignee_savebt");				
}
public void clickOnPlusicon(String orname)
{
	log.info("clicking on Plusicon");
	UtilityClass.fn_Click(orname);				
}
public void createNewConsignerConsignee(String name,String gst,String tannum,String pannum,String pincodestate,String pincodecity,String dlrcode,String mob,String cosigntype)
{
	 log.info("Consigner_ConsigneePage:createNewConsignerConsignee method");
	 setName("Newconsignor_consignee_name",name);
	 setGST("Newconsignor_consignee_gstnum",gst);
	 setTAN("Newconsignor_consignee_tannum",tannum);
	 setPAN("Newconsignor_consignee_pannum",pannum);
	 setPincode(pincodestate,pincodecity);
	 setDealercode("Newconsignor_consignee_dealer",dlrcode);
	 setMobile("Newconsignor_consignee_mob",mob);
	 selectConsignType("Newconsignor_consignee_consigntype",cosigntype);
	 
}
public void setAddress(String addr1,String addr2,String addr3)
{
	log.info("Consigner_ConsigneePage:setAddress method");
	log.info("setting first address");
	UtilityClass.fn_Input("consignor_consignee_address1",addr1);
	log.info("setting second address");
	UtilityClass.fn_Input("consignor_consignee_address2",addr2);
	log.info("Consigner_Consignee third address");
	UtilityClass.fn_Input("consignor_consignee_address3",addr3);
	clickOnPlusicon("Newconsignor_consignee_plusicon");
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
clickOnSave();
}
public void setName(String orname,String name)
{
	log.info("setting consigner/consignee name");
	UtilityClass.fn_Input(orname,name);	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void setGST(String orname,String gstnum)
{
	log.info("setting GST value");
	UtilityClass.fn_Input(orname,gstnum);	
}
public void setTAN(String orname,String tan)
{
	log.info("setting TAN value");
	UtilityClass.fn_Input(orname,tan);	
}
public void setPAN(String orname,String pan)
{
	log.info("setting PAN value");
	UtilityClass.fn_Input(orname,pan);	
}
public void setPincode(String pincodestate,String pincodecity)
{	
	log.info("clicking on pincode field");
	UtilityClass.fn_Click("Newconsignor_consignee_pincode");
	log.info("selecting state");
	UtilityClass.fn_SelectByVisibleText("Newconsignor_consignee_pincode_selectstate","Newconsignor_consignee_pincode_stateOption", pincodestate);
	log.info("selecting city");
	UtilityClass.fn_SelectByVisibleText("Newconsignor_consignee_pincode_selectcity","Newconsignor_consignee_pincode_cityOption", pincodecity);
	log.info("selecting pincode");
	UtilityClass.fn_Click("Newconsignor_consignee_selectpincode");
	log.info("clicking on submit button");
	UtilityClass.fn_Click("Newconsignor_consignee_submitpincodebtn");

}
public void setDealercode(String orname,String dlrcode)
{
	log.info("setting dealer code");
	UtilityClass.fn_Input(orname,dlrcode);	
}
public void setMobile(String orname,String mobile)
{
	log.info("setting mobile number");
	UtilityClass.fn_Input(orname,mobile);	
}
public void selectConsignType(String orname,String option)
{
	log.info("clicking on consign type dropdown");
	//UtilityClass.fn_SelectByVisibleText(orname, option);
	UtilityClass.fn_Click(orname);
	log.info("list of consign type is being fetched");
	List<WebElement> segmentlist=UtilityClass.fn_getWebelements("Newconsignor_consigntypeOptions");
	int listsize=segmentlist.size();
	log.info("expected consign type is being searched");
	for(int i=0;i<listsize;i++)
	{
		String s=segmentlist.get(i).getText();
		//System.out.println(s);
		if(s.equals(option))
		{
			log.info("found expected consign type and is being clicked");
			segmentlist.get(i).click();break;
		}
	}
}
 public void filldetailsExceptAddress(String name,String dlrcode,String pannum,String tannum,String gst,String mob,String pincodestate,String pincodecity,String cosigntype)
 {
	 setName("consignor_consignee_name",name);
	 setGST("consignor_consignee_gstnum",gst);
	 setTAN("consignor_consignee_tannum",tannum);
	 setPAN("consignor_consignee_pannum",pannum);
	 setPincode(pincodestate,pincodecity);
	 setDealercode("consignor_consignee_dealer",dlrcode);
	 setMobile("consignor_consignee_mob",mob);
	 selectConsignType("consignor_consignee_consigntype",cosigntype);
	
	 
 }
 public void saveDetails()
 {
	 //clickOnPlusicon();
	 clickOnSave();
 }

}
