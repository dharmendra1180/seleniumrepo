package com.safexpress.MDM.API_Automation.managerClass;

import java.util.Map;

import org.apache.log4j.Logger;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Verify;
import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForGetRequest;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForPostRequest;
import com.safexpress.MDM.API_Automation.pagelibrary.PageForPutRequest;
import com.safexpress.MDM.API_Automation.testcases.UsermanagementAPITest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIFrameworkDriver {
	
static Logger log1=Logger.getLogger(APIFrameworkDriver.class.getName());
public static boolean flag;
	public static void automateAPITestcase(String testid,String testname,String module,String submodule,String testdatapath,String scriptpath)
		{
			
		
		flag=true;
			try {
				
		// create connection with data source
			Fillo f=new Fillo();
			Connection con=f.getConnection(scriptpath);		
		// select all the steps for current testcaseid	
			Recordset rs1=con.executeQuery("select * from "+module+" where TC='"+testid+"' and SubModule='"+submodule+"'");
		// execute the current testcase for each set of data
			rs1.next();
		if(module.equalsIgnoreCase("Usermanagement")) {						
				do
		    	{
			    
				String requesturl=rs1.getField("RequestURL");
				String basepath=rs1.getField("basePath");
				String httpMethod=rs1.getField("HTTPMethod");
				String testId=rs1.getField("TC");
				String testcasename=rs1.getField("TestcaseName");
				
				if(httpMethod.equalsIgnoreCase("GET")) 
			    {  
				log1.info("....processing GET Request....");
				//System.out.println("inside GET");
				PageForGetRequest pgetobj=new PageForGetRequest();
				Map<String,Object> header=pgetobj.getHeader();
				
				ReadExcelData readexcel=new ReadExcelData();
				readexcel.readDataFor_GET(module,submodule,testId);
				//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
			    Map<String,String> datamap=ReadExcelData.DataIt.next();
			    
			    String get_identifier=datamap.get("Get_identifier");
				
				if(get_identifier.equalsIgnoreCase("userId")) {
			    
			    String userId=datamap.get("userId").toString().trim();
			    if((userId!=null)&&(userId.equalsIgnoreCase("")==false))
				{response=pgetobj.getResponseOfaUser(requesturl, basepath, header,userId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
				
				else if(get_identifier.equalsIgnoreCase("uid")) {
				    
				    String uid=datamap.get("uid").toString().trim();
				    if((uid!=null)&&(uid.equalsIgnoreCase("")==false))
					{response=pgetobj.getResponseOfaUser(requesturl, basepath, header,uid);}
				    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
					//pgetobj.getDetailsOf(response);
					pgetobj.verifyGetSuccess(response);
					
					}
				else if(get_identifier.equalsIgnoreCase("uid_AD")) {
				    
				    String uid=datamap.get("uid").toString().trim();
				    if((uid!=null)&&(uid.equalsIgnoreCase("")==false))
					{response=pgetobj.getResponseOfaUserInAD(requesturl, basepath, header,uid);}
				    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
					//pgetobj.getDetailsOf(response);
					pgetobj.verifyGetSuccess(response);
					
					}
				else if(get_identifier.equalsIgnoreCase("uid_privilegeBranchIds")) {
				    
				    String uid=datamap.get("uid").toString().trim();
				    if((uid!=null)&&(uid.equalsIgnoreCase("")==false))
					{response=pgetobj.getResponseOfaUserInAD(requesturl, basepath, header,uid);}
				    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
					//pgetobj.getDetailsOf(response);
					pgetobj.verifyGetSuccess(response);
					
					}
				else if(get_identifier.equalsIgnoreCase("uid_roles")) {
				    
				    String uid=datamap.get("uid").toString().trim();
				    if((uid!=null)&&(uid.equalsIgnoreCase("")==false))
					{response=pgetobj.getResponseOfListOfRolesMappedForUser(requesturl, basepath, header,uid);}
				    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
					//pgetobj.getDetailsOf(response);
					pgetobj.verifyGetSuccess(response);
					
					}
				else if(get_identifier.equalsIgnoreCase("number")) {
				    
				    String number=datamap.get("number").toString().trim();
				    if((number!=null)&&(number.equalsIgnoreCase("")==false))
					{response=pgetobj.getResponseOfaUser(requesturl, basepath, header,number);}
				    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
					//pgetobj.getDetailsOf(response);
					pgetobj.verifyGetSuccess(response);
					
					}
				else if(get_identifier.equalsIgnoreCase("userName")) {
				    
				    String userName=datamap.get("userName").toString().trim();
				    if((userName!=null)&&(userName.equalsIgnoreCase("")==false))
					{response=pgetobj.getResponseOfaUser(requesturl, basepath, header,userName);}
				    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
					//pgetobj.getDetailsOf(response);
					pgetobj.verifyGetSuccess(response);
					
					}
				}
				
				
				log1.info("....GET Request Processed....");		
			    }
				else if(httpMethod.equalsIgnoreCase("POST"))
				{
					log1.info("....processing POST Request....");
					//System.out.println("inside POST");
					PageForPostRequest postobj=new PageForPostRequest();
					Map<String,Object> header=postobj.getHeader();
					ReadExcelData readexcel=new ReadExcelData();
					//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
					readexcel.readDataFor_POST(module,submodule,testId);
					Response response=null;
					while(ReadExcelData.DataIt.hasNext()) {
						Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
						String json=postobj.getJSONString(jsonparamvalue);
						log1.info("JSON is:"+json);
						//System.out.println("JSON is:"+json);
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
			    					}
			     log1.info(".............POST Request Processed..................");
				}
				else if(httpMethod.equalsIgnoreCase("PUT"))
				{
					log1.info(".............Processing PUT Request..................");
					//System.out.println("inside put");
					PageForPutRequest putobj=new PageForPutRequest();
					Map<String,Object> header=putobj.getHeader();
					ReadExcelData readexcel=new ReadExcelData();
					readexcel.readExcelData_PUT(module,submodule,testId);
					//readexcel.readDataFor_PUT(module,submodule,testId,testdatapath);
					Response response=null;
					while(ReadExcelData.DataIt.hasNext()) {
					Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
					
					String put_identifier=jsonparamvalue.get("Put_identifier");	
					
					if(put_identifier.equalsIgnoreCase("updateUser")) {
					
					String json=putobj.getJSONString(jsonparamvalue);
					log1.info("JSON is:"+json);
					//System.out.println("JSON is:"+json);
					response=putobj.putRequest(requesturl, basepath, header, json);
					//Map<String,Object> responsemap=putobj.getResponse(response);
					putobj.verifyPutSuccess(response);
					}
					else if(put_identifier.equalsIgnoreCase("update_privilegeBranchIds")) {
						
						String uid=jsonparamvalue.get("uid");
						String idKey=jsonparamvalue.get("idKey");						
						String json=putobj.updateListOfPrivilegeBranchIds(jsonparamvalue);
						log1.info("JSON is:"+json);
						//System.out.println("JSON is:"+json);
						response=putobj.putRequestForPrivilegeBranchIds(requesturl, basepath, uid, idKey, header, json);
						//Map<String,Object> responsemap=putobj.getResponse(response);
						putobj.verifyPutSuccess(response);
						}
					
					
					else if(put_identifier.equalsIgnoreCase("update_roles")) {
						
						String uid=jsonparamvalue.get("uid");
						String idKey=jsonparamvalue.get("idKey");						
						String json=putobj.updateListOfRolesMappedForUser(jsonparamvalue);
						log1.info("JSON is:"+json);
						//System.out.println("JSON is:"+json);
						response=putobj.putRequestForRoles(requesturl, basepath, uid, idKey, header, json);
						//Map<String,Object> responsemap=putobj.getResponse(response);
						putobj.verifyPutSuccess(response);
						}
					}
					
					log1.info(".............PUT Request Processed..................");
				}				
					
			}while(rs1.next());//while
				rs1.moveFirst();
				//Thread.sleep(3000);	
				if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
				}
		}
		
		else if(module.equalsIgnoreCase("Rolemanagement")) {						
			do
	    	{
		    
			String requesturl=rs1.getField("RequestURL");
			String basepath=rs1.getField("basePath");
			String httpMethod=rs1.getField("HTTPMethod");
			String testId=rs1.getField("TC");
			String testcasename=rs1.getField("TestcaseName");
			
			if(httpMethod.equalsIgnoreCase("GET")) 
		    {  
			log1.info("....processing GET Request....");
			//System.out.println("inside GET");
			PageForGetRequest pgetobj=new PageForGetRequest();
			Map<String,Object> header=pgetobj.getHeader();
			
			ReadExcelData readexcel=new ReadExcelData();
			readexcel.readDataFor_GET(module,submodule,testId);
			//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
			Response response=null;
			while(ReadExcelData.DataIt.hasNext()) {
		    Map<String,String> datamap=ReadExcelData.DataIt.next();
		    
		    String get_identifier=datamap.get("Get_identifier");
			
			if(get_identifier.equalsIgnoreCase("roleId")) {
				String roleId=datamap.get("roleId").toString().trim();
			    if((roleId!=null)&&(roleId.equalsIgnoreCase("")==false))
				{response=pgetobj.getResponseOfRole(requesturl, basepath, header,roleId);}
			    else {response=pgetobj.getResponse_AllRole(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
			
			if(get_identifier.equalsIgnoreCase("number")) {
				String number=datamap.get("number").toString().trim();
			    if((number!=null)&&(number.equalsIgnoreCase("")==false))
				{response=pgetobj.getResponseOfRole(requesturl, basepath, header,number);}
			    else {response=pgetobj.getResponse_AllRole(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
			
			if(get_identifier.equalsIgnoreCase("roleName")) {
				String roleName=datamap.get("roleName").toString().trim();
			    if((roleName!=null)&&(roleName.equalsIgnoreCase("")==false))
				{response=pgetobj.getResponseOfRole(requesturl, basepath, header,roleName);}
			    else {response=pgetobj.getResponse_AllRole(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
		    }
			log1.info("....GET Request Processed....");		
		    }
			else if(httpMethod.equalsIgnoreCase("POST"))
			{
				
				log1.info("....processing POST Request....");
				//System.out.println("inside POST");
				PageForPostRequest postobj=new PageForPostRequest();
				Map<String,Object> header=postobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
				readexcel.readDataFor_POST(module,submodule,testId);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
					Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
					
					String post_identifier=jsonparamvalue.get("Post_identifier");
					
					if(post_identifier.equalsIgnoreCase("role_permission")) {
						String json=postobj.getAllRoleDetails(jsonparamvalue);
						log1.info("JSON is:"+json);
						
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
					}
					
					else if(post_identifier.equalsIgnoreCase("roleList_permission")) {
						String json=postobj.getAllRoleListPermissionDetails(jsonparamvalue);
						log1.info("JSON is:"+json);
						
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
					}
					
					else if(post_identifier.equalsIgnoreCase("create_role")) {
						String json=postobj.createRole(jsonparamvalue);
						log1.info("JSON is:"+json);
						
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
					}
					
		    					}
		     log1.info(".............POST Request Processed..................");
			}
			else if(httpMethod.equalsIgnoreCase("PUT"))
			{
				log1.info(".............Processing PUT Request..................");
				//System.out.println("inside put");
				PageForPutRequest putobj=new PageForPutRequest();
				Map<String,Object> header=putobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				readexcel.readExcelData_PUT(module,submodule,testId);
				//readexcel.readDataFor_PUT(module,submodule,testId,testdatapath);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
				Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
				String json=putobj.updateRolePermissionDetails(jsonparamvalue);
				log1.info("JSON is:"+json);
				//System.out.println("JSON is:"+json);
				response=putobj.putRequest(requesturl, basepath, header, json);
				//Map<String,Object> responsemap=putobj.getResponse(response);
				putobj.verifyPutSuccess(response);
				}
				
				log1.info(".............PUT Request Processed..................");
			}				
				
		}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);	
			if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
			}
	}
		
		
		else if(module.equalsIgnoreCase("Objectmanagement")) {						
			do
	    	{
		    
			String requesturl=rs1.getField("RequestURL");
			String basepath=rs1.getField("basePath");
			String httpMethod=rs1.getField("HTTPMethod");
			String testId=rs1.getField("TC");
			String testcasename=rs1.getField("TestcaseName");
			
			if(httpMethod.equalsIgnoreCase("GET")) 
		    {  
			log1.info("....processing GET Request....");
			//System.out.println("inside GET");
			PageForGetRequest pgetobj=new PageForGetRequest();
			Map<String,Object> header=pgetobj.getHeader();
			
			ReadExcelData readexcel=new ReadExcelData();
			readexcel.readDataFor_GET(module,submodule,testId);
			//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
			Response response=null;
			while(ReadExcelData.DataIt.hasNext()) {
		    Map<String,String> datamap=ReadExcelData.DataIt.next();
		    
		    String get_identifier=datamap.get("Get_identifier");
		    
		    if(get_identifier.equalsIgnoreCase("objectId")) {
				String objectId=datamap.get("objectId").toString().trim();
			    if((objectId!=null)&&(objectId.equalsIgnoreCase("")==false))
			    {response=pgetobj.getResponseOfObject(requesturl, basepath, header,objectId);}
			    else {response=pgetobj.getResponse_AllObject(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
		    
		    else if(get_identifier.equalsIgnoreCase("number")) {
				String number=datamap.get("number").toString().trim();
			    if((number!=null)&&(number.equalsIgnoreCase("")==false))
			    {response=pgetobj.getResponseOfObject(requesturl, basepath, header,number);}
			    else {response=pgetobj.getResponse_AllObject(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
		    
		    else if(get_identifier.equalsIgnoreCase("objectName")) {
				String objectName=datamap.get("objectName").toString().trim();
			    if((objectName!=null)&&(objectName.equalsIgnoreCase("")==false))
			    {response=pgetobj.getResponseOfObject(requesturl, basepath, header,objectName);}
			    else {response=pgetobj.getResponse_AllObject(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
		    
		    else if(get_identifier.equalsIgnoreCase("menuId")) {
				String menuId=datamap.get("menuId").toString().trim();
			    if((menuId!=null)&&(menuId.equalsIgnoreCase("")==false))
			    {response=pgetobj.getResponseOfObject(requesturl, basepath, header,menuId);}
			    else {response=pgetobj.getResponse_AllObject(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);	
			}
		    
			}
		    	
		    	log1.info("....GET Request Processed....");		 
		    
			
		    }  
				    
		    
			else if(httpMethod.equalsIgnoreCase("POST"))
			{
				log1.info("....processing POST Request....");
				//System.out.println("inside POST");
				PageForPostRequest postobj=new PageForPostRequest();
				Map<String,Object> header=postobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
				readexcel.readDataFor_POST(module,submodule,testId);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
					Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
					String json=postobj.createAllObjectDetails(jsonparamvalue);
					log1.info("JSON is:"+json);
					//System.out.println("JSON is:"+json);
					response=postobj.postRequest(requesturl, basepath, header, json);
					//Map<String,Object> responsemap=postobj.getResponse(response);
				    postobj.verifyPostSuccess(response);
		    					}
		     log1.info(".............POST Request Processed..................");
			}
			else if(httpMethod.equalsIgnoreCase("PUT"))
			{
				log1.info(".............Processing PUT Request..................");
				//System.out.println("inside put");
				PageForPutRequest putobj=new PageForPutRequest();
				Map<String,Object> header=putobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				readexcel.readExcelData_PUT(module,submodule,testId);
				//readexcel.readDataFor_PUT(module,submodule,testId,testdatapath);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
				Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
				String json=putobj.updateRolePermissionDetails(jsonparamvalue);
				log1.info("JSON is:"+json);
				//System.out.println("JSON is:"+json);
				response=putobj.putRequest(requesturl, basepath, header, json);
				//Map<String,Object> responsemap=putobj.getResponse(response);
				putobj.verifyPutSuccess(response);
				}
				
				log1.info(".............PUT Request Processed..................");
			}				
				
		}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);	
			if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
			}
	}
	//Testcase finished	
		////////////////////////////////////usermanagement BFF////////////////////
	else if(module.equalsIgnoreCase("Usermanagement_BFF")) 
		{
			if(submodule.equals("Authentication_Authorization"))
			{
				do
				{
		    
					String requesturl=rs1.getField("RequestURL");
					String basepath=rs1.getField("basePath");
					String httpMethod=rs1.getField("HTTPMethod");
					String testId=rs1.getField("TC");
					String testcasename=rs1.getField("TestcaseName");
			
					if(httpMethod.equalsIgnoreCase("GET")) 
					{  
						log1.info("....processing GET Request....");
						//System.out.println("inside GET");
						PageForGetRequest pgetobj=new PageForGetRequest();
						Map<String,Object> header=pgetobj.getHeader_BFF();
			
						ReadExcelData readexcel=new ReadExcelData();
						readexcel.readDataFor_GET(module,submodule,testId);
						//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
						Response response=null;
						while(ReadExcelData.DataIt.hasNext())
						{
							Map<String,String> datamap=ReadExcelData.DataIt.next();
		    				String get_identifier=datamap.get("Get_identifier");
		    				if(get_identifier.equalsIgnoreCase("Authentication_menu"))
		    				{
		    					response=pgetobj.getMenuDetails(requesturl, basepath, header);
		    					pgetobj.verifyGetSuccess(response);
							}
		    				else if(get_identifier.equalsIgnoreCase("Authentication_permission")) 
		    				{
			    				response=pgetobj.getUserPermissionsDetails(requesturl, basepath, header);
		    					pgetobj.verifyGetSuccess(response);
							}
						}
				
						log1.info("....GET Request Processed....");		
					}
					else if(httpMethod.equalsIgnoreCase("POST"))
					{	
						log1.info("....processing POST Request....");
						//System.out.println("inside POST");
						PageForPostRequest postobj=new PageForPostRequest();
						Map<String,Object> header=postobj.getHeader_BFF();
						ReadExcelData readexcel=new ReadExcelData();
						//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
						readexcel.readDataFor_POST(module,submodule,testId);
						Response response=null;
						while(ReadExcelData.DataIt.hasNext()) 
						{
							Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
							String post_identifier=jsonparamvalue.get("Post_identifier");
							if(post_identifier.equalsIgnoreCase("AccessToken")) 	
							{
								UtilityClassForAPI.userId_BFF=jsonparamvalue.get("username");
								String json=postobj.getJsonforTokenAccess(jsonparamvalue);
								log1.info("JSON is:"+json);
								response=postobj.postRequestToGetAccessTokenInCookie(requesturl, basepath, header,json);
								postobj.verifyPostSuccess(response);
								//JsonPath extract=response.get.jsonPath();
								String token =response.getHeader("authorization");
								System.out.println("Access token : " + token);
								UtilityClassForAPI.accessTokenBFF=token;
										
							}
				
							else if(post_identifier.equalsIgnoreCase("logout"))
							{
								response=postobj.postRequestForLogout(requesturl, basepath, header);
								postobj.verifyPostSuccess(response);
							}
						}		
						log1.info(".............POST Request Processed..................");
					}
					else if(httpMethod.equalsIgnoreCase("PUT"))
					{
						
					}				
				
				}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);	
			if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
			}
	}
		
		//////////////////////////object operation service//////////////////
	else if(submodule.equals("Object_Operation_Service"))
	{

		do
    	{
	    
		String requesturl=rs1.getField("RequestURL");
		String basepath=rs1.getField("basePath");
		String httpMethod=rs1.getField("HTTPMethod");
		String testId=rs1.getField("TC");
		String testcasename=rs1.getField("TestcaseName");
		
		if(httpMethod.equalsIgnoreCase("GET")) 
	    {  
		log1.info("....processing GET Request....");
		//System.out.println("inside GET");
		PageForGetRequest pgetobj=new PageForGetRequest();
		Map<String,Object> header=pgetobj.getHeader_BFF();
		
		ReadExcelData readexcel=new ReadExcelData();
		readexcel.readDataFor_GET(module,submodule,testId);
		//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
		Response response=null;
		while(ReadExcelData.DataIt.hasNext()) {
	    Map<String,String> datamap=ReadExcelData.DataIt.next();
	    
	    String get_identifier=datamap.get("Get_identifier");
		
		if(get_identifier.equalsIgnoreCase("AllObject")) {
	    
			 response=pgetobj.getObjectListDetails(requesturl, basepath, header);
				pgetobj.verifyGetSuccess(response);
				
		}

		
		else if(get_identifier.equalsIgnoreCase("N_LastUpdatedObject")) {
		    
		
		    String number=datamap.get("RequiredNumberOfObjects").toString().trim();
		    response=pgetobj.GetLast_n_UpdatedObjectDetails(requesturl, basepath,number, header);
			pgetobj.verifyGetSuccess(response);
			
			}
		else if(get_identifier.equalsIgnoreCase("SpecifiedObject")) {
		    
		    String obname=datamap.get("objectName").toString().trim();
		    response=pgetobj.getAllObjectsNamesMatchingWildSearchCharacters(requesturl, basepath,obname, header);
			pgetobj.verifyGetSuccess(response);
			
			}
		}
			
		log1.info("....GET Request Processed....");		
	    }
		else if(httpMethod.equalsIgnoreCase("POST"))
		{
			log1.info(".............POST Request Processed..................");
		}
		else if(httpMethod.equalsIgnoreCase("PUT"))
		{
						
			
			log1.info(".............PUT Request Processed..................");
		}				
			
	}while(rs1.next());//while
		rs1.moveFirst();
		//Thread.sleep(3000);	
		if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
		}
}

		////////////////////////////branch controller//////////////////////
 else if(submodule.equals("branch_controller"))
	{
			do
	    	{
		    
			String requesturl=rs1.getField("RequestURL");
			String basepath=rs1.getField("basePath");
			String httpMethod=rs1.getField("HTTPMethod");
			String testId=rs1.getField("TC");
			String testcasename=rs1.getField("TestcaseName");
			
			if(httpMethod.equalsIgnoreCase("GET")) 
		    {  
			log1.info("....processing GET Request....");
			//System.out.println("inside GET");
			PageForGetRequest pgetobj=new PageForGetRequest();
			Map<String,Object> header=pgetobj.getHeader_BFF();
			
			ReadExcelData readexcel=new ReadExcelData();
			readexcel.readDataFor_GET(module,submodule,testId);
			//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
			Response response=null;
			while(ReadExcelData.DataIt.hasNext()) {
		    Map<String,String> datamap=ReadExcelData.DataIt.next();
		    
		    String get_identifier=datamap.get("Get_identifier");
			
			if(get_identifier.equalsIgnoreCase("AllBranch"))
			{
				response=pgetobj.getBranchListDetailsSortedByBranchName(requesturl, basepath, header);
				pgetobj.verifyGetSuccess(response);
			
			}

			else if(get_identifier.equalsIgnoreCase("lastNCreatedBranches"))
			{
			    
			    String number=datamap.get("RequiredNumberOfBranches").toString().trim();
			    response=pgetobj.getListOfLatest_N_CreatedBranchesBasedOnInputNumber(requesturl, basepath,number, header);
				pgetobj.verifyGetSuccess(response);

			}
			else if(get_identifier.equalsIgnoreCase("searchCriteria_Value")) {
			    
				String searchcriteria=datamap.get("searchCriteria").toString().trim();
				String criteriaval=datamap.get("criteriaValue").toString().trim();
			    response=pgetobj.getBranchDetailsBySearchCriteria(requesturl, basepath,searchcriteria,criteriaval, header);
				pgetobj.verifyGetSuccess(response);

				}
			else if(get_identifier.equalsIgnoreCase("branchcode")) {
			    
				String brcode=datamap.get("branchCode").toString().trim();
				
			    response=pgetobj.getBranchDetailsByBranchCode(requesturl, basepath,brcode, header);
				pgetobj.verifyGetSuccess(response);

				}
			else if(get_identifier.equalsIgnoreCase("branchName")) {
				
				String brname=datamap.get("branchName").toString().trim();
				response=pgetobj.geListOfBranchesWithWildSearch(requesturl, basepath,brname, header);
				pgetobj.verifyGetSuccess(response);


			    
				}
			else if(get_identifier.equalsIgnoreCase("pincodeSearchCharacters")) {
			    
				String pincode=datamap.get("pincodeSearchCharacters").toString().trim();
				response=pgetobj.getListOfPinCodesMatchingSearchCharacters(requesturl, basepath,pincode, header);
				pgetobj.verifyGetSuccess(response);

				}
			else if(get_identifier.equalsIgnoreCase("types")) {
				
				response=pgetobj.getListOfAllTypesOfBranches(requesturl, basepath, header);
				pgetobj.verifyGetSuccess(response);

			    }
			}
				
			log1.info("....GET Request Processed....");		
		    }
			else if(httpMethod.equalsIgnoreCase("POST"))
			{
			/*	log1.info("....processing POST Request....");
				//System.out.println("inside POST");
				PageForPostRequest postobj=new PageForPostRequest();
				Map<String,Object> header=postobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
				readexcel.readDataFor_POST(module,submodule,testId);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
					Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
					String json=postobj.getJSONString(jsonparamvalue);
					log1.info("JSON is:"+json);
					System.out.println("JSON is:"+json);
					response=postobj.postRequest(requesturl, basepath, header, json);
					//Map<String,Object> responsemap=postobj.getResponse(response);
				    postobj.verifyPostSuccess(response);
		    					}
		     log1.info(".............POST Request Processed..................");*/
			}
			else if(httpMethod.equalsIgnoreCase("PUT"))
			{
				
				
				log1.info(".............PUT Request Processed..................");
			}				
				
		}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);	
			if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
			}
	}
//////////////////////////role controller/////////////////////////
 else if(submodule.equals("role_controller"))
	{
	do
	{
    
	String requesturl=rs1.getField("RequestURL");
	String basepath=rs1.getField("basePath");
	String httpMethod=rs1.getField("HTTPMethod");
	String testId=rs1.getField("TC");
	String testcasename=rs1.getField("TestcaseName");
	
	if(httpMethod.equalsIgnoreCase("GET")) 
    {  
	log1.info("....processing GET Request....");
	//System.out.println("inside GET");
	PageForGetRequest pgetobj=new PageForGetRequest();
	Map<String,Object> header=pgetobj.getHeader_BFF();
	
	ReadExcelData readexcel=new ReadExcelData();
	readexcel.readDataFor_GET(module,submodule,testId);
	//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
	Response response=null;
	while(ReadExcelData.DataIt.hasNext()) {
    Map<String,String> datamap=ReadExcelData.DataIt.next();
    
    String get_identifier=datamap.get("Get_identifier");
	
	if(get_identifier.equalsIgnoreCase("permissionOnRoleId")) {
		
		String roleid=datamap.get("roleId").toString().trim();
	    response=pgetobj.getPermissionsOf_a_Role(requesturl, basepath,roleid,header);
		pgetobj.verifyGetSuccess(response);
    
	}

	else if(get_identifier.equalsIgnoreCase("N_LastUpdatedRole")) {
	    
		String number=datamap.get("RequiredNumberOfRoles").toString().trim();
	    response=pgetobj.getLast_n_updatedRoleDetails(requesturl, basepath,number,header);
		pgetobj.verifyGetSuccess(response);

		}
	else if(get_identifier.equalsIgnoreCase("lookupType")) {
	    
	    String lookuptype=datamap.get("lookupType").toString().trim();
	    response=pgetobj.getLookupValuesFor_a_LookupType(requesturl, basepath,lookuptype,header);
		pgetobj.verifyGetSuccess(response);
		}
	else if(get_identifier.equalsIgnoreCase("Allpermissions")) {
	    
		response=pgetobj.getAllPermissions(requesturl, basepath,header);
		pgetobj.verifyGetSuccess(response);
		
		}
	else if(get_identifier.equalsIgnoreCase("RoleName")) {
	    
	    String rolename=datamap.get("roleName").toString().trim();
	    
	    response=pgetobj.getAllRolesBasedOnWildSearchOfRoleName(requesturl, basepath,rolename, header);
		pgetobj.verifyGetSuccess(response);
		
		}
	else if(get_identifier.equalsIgnoreCase("Allroles")) 
	{
	    
	   
	    response=pgetobj.getAllRoles(requesturl, basepath, header);
	    //pgetobj.getDetailsOf(response);
		pgetobj.verifyGetSuccess(response);
		
		}
		
	log1.info("....GET Request Processed....");		
    }
   }
	else if(httpMethod.equalsIgnoreCase("POST"))
	{
		log1.info("....processing POST Request....");
		//System.out.println("inside POST");
		PageForPostRequest postobj=new PageForPostRequest();
		Map<String,Object> header=postobj.getHeader_BFF();
		ReadExcelData readexcel=new ReadExcelData();
		//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
		readexcel.readDataFor_POST(module,submodule,testId);
		Response response=null;
		while(ReadExcelData.DataIt.hasNext()) {
			Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
			String post_identifier=jsonparamvalue.get("Post_identifier");	
			
			if(post_identifier.equalsIgnoreCase("createRole")) {
			String json=postobj.getJsonforCreateRole(jsonparamvalue);
			log1.info("JSON is:"+json);
			//System.out.println("JSON is:"+json);
			response=postobj.CreatesRolewith_or_withoutPermissions_or_addPermissionToExistingRolewith_or_withoutAttributeExclusion(requesturl, basepath, header, json);
			//Map<String,Object> responsemap=postobj.getResponse(response);
		    postobj.verifyPostSuccess(response);
    					}
     log1.info(".............POST Request Processed..................");
	}
	}
	else if(httpMethod.equalsIgnoreCase("PUT"))
	{
		log1.info(".............Processing PUT Request..................");
		//System.out.println("inside put");
		PageForPutRequest putobj=new PageForPutRequest();
		Map<String,Object> header=putobj.getHeader();
		ReadExcelData readexcel=new ReadExcelData();
		readexcel.readExcelData_PUT(module,submodule,testId);
		//readexcel.readDataFor_PUT(module,submodule,testId,testdatapath);
		Response response=null;
		while(ReadExcelData.DataIt.hasNext()) {
		Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
		
		String put_identifier=jsonparamvalue.get("Put_identifier");	
		
		if(put_identifier.equalsIgnoreCase("updateRole")) {
		
		String json=putobj.getJsonToUpdateRole(jsonparamvalue);
		log1.info("JSON is:"+json);
		//System.out.println("JSON is:"+json);
		response=putobj.updatesRoleWithPermissions(requesturl, basepath, header, json);
		//Map<String,Object> responsemap=putobj.getResponse(response);
		putobj.verifyPutSuccess(response);
		}
	}
		
		log1.info(".............PUT Request Processed..................");
	}				
		
}while(rs1.next());//while
	rs1.moveFirst();
	//Thread.sleep(3000);	
	if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
	}
}

		////////////////////////////user controller////////////////////////
else if(submodule.equals("user_controller"))
{
do
{

String requesturl=rs1.getField("RequestURL");
String basepath=rs1.getField("basePath");
String httpMethod=rs1.getField("HTTPMethod");
String testId=rs1.getField("TC");
String testcasename=rs1.getField("TestcaseName");

if(httpMethod.equalsIgnoreCase("GET")) 
{  
log1.info("....processing GET Request....");
//System.out.println("inside GET");
PageForGetRequest pgetobj=new PageForGetRequest();
Map<String,Object> header=pgetobj.getHeader_BFF();

ReadExcelData readexcel=new ReadExcelData();
readexcel.readDataFor_GET(module,submodule,testId);
//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
Response response=null;
while(ReadExcelData.DataIt.hasNext()) {
Map<String,String> datamap=ReadExcelData.DataIt.next();

String get_identifier=datamap.get("Get_identifier");
if(get_identifier.equalsIgnoreCase("Allusers"))
{
	response=pgetobj.getDetailsOfAllUsers(requesturl,basepath,header);
	pgetobj.verifyGetSuccess(response);
}
else if(get_identifier.equalsIgnoreCase("UserByUidDefaultBranch")) 
{
	String uid=datamap.get("uid_defaultBranch").toString().trim();
	response=pgetobj.getDetailsOfUserWith_id_OfItsDefaultBranch(requesturl,basepath,uid,header);
	pgetobj.verifyGetSuccess(response);
}

else if(get_identifier.equalsIgnoreCase("uIdInAD"))
{
	String uid=datamap.get("uid_AD").toString().trim();
	response=pgetobj.getUserIn_AD(requesturl,basepath,uid,header);
	pgetobj.verifyGetSuccess(response);
    
}
else if(get_identifier.equalsIgnoreCase("privilegeBranchOfUid"))
{
    
    String uid=datamap.get("uid_privilageBranch").toString().trim();
    response=pgetobj.getListOfPrevilegeBranch_Ids_MappedForUser(requesturl, basepath,uid,header);
    pgetobj.verifyGetSuccess(response);
	
}
else if(get_identifier.equalsIgnoreCase("rolesOfUid"))
{
	String uid=datamap.get("uid_roles").toString().trim();
    response=pgetobj.getListOfRolesMappedForUser(requesturl, basepath,uid,header);
    pgetobj.verifyGetSuccess(response);
	
}
else if(get_identifier.equalsIgnoreCase("N_LastUpdatedUser")) 
{
	String number=datamap.get("RequiredNumberOfUsers").toString().trim();
    response=pgetobj.getLast_n_UpdatedUserDetails(requesturl, basepath,number,header);
    pgetobj.verifyGetSuccess(response);  
	
}
else if(get_identifier.equalsIgnoreCase("usersByuserName"))
{
	String uname=datamap.get("uName").toString().trim();
    response=pgetobj.getDetailsOfAllUsersOnWildSearchOfName(requesturl, basepath,uname,header);
    pgetobj.verifyGetSuccess(response);   
    	
}
else if(get_identifier.equalsIgnoreCase("userByuId")) 
{
	String uid=datamap.get("uid").toString().trim();
    response=pgetobj.getDetailsOfAllUsersOnWildSearchOfUserId(requesturl, basepath,uid,header);
    pgetobj.verifyGetSuccess(response);       
   
}
}
	
log1.info("....GET Request Processed....");		
}
else if(httpMethod.equalsIgnoreCase("POST"))
{
	log1.info("....processing POST Request....");
	//System.out.println("inside POST");
	PageForPostRequest postobj=new PageForPostRequest();
	Map<String,Object> header=postobj.getHeader();
	ReadExcelData readexcel=new ReadExcelData();
	//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
	readexcel.readDataFor_POST(module,submodule,testId);
	Response response=null;
	while(ReadExcelData.DataIt.hasNext()) {
		Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
		
		String post_identifier=jsonparamvalue.get("Post_identifier");	
		
		if(post_identifier.equalsIgnoreCase("createUser")) 
		{		
		String json=postobj.getJsonforusercreation(jsonparamvalue);
		log1.info("JSON is:"+json);
		System.out.println("JSON is:"+json);
		response=postobj.CreatesUserWithDefaultbranch_multiplePrivilegeBranches_multipleroles(requesturl, basepath, header, json);
		//Map<String,Object> responsemap=postobj.getResponse(response);
	    postobj.verifyPostSuccess(response);
		}
		
	}
 log1.info(".............POST Request Processed..................");
}
else if(httpMethod.equalsIgnoreCase("PUT"))
{
	log1.info(".............Processing PUT Request..................");
	//System.out.println("inside put");
	PageForPutRequest putobj=new PageForPutRequest();
	Map<String,Object> header=putobj.getHeader_BFF();
	ReadExcelData readexcel=new ReadExcelData();
	readexcel.readExcelData_PUT(module,submodule,testId);
	//readexcel.readDataFor_PUT(module,submodule,testId,testdatapath);
	Response response=null;
	while(ReadExcelData.DataIt.hasNext()) {
	Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
	
	String put_identifier=jsonparamvalue.get("Put_identifier");	
	
	if(put_identifier.equalsIgnoreCase("updateUser")) {
	
	String json=putobj.getJsonToUpdatdeUser(jsonparamvalue);
	log1.info("JSON is:"+json);
	//System.out.println("JSON is:"+json);
	response=putobj.updatesUser_and_or_itsDefaultBranchCode(requesturl, basepath, header, json);
	//Map<String,Object> responsemap=putobj.getResponse(response);
	putobj.verifyPutSuccess(response);
	}
	else if(put_identifier.equalsIgnoreCase("update_privilegeBranch")) 
	{
		
		//String uid=jsonparamvalue.get("uid");
		//String idKey=jsonparamvalue.get("idKey");						
		String json=putobj.getJsonToUpdateUser_privilageBranch(jsonparamvalue);
		log1.info("JSON is:"+json);
		//System.out.println("JSON is:"+json);
		response=putobj.UpdateListOfPrivilegeBranch_ids_mappedforUser(requesturl, basepath, header, json);
		//Map<String,Object> responsemap=putobj.getResponse(response);
		putobj.verifyPutSuccess(response);
	}
	
	else if(put_identifier.equalsIgnoreCase("update_roles")) {
		
		String uid=jsonparamvalue.get("uid");
		String idKey=jsonparamvalue.get("idKey");						
		String json=putobj.getJsonToUpdateUser_role(jsonparamvalue);
		log1.info("JSON is:"+json);
		//System.out.println("JSON is:"+json);
		response=putobj.UpdatesListOfRolesMappedForUser(requesturl, basepath, uid, idKey, header, json);
		//Map<String,Object> responsemap=putobj.getResponse(response);
		putobj.verifyPutSuccess(response);
		}
	}
	
	

	
	log1.info(".............PUT Request Processed..................");
}				
	
}while(rs1.next());//while
rs1.moveFirst();
//Thread.sleep(3000);	
if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
}
}
			}
///////////////Credit Contract Core////////////////////////
		
	else if(module.equalsIgnoreCase("Credit_Contract")) {						
			do
	    	{
		    
			String requesturl=rs1.getField("RequestURL");
			String basepath=rs1.getField("basePath");
			String httpMethod=rs1.getField("HTTPMethod");
			String testId=rs1.getField("TC");
			String testcasename=rs1.getField("TestcaseName");
			
			if(httpMethod.equalsIgnoreCase("GET")) 
		    {  
			log1.info("....processing GET Request....");
			//System.out.println("inside GET");
			PageForGetRequest pgetobj=new PageForGetRequest();
			Map<String,Object> header=pgetobj.getHeader();
			
			ReadExcelData readexcel=new ReadExcelData();
			readexcel.readDataFor_GET(module,submodule,testId);
			//readexcel.readDataFor_GET(module,submodule,testId,testdatapath);
			Response response=null;
			while(ReadExcelData.DataIt.hasNext()) {
		    Map<String,String> datamap=ReadExcelData.DataIt.next();
		    
		    String get_identifier=datamap.get("Get_identifier");
			
			if(get_identifier.equalsIgnoreCase("branch")) {
		    
		    String contractId=datamap.get("contractId").toString().trim();
		    if((contractId!=null)&&(contractId.equalsIgnoreCase("")==false))
			{response=pgetobj.getBranchByContractId(requesturl, basepath, contractId,header);}
		    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
			//pgetobj.getDetailsOf(response);
			pgetobj.verifyGetSuccess(response);
			
			}
			
			else if(get_identifier.equalsIgnoreCase("getBranches")) {
			    
			    String ratecardId=datamap.get("ratecardId").toString().trim();
			    if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getBranchByRatrcardId(requesturl, basepath, header,ratecardId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getCommercial")) {
			    
			    String commercialId=datamap.get("commercialId").toString().trim();
			    if((commercialId!=null)&&(commercialId.equalsIgnoreCase("")==false))
				{response=pgetobj.getCommercialByCommercialId(requesturl, basepath, header,commercialId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getCommercials")) {
			    
			    String ratecardId=datamap.get("ratecardId").toString().trim();
			    if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getCommercialsByRateCardId(requesturl, basepath, header,ratecardId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getRateCard")) {
			    
			    String ratecardId=datamap.get("ratecardId").toString().trim();
			    if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getRateCardById(requesturl, basepath, header,ratecardId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getRateCards")) {
			    
			    String contractId=datamap.get("contractId").toString().trim();
			    if((contractId!=null)&&(contractId.equalsIgnoreCase("")==false))
				{response=pgetobj.getRateCardByContractId(requesturl, basepath, header,contractId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getSafex")) {
			    
			    String ratecardId=datamap.get("ratecardId").toString().trim();
			    if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getSafextSlaByRateCardId(requesturl, basepath, header,ratecardId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getTnc")) {
			    
			    String tncId=datamap.get("tncId").toString().trim();
			    if((tncId!=null)&&(tncId.equalsIgnoreCase("")==false))
				{response=pgetobj.getTncById(requesturl, basepath, header,tncId);}
			    else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				//pgetobj.getDetailsOf(response);
				pgetobj.verifyGetSuccess(response);
				
				}
			else if(get_identifier.equalsIgnoreCase("getTncs")) {
				
				String ratecardId=datamap.get("ratecardId").toString().trim();
				if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getTncByRateCardId(requesturl, basepath, header, ratecardId);}
				else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				pgetobj.verifyGetSuccess(response);
			}
			
			else if(get_identifier.equalsIgnoreCase("getVmi")) {
				
				String ratecardId=datamap.get("ratecardId").toString().trim();
				if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getVmiByRateCardId(requesturl, basepath, header, ratecardId);}
				else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				pgetobj.verifyGetSuccess(response);
			}
			
			else if(get_identifier.equalsIgnoreCase("getZmCustom")) {
				
				String ratecardId=datamap.get("ratecardId").toString().trim();
				if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getZmCustomeSlaByRateCardId(requesturl, basepath, header, ratecardId);}
				else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				pgetobj.verifyGetSuccess(response);
			}
			else if(get_identifier.equalsIgnoreCase("getZmSla")) {
				
				String ratecardId=datamap.get("ratecardId").toString().trim();
				if((ratecardId!=null)&&(ratecardId.equalsIgnoreCase("")==false))
				{response=pgetobj.getZmSlaByRateCardId(requesturl, basepath, header, ratecardId);}
				else {response=pgetobj.getResponse_All(requesturl, basepath, header);}
				pgetobj.verifyGetSuccess(response);
			}
			}
					
			log1.info("....GET Request Processed....");		
		    }
			
			else if(httpMethod.equalsIgnoreCase("POST"))
			{
				
				log1.info("....processing POST Request....");
				//System.out.println("inside POST");
				PageForPostRequest postobj=new PageForPostRequest();
				Map<String,Object> header=postobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				//readexcel.readDataFor_POST(module,submodule,testId,testdatapath);
				readexcel.readDataFor_POST(module,submodule,testId);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
					Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
					
					String post_identifier=jsonparamvalue.get("Post_identifier");
					
					if(post_identifier.equalsIgnoreCase("addRateCard")) {
						String json=postobj.addRateCard(jsonparamvalue);
						log1.info("JSON is:"+json);
						
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
					}
					
					else if(post_identifier.equalsIgnoreCase("addSafextSla")) {
						String json=postobj.addSafextSla(jsonparamvalue);
						log1.info("JSON is:"+json);
						
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
					}
					
					else if(post_identifier.equalsIgnoreCase("create_role")) {
						String json=postobj.createRole(jsonparamvalue);
						log1.info("JSON is:"+json);
						
						response=postobj.postRequest(requesturl, basepath, header, json);
						//Map<String,Object> responsemap=postobj.getResponse(response);
					    postobj.verifyPostSuccess(response);
					}
					
		    					}
		     log1.info(".............POST Request Processed..................");
			}
	
			else if(httpMethod.equalsIgnoreCase("PUT"))
			{
				log1.info(".............Processing PUT Request..................");
				//System.out.println("inside put");
				PageForPutRequest putobj=new PageForPutRequest();
				Map<String,Object> header=putobj.getHeader();
				ReadExcelData readexcel=new ReadExcelData();
				readexcel.readExcelData_PUT(module,submodule,testId);
				//readexcel.readDataFor_PUT(module,submodule,testId,testdatapath);
				Response response=null;
				while(ReadExcelData.DataIt.hasNext()) {
				Map<String,String> jsonparamvalue=ReadExcelData.DataIt.next();
				
				String put_identifier=jsonparamvalue.get("Put_identifier");	
				
				if(put_identifier.equalsIgnoreCase("updateUser")) {
				
				String json=putobj.getJSONString(jsonparamvalue);
				log1.info("JSON is:"+json);
				//System.out.println("JSON is:"+json);
				response=putobj.putRequest(requesturl, basepath, header, json);
				//Map<String,Object> responsemap=putobj.getResponse(response);
				putobj.verifyPutSuccess(response);
				}
				else if(put_identifier.equalsIgnoreCase("update_privilegeBranchIds")) {
					
					String uid=jsonparamvalue.get("uid");
					String idKey=jsonparamvalue.get("idKey");						
					String json=putobj.updateListOfPrivilegeBranchIds(jsonparamvalue);
					log1.info("JSON is:"+json);
					//System.out.println("JSON is:"+json);
					response=putobj.putRequestForPrivilegeBranchIds(requesturl, basepath, uid, idKey, header, json);
					//Map<String,Object> responsemap=putobj.getResponse(response);
					putobj.verifyPutSuccess(response);
					}
				
				
				else if(put_identifier.equalsIgnoreCase("update_roles")) {
					
					String uid=jsonparamvalue.get("uid");
					String idKey=jsonparamvalue.get("idKey");						
					String json=putobj.updateListOfRolesMappedForUser(jsonparamvalue);
					log1.info("JSON is:"+json);
					//System.out.println("JSON is:"+json);
					response=putobj.putRequestForRoles(requesturl, basepath, uid, idKey, header, json);
					//Map<String,Object> responsemap=putobj.getResponse(response);
					putobj.verifyPutSuccess(response);
					}
				}
				
				log1.info(".............PUT Request Processed..................");
			}				
				
		}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);	
			if(flag==false) {throw new Exception();}else {UtilityClassForAPI.logger.pass(testname+" passed");UtilityClassForAPI.extent.flush();
			}
	}
	
		
//////////////////////////////////////////////////////////		
		
				
			}catch(Exception e) 
			{
				UtilityClassForAPI.logger.fail(testname+" failed");
				UtilityClassForAPI.extent.flush();
		        Verify.verify(false);
				
			}
			
		}
		

	}
