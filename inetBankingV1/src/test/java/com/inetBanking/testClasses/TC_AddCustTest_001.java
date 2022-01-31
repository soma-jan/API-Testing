package com.inetBanking.testClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddNewCustomer;
import com.inetBanking.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustTest_001 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.get(baseUrl);
		logger.info("URL entered");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username entered");
		
		lp.setPassWord(passWord);
		logger.info("password entered");
		
		lp.btnClick();
		
		//Thread.sleep(3000);
		//driver.switchTo().frame("prime-popover-div");
		
	//	driver.findElement(By.id("prime-popover-close-button")).click();

	//	driver.switchTo().defaultContent();
		AddNewCustomer addcust=new AddNewCustomer(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		Thread.sleep(3000);
		
		addcust.custName("Soma");
		addcust.custgender("female");
		addcust.custdob("10","15","1990");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("CA");
		addcust.custstate("ON");
		addcust.custpinno("M1X1S4");
		addcust.custtelephoneno("647148565");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	

}
