package com.san.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.san.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC001_Get_All_Employees extends TestBase {

	
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("**************************** started All employee *******************************************");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		Thread.sleep(3);
		
		
	}
	
	@Test
	void checkResponseBody()
	{
		
		logger.info("******************checking Response body for all employees get method *******************************");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body-->"+ responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
	
	
	@Test
	void checkStatusCode()
	{
		
		logger.info("******************checking Status code is 200 for all employees get method *******************************");
		
		int responseCode = response.statusCode();
		logger.info("Response code should be 200-->"+ responseCode);
		Assert.assertTrue(responseCode==200);
		
	}
	
	@Test
	void checkStatusLine()
	{
		
		logger.info("******************checking Status Line for all employees get method *******************************");
		
		String responseStatusLine = response.statusLine();
		logger.info("Response Status Line should be HTTP/1.1 200 OK-->"+ responseStatusLine);
		Assert.assertEquals(responseStatusLine,"HTTP/1.1 200 OK");
		
	}
	
	
	@Test
	void checkResponseTime()
	{
		
		logger.info("******************checking Response Time for all employees get method *******************************");
		
		long responseTime = response.getTime();
		logger.info("Response Time should be < 600 ms -->"+ responseTime);
		
		if(responseTime > 601)
			logger.warn("The response time is more than 2000");
		Assert.assertTrue(responseTime<=600);
		
	}
	
	@Test
	void checkContentType()
	{
		
		logger.info("******************checking Response Content Type for all employees get method *******************************");
		
		String responseContentType = response.getContentType();
		logger.info("Response Content Type should text/html; charset=UTF-8 -->"+ responseContentType);
		Assert.assertEquals(responseContentType,"application/json;charset=utf-8");
		
	}
	
	@Test
	void checkServerType()
	{
		
		logger.info("******************checking Response Server Type for all employees get method *******************************");
		
		String responseServerType = response.header("Server");
		logger.info("Response  Server Type should be nginx/1.16.0 -->"+ responseServerType);
		Assert.assertEquals(responseServerType,"nginx/1.16.0");
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("************************Finished All employee *************************************************************** ");
	}
}
