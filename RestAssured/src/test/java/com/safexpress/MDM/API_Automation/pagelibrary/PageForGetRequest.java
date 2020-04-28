package com.safexpress.MDM.API_Automation.pagelibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;
import com.safexpress.MDM.API_Automation.managerClass.ReadExcelData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PageForGetRequest {
	
	Logger log=Logger.getLogger(PageForGetRequest.class.getName());

	public Map<String,Object> getDetailsOf(Response rs)
	{
		log.info("......retrieving details of GET Response...........");
		Map<String,Object> details=new HashMap<String,Object>();
		Response response=rs;
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
		log.info("........end of details of GET Response........");
		return details;
	}
	
	public void verifyGetSuccess(Response response)
	{
		//log.info("Verifying the status code");
		log.info(".........verifying GET success.....");
				
		try {
			int statusCode=0;
			try {
			     statusCode=response.getStatusCode();
			}catch(Exception e) {log.info("status code not retrieved");}
			if(statusCode==200)
			{
				APIFrameworkDriver.flag=true;
		   	   log.info("...GET Request successed" );
		   	  // UtilityClassForAPI.logger.pass("GET Request passed");
		   	  // System.out.println("Post request success");
		   	   
			}
			else 
			{
				
				throw new Exception();
			}
		}catch(Exception e) 
		{
			APIFrameworkDriver.flag=false;
			log.info("...GET Request not successed" );
			JsonPath jp=response.jsonPath();				
			String s=jp.getString("errors");
			UtilityClassForAPI.logger.fail("GET Request failed :"+s);
	    	//System.out.println("user exist");
	    	//Assert.fail();
	    	//e.printStackTrace();
	    }
		
		    	
	}
	
	public String getUIdOfExistingUserId(Response response,String userID) 
	{ 
		log.info("retrieving Id of user "+userID);
		response.prettyPrint();
		JsonPath jp=response.jsonPath();
		
		ArrayList<String> s=jp.get("userId");
		ArrayList<Integer> s1=jp.get("id");
		int count=s.size();
		
		for(int i=0;i<count;i++)
		{
			if((s.get(i)).equalsIgnoreCase(userID))
			{
				log.info("user found and now retrieving its Id");
				PageForPostRequest.userID=s.get(i);
		    	PageForPostRequest.uId=s1.get(i);
		    	log.info("user Id is: "+PageForPostRequest.uId+" for user:"+PageForPostRequest.userID);
		    	break;
				
			}
		}
		
		log.info("Id retrieval done");      
		//System.out.println(userID+" "+PageForPostRequest.uId);
		return (Integer.toString(PageForPostRequest.uId));
	}
	
	

	public Object[][] getRandomUserIdAlongWithId(Response response)
	{
		log.info("......Retrieving user and its Id on random basis.........");
		Object[][] obj=null;
		try {
		JsonPath jp=response.jsonPath();
		ArrayList<String> s=jp.get("userId");
		ArrayList<Integer> s1=jp.get("id");
		obj=new Object[1][2];
		for(int i=0;i<s.size();i++) {
		if(s.get(i).equalsIgnoreCase("USER1")||s.get(i).equalsIgnoreCase("USER2")||s.get(i).equalsIgnoreCase("USER3")||s.get(i).equalsIgnoreCase("USER4")||s.get(i).equalsIgnoreCase("USER5"))
		{ 
		 continue;
		
		}
		else
		{
			
			obj[0][0]=s.get(i);
			obj[0][1]=s1.get(i);
			log.info("...retrieved user is:"+obj[0][0]+" and itd Id is:"+obj[0][1]);
			break;
		}
		}
		
		log.info("......user retrieval on random basis is done.......");
		}catch(Exception e) {log.info("failed to retrieve data");}
		
		return obj;
			
	}
	
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
	
	public Response getResponseOfaUser(String baseuri,String basepath,Map header,String userId)
	{   
		log.info(".......GET Request is fired for "+userId+"........");
		//String userid=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+userId)
					
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	
	public Response getResponseOfaUserInAD(String baseuri,String basepath,Map header,String uid)
	{   
		log.info(".......GET Request is fired for "+uid+"........");
		//String userid=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/AD")
					
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	
	public Response getResponseOfaUserForPrivilegeBranchIds(String baseuri,String basepath,Map header,String uid)
	{   
		log.info(".......GET Request is fired for "+uid+"........");
		//String userid=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/privilegeBranchIds")
					
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	
	public Response getResponseOfListOfRolesMappedForUser(String baseuri,String basepath,Map header,String uid)
	{   
		log.info(".......GET Request is fired for "+uid+"........");
		//String userid=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/roles")
					
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	public Response getResponse_All(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
		
	}
	
	public Response getResponseOfRole(String baseuri,String basepath,Map header,String roleId)
	{   
		log.info(".......GET Request is fired for "+roleId+"........");
		//String userid=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+roleId)
					
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	public Response getResponse_AllRole(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
		
	}
	
	public Response getResponseOfObject(String baseuri,String basepath,Map header,String objectId)
	{   
		log.info(".......GET Request is fired for "+objectId+"........");
		//String objectId=PageForPostRequest.userID;
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+objectId)
					
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {log.info(".......GET Request  could not processed since server not responding........");//e.printStackTrace();
		   
		   }
		
		return response;
		
	}
	public Response getResponse_AllObject(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
		
	}
	
///////usermanagement BFF Authentication and Authorization////////////////////

	public Response getMenuDetails(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
		
	}
	
	public Response getUserPermissionsDetails(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
//////////////////Object_Operation_service///////////////////////////////

	public Response getObjectListDetails(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response GetLast_n_UpdatedObjectDetails(String baseuri,String basepath,String number,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		int n=Integer.parseInt(number);
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+n)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response getAllObjectsNamesMatchingWildSearchCharacters(String baseuri,String basepath,String objectname,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+objectname)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	
///////////////////branch controller///////////////////////////////////////	
	
	public Response getBranchListDetailsSortedByBranchName(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response getListOfLatest_N_CreatedBranchesBasedOnInputNumber(String baseuri,String basepath,String number,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		int n=Integer.parseInt(number);
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+n)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response getBranchDetailsBySearchCriteria(String baseuri,String basepath,String searchCriteria,String criteriaValue,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+searchCriteria+"/"+criteriaValue)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response getBranchDetailsByBranchCode(String baseuri,String basepath,String branchcode,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+branchcode)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response geListOfBranchesWithWildSearch(String baseuri,String basepath,String branchname,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+branchname)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response getListOfPinCodesMatchingSearchCharacters(String baseuri,String basepath,String pincodeSearchCharacters,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+pincodeSearchCharacters)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	public Response getListOfAllTypesOfBranches(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
////////////////////role controller//////////////////////////////////
	
	public Response getPermissionsOf_a_Role(String baseuri,String basepath,String roleId,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+roleId+"/permissions")
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getLast_n_updatedRoleDetails(String baseuri,String basepath,String number,Map header)
	{   
		log.info(".......GET Request is fired........");
		int n=Integer.parseInt(number);
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+n)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getLookupValuesFor_a_LookupType(String baseuri,String basepath,String lookuptype,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+lookuptype)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getAllPermissions(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getAllRolesBasedOnWildSearchOfRoleName(String baseuri,String basepath,String rolename,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+rolename)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getAllRoles(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
///////////////////////////user controller//////////////////////////////////
	
	public Response getDetailsOfAllUsers(String baseuri,String basepath,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getDetailsOfUserWith_id_OfItsDefaultBranch(String baseuri,String basepath,String uid,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getUserIn_AD(String baseuri,String basepath,String uid,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/AD")
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getListOfPrevilegeBranch_Ids_MappedForUser(String baseuri,String basepath,String uid,Map header)
	{   
		log.info(".......GET Request is fired........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/privilegeBranchIDs")
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getListOfRolesMappedForUser(String baseuri,String basepath,String uid,Map header)
	{   
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid+"/roles")
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getLast_n_UpdatedUserDetails(String baseuri,String basepath,String number,Map header)
	{   
		log.info(".......GET Request is fired .......");
		Response response=null;
		int n=Integer.parseInt(number);
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+n)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getDetailsOfAllUsersOnWildSearchOfName(String baseuri,String basepath,String userName,Map header)
	{   
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+userName)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getDetailsOfAllUsersOnWildSearchOfUserId(String baseuri,String basepath,String uid,Map header)
	{   
		log.info(".......GET Request is fired for All........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+uid)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
/////////////////////////////////Credit Contract Ratecard Controller//////////////////////////////////
	
	
	public Response getBranchByContractId(String baseuri,String basepath,String contractId,Map header)
	{   
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+contractId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getBranchByRatrcardId(String baseuri,String basepath,Map header,String ratecardId)
	{   
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getCommercialByCommercialId(String baseuri,String basepath,Map header,String commercialId)
	{   
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+commercialId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		   }catch(Exception e) {//e.printStackTrace();
		   }
		return response;
	}
	
	public Response getCommercialsByRateCardId(String baseuri,String basepath,Map header,String ratecardId)

	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
			
		}
			return response;
		}
	
	public Response getRateCardById(String baseuri,String basepath,Map header,String ratecardId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri).basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
		}
		return response;
	}
	
	public Response getRateCardByContractId(String baseuri,String basepath,Map header,String contractId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri)
					.basePath(basepath+"/"+contractId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printstackTrace();
			
		}
		return response;
	}

	public Response getSafextSlaByRateCardId(String baseuri,String basepath,Map header,String ratecardId)
{
	log.info(".......GET Request is fired ........");
	Response response=null;
	try {
		response=RestAssured.given()
				.baseUri(baseuri)
				.basePath(basepath+"/"+ratecardId)
				.headers(header)
				.get();
		log.info(".....GET Request has been processed");
	}
	catch(Exception e) {//e.printStackTrace();
	}
	return response;
	}
	
	public Response getTncById(String baseuri,String basepath,Map header,String tncId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri).basePath(basepath+"/"+tncId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
		}
		return response;
	}
	public Response getTncByRateCardId(String baseuri,String basepath,Map header,String ratecardId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri).basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
		}
		return response;
	}
	
	public Response getVmiByRateCardId(String baseuri,String basepath,Map header,String ratecardId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri).basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
		}
		return response;
	}
	
	public Response getZmCustomeSlaByRateCardId(String baseuri,String basepath,Map header,String ratecardId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri).basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
		}
		return response;
	}
	
	public Response getZmSlaByRateCardId(String baseuri,String basepath,Map header,String ratecardId)
	{
		log.info(".......GET Request is fired ........");
		Response response=null;
		try {
			response=RestAssured.given()
					.baseUri(baseuri).basePath(basepath+"/"+ratecardId)
					.headers(header)
					.get();
			log.info(".....GET Request has been processed");
		}
		catch(Exception e)
		{//e.printStackTrace();
		}
		return response;
	}
}

