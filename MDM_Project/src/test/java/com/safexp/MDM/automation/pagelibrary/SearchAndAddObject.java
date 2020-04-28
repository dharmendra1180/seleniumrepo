package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class SearchAndAddObject 
{
	Logger log=Logger.getLogger(SearchAndAddObject.class.getName());
	public void searchObject(String objecttosearch,String channel)
	{
		UtilityClass.fn_Input("RoleManagementpage_objectSearchInputbox",objecttosearch);
		if(channel.equals("WEB"))
		{
			UtilityClass.fn_Click("SearchAndaddObjectPage_WebChannel");
			List<Integer> rowno=UtilityClass.fn_searchByElementTextInWebTable("SearchAndaddObjectPage__objectlistTable",2, objecttosearch);
			if(rowno.size()!=0)
			{
				
					UtilityClass.fn_clickOnSetOfCheckboxInWebTable("SearchAndaddObjectPage__objectlistTable",rowno,1);
				
			}
			/*boolean status=UtilityClass.fn_searchByElementTextInWebTable("SearchAndaddObjectPage__objectlistTable",2, objecttosearch);
			if(status==true)
			{
				boolean status1=UtilityClass.fn_searchByElementTextInWebTable("SearchAndaddObjectPage__objectlistTable",5,"Web");
				if(status1==true)
				{
					UtilityClass.fn_clickOnSetOfCheckboxInWebTable("SearchAndaddObjectPage__objectlistTable",1);
				}
			}*/
		}
		else if(channel.equals("MOBILE"))
		{
			UtilityClass.fn_Click("SearchAndaddObjectPage_MobileChannel");
			List<Integer> rowno=UtilityClass.fn_searchByElementTextInWebTable("SearchAndaddObjectPage__objectlistTable",2, objecttosearch);
			if(rowno.size()!=0)
			{
				
					UtilityClass.fn_clickOnSetOfCheckboxInWebTable("SearchAndaddObjectPage__objectlistTable",rowno,1);
				
			}
		}
		else if(channel.equals("All"))
		{
			UtilityClass.fn_Click("SearchAndaddObjectPage_AllChannel");
			List<Integer> rowno=UtilityClass.fn_searchByElementTextInWebTable("SearchAndaddObjectPage__objectlistTable",2, objecttosearch);
			if(rowno.size()!=0)
			{
				
					UtilityClass.fn_clickOnSetOfCheckboxInWebTable("SearchAndaddObjectPage__objectlistTable",rowno,1);
				
			}
			
		}
		UtilityClass.fn_Click("SearchAndaddObjectPage__submitbutton");
	}
	
}
