package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase{
	public String serviceUrl;
	public String apiUrl;
	public String url;
	CloseableHttpResponse closeableHttpResponse;
	
	@BeforeMethod
	public void setUp() {
		TestBase testbase = new TestBase();
		serviceUrl= prop.getProperty("URL");
		apiUrl =prop.getProperty("serviceURL");
		url =serviceUrl + apiUrl+"/2";
		
	}

	
	public void getapiwithoutHeader() throws ClientProtocolException, IOException {
		RestClient rc =new RestClient();
		closeableHttpResponse  =rc.get(url);
		//get Status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("StatusCode-->"+statusCode);
		
		//getjson
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		JSONObject respoJsonObject =new JSONObject(responseString);
		System.out.println("JSON Response-->"+respoJsonObject);
		
		//get header
		Header[] headArray = closeableHttpResponse.getAllHeaders();
		HashMap<String,String> HeaderhashMap = new HashMap<String, String>();
		for (Header header:headArray)
		{
			HeaderhashMap.put(header.getName(), header.getValue());
		}
		for (Header header:headArray)
		{
			System.out.println(header.getName()+"--->"+ header.getValue());
		}
		
		
	}
	@Test(priority=1)
	public void getapiwithtHeader() throws ClientProtocolException, IOException {
		RestClient rc =new RestClient();
		//pass header
		HashMap<String,String> HeaderMap = new HashMap<String, String>();
		HeaderMap.put("Content-Type", "application/XML");
		
		closeableHttpResponse  =rc.get(url,HeaderMap);
		
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("StatusCode-->"+statusCode);
	
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		JSONObject respoJsonObject =new JSONObject(responseString);
		System.out.println("JSON Response-->"+respoJsonObject);
		
		//get header
				Header[] headArray = closeableHttpResponse.getAllHeaders();
				HashMap<String,String> HeaderhashMap = new HashMap<String, String>();
				for (Header header:headArray)
				{
					HeaderhashMap.put(header.getName(), header.getValue());
				}
				for (Header header:headArray)
				{
					System.out.println(header.getName()+"--->"+ header.getValue());
				}
	
}}
