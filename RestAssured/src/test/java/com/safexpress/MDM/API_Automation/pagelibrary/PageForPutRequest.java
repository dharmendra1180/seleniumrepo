package com.safexpress.MDM.API_Automation.pagelibrary;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PageForPutRequest {
	
	Logger log=Logger.getLogger(PageForPutRequest.class.getName());
	static String userID=null;
	
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
		return headerMap;	}
	
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
	
	public  String updateRolePermissionDetails(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();

	log.info(".......creating json string.......");
	String jsonbody="{\n"+
	 "\"roleDto\": {\n"+
	 "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("roleDto_addOrRemoveOrUpdate")+"\",\n"+
	 "\"createdBy\": \""+jsonparamvalue.get("roleDto_createdBy")+"\",\n"+
	 "\"description\": \""+jsonparamvalue.get("roleDto_description")+"\",\n"+  
	 "\"effectiveDate\":\"2020-01-02\",\n"+
	 "\"expiryDate\":\"2020-01-02\",\n"+
	 "\"roleId\":"+jsonparamvalue.get("roleDto_roleId")+",\n"+
	 "\"roleName\": \""+jsonparamvalue.get("roleDto_roleName")+"\",\n"+
	 "\"status\":"+jsonparamvalue.get("roleDto_status")+ ",\n"+
	 "\"updatedBy\": \""+jsonparamvalue.get("roleDto_updatedBy")+"\"\n"+

	 "}\n"+
	"}";

	log.info(".......json string created.......");
	return jsonbody;
	}
	
	public  String updateListOfPrivilegeBranchIds(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();

	log.info(".......creating json string.......");
	String jsonbody="[\n"+
			 "{\n"+
		 "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("addOrRemoveOrUpdate")+"\",\n"+
		 "\"branchId\":"+jsonparamvalue.get("branchId")+",\n"+
		 "\"effectiveDate\":\""+jsonparamvalue.get("effectiveDate")+"\",\n"+
		 "\"expiryDate\":\""+jsonparamvalue.get("expiryDate")+"\",\n"+	
		 "\"isDefault\":"+jsonparamvalue.get("isDefault")+ ",\n"+
		 "\"status\":"+jsonparamvalue.get("status")+ "\n"+
		 "}\n"+
		"]";


	log.info(".......json string created.......");
	return jsonbody;
	}
	
	public  String updateListOfRolesMappedForUser(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();

	log.info(".......creating json string.......");
	String jsonbody="[\n"+
			  "{\n"+

		 "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("addOrRemoveOrUpdate")+"\",\n"+
		 "\"createdBy\": \""+jsonparamvalue.get("createdBy")+"\",\n"+
		 "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
		 "\"effectiveDate\":\""+jsonparamvalue.get("effectiveDate")+"\",\n"+
		 "\"expiryDate\":\""+jsonparamvalue.get("expiryDate")+"\",\n"+
		 "\"roleId\":"+jsonparamvalue.get("roleId")+ ",\n"+
		 "\"roleName\":\""+jsonparamvalue.get("roleName")+"\",\n"+
		 "\"status\":"+jsonparamvalue.get("status")+ ",\n"+
		 "\"updatedBy\":\""+jsonparamvalue.get("updatedBy")+ "\"\n"+
		 
		 "}\n"+
		"]";


	log.info(".......json string created.......");
	return jsonbody;
	}
///////////////////////////////json for Usermanagement BFF user-controller/////////////////////////////////////
	public  String getJsonToUpdatdeUser(Map jsonparamvalue)
	{
		
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
				      "\"status\":"+jsonparamvalue.get("userRoles_status")+"\n"+
				    "}\n"+
				  "]\n"+
				"}";
				log.info(".......json string created.......");
		return jsonbody;
	}


	public  String getJsonToUpdateUser_privilageBranch(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();

	log.info(".......creating json string.......");
	String jsonbody="{\n"+
				  
				    "\"categoryId\":\""+jsonparamvalue.get("categoryId")+"\",\n"+
				    "\"defaultBranch\": \n{"+
				  
				    "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("defaultBranch_addOrRemoveOrUpdate")+"\",\n"+
				    "\"branchId\":"+jsonparamvalue.get("defaultBranch_branchId")+",\n"+
				    "\"effectiveDate\":\""+jsonparamvalue.get("defaultBranch_effectiveDate")+"\",\n"+
				    "\"expiryDate\":\""+jsonparamvalue.get("defaultBranch_expiryDate")+"\",\n"+
				    "\"isDefault\":"+jsonparamvalue.get("defaultBranch_isDefault")+ ",\n"+
				    "\"status\":"+jsonparamvalue.get("defaultBranch_status")+"\n"+

				  	"},\n"+	
				  	
				    "\"description\": \""+jsonparamvalue.get("description")+"\",\n"+
				    "\"email\":\""+jsonparamvalue.get("email")+"\",\n"+
				    "\"id\":"+jsonparamvalue.get("id")+",\n"+
                    "\"isAdmin\":"+jsonparamvalue.get("isAdmin")+",\n"+
				    "\"menuHierarchyId\":"+jsonparamvalue.get("menuHierarchyId")+",\n"+
				    "\"mobile\":\""+jsonparamvalue.get("mobile")+"\",\n"+
				    "\"name\":\""+jsonparamvalue.get("name")+"\",\n"+
				
				    "\"previlegeBranches\": [\n{"+
				    
				    "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("previlegeBranches_addOrRemoveOrUpdate")+"\",\n"+
				    "\"branchId\":"+jsonparamvalue.get("previlegeBranches_branchId")+",\n"+
				    "\"effectiveDate\":\""+jsonparamvalue.get("previlegeBranches_effectiveDate")+"\",\n"+
				    "\"expiryDate\":\""+jsonparamvalue.get("previlegeBranches_expiryDate")+"\",\n"+
				    "\"isDefault\":"+jsonparamvalue.get("previlegeBranches_isDefault")+ ",\n"+
				   "\"status\":"+jsonparamvalue.get("previlegeBranches_status")+"\n"+

				  	"}\n],"+

		  		   "\"status\":"+jsonparamvalue.get("status")+",\n"+
		  		   "\"userDepartment\": "+jsonparamvalue.get("userDepartment")+",\n"+
		  		   "\"userId\": \""+jsonparamvalue.get("userId")+"\",\n"+
		  		   
				   "\"userRoles\": [\n{"+
				   
				   "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("userRoles_addOrRemoveOrUpdate")+"\",\n"+
				   "\"description\": \""+jsonparamvalue.get("userRoles_description")+"\",\n"+
				   "\"roleId\":"+jsonparamvalue.get("userRoles_roleId")+",\n"+
				   "\"roleName\":\""+jsonparamvalue.get("userRoles_roleName")+"\",\n"+
				   "\"status\":"+jsonparamvalue.get("userRoles_status")+"\n"+
				   "}\n" +
				   "]\n" +
"}\n";									

	log.info(".......json string created.......");
	return jsonbody;
	}
	
	public  String getJsonToUpdateUser_role(Map jsonparamvalue)
	{
	//userID=jsonparamvalue.get("userId").toString();
	log.info(".......creating json string.......");
	String jsonbody="[\n"+
			  "{\n"+
		 "\"addOrRemoveOrUpdate\":\""+jsonparamvalue.get("addOrRemoveOrUpdate")+"\",\n"+
		 "\"description\": \""+jsonparamvalue.get("branchId")+"\",\n"+
		 "\"roleId\": "+jsonparamvalue.get("effectiveDate")+",\n"+
		 "\"roleName\":\""+jsonparamvalue.get("expiryDate")+"\",\n"+
		 "\"status\":"+jsonparamvalue.get("isDefault")+",\n"+
		 "}\n"+
		"]";										

	log.info(".......json string created.......");
	return jsonbody;
	}

/////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////json for usermanagement BFF role-controller////////////////////
	public  String getJsonToUpdateRole(Map jsonparamvalue)
	{
//		userID=jsonparamvalue.get("userId").toString();
		log.info(".......creating json string.......");	
				String jsonbody="{\n"+
				  "\"id\":"+jsonparamvalue.get("id")+",\n"+
				  "\"isAddOrRemoveOrUpdate\":\""+jsonparamvalue.get("isAddOrRemoveOrUpdate")+"\",\n"+
				  "\"objectPermissionList\": [\n{"+
				  "\"attributeExclutionList\": [\n{"+
				  "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("attributeExclutionList_addOrRemoveOrUpdate")+"\",\n"+
				  "\"attributeName\":\""+jsonparamvalue.get("attributeExclutionList_attributeName")+"\",\n"+
				  "\"excluded\":true,\n"+
				  "\"id\":"+jsonparamvalue.get("attributeExclutionList_id")+",\n"+
				  "\"isAddorUpdate\":\""+jsonparamvalue.get("attributeExclutionList_isAddorUpdate")+"\",\n"+
				  "\"objRolePermMapId\":"+jsonparamvalue.get("attributeExclutionList_objRolePermMapId")+ "\n"+
				  "\"objectAttributeId\":"+jsonparamvalue.get("attributeExclutionList_objectAttributeId")+",\n"+
				  "\"objectId\":"+jsonparamvalue.get("attributeExclutionList_objectId")+ "\n"+
				  "\"permissionId\":"+jsonparamvalue.get("attributeExclutionList_permissionId")+",\n"+
				  "\"status\":"+jsonparamvalue.get("attributeExclutionList_status")+ "\n"+
				  "}\n],\n"+		    	  
				  "\"channelId\": \""+jsonparamvalue.get("channelId")+"\",\n"+
				  "\"entityId\": \""+jsonparamvalue.get("entityId")+"\",\n"+
				  "\"entityName\":"+jsonparamvalue.get("entityName")+",\n"+
				  "\"id\":"+jsonparamvalue.get("objectPermissionList_id")+",\n"+
				  "\"isAddOrRemoveOrUpdate\":\""+jsonparamvalue.get("objectPermissionList_isAddOrRemoveOrUpdate")+"\",\n"+
				  "\"moduleId\":"+jsonparamvalue.get("moduleId")+",\n"+
				  "\"moduleName\": \""+jsonparamvalue.get("name")+"\",\n"+
				  "\"objectId\": \""+jsonparamvalue.get("objectId")+"\",\n"+
				  "\"permissionId\": \""+jsonparamvalue.get("permissionId")+"\",\n"+
				  "\"permissionType\":"+jsonparamvalue.get("permissionType")+",\n"+
				  "\"status\":"+jsonparamvalue.get("objectPermissionList_status")+",\n"+
				  "\"subEntityName\":\""+jsonparamvalue.get("subEntityName")+"\",\n"+
				  "}\n],\n"+	
				  "\"roleDto\": {\n"+
				     "\"addOrRemoveOrUpdate\": \""+jsonparamvalue.get("roleDto_addOrRemoveOrUpdate")+"\",\n"+
				      "\"description\":\" "+jsonparamvalue.get("description")+"\",\n"+
				      "\"roleId\": "+jsonparamvalue.get("roleId")+",\n"+
				      "\"roleName\": \""+jsonparamvalue.get("roleName")+"\",\n"+
				      "\"status\":"+jsonparamvalue.get("roleDto_status")+"\n"+
				     "},\n"+
					"\"status\":"+jsonparamvalue.get("status")+"\n"+   
				"}";
				log.info(".......json string created.......");
		return jsonbody;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
	public Response putRequest(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......PUT Request is fired for user ..........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.put();
			//log.info(".....user updated successfully");
		   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
		   		//e.printStackTrace();
		   }return response;
		
		
	}
	
	public Response putRequestForPrivilegeBranchIds(String baseuri,String basepath,Object uid, Object idKey,Map header,String json)
	{
		log.info(".......PUT Request is fired for user :"+uid+""+idKey+".......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/"+idKey+"/privilegeBranchIds")
					.headers(header)
					.body(json)
					.put();
			//log.info(".....user updated successfully");
		   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
		   		//e.printStackTrace();
		   }return response;
		
		
	}
	
	public Response putRequestForRoles(String baseuri,String basepath,Object uid, Object idKey,Map header,String json)
	{
		log.info(".......PUT Request is fired for user :"+uid+""+idKey+".......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/"+idKey+"/roles")
					.headers(header)
					.body(json)
					.put();
			//log.info(".....user updated successfully");
		   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
		   		//e.printStackTrace();
		   }return response;
		
		
	}
	
	public Map<String,Object> getResponse(Response response)
	{
		log.info("......retrieving details of PUT Response...........");
		HashMap<String,Object> resp=new HashMap<String,Object>();
		String responseBody=response.getBody().asString();
		resp.put("ResponseBody",responseBody);
		log.info("Response Body is: "+responseBody);
		//System.out.println("Response Body is: "+responseBody);
		int statusCode=response.getStatusCode();
		resp.put("StatusCode",statusCode);
		log.info("Status code is: "+statusCode);
		//System.out.println("status code is:"+statusCode);
		//String successCode=response.jsonPath().get("SuccessCode");
		//resp.put("SuccessCode",successCode);
		log.info(".........End of PUT Response Details.............");
		return resp;
	}
	
	public void verifyPutSuccess(Response response)
	{
		log.info("...........verifying PUT Request.............");
		try {
			
			//System.out.println(statusCode);
			//System.out.println(successcode);
			int statusCode=0;
			try {
			     statusCode=response.getStatusCode();
			}catch(Exception e) {log.info("status code not retrieved");}
			if(statusCode==200)
			{
			   APIFrameworkDriver.flag=true;
		   	   log.info("...PUT Request successed" );
		   	   //.UtilityClassForAPI.logger.pass("PUT Request passed");
		   	  // System.out.println("Post request success");
		   	   
			}
			else 
			{
				
				throw new Exception();
			}
		    }catch(Exception e) 
			{
		    	APIFrameworkDriver.flag=false;
		    	log.info("...PUT Request not successed" );
		    	JsonPath jp=response.jsonPath();				
				String s=jp.getString("errors");
				UtilityClassForAPI.logger.fail("PUT Request failed :"+s);
		    	
		    }
		}
////////////////////////////usermanagement_BFF-role controller/////////////////////////
	
	public Response updatesRoleWithPermissions(String baseuri,String basepath,Map header,String json)
	{
		log.info(".......PUT Request is fired .......");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.body(json)
					.put();
			//log.info(".....user updated successfully");
		   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
		   		//e.printStackTrace();
		   }return response;
		
		
	}
	
/////////////////////////////usermanagement_BFF-user controller/////////////////
		
		public Response updatesUser_and_or_itsDefaultBranchCode(String baseuri,String basepath,Map header,String json)
		{
			log.info(".......PUT Request is fired .......");
			Response response=null;
			try {
				response=RestAssured.given()
						.baseUri(baseuri)
						.basePath(basepath)
						.headers(header)
						.body(json)
						.put();
				//log.info(".....user updated successfully");
			   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
			   		//e.printStackTrace();
			   }return response;
			
			
		}
		
		public Response UpdateListOfPrivilegeBranch_ids_mappedforUser(String baseuri,String basepath,Map header,String json)
		{
			log.info(".......PUT Request is fired.......");
			Response response=null;
			try {
				response=RestAssured.given()
						.baseUri(baseuri)
						.basePath(basepath+"/"+"privilegeBranchIds")
						.headers(header)
						.body(json)
						.put();
				//log.info(".....user updated successfully");
			   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
			   		//e.printStackTrace();
			   }return response;
			
			
		}
		

		
		public Response UpdatesListOfRolesMappedForUser(String baseuri,String basepath,String uid,String idkey,Map header,String json)
		{
			log.info(".......PUT Request is fired.......");
			Response response=null;
			try {
				response=RestAssured.given()
						.baseUri(baseuri)
						.basePath(basepath+"/"+uid+"/"+idkey+"/roles")
						.headers(header)
						.body(json)
						.put();
				//log.info(".....user updated successfully");
			   }catch(Exception e) {log.info(".....user updation was unsuccessful due to server down");
			   		//e.printStackTrace();
			   }return response;
			
			
		}

	

	
	
	

}
