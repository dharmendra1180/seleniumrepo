package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class CreateRoleLandingPage {
	Logger log=Logger.getLogger(CreateRoleLandingPage.class.getName());
	public void createNewRole(String role,String description,String objectnm,String channel)
	{
		log.info("CreateRoleLandingPage:createNewRole method");
		log.info("role name is being entered");
		UtilityClass.fn_Input("RoleManagementpage_roleInputbox", role);
		//UtilityClass.fn_Click("RoleManagementpage_statusDropdown");
//		UtilityClass.fn_clickByAction("RoleManagementpage_statusDropdown");
		//UtilityClass.fn_Click("RoleManagementpage_ActiveStatus");
		log.info("role description is being entered");
		UtilityClass.fn_Input("RoleManagementpage_descriptionInput",description);
		/*UtilityClass.fn_Click("RoleManagementpage_addObjectLink");
		new SearchAndAddObject().searchObject(objectnm, channel);
		List<WebElement> we=UtilityClass.fn_getWebelements("RoleManagementpage_mappermissionlist");
		for(int i=we.size()-1;i>=0;i--)
		{ 
			List<WebElement> we1=UtilityClass.fn_getWebelements("RoleManagementpage_mappermissionlist");
			WebElement ele=we1.get(i);
		//String val=ele.getAttribute("name");
			//System.out.println(ele.getText());
			if(ele.getText().contains("Web")) {
				System.out.println("in web permission");
					ele.click();
					if(channel.equalsIgnoreCase("All"))
					{
						List<WebElement> tablerows=UtilityClass.fn_getWebelements("RoleManagementpage_webpermissiontableAllcase");
						int totalrows=tablerows.size();
						System.out.println(totalrows);

						for(int j=1;j<totalrows;j++)
						{
						for(int k=2;k<=4;k++) 
						{
							UtilityClass.fn_clickOnCheckboxInWebTable("RoleManagementpage_webpermissiontableAllcase",j,k);
						}
						}
						
					}else
					{
						List<WebElement> tablerows=UtilityClass.fn_getWebelements("RoleManagementpage_mappermissionlisttable");
						int totalrows=tablerows.size();
						System.out.println(totalrows);

						for(int j=1;j<totalrows;j++)
						{
							UtilityClass.fn_clickOnCheckboxInWebTable("RoleManagementpage_mappermissionlisttable",j,2);
					//	for(int k=2;k<=4;k++) 
					//	{
						//	UtilityClass.fn_clickOnCheckboxInWebTable("RoleManagementpage_mappermissionlisttable",j,k);
						//}
						}
					}
			}
			if(ele.getText().contains("Mobile"))
			{
				System.out.println("in mobile permission");
					ele.click();
					if(channel.equalsIgnoreCase("All"))
					{
						List<WebElement> tablerows=UtilityClass.fn_getWebelements("RoleManagementpage_mobilepermissiontableAllcase");
						int totalrows=tablerows.size();
						System.out.println(totalrows);

						
						for(int j=1;j<totalrows;j++)
						{
						for(int k=2;k<=4;k++) 
						{
							UtilityClass.fn_clickOnCheckboxInWebTable("RoleManagementpage_mobilepermissiontableAllcase",j,k);
						}
						}
						
					}else
					{
						List<WebElement> tablerows=UtilityClass.fn_getWebelements("RoleManagementpage_mappermissionlisttable");
						int totalrows=tablerows.size();
						System.out.println(totalrows);

						for(int j=1;j<totalrows;j++)
						{
						for(int k=2;k<=4;k++) 
						{
							UtilityClass.fn_clickOnCheckboxInWebTable("RoleManagementpage_mappermissionlisttable",j,k);
						}
						}
					}
			}
		}*/
		log.info("clicking on submit button");
		UtilityClass.fn_Click("RoleManagementpage_submitbutton");
		
	}
	public void verifyRoleCreated(String role)
	{
		//UtilityClass.fn_clickByAction("UsermanagementHome_role_Usermanagementmenu");
		log.info("clicking on role menu option");
		UtilityClass.fn_Input("RoleManagementpage_searchbox_input",role);
		//List<WebElement> we=UtilityClass.fn_getWebelements("RoleManagementpage_rolelistTable");
		log.info("Looking for the role created in the rolelist");
		List<Integer> rowlist=UtilityClass.fn_searchByElementTextInWebTable("RoleManagementpage_rolelistTable",1,role);
		if(rowlist.size()!=0) {System.out.println("role created successfully");}
		//UtilityClass.fn_clickOnSetOfDataInWebTable("RoleManagementpage_rolelistTable",rowlist,3);
		//UtilityClass.fn_Input("RoleManagementpage_descriptionInput","role modified");
	//	UtilityClass.fn_Click("RoleManagementpage_submitbutton");

		
	}
	
}
