package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig{
	public Properties pro;
	public	ReadConfig(){
	
	
	File src = new File("./configuration/config.properties");
	try {
		FileInputStream fis  =new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}catch(Exception e){
		System.out.println(e);
		
	}
	}
	
public String getApplicationUrl()
{
	String Url = pro.getProperty("baseUrl");
	return Url;
	
}
public String getUsername()
{
	String username = pro.getProperty("username");
	return username;
}
public String getPassword()
{
	String password = pro.getProperty("password");
	return password;
}
public String getChromepath()
{
	String chromepath = pro.getProperty("chromepath");
	return chromepath;
}
public String getFirepath()
{
	String firepath = pro.getProperty("firepath");
	return firepath;
}
public String getEdgepath()
{
	String edgepath = pro.getProperty("edgepath");
	return edgepath;
}

}