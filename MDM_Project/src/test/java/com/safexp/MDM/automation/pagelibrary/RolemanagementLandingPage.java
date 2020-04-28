package com.safexp.MDM.automation.pagelibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class RolemanagementLandingPage {
	
	public void enterRoleToSearch(String role)
	{
		UtilityClass.fn_Input("RoleManagementpage_searchbox_input", role);
	}
	 public void verifyRoleExist_createIfnotExist(String role,String description,String objectnm,String channel)
	 {
		 System.out.println("role is being entered");
		 UtilityClass.fn_Input("RoleManagementpage_searchbox_input", role);
		 List<Integer> status=null;
		 try {
			Thread.sleep(500);
			status=UtilityClass.fn_searchByElementTextInWebTable("RoleManagementpage_rolelistTable",1,role);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Existence role is being verified");
		 if(status.size()==0)
		 {
			 System.out.println("role does not exist");
			 System.out.println("role is being created");
			 UtilityClass.fn_Click("RoleManagementpage_plusbutton");
			 new CreateRoleLandingPage().createNewRole(role,description,objectnm,channel);
		 }
		 else
		 {
			 System.out.println("role exist");
			 
		 }
	 }
	 public void modifyRole(String role,String newtext)
		{
		 	
//			UtilityClass.getWebElement("UsermanagementHome_role_Usermanagementmenu").click();
			UtilityClass.clearTheContent("RoleManagementpage_searchbox_input");
			UtilityClass.fn_Input("RoleManagementpage_searchbox_input",role);
			List<WebElement> we=UtilityClass.fn_getWebelements("RoleManagementpage_rolelistTable");
			if(we.size()!=0) {System.out.println("role is being searched to modify");
			List<Integer> rowlist=UtilityClass.fn_searchByElementTextInWebTable("RoleManagementpage_rolelistTable",1,role);
			if(rowlist.size()!=0) 
			{			
			System.out.println("role is being modified");
			//UtilityClass.driver.findElement(By.xpath("//*[@id='lending']/div[1]/table/tbody/tr[1]/td[3]/span[2]")).click();
			//fn_clickByAction("RoleManagementpage_rolelistTable");
			UtilityClass.fn_clickOnSetOfDataInWebTable("RoleManagementpage_rolelistTable",rowlist,5);
			UtilityClass.fn_InputByAction("RoleManagementpage_modifydescription",newtext);
			UtilityClass.fn_Click("RoleManagementpage_submitbutton");
			System.out.println("role is modified");
			}
			
			}else {System.out.println("invalid role");}
		}

}
