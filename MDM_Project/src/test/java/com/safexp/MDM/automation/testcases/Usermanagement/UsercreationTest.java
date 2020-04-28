package com.safexp.MDM.automation.testcases.Usermanagement;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Verify;
import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.Utility.ZipUtils;
import com.safexp.MDM.automation.managerClasses.HybridFrameworkDriver;
//@Listeners(com.safexp.MDM.automation.managerClasses.TestListener.class)
public class UsercreationTest 
{
	Logger log=Logger.getLogger(UsercreationTest.class.getName());
	String drvrsheet=null;
	String datasheet=null;
	
	String testdataresource=null;
	String scriptresource=null;
	@BeforeTest
	
	public void OR_Log_Extent_Initialisation()
	{
		UtilityClass.Init();
		UtilityClass.deleteFolder(new File(System.getProperty("user.dir")+"/Report"));
    }
	
	@BeforeMethod
	public void appLaunch() 
	{
		UtilityClass.launchUrl();
	}
	
	@Test(dataProvider="executableTestID_provider")
	public void hybridTestAutomation(String s1, String s2,String s3,String s4)
	{
	
		UtilityClass.logger=UtilityClass.extent.createTest(s2);
	    //datasheet=System.getProperty("testdatasheet");
		//HybridFrameworkDriver.hybridTestAutomation(s1, s2,s3,datasheet,drvrsheet);
	    testdataresource=UtilityClass.conf.getProperty("Testdata_file_path");   
		HybridFrameworkDriver.hybridTestAutomation(s1, s2,s3,s4,testdataresource,scriptresource);
		UtilityClass.extent.flush();   
		  
     }
	      	
@DataProvider
	public Object[][] executableTestID_provider()
	{
	int n;
    Object[][] obj=null;
	Connection conn;
	Recordset record;
	
	Fillo f=new Fillo();
	try {
		//drvrsheet=System.getProperty("Scriptdriversheet");
		//log.info(drvrsheet);
		//conn=f.getConnection(drvrsheet);
		scriptresource=UtilityClass.conf.getProperty("ScriptDriver_file_path");
		conn=f.getConnection(scriptresource);
		record=conn.executeQuery("select TestCaseID,TestCaseName,ModuleName,SubmoduleName from DriverSheet where ExecutionMode='y'");
	
		n=record.getCount();
		obj=new Object[n][4];
		for(int i=0;i<n;i++)
		{
		record.next();
		obj[i][0]=record.getField("TestCaseID");
		obj[i][1]=record.getField("TestCaseName");
		obj[i][2]=record.getField("ModuleName");
		obj[i][3]=record.getField("SubmoduleName");
		}
		}catch(Exception e)
		{
			
		}
		return obj;
			
	}

@AfterTest
public void closeOpenWindows()
{
	log.info("after test");
	try {
			ZipUtils.zipReportFile();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
}
@AfterMethod
public void closeOpenWindow()
{
	log.info("after method");
	UtilityClass.driver.close();
}

}
