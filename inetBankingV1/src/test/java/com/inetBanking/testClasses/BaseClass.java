package com.inetBanking.testClasses;


import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;




public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseUrl =readconfig.getApplicationUrl();
	public String userName =readconfig.getUsername();
	public String passWord =readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger ;
	
@Parameters("browser")	
@BeforeClass
public void setUp(String br)
{
		
		logger = Logger.getLogger(BaseClass.class);;
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver =new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirepath());
			driver =new FirefoxDriver();	
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
			driver =new EdgeDriver();
		}
		/*@SuppressWarnings("deprecation")
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		WebEventListener eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		 
}
@AfterClass
public void tearDown()
{
	driver.quit();
}
public  void captureScreen(WebDriver driver, String tname) {
	TakesScreenshot ts =(TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File (System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	try {
		FileUtils.copyFile(source, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Screenshot taken");
	
}
public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}

}