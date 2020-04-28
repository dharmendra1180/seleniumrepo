package com.safexp.MDM.automation.managerClasses;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.safexp.MDM.automation.Utility.UtilityClass;

public class HybridFrameworkDriver {
	static Logger log=Logger.getLogger(HybridFrameworkDriver.class.getName());
	public static void hybridTestAutomation(String testid,String testname,String module,String submodule,String testdatapath,String scriptpath)
	{
		String pagename=null;
		String methodname=null;
		
		try {
			
	/* create connection with data source*/
		Fillo f=new Fillo();
		Connection con=f.getConnection(scriptpath);
				
	/* select all the steps for current testcaseid*/	
		Recordset rs1=con.executeQuery("select * from "+submodule+" where TestCaseID='"+testid+"'");
	/* gettestdata for current testcaseid*/
		ReadExcelData.readData(testdatapath,testid,module,submodule);
	/* execute the current testcase for each set of data*/	
		rs1.next();
		
		while(ReadExcelData.DataIt.hasNext())
		{
			//log.info("calling initeration");
			UtilityClass.Initeration();
			//log.info("after initeration");
			
			
			do
	    	{
		    
			String javaclassName=rs1.getField("pagesheet");
			String methodName=rs1.getField("pagekeyword");
			pagename=javaclassName;
			methodname=methodName;
			//log.info(javaclassName);
		//	log.info(methodName);
			Recordset rs2=con.executeQuery("select * from "+javaclassName+" where pagekeyword='"+methodName+"'"); 
			int fieldcount=rs2.getFieldNames().size();
			int count=0;
		//	log.info(fieldcount);
			rs2.next();
			
			List<String> parameterList=new ArrayList<String>();
				for(int i=1;i<fieldcount;i++)
				{   
					String fieldname=rs2.getField(i).value();
					//log.info(fieldname);
					if(fieldname!=null&&fieldname.trim().equalsIgnoreCase("")==false)
					{
					parameterList.add(rs2.getField(i).value());
					count++;
					}
					else
					{
						break;
					}
					
				}
			
				//log.info(count);
					
						switch(count)
						{
						case 0: Class cls=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj=cls.newInstance();
							    Method m=cls.getMethod(methodName,null);
							    m.invoke(obj,null);  
								//log.info("in case 0");
								break;				
						case 1: //log.info("entered in case 1");
							    Class cls1=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj1=cls1.newInstance();
								Method m1=cls1.getMethod(methodName,String.class);
								String s=parameterList.get(0);
								//log.info(s);
								String p=ReadExcelData.DataMap.get(s);
								//log.info(p);
								m1.invoke(obj1,p);						          
								break;
						case 2: Class cls2=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj2=cls2.newInstance();
								Method m2=cls2.getMethod(methodName,String.class,String.class);
								String p1=ReadExcelData.DataMap.get(parameterList.get(0));
								String p2=ReadExcelData.DataMap.get(parameterList.get(1));						
							    m2.invoke(obj2,p1,p2);
							    //log.info("in case 2");
							    break; 						    
						case 3: Class cls3=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
	                        	Object obj3=cls3.newInstance();
	                        	Method m3=cls3.getMethod(methodName,String.class,String.class,String.class);
	                        	String p3=ReadExcelData.DataMap.get(parameterList.get(0));
	                        	String p4=ReadExcelData.DataMap.get(parameterList.get(1));
	                        	String p5=ReadExcelData.DataMap.get(parameterList.get(2));
				            	m3.invoke(obj3,p3,p4,p5);							   								
								//log.info("in case 3");
								break;
						case 4: Class cls4=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
                    			Object obj4=cls4.newInstance();
                    			Method m4=cls4.getMethod(methodName,String.class,String.class,String.class,String.class);
                    			String p6=ReadExcelData.DataMap.get(parameterList.get(0));
                    			String p7=ReadExcelData.DataMap.get(parameterList.get(1));
                    			String p8=ReadExcelData.DataMap.get(parameterList.get(2));
                    			String p9=ReadExcelData.DataMap.get(parameterList.get(3));
                    			m4.invoke(obj4,p6,p7,p8,p9);							   								
                    			//log.info("in case 4");
                    			break;
						case 5: Class cls5=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
            					Object obj5=cls5.newInstance();
		            			Method m5=cls5.getMethod(methodName,String.class,String.class,String.class,String.class,String.class);
		            			String p10=ReadExcelData.DataMap.get(parameterList.get(0));
		            			String p11=ReadExcelData.DataMap.get(parameterList.get(1));
		            			String p12=ReadExcelData.DataMap.get(parameterList.get(2));
		            			String p13=ReadExcelData.DataMap.get(parameterList.get(3));
		            			String p14=ReadExcelData.DataMap.get(parameterList.get(4));
		            			m5.invoke(obj5,p10,p11,p12,p13,p14);							   								
		            			//log.info("in case 5");
		            			break;
						case 6: Class cls6=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
            					Object obj6=cls6.newInstance();
            					Method m6=cls6.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class);
            					String p31=ReadExcelData.DataMap.get(parameterList.get(0));
            					String p15=ReadExcelData.DataMap.get(parameterList.get(1));
            					String p16=ReadExcelData.DataMap.get(parameterList.get(2));
            					String p17=ReadExcelData.DataMap.get(parameterList.get(3));
            					String p18=ReadExcelData.DataMap.get(parameterList.get(4));
            					String p19=ReadExcelData.DataMap.get(parameterList.get(5));
            					m6.invoke(obj6,p31,p15,p16,p17,p18,p19);							   								
            					//log.info("in case 6");
            					break;
						case 7: Class cls7=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
    							Object obj7=cls7.newInstance();
		    					Method m7=cls7.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
		    					String p45=ReadExcelData.DataMap.get(parameterList.get(0));
		    					String p46=ReadExcelData.DataMap.get(parameterList.get(1));
		    					String p47=ReadExcelData.DataMap.get(parameterList.get(2));
		    					String p48=ReadExcelData.DataMap.get(parameterList.get(3));
		    					String p49=ReadExcelData.DataMap.get(parameterList.get(4));
		    					String p50=ReadExcelData.DataMap.get(parameterList.get(5));
		    					String p51=ReadExcelData.DataMap.get(parameterList.get(6));
		    					m7.invoke(obj7,p45,p46,p47,p48,p49,p50,p51);							   								
		    					//log.info("in case 7");
		    					break;
						case 8: Class cls8=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj8=cls8.newInstance();
								Method m8=cls8.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
								String p67=ReadExcelData.DataMap.get(parameterList.get(0));
								String p68=ReadExcelData.DataMap.get(parameterList.get(1));
								String p69=ReadExcelData.DataMap.get(parameterList.get(2));
								String p70=ReadExcelData.DataMap.get(parameterList.get(3));
								String p71=ReadExcelData.DataMap.get(parameterList.get(4));
								String p72=ReadExcelData.DataMap.get(parameterList.get(5));
								String p73=ReadExcelData.DataMap.get(parameterList.get(6));
								String p74=ReadExcelData.DataMap.get(parameterList.get(7));
								m8.invoke(obj8,p67,p68,p69,p70,p71,p72,p73,p74);							   								
								//log.info("in case 8");
								break;
						case 9: Class cls9=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
								Object obj9=cls9.newInstance();
								Method m9=cls9.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
								String p85=ReadExcelData.DataMap.get(parameterList.get(0));
								String p86=ReadExcelData.DataMap.get(parameterList.get(1));
								String p87=ReadExcelData.DataMap.get(parameterList.get(2));
								String p88=ReadExcelData.DataMap.get(parameterList.get(3));
								String p89=ReadExcelData.DataMap.get(parameterList.get(4));
								String p90=ReadExcelData.DataMap.get(parameterList.get(5));
								String p91=ReadExcelData.DataMap.get(parameterList.get(6));
								String p92=ReadExcelData.DataMap.get(parameterList.get(7));
								String p93=ReadExcelData.DataMap.get(parameterList.get(8));
								m9.invoke(obj9,p85,p86,p87,p88,p89,p90,p91,p92,p93);							   								
								//log.info("in case 8");
								break;
						case 10:Class cls10=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
			   					 Object obj10=cls10.newInstance();
			   					 Method m10=cls10.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
			   					 String p75=ReadExcelData.DataMap.get(parameterList.get(0));
			   					 String p76=ReadExcelData.DataMap.get(parameterList.get(1));
			   					 String p77=ReadExcelData.DataMap.get(parameterList.get(2));
			   					 String p78=ReadExcelData.DataMap.get(parameterList.get(3));
			   					 String p79=ReadExcelData.DataMap.get(parameterList.get(4));
			   					 String p80=ReadExcelData.DataMap.get(parameterList.get(5));
			   					 String p81=ReadExcelData.DataMap.get(parameterList.get(6));
			   					 String p82=ReadExcelData.DataMap.get(parameterList.get(7));
			   					 String p83=ReadExcelData.DataMap.get(parameterList.get(8));
			   					 String p84=ReadExcelData.DataMap.get(parameterList.get(9));
			   								
			   					 m10.invoke(obj10,p75,p76,p77,p78,p79,p80,p81,p82,p83,p84);							   								
			   					//log.info("in case 10");
			   					 break;
			
						case 11:Class cls11=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
		    					 Object obj11=cls11.newInstance();
		    					 Method m11=cls11.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
		    					 String p20=ReadExcelData.DataMap.get(parameterList.get(0));
		    					 String p21=ReadExcelData.DataMap.get(parameterList.get(1));
		    					 String p22=ReadExcelData.DataMap.get(parameterList.get(2));
		    					 String p23=ReadExcelData.DataMap.get(parameterList.get(3));
		    					 String p24=ReadExcelData.DataMap.get(parameterList.get(4));
		    					 String p25=ReadExcelData.DataMap.get(parameterList.get(5));
		    					 String p26=ReadExcelData.DataMap.get(parameterList.get(6));
		    					 String p27=ReadExcelData.DataMap.get(parameterList.get(7));
		    					 String p28=ReadExcelData.DataMap.get(parameterList.get(8));
		    					 String p29=ReadExcelData.DataMap.get(parameterList.get(9));
		    					 String p30=ReadExcelData.DataMap.get(parameterList.get(10));

		    					 m11.invoke(obj11,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30);							   								
		    					//log.info("in case 11");
		    					 break;
						case 13: Class cls13=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
			    					Object obj13=cls13.newInstance();
			    					Method m13=cls13.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
			    					String p32=ReadExcelData.DataMap.get(parameterList.get(0));
			    					String p33=ReadExcelData.DataMap.get(parameterList.get(1));
			    					String p34=ReadExcelData.DataMap.get(parameterList.get(2));
			    					String p35=ReadExcelData.DataMap.get(parameterList.get(3));
			    					String p36=ReadExcelData.DataMap.get(parameterList.get(4));
			    					String p37=ReadExcelData.DataMap.get(parameterList.get(5));
			    					String p38=ReadExcelData.DataMap.get(parameterList.get(6));
			    					String p39=ReadExcelData.DataMap.get(parameterList.get(7));
			    					String p40=ReadExcelData.DataMap.get(parameterList.get(8));
			    					String p41=ReadExcelData.DataMap.get(parameterList.get(9));
			    					String p42=ReadExcelData.DataMap.get(parameterList.get(10));
			    					String p43=ReadExcelData.DataMap.get(parameterList.get(11));
			    					String p44=ReadExcelData.DataMap.get(parameterList.get(12));
			    					m13.invoke(obj13,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44);							   								
			    					//log.info("in case 13");
			    					break;
							case 15: Class cls15=Class.forName("com.safexp.MDM.automation.pagelibrary."+javaclassName);
			    					Object obj15=cls15.newInstance();
			    					Method m15=cls15.getMethod(methodName,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class);
			    					String p53=ReadExcelData.DataMap.get(parameterList.get(0));
			    					String p54=ReadExcelData.DataMap.get(parameterList.get(1));
			    					String p55=ReadExcelData.DataMap.get(parameterList.get(2));
			    					String p56=ReadExcelData.DataMap.get(parameterList.get(3));
			    					String p57=ReadExcelData.DataMap.get(parameterList.get(4));
			    					String p58=ReadExcelData.DataMap.get(parameterList.get(5));
			    					String p59=ReadExcelData.DataMap.get(parameterList.get(6));
			    					String p60=ReadExcelData.DataMap.get(parameterList.get(7));
			    					String p61=ReadExcelData.DataMap.get(parameterList.get(8));
			    					String p62=ReadExcelData.DataMap.get(parameterList.get(9));
			    					String p63=ReadExcelData.DataMap.get(parameterList.get(10));
			    					String p64=ReadExcelData.DataMap.get(parameterList.get(11));
			    					String p65=ReadExcelData.DataMap.get(parameterList.get(12));
			    					String p66=ReadExcelData.DataMap.get(parameterList.get(13));
			    					String p94=ReadExcelData.DataMap.get(parameterList.get(14));
			    					m15.invoke(obj15,p53,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63,p64,p65,p66,p94);							   								
			    					//log.info("in case 15");
			    					break;

				            
						default:log.info("invalid option");
					}//switch		
				}while(rs1.next());//while
			rs1.moveFirst();
			//Thread.sleep(3000);
		}//while
//Testcase finished		
		
		}catch(Exception e) 
		{
			UtilityClass.logger.fail("testfailed");
			UtilityClass.logger.error("Method \""+methodname+"\" of page \""+pagename+"\" has been failed");
			log.info("Method \""+methodname+"\" of page \""+pagename+"\" has been failed");
			UtilityClass.extent.flush();
			//UtilityClass.driver.close();
	        Verify.verify(false);
	        
		}
		
	}
	

}
