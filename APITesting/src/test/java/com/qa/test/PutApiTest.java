package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PutApiTest extends TestBase {
	public String putUrl;
	public String apiUrl;
	public String url;
	CloseableHttpResponse closeableHttpResponse;
	RestClient restclient;
	TestBase testbase ;
	@BeforeMethod
	public void setUp() {
		 testbase = new TestBase();
		apiUrl= prop.getProperty("URL");
		putUrl =prop.getProperty("putUrl");
		url =apiUrl + putUrl;
		
	}
	@Test(priority=1)
    public void PostApiTest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient =new RestClient();
		HashMap<String,String> header =new HashMap<String,String>();
		header.put("Content-Type", "application/json");
		ObjectMapper mapper =new ObjectMapper();
		Users user= new Users("morpheus","zion resident","2");
		mapper.writeValue(new File(System.getProperty("user.dir")+"/src/main/java/com/qa/data/user.json"), user);
		
		String userJson = mapper.writeValueAsString(user);
		System.out.println(url);
		closeableHttpResponse=restclient.put(url, userJson, header);
		
		int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
	    System.out.print(statusCode);
	    Assert.assertEquals(statusCode, testbase.RESPONSE_STATUS_CODE_200);
	    
	    String resString =EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	    JSONObject resJson = new JSONObject(resString);
	    System.out.print(resString);
	    Users objUser =mapper.readValue(resString, Users.class);
	    Assert.assertEquals(user.getName(),(objUser.getName()));
		
	
	}

}
