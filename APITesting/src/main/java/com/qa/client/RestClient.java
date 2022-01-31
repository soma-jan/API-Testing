package com.qa.client;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.qa.base.TestBase;

public class RestClient extends TestBase{
	
	/*public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		
		return closebaleHttpResponse;}*/
	public CloseableHttpResponse  get(String url) throws ClientProtocolException, IOException 
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget =new HttpGet(url);
		CloseableHttpResponse closehttpresponse = httpClient.execute(httpget);
		return closehttpresponse;
	}


	public CloseableHttpResponse get(String url,HashMap<String,String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpget = new HttpGet(url); //http get request
		for(Entry<String, String> entry : headerMap.entrySet()){
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
		
		return closebaleHttpResponse;
}
//POST
	public CloseableHttpResponse post(String url,String strEntity,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost =new HttpPost(url);
		httppost.setEntity(new StringEntity(strEntity));
		//Student.forEach((k,v)->System.out.println(k+"-->"+v));
		for(Map.Entry<String, String > entry :headerMap.entrySet())
		{
			httppost.addHeader(entry.getKey(),entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httppost); //hit the post URL
		
		return closebaleHttpResponse;
		}
	//PUT	
	public CloseableHttpResponse put(String url,String strEntity,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpput =new HttpPut(url);
		httpput.setEntity(new StringEntity(strEntity));
		//Student.forEach((k,v)->System.out.println(k+"-->"+v));
		for(Map.Entry<String, String > entry :headerMap.entrySet())
		{
			httpput.addHeader(entry.getKey(),entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpput); //hit the post URL
		
		return closebaleHttpResponse;
		}
	
	//delete
	public CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpdelete =new HttpDelete(url);
		
		
		CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpdelete); //hit the post URL
		
		return closebaleHttpResponse;
		}
		
		
		
		
	}






