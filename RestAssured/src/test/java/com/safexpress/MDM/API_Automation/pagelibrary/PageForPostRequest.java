package com.safexpress.MDM.API_Automation.pagelibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;
import com.safexpress.MDM.API_Automation.managerClass.ReadExcelData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class PageForPostRequest {
	Logger log=Logger.getLogger(PageForPostRequest.class.getName());
	public static String userID=null;
	public static Integer uId=null;
	public static boolean bool=false;
	public Map<String,Object> getHeader()
	{
		log.info("....initialising headers......");
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("authorization"," ");
		headerMap.put("branchCode"," ");
		headerMap.put("correlationId"," ");
		headerMap.put("journeyId","123");
		headerMap.put("userId","USER1");
		headerMap.put("origiUserType"," ");
		headerMap.put("Content-Type","application/json");
		log.info(".......headers initialisation done.......");
		return headerMap;
	}
	
	public Map<String,Object> getHeader_BFF()
	{
		log.info("....initialising headers......");
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("authorization",UtilityClassForAPI.accessTokenBFF);
		headerMap.put("branchCode"," ");
		headerMap.put("correlationId"," ");
		headerMap.put("journeyId","123");
		headerMap.put("userId",UtilityClassForAPI.userId_BFF);
		headerMap.put("origiUserType"," ");
		headerMap.put("Content-Type","application/json");
		log.info(".......headers initialisation done.......");
		return headerMap;
	}
	
	public  String getJSONString(Map jsonparamvalue)
	{
		userID=jsonparamvalue.get("userId").toString();
		log.info(".......creating json string.......");	
				String jsonbody="{\n"+
				  "\"categoryId\":"+jsonparamvalue.get("categoryId")+",\n"+
				  "\"defaultBranch\": {\n"+
				  "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("defaultBranch_addOrRemoveOrUpdate")+"\",\n"+
				  "\"branchId\": "+jsonparamvalue.get("defaultBranch_branchId")+",\n"+
				  "\"effectiveDate\": \""+jsonparamvalue.get("defaultBranch_effectiveDate")+"\",\n"+
				  "\"expiryDate\": \""+jsonparamvalue.get("defaultBranch_expiryDate")+"\",\n"+
				  "\"isDefault\":"+jsonparamvalue.get("defaultBranch_isDefault")+",\n"+
				  "\"status\":"+jsonparamvalue.get("defaultBranch_status")+ "\n"+
				  "},\n"+
				  "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
				  "\"email\": \""+jsonparamvalue.get("email")+"\",\n"+
				  "\"id\":"+jsonparamvalue.get("id")+",\n"+
				  "\"isAdmin\":"+jsonparamvalue.get("isAdmin")+",\n"+
				  "\"menuHierarchyId\":"+jsonparamvalue.get("menuHierarchyId")+",\n"+
				  "\"mobile\": \""+jsonparamvalue.get("mobile")+"\",\n"+
				  "\"name\": \""+jsonparamvalue.get("name")+"\",\n"+
				  "\"previlegeBranches\": [\n"+
				    "{\n"+
				      "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("previlegeBranches_addOrRemoveOrUpdate")+"\",\n"+
				      "\"branchId\": "+jsonparamvalue.get("previlegeBranches_branchId")+",\n"+
				      "\"effectiveDate\": \""+jsonparamvalue.get("previlegeBranches_effectiveDate")+"\",\n"+
				      "\"expiryDate\": \""+jsonparamvalue.get("previlegeBranches_expiryDate")+"\",\n"+
				      "\"isDefault\":"+jsonparamvalue.get("previlegeBranches_isDefault")+",\n"+
				      "\"status\":"+jsonparamvalue.get("previlegeBranches_status")+"\n"+
				    "}\n"+
				  "],\n"+
				  "\"status\":"+jsonparamvalue.get("status")+",\n"+
				  "\"userDepartment\":"+jsonparamvalue.get("userDepartment")+",\n"+
				  "\"userId\": \""+jsonparamvalue.get("userId")+"\",\n"+
				  "\"userRoles\": [\n"+
				    "{\n"+
				     "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("userRoles_addOrRemoveOrUpdate")+"\",\n"+
				      "\"createdBy\": \""+jsonparamvalue.get("userRoles_createdBy")+"\",\n"+
				      "\"description\": \""+jsonparamvalue.get("userRoles_description")+"\",\n"+
				      "\"effectiveDate\": \""+jsonparamvalue.get("userRoles_effectiveDate")+"\",\n"+
				      "\"expiryDate\":\""+jsonparamvalue.get("userRoles_expiryDate")+"\",\n"+
				      "\"roleId\":"+jsonparamvalue.get("userRoles_roleId")+",\n"+
				      "\"roleName\": \""+jsonparamvalue.get("userRoles_roleName")+"\",\n"+
				      "\"status\":"+jsonparamvalue.get("userRoles_status")+",\n"+
				      "\"updatedBy\":\""+jsonparamvalue.get("userRoles_updatedBy")+"\"\n"+
				    "}\n"+
				  "]\n"+
				"}";
				log.info(".......json string created.......");
		return jsonbody;
	}
	
	public  String getAllRoleDetails(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();
	log.info(".......creating json string.......");
	String jsonbody="{\n"+
			 "\"roleDto\": {\n"+
			
	 "\"addOrRemoveOrUpdate\":\""+jsonparamvalue.get("roleDto_addOrRemoveOrUpdate")+"\",\n"+
	 "\"createdBy\": \""+jsonparamvalue.get("roleDto_createdBy")+"\",\n"+
	 "\"description\": \""+jsonparamvalue.get("roleDto_description")+"\",\n"+
	 "\"effectiveDate\": \""+jsonparamvalue.get("roleDto_effectiveDate")+"\",\n"+
	 "\"expiryDate\": \""+jsonparamvalue.get("roleDto_expiryDate")+"\",\n"+
	 "\"roleId\":"+jsonparamvalue.get("roleDto_roleId")+",\n"+
	 "\"roleName\":\""+jsonparamvalue.get("roleDto_roleName")+"\",\n"+
	 "\"status\": "+jsonparamvalue.get("roleDto_status")+",\n"+
	 "\"updatedBy\": \""+jsonparamvalue.get("roleDto_updatedBy")+"\"\n"+
	 "},\n"+
	 
	 "\"status\": \""+jsonparamvalue.get("status")+"\",\n"+
	 "\"updatedBy\": \""+jsonparamvalue.get("updatedBy")+"\"\n"+
	"}";
	log.info(".......json string created.......");
	return jsonbody;
	}
	
	public  String getAllRoleListPermissionDetails(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();
	log.info(".......creating json string.......");
	String jsonbody="[\n"+
			 "{\n"+
			
	 "\"addOrRemoveOrUpdate\":\""+jsonparamvalue.get("addOrRemoveOrUpdate")+"\",\n"+
	 "\"createdBy\": \""+jsonparamvalue.get("createdBy")+"\",\n"+
	 "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
	 "\"effectiveDate\": \""+jsonparamvalue.get("effectiveDate")+"\",\n"+
	 "\"expiryDate\": \""+jsonparamvalue.get("expiryDate")+"\",\n"+
	 "\"roleId\":"+jsonparamvalue.get("roleId")+",\n"+
	 "\"roleName\":\""+jsonparamvalue.get("roleName")+"\",\n"+
	 "\"status\": "+jsonparamvalue.get("status")+",\n"+
	 "\"updatedBy\": \""+jsonparamvalue.get("updatedBy")+"\"\n"+
	 "}\n"+
	 
	"]";
	log.info(".......json string created.......");
	return jsonbody;
	}
	
	public  String createRole(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();
	log.info(".......creating json string.......");
	String jsonbody= "{\n"+
			
	 "\"addOrRemoveOrUpdate\":\""+jsonparamvalue.get("addOrRemoveOrUpdate")+"\",\n"+
	 "\"createdBy\": \""+jsonparamvalue.get("createdBy")+"\",\n"+
	 "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
	 "\"effectiveDate\": \""+jsonparamvalue.get("effectiveDate")+"\",\n"+
	 "\"expiryDate\": \""+jsonparamvalue.get("expiryDate")+"\",\n"+
	 "\"roleId\":"+jsonparamvalue.get("roleId")+",\n"+
	 "\"roleName\":\""+jsonparamvalue.get("roleName")+"\",\n"+
	 "\"status\": "+jsonparamvalue.get("status")+",\n"+
	 "\"updatedBy\": \""+jsonparamvalue.get("updatedBy")+"\"\n"+
	 "}\n";
	 
	log.info(".......json string created.......");
	return jsonbody;
	}
	
	/////////////////////////////////json for get token in cookie////////////////////////
	public  String getJsonforTokenAccess(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();
	log.info(".......creating json string.......");
	String jsonbody= "\n{\n"+
	  "\"channelId\": "+jsonparamvalue.get("channelId")+",\n"+
	 "\"password\":\""+jsonparamvalue.get("password")+"\",\n"+
	 "\"username\": \""+jsonparamvalue.get("username")+"\"\n"+
	 "}\n";
	 
	log.info(".......json string created.......");
	return jsonbody;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////json for user creation (user_controller)/////////////
	public  String getJsonforusercreation(Map jsonparamvalue)
	{
		userID=jsonparamvalue.get("userId").toString();
		log.info(".......creating json string.......");	
				String jsonbody="{\n"+
				  "\"categoryId\":"+jsonparamvalue.get("categoryId")+",\n"+
				  "\"defaultBranch\": {\n"+
				  "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("defaultBranch_addOrRemoveOrUpdate")+"\",\n"+
				  "\"branchId\": "+jsonparamvalue.get("defaultBranch_branchId")+",\n"+
				  "\"effectiveDate\": \""+jsonparamvalue.get("defaultBranch_effectiveDate")+"\",\n"+
				  "\"expiryDate\": \""+jsonparamvalue.get("defaultBranch_expiryDate")+"\",\n"+
				  "\"isDefault\":"+jsonparamvalue.get("defaultBranch_isDefault")+",\n"+
				  "\"status\":"+jsonparamvalue.get("defaultBranch_status")+ "\n"+
				  "},\n"+
				  "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
				  "\"email\": \""+jsonparamvalue.get("email")+"\",\n"+
				  "\"id\":"+jsonparamvalue.get("id")+",\n"+
				  "\"isAdmin\":"+jsonparamvalue.get("isAdmin")+",\n"+
				  "\"menuHierarchyId\":"+jsonparamvalue.get("menuHierarchyId")+",\n"+
				  "\"mobile\": \""+jsonparamvalue.get("mobile")+"\",\n"+
				  "\"name\": \""+jsonparamvalue.get("name")+"\",\n"+
				  "\"previlegeBranches\": [\n"+
				    "{\n"+
				      "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("previlegeBranches_addOrRemoveOrUpdate")+"\",\n"+
				      "\"branchId\": "+jsonparamvalue.get("previlegeBranches_branchId")+",\n"+
				      "\"effectiveDate\": \""+jsonparamvalue.get("previlegeBranches_effectiveDate")+"\",\n"+
				      "\"expiryDate\": \""+jsonparamvalue.get("previlegeBranches_expiryDate")+"\",\n"+
				      "\"isDefault\":"+jsonparamvalue.get("previlegeBranches_isDefault")+",\n"+
				      "\"status\":"+jsonparamvalue.get("previlegeBranches_status")+"\n"+
				    "}\n"+
				  "],\n"+
				  "\"status\":"+jsonparamvalue.get("status")+",\n"+
				  "\"userDepartment\":"+jsonparamvalue.get("userDepartment")+",\n"+
				  "\"userId\": \""+jsonparamvalue.get("userId")+"\",\n"+
				  "\"userRoles\": [\n"+
				    "{\n"+
				     "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("userRoles_addOrRemoveOrUpdate")+"\",\n"+
				      "\"description\": \""+jsonparamvalue.get("userRoles_description")+"\",\n"+
				      "\"roleId\":"+jsonparamvalue.get("userRoles_roleId")+",\n"+
				      "\"roleName\": \""+jsonparamvalue.get("userRoles_roleName")+"\",\n"+
				      "\"status\":"+jsonparamvalue.get("userRoles_status")+",\n"+
				    "}\n"+
				  "]\n"+
				"}";
				log.info(".......json string created.......");
		return jsonbody;
	}

	////////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////json for usermanagement BFF role-controller ////////////////////////////////////
	
	public  String getJsonforCreateRole(Map jsonparamvalue)
	{
		//userID=jsonparamvalue.get("userId").toString();
		log.info(".......creating json string.......");	
				String jsonbody=

"{\n"+
				  
				  "\"isAddOrRemoveOrUpdate\":\""+jsonparamvalue.get("isAddOrRemoveOrUpdate")+"\",\n"+
				  "\"objectPermissionList\": [\n{"+
				  "\"attributeExclutionList\": [\n{"+
				  "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("objectPermissionList_attributeExclutionList_addOrRemoveOrUpdate")+"\",\n"+
				  "\"attributeName\":\""+jsonparamvalue.get("objectPermissionList_attributeExclutionList_attributeName")+"\",\n"+
				  "\"excluded\":\""+jsonparamvalue.get("objectPermissionList_attributeExclutionList_excluded")+"\",\n"+
				  "\"id\":"+jsonparamvalue.get("objectPermissionList_attributeExclutionList_id")+",\n"+
				  "\"isAddorUpdate\":\""+jsonparamvalue.get("objectPermissionList_attributeExclutionList_isAddorUpdate")+"\",\n"+
				  "\"objRolePermMapId\":"+jsonparamvalue.get("objectPermissionList_attributeExclutionList_objRolePermMapId")+",\n"+
				  "\"objectAttributeId\":"+jsonparamvalue.get("objectPermissionList_attributeExclutionList_objectAttributeId")+",\n"+
				  "\"objectId\":"+jsonparamvalue.get("objectPermissionList_attributeExclutionList_objectId")+ ",\n"+
				  "\"permissionId\":"+jsonparamvalue.get("objectPermissionList_attributeExclutionList_permissionId")+",\n"+
				  "\"status\":"+jsonparamvalue.get("objectPermissionList_attributeExclutionList_status")+ "\n"+
				  "}\n],\n"+		    	  
				  "\"channelId\": \""+jsonparamvalue.get("objectPermissionList_channelId")+"\",\n"+
				  "\"id\":"+jsonparamvalue.get("objectPermissionList_id")+",\n"+
				  "\"isAddOrRemoveOrUpdate\":\""+jsonparamvalue.get("objectPermissionList_isAddOrRemoveOrUpdate")+"\",\n"+
				  "\"moduleId\":"+jsonparamvalue.get("objectPermissionList_moduleId")+",\n"+
				  "\"moduleName\": \""+jsonparamvalue.get("objectPermissionList_moduleName")+"\",\n"+
				  "\"objectId\": \""+jsonparamvalue.get("objectPermissionList_objectId")+"\",\n"+
				  "\"permissionId\": \""+jsonparamvalue.get("objectPermissionList_permissionId")+"\",\n"+
				  "\"permissionType\":\""+jsonparamvalue.get("objectPermissionList_permissionType")+"\",\n"+
				  "\"status\":"+jsonparamvalue.get("objectPermissionList_status")+"\n"+
				  
				  "}\n],\n"+	
				  "\"roleDto\": {\n"+
				     "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("roleDto_addOrRemoveOrUpdate")+"\",\n"+
				      "\"description\":\" "+jsonparamvalue.get("roleDto_description")+"\",\n"+
				      "\"roleId\": "+jsonparamvalue.get("roleDto_roleId")+",\n"+
				      "\"roleName\": \""+jsonparamvalue.get("roleDto_roleName")+"\",\n"+
				      "\"status\":"+jsonparamvalue.get("roleDto_status")+"\n"+
				     "},\n"+
					"\"status\":\""+jsonparamvalue.get("status")+"\"\n"+  
				"}";
				log.info(".......json string created.......");
		return jsonbody;
	}
		
	
/////////////////////////////////////////////////////////////////////////////////////////////////
	public  String createAllObjectDetails(Map jsonparamvalue)
	{
		//userID=jsonparamvalue.get("objectId").toString();
		log.info(".......creating json string.......");	
				String jsonbody="{\n"+
				  "\"attributeExclutionList\": [\n"+
				  "{\n"+
				"\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("attributeExclutionList_addOrRemoveOrUpdate")+"\",\n"+
				"\"attributeName\": \""+jsonparamvalue.get("attributeExclutionList_attributeName")+"\",\n"+
				"\"attributeType\": \""+jsonparamvalue.get("attributeExclutionList_attributeType")+"\",\n"+
				"\"createdBy\": \""+jsonparamvalue.get("attributeExclutionList_createdBy")+"\",\n"+
				"\"description\": \""+jsonparamvalue.get("attributeExclutionList_description")+"\",\n"+
				"\"effectiveDate\": \""+jsonparamvalue.get("attributeExclutionList_effectiveDate")+"\",\n"+
				"\"expiryDate\": \""+jsonparamvalue.get("attributeExclutionList_expiryDate")+"\",\n"+
				"\"id\":"+jsonparamvalue.get("attributeExclutionList_id")+",\n"+
				"\"isAddorUpdate\": \""+jsonparamvalue.get("attributeExclutionList_isAddorUpdate")+"\",\n"+
				"\"objRolePermMapId\":"+jsonparamvalue.get("attributeExclutionList_objRolePermMapId")+",\n"+
				"\"objectAttributeId\":"+jsonparamvalue.get("attributeExclutionList_objectAttributeId")+",\n"+
				"\"objectId\":"+jsonparamvalue.get("attributeExclutionList_objectId")+",\n"+
				"\"permissionExclusion\": \""+jsonparamvalue.get("attributeExclutionList_permissionExclusion")+"\",\n"+
				"\"permissionId\":"+jsonparamvalue.get("attributeExclutionList_permissionId")+",\n"+
				"\"status\":"+jsonparamvalue.get("attributeExclutionList_status")+",\n"+
				"\"updatedBY\": \""+jsonparamvalue.get("attributeExclutionList_updatedBY")+"\"\n"+
			"}\n"+
				
		 "],\n"+

				"\"channelArr\":["+jsonparamvalue.get("channelArr")+"\n"+

 		"],\n"+
 		"\"channelId\":"+jsonparamvalue.get("channelArr")+",\n"+
 		"\"channelList\":["+jsonparamvalue.get("channelArr")+"\n"+

 		"],\n"+


 			"\"createdBy\": \""+jsonparamvalue.get("createdBy")+"\",\n"+
 			"\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
 			"\"effectiveDate\": \""+jsonparamvalue.get("effectiveDate")+"\",\n"+
 			"\"entityId\":"+jsonparamvalue.get("entityId")+",\n"+
 			"\"entityName\": \""+jsonparamvalue.get("entityName")+"\",\n"+
 			"\"expiryDaye\": \""+jsonparamvalue.get("expiryDaye")+"\",\n"+
 			"\"id\":"+jsonparamvalue.get("id")+",\n"+
 			"\"isAddOrRemoveOrUpdate\": \""+jsonparamvalue.get("isAddOrRemoveOrUpdate")+"\",\n"+
 			"\"isPublic\":"+jsonparamvalue.get("isPublic")+",\n"+
 			"\"moduleId\":"+jsonparamvalue.get("moduleId")+",\n"+
 			"\"moduleName\": \""+jsonparamvalue.get("moduleName")+"\",\n"+
 			"\"objectId\":"+jsonparamvalue.get("objectId")+",\n"+
 			"\"permissionId\":"+jsonparamvalue.get("permissionId")+",\n"+
 			"\"permissionType\": \""+jsonparamvalue.get("permissionType")+"\",\n"+
 			"\"public\":"+jsonparamvalue.get("public")+",\n"+
 			"\"status\":"+jsonparamvalue.get("status")+",\n"+
 			"\"subEntityName\":\""+jsonparamvalue.get("subEntityName")+"\",\n"+
 			"\"updatedBy\":\""+jsonparamvalue.get("updatedBy")+"\"\n"+
				    "}";
				log.info(".......json string created.......");
				return jsonbody;
	}
	
	public Response postRequest(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......POST Request is fired for new user :"+PageForPostRequest.userID+".......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.post();
			//.headers("Content-Type","application/json")
			
		   }catch(Exception e) {
			   log.info(".......sorry,requested url is down so unbale to fulfil request");
			 //  e.printStackTrace();
			   }
		return response;	
		
	}
	
	public Map<String,Object> getResponse(Response response)
	{
		log.info("......retrieving details of POST Response...........");
		Map<String,Object> details=new HashMap<String,Object>();
		String responseBody=response.getBody().asString();
		details.put("ResponseBody",responseBody);
		log.info("Response Body is: "+responseBody);
		//System.out.println("Response Body is: "+responseBody);
		int statusCode=response.getStatusCode();
		details.put("StatusCode",statusCode);
		log.info("Status code is: "+statusCode);
		//System.out.println("status code is:"+statusCode);
		String StatusLine=response.getStatusLine();
		details.put("StatusLine",StatusLine);
		log.info("Status Line is: "+StatusLine);
		String contenttype=response.getContentType();
		details.put("Content-Type",contenttype);
		log.info("........end of details of POST Response........");
		return details;

	}
	
	public void verifyPostSuccess(Response response)
	{ 
		log.info(".........verifying POST success.....");
		bool=false;
		
		try {
			int statusCode=0;
			try {
			     statusCode=response.getStatusCode();
			}catch(Exception e) {log.info("status code not retrieved");}
			
			if(statusCode==201)
			{
		   	   bool=true;
		       APIFrameworkDriver.flag=true;
		   	   log.info("...POST Request successed" );
		   	
			}
			
			else if(statusCode==200)
			{
			   	   bool=true;
			       APIFrameworkDriver.flag=true;
			   	   log.info("...POST Request successed" );
			   	  
				}
			else 
			{
				//userID=null;
				APIFrameworkDriver.flag=false;
				throw new Exception();
			}
		    }catch(Exception e) 
			{
		    	APIFrameworkDriver.flag=false;
				log.info("...POST Request not successed" );
				JsonPath jp=response.jsonPath();				
				String s=jp.getString("errors");
				UtilityClassForAPI.logger.fail("POST Request failed:"+s);
		    	
		    }
		    	
		
	}
///////////////////////////usermanagement_BFF-Authentication and Authorization///////////////////////////////
	
	public Response postRequestToGetAccessTokenInCookie(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......POST Request is fired to get Access Token in cookie.......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.post();
			//.headers("Content-Type","application/json")
			
		   }catch(Exception e) {
			   log.info(".......sorry,requested url is down so unbale to fulfil request");
			 //  e.printStackTrace();
			   }
		return response;	
		
	}
	
	
	public Response postRequestForLogout(String baseuri,String basepath,Map header)
	{
		log.info(".......POST Request is fired for Logout.......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.post();
			//.headers("Content-Type","application/json")
			
		   }catch(Exception e) {
			   log.info(".......sorry,requested url is down so unbale to fulfil request");
			 //  e.printStackTrace();
			   }
		return response;	
		
	}
	
	
////////////////////////////usermanagement_BFF-role controller/////////////////////////
	

	public Response CreatesRolewith_or_withoutPermissions_or_addPermissionToExistingRolewith_or_withoutAttributeExclusion(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......POST Request is fired for role creation.......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.post();
			//.headers("Content-Type","application/json")
			
		   }catch(Exception e) {
			   log.info(".......sorry,requested url is down so unbale to fulfil request");
			 //  e.printStackTrace();
			   }
		return response;	
		
	}
	
/////////////////////////////usermanagement_BFF-user controller/////////////////

public Response CreatesUserWithDefaultbranch_multiplePrivilegeBranches_multipleroles(String baseuri,String basepath,Map header,String json)
{
	log.info(".......POST Request is fired for new user :"+PageForPostRequest.userID+".......");
	Response response=null;
	try {
		response=RestAssured.given()
				.baseUri(baseuri)
				.basePath(basepath)
				.headers(header)
				.body(json)
				.post();
		//.headers("Content-Type","application/json")
		
	   }catch(Exception e) {
		   log.info(".......sorry,requested url is down so unbale to fulfil request");
		 //  e.printStackTrace();
		   }
	return response;	
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////Credit Contract Ratecard Controller/////////////////////////////

			public  String addRateCard(Map jsonparamvalue)
			{
			
			log.info(".......creating json string.......");
			String jsonbody= "{\n"+
					
			 "\"baseLocnBranchId\":\""+jsonparamvalue.get("baseLocnBranchId")+"\",\n"+
			 "\"cmdmntLevel\": \""+jsonparamvalue.get("cmdmntLevel")+"\",\n"+
			 "\"cntrId\": \""+jsonparamvalue.get("cntrId")+"\",\n"+
			 "\"crtdBy\": \""+jsonparamvalue.get("crtdBy")+"\",\n"+
			 "\"crtdDt\": \""+jsonparamvalue.get("crtdDt")+"\",\n"+
			 "\"descr\":"+jsonparamvalue.get("descr")+",\n"+
			 "\"effectiveDt\":\""+jsonparamvalue.get("effectiveDt")+"\",\n"+
			 "\"expDt\": "+jsonparamvalue.get("expDt")+",\n"+
			 "\"offeringId\": \""+jsonparamvalue.get("offeringId")+"\"\n"+
			 "\"rateCardSignDt\":\""+jsonparamvalue.get("rateCardSignDt")+"\"\n"+
			 "\"status\":\""+jsonparamvalue.get("status")+"\"\n"+
			 "\"updBy\":\""+jsonparamvalue.get("updBy")+"\"\n"+
			 "\"updDt\":\""+jsonparamvalue.get("updDt")+"\"\n"+
			 "\"zoneMtxId\":\""+jsonparamvalue.get("zoneMtxId")+"\"\n"+
			 "}\n";
			 
			log.info(".......json string created.......");
			return jsonbody;
}

			public  String addSafextSla(Map jsonparamvalue)
			{
			
			log.info(".......creating json string.......");
			String jsonbody= "{\n"+
					
			 "\"descr\":\""+jsonparamvalue.get("descr")+"\",\n"+
			 "\"effectiveDt\": \""+jsonparamvalue.get("effectiveDt")+"\",\n"+
			 "\"expDt\": \""+jsonparamvalue.get("expDt")+"\",\n"+
			 "\"lkpSafextLevelId\": \""+jsonparamvalue.get("lkpSafextLevelId")+"\",\n"+
			 "\"ratecardId\": \""+jsonparamvalue.get("ratecardId")+"\",\n"+
			 "\"safextCtgy\":"+jsonparamvalue.get("safextCtgy")+",\n"+
			 "\"safextDestId\":\""+jsonparamvalue.get("safextDestId")+"\",\n"+
			 "\"safextEntityId\": "+jsonparamvalue.get("safextEntityId")+",\n"+
			 "\"safextSrcId\": \""+jsonparamvalue.get("safextSrcId")+",\n"+
			 "\"slaDays\":\""+jsonparamvalue.get("slaDays")+",\n"+
			 "\"slaRrFlag\":\""+jsonparamvalue.get("slaRrFlag")+",\n"+
			 "\"status\":\""+jsonparamvalue.get("status")+"\"\n"+
			 "}\n";
			 
			log.info(".......json string created.......");
			return jsonbody;
}

}
