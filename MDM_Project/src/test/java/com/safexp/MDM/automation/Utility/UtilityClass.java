package com.safexp.MDM.automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import com.safexp.MDM.automation.managerClasses.ReadExcelData;

public class UtilityClass {
	
    public static WebDriver driver=null;
	public static Properties OR=null;
	public static Properties conf=null;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static String expectedUserid;
	
	static Logger log=Logger.getLogger(UtilityClass.class.getName());
	public static void Init()
	{
		initOR();
		intitExtentReport();
		initLogReport();		
	}
	
	public static void initLogReport()
	{
		PropertyConfigurator.configure("Log4j/log4j.properties");
		log.info("in beforetest");
	}
	public static void Initeration()
	{
		ReadExcelData.DataMap=ReadExcelData.DataIt.next();
	}
	
	public static void initOR() 
	{
		try 
		{
		FileInputStream file_or=new FileInputStream("OR/OR.properties");
		FileInputStream file_config=new FileInputStream("Config/config.properties");

		OR=new Properties();
		conf=new Properties();
		OR.load(file_or);
		conf.load(file_config);
		}catch (IOException e)
		{
		 logger.fail("Object repository initialisation failed");
	    }
	}
	
	public static void webDriverInit(String dr)
	{
		if(dr.equalsIgnoreCase("CH"))
		{
			try 
			{
			//System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
			driver=new ChromeDriver(chromeOptions);
	    	//driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		    driver.manage().window().maximize();
	        }catch(Exception e)
	        {
		    logger.fail("webdriver initialisation failed");
	        }
		 }
		else if(dr.equalsIgnoreCase("IE"))
		 {
			try
			{
			System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
			//System.setProperty("webdriver.ie.driver","drivers/IEDriverServer");
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    }catch(Exception e)
		    {
			logger.fail("webdriver initialisation failed");
		    }
		}
		else if(dr.equalsIgnoreCase("FF")) 
		{
			try
			{
				
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    }catch(Exception e)
		    {
			logger.fail("webdriver initialisation failed");
		    }
			
		}
		
	}
	
	public static void launchApplication(String url,String browser)
	{  	//String url=conf.getProperty("AppUrl");
		//String browser=conf.getProperty("browser_name");
		
		 webDriverInit(browser);
		driver.get(url);
		
	}
	public static void launchUrl()
	{   String browser=conf.getProperty("browser_name");
		String url=conf.getProperty("ApplUrl");
		webDriverInit(browser);
		//String url=conf.getProperty("AppUrl");
		driver.get(url);
		
	}
	public static void closeApplication()
	{
		driver.close();
	}
	
	public static void clickOnElementByIndexInList(String listxpath,int index)
	{    String xpath=OR.getProperty(listxpath);
		 List<WebElement> wb=UtilityClass.driver.findElements(By.xpath(xpath));
		 wb.get(index-1).click();
	}
	
	
	public static void fn_Input(String s1,String s)
	{
		//System.out.println(s);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement we=getWebElement(s1);
		we.clear();
		we.sendKeys(s);		
		
	}
	public static void fn_InputByAction(String s1,String s)
	{
		//System.out.println(s);
		WebElement we=getWebElement(s1);
		Actions act=new Actions(driver);
		act.moveToElement(we).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
		WebDriverWait wt=new WebDriverWait(driver,50);
		wt.until(ExpectedConditions.textToBePresentInElement(we,""));
		we.clear();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		we.sendKeys(s);
		
	}
	public static void fn_doubleClick(String ORname)
	{
		//System.out.println(s);
		WebElement we=getWebElement(ORname);
		Actions act=new Actions(driver);
		act.moveToElement(we).doubleClick().build().perform();
		
	}
	public static void fn_sendKeysINTByJS(String ORname,String s)
	{
	WebElement we=getWebElement(ORname);
	int a=Integer.parseInt(s);
	JavascriptExecutor js = ((JavascriptExecutor) UtilityClass.driver);
    js.executeScript("arguments[0].setAttribute('value','"+a+"');",we);
	}
	public static void fn_sendKeysByJS(String ORname,String s)
	{
	WebElement we=getWebElement(ORname);
	JavascriptExecutor js = ((JavascriptExecutor) UtilityClass.driver);
    js.executeScript("arguments[0].setAttribute('value','"+s+"');",we);
	}
	public static void fn_metaselect(String metaselectxpath,String metaoptionxpath)
	{
		WebElement we=getWebElement(metaselectxpath);
		we.click();
		WebElement we2=getWebElement(metaoptionxpath);
		we2.click();		
	}
	
	public static String getdataofWebTable(String xpath) 
	{
		WebElement we=getWebElement(xpath);
		return(we.getText());
		
	}
	public static void fn_applyTAB(String ORname) 
	{
		WebElement we=getWebElement(ORname);
		we.sendKeys(Keys.TAB);
		
	}
	public static void fn_applyEnter(String ORname) 
	{
		WebElement we=getWebElement(ORname);
		we.sendKeys(Keys.ENTER);
		
	}
	public static void fn_validateString(String ORname,String expectedtext)
	{
		WebElement we=getWebElement(ORname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual=we.getAttribute("value");
		System.out.println(actual);
		if(actual.equalsIgnoreCase(expectedtext))
		{
			log.info("string matched and as expected");
		}
		else
		{
			log.info("string not matched");
			
		}
	}
	public static void fn_validateText(String ORname,String expectedtext)
	{
		WebElement we=getWebElement(ORname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual=we.getText();
		System.out.println(actual);
		if(actual.equalsIgnoreCase(expectedtext))
		{
			log.info("string matched and as expected");
		}
		else
		{
			log.info("string not matched");
			
		}
	}
	
	public static void fn_SelectByVisibleText(String dropdownxpath,String dropdownlistxpath, String text) 
	{
		try {
		WebElement element=getWebElement(dropdownxpath);
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(2000);
		ac.click().perform();
		Thread.sleep(500);
		List<WebElement> optionslist=UtilityClass.fn_getWebelements(dropdownlistxpath);
		int n=optionslist.size();
		for(int i=0;i<n;i++)
		{
			String s=optionslist.get(i).getText();
			if(s.equals(text))
			{
				WebElement we1=optionslist.get(i);
				ac.moveToElement(we1).perform();
				Thread.sleep(2000);
				ac.click().perform();
				
				break;
				
			}
		}
		}catch(Exception e) {}
	}
	
 public static void fn_SelectByIndex(String xpath,String index) {
		
	}
 public static void fn_SelectByValue(String xpath,String value) {
		
	}
 
	public static String getTitleOfPage()
	{
		return(driver.getTitle());
	}
	public static void fn_Click(String s)
	{WebElement we=getWebElement(s);
		try {//Thread.sleep(500);
			we.click();			
		//System.out.println("button clicked");
	}catch(Exception e) {
		//WebElement we=getWebElement(s);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",we);
		//System.out.println("button clicked");
	}
	}
	public static String fn_getTextfromDisabledElement(WebElement we)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled','')",we);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(we));
		return we.getAttribute("value");
	}
	public static void clearTheContent(String ORname)
	{
		WebElement we=getWebElement(ORname);
		we.clear();
	}
	public static boolean fn_isDisplayed(String ORname)
	{
		boolean status=false;
		WebElement we=getWebElement(ORname);
		if(we!=null) {
		status=true;}
		return status;
	}
	
	public static void fn_setFocusOnElement(String ORname)
	{
		WebElement we=getWebElement(ORname);
		String tagname=we.getTagName();
		System.out.println(tagname);
		if("input".equals(tagname))
			{
			we.sendKeys(" ");
			} 
			else{
			   new Actions(driver).moveToElement(we).perform();

			}
	}
	
	public static WebElement getWebElement(String object)
	{
		WebElement we=null;
		try {
		String xpath=OR.getProperty(object);
		//System.out.println(xpath);
		we=driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e) {
		//	log.info("element not found");
		}
		return we;
		
	}
	
	public static String genRandomNumber()
	{
		int nk;
    	Random rn=new Random();
    	nk=rn.nextInt();
    	if(nk<0)
    	{
    		nk=nk*(-1);
    	}
        String s=Integer.toString(nk);
        return(s.substring(0,3));
 
	}
	
	public static void pressDownArrowKey(String Object)
	{
		WebElement wb=getWebElement(Object);	
		Actions a=new Actions(driver);
		a.moveToElement(wb).sendKeys(Keys.ARROW_DOWN);
		
	}
	public static void pressEnterKey(String Object)
	{
		WebElement wb=getWebElement(Object);
		//Actions a=new Actions(driver);
		wb.sendKeys(Keys.RETURN);
	}
			
	public static String getTextOnElement(String Object)
	{
		WebElement wb=getWebElement(Object);
		String text=wb.getText();
		return text;
	}
	public static void scrollToElementIntoView(String object)
	{
		WebElement element=getWebElement(object);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	public static String getScreenshot(ITestResult result)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		//String path=System.getProperty("user.dir")+"/Report/"+System.currentTimeMillis()+".png";
		String path="./Report/Screenshots/"+System.currentTimeMillis()+".png";
		System.out.println(path);
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		}catch (IOException e) {
		
			System.out.println("Capture Failed "+e.getMessage());
		}
			
		return path;
	}
////	
	public static void deleteFolder(File folder) {
		//log.info("clearing Report directory");
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    //folder.delete();
	}
	
	public static void intitExtentReport() 
	{
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/extentreport.html");
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
	
	}
	public static void closeAllWindow() {
		driver.quit();
	}
	
	public static List<WebElement> fn_getWebelements(String ORname)
	{
		String xpath=OR.getProperty(ORname);
		List<WebElement> welist=driver.findElements(By.xpath(xpath));
		return welist;
	}
	public static List<Integer> fn_searchByElementTextInWebTable(String xpathforrows,int columnindex,String text )
	{ 
		//boolean flag=false;
		//System.out.println("Element is being searched");
		List<Integer> flag=new ArrayList<Integer>();
		int count=0;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath=OR.getProperty(xpathforrows);
		List<WebElement> rows=fn_getWebelements(xpathforrows);
		
		String beforeXpath=xpath+"[";
		String afterXpath="]/td["+columnindex+"]";
		int totalrecords=rows.size();
		//System.out.println(totalrecords);
		String txt=text.toUpperCase().trim();
		for(int i=1;i<=totalrecords;i++)
		{
			String actualXpath=beforeXpath+i+afterXpath;
			WebElement element=driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if(element.getText().equals(txt))
			{
			flag.add(i);
			//System.out.println("Element found");
			//break;
			}
		}
		return flag;
		
	}
	
	public static void fn_clickOnSetOfCheckboxInWebTable(String xpathforrows,List<Integer> rowindexlist,int columnindex)
	{ 
		
		String xpath=OR.getProperty(xpathforrows);
		//List<WebElement> rows=fn_getWebelements(xpath);
		String beforeXpath=xpath+"[";
		String afterXpath="]/td["+columnindex+"]/mat-checkbox";
		int totalrecords=rowindexlist.size();
		for(int i=0;i<totalrecords;i++)
		{    int rowindex=rowindexlist.get(i);
			String actualXpath=beforeXpath+rowindex+afterXpath;
			WebElement we=driver.findElement(By.xpath(actualXpath));
			Actions act=new Actions(driver);
			act.moveToElement(we).click().build().perform();
		}
		
	}
	
	public static void fn_clickOnSetOfDataInWebTable(String xpathforrows,List<Integer> rowindexlist,int columnindex)
	{ 
		
		String xpath=OR.getProperty(xpathforrows);
		//List<WebElement> rows=fn_getWebelements(xpath);
		String beforeXpath=xpath+"[";
		String afterXpath="]/td["+columnindex+"]/span[2]";
		int totalrecords=rowindexlist.size();
		for(int i=0;i<totalrecords;i++)
		{    int rowindex=rowindexlist.get(i);
			String actualXpath=beforeXpath+rowindex+afterXpath;
			WebElement we=driver.findElement(By.xpath(actualXpath));
			Actions act=new Actions(driver);
			act.moveToElement(we).perform();
			we.click();
		}
		
	}
	public static void fn_clickOnSetOfDataInWebTable1(String xpathforrows,List<Integer> rowindexlist,int columnindex)
	{ 
		
		String xpath=OR.getProperty(xpathforrows);
		//List<WebElement> rows=fn_getWebelements(xpath);
		String beforeXpath=xpath+"[";
		String afterXpath="]/td["+columnindex+"]";
		int totalrecords=rowindexlist.size();
		for(int i=0;i<totalrecords;i++)
		{  
			int rowindex=rowindexlist.get(i);
			String actualXpath=null;
			if(rowindex==1) 
			{
				actualXpath=xpath+"/td["+columnindex+"]/a";
			}
			else
			{
				actualXpath=beforeXpath+rowindex+"]/td["+columnindex+"]/a";
			}
				WebElement we=driver.findElement(By.xpath(actualXpath));
				Actions act=new Actions(driver);
				act.moveToElement(we).perform();
				we.click();break;
		}
	}
	public static void fn_clickOnCheckboxInWebTable(String xpathforrows,int rowindex,int columnindex)
	{ 
		
		String xpath=OR.getProperty(xpathforrows);
		String beforeXpath=xpath+"[";
		String afterXpath="]/td["+columnindex+"]/mat-checkbox";		
		String actualXpath=beforeXpath+rowindex+afterXpath;
		WebElement we=driver.findElement(By.xpath(actualXpath));
		Actions act=new Actions(driver);
	
		act.moveToElement(we).click().build().perform();
		
	}
	
	public static void fn_clickByAction(String ORElement)
	{ 
		WebElement we=getWebElement(ORElement);
		Actions act=new Actions(driver);
		act.moveToElement(we).perform();
		act.click().perform();
	}
	
	public static void fn_datepicker(String date,String datepicker_orname,String selectyeardropdown_orname,String selectyear_orname,String selectmonth_orname,String selectday_orname) 
	{
		String[] dt=date.split("-");
		String day=dt[0];
		String month=dt[1].toUpperCase();
		String year=dt[2];
		UtilityClass.fn_Click(datepicker_orname);
		UtilityClass.fn_Click(selectyeardropdown_orname);
		List<WebElement> yearList=UtilityClass.fn_getWebelements(selectyear_orname);
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
		List<WebElement> monthList=UtilityClass.fn_getWebelements(selectmonth_orname);
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
		List<WebElement> dayList=UtilityClass.fn_getWebelements(selectday_orname);
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
	}
