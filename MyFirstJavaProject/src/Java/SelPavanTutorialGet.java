package WEEK2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SelPavanTutorialGet
{
	WebDriver driver=null;
	@BeforeTest
	@Parameters({"url"})
	public void startMethod(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma.000\\Downloads\\SoftwareTesting\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		driver.get(url);
	}
	@Test
	@Parameters({"email","password"})
		public void TestMethod(String email ,String password)
		
	{	
		String act_title=driver.getTitle();
		Assert.assertEquals(act_title, "Facebook - Log In or Sign","title not matched");
		//System.out.println(act_title);
		System.out.println(driver.getCurrentUrl());
	//	System.out.println(driver.getPageSource());
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys(email);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(password);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]")).click();
	}
	@AfterTest
		public void EndMethod()
	{
			driver.close();
			driver.quit();
	}
}

