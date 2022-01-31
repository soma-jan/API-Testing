package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop = new Properties();
	FileInputStream ip = null;
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;
	public int RESPONSE_STATUS_CODE_204 = 204;
	
public TestBase() 
{ 
	
	try {
		ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();
	}

	
}
}
