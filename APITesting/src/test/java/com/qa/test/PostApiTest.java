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
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostApiTest extends TestBase{
	public String userUrl;
	public String apiUrl;
	public String url;
	CloseableHttpResponse closeableHttpResponse;
	RestClient restclient;
	TestBase testbase ;
	@BeforeMethod
	public void setUp() {
		 testbase = new TestBase();
		apiUrl= prop.getProperty("URL");
		userUrl =prop.getProperty("userUrl");
		url =apiUrl + userUrl;
		
	}

	@Test(priority=1)
    public void PostApiTest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient =new RestClient();
		HashMap<String,String> header =new HashMap<String,String>();
		header.put("Content-Type", "application/json");
		//json
		ObjectMapper mapper =new ObjectMapper();
		Users user= new Users("morpheus","leader");
		mapper.writeValue(new File(System.getProperty("user.dir")+"/src/main/java/com/qa/data/user.json"), user);
		
		String userJson = mapper.writeValueAsString(user);
		System.out.println(url);
		closeableHttpResponse=restclient.post(url, userJson, header);
		
		int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
	    System.out.print(statusCode);
	    Assert.assertEquals(statusCode, testbase.RESPONSE_STATUS_CODE_201);
	    
	    String resString =EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	    JSONObject resJson = new JSONObject(resString);
	    System.out.print(resString);
	    
	    //
	    Users objUser =mapper.readValue(resString, Users.class);
	    System.out.print(objUser.getId());
	    Assert.assertEquals(user.getName(),(objUser.getName()));
	    
	    
	}
}