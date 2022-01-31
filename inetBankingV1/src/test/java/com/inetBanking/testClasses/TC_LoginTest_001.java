     package com.inetBanking.testClasses;





import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import com.inetBanking.PageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest()
	
	{
		
		driver.get(baseUrl);
		logger.info("URL entered");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username entered");
		
		lp.setPassWord(passWord);
		logger.info("password entered");
		
		lp.btnClick();
		
		String title = driver.getTitle();
		System.out.print(title);
		if(title.equals("GTPL Bank Manager HomePage"))
		{
			 Assert.assertTrue(true);
			 logger.info("GetTitle testcase passed");
		}
		else 
		
		{
			captureScreen(driver ,"LoginTest");
			Assert.assertTrue(false);
			logger.info("GetTitle testcase failed");
		}
		
			
		}}
		//System.out.println("before test shown");
	/*	try {
		    driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in...')]")).isDisplayed();
		    Assert.assertTrue(true);
		 	logger.info("GetTitle testcase passed");
			}
		catch (Exception e) {
				captureScreen(driver ,"LoginTest");
				Assert.assertTrue(false);
				logger.info(e);
			}

		
	}

	

}*/
