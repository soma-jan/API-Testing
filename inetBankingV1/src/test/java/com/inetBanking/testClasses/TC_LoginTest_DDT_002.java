package com.inetBanking.testClasses;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginTest_DDT_002 extends BaseClass {
	
	@Test(dataProvider ="LoginData")
	public void loginDDT(String userName ,String password) {
		
		driver.get(baseUrl);
		logger.info("URL entered");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassWord(password);
		lp.btnClick();
		if(isAlertPresent()==true)
		{
			logger.info("Testcase failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
		}else
		{
			logger.info("Testcase passed");
			Assert.assertTrue(true);
		}
		}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert().accept();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{ 
		String path = System.getProperty("user.dir") + "/testData/LoginData.xlsx";
		int rowCount =XLUtils.getRowCount(path, "Sheet1");
		int colCount =XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				logindata[i-1][j] =XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
