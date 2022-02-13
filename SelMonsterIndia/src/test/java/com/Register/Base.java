package com.Register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public static WebDriver driver;
	@BeforeTest
	  public void setup() {
		  
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma.000\\Downloads\\SoftwareTesting\\chromedriver_win32\\chromedriver.exe");
		    driver =new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://recruiter.monsterindia.com/v2/recruiter-sign-up.html/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			
			
	  }
	public void failed() throws InterruptedException, IOException
	{
		{
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(2000);;
			/*FileUtils.copyFile(src, new File ("C://Users//soma.000//eclipse-workspace//MyFirstJavaProject//src//Testng//google.png"));*/
			FileUtils.copyFile(src, new File ("ff.png"));
			}
	

}

	
	 @AfterTest
	  public void tearDown()
	  {
		//driver.close();
		 
	  }


}
