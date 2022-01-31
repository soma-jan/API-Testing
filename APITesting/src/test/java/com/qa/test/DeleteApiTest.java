package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class DeleteApiTest extends TestBase {
	public String deleteUrl;
	public String apiUrl;
	public String url;
	CloseableHttpResponse closeableHttpResponse;
	RestClient restclient;
	TestBase testbase ;
	@BeforeMethod
	public void setUp() {
		 testbase = new TestBase();
		apiUrl= prop.getProperty("URL");
		deleteUrl =prop.getProperty("deleteUrl");
		url =apiUrl + deleteUrl;
		
	}
	@Test(priority=1)
    public void DeleteApiTest() throws ClientProtocolException, IOException  {
		restclient =new RestClient();
	    closeableHttpResponse=restclient.delete(url);
		
		int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
	    System.out.print(statusCode);
	    Assert.assertEquals(statusCode, testbase.RESPONSE_STATUS_CODE_204);

}}
