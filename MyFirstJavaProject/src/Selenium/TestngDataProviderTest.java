package Testng;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDataProviderTest {
	WebDriver driver ;
	
  @BeforeMethod
  public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma.000\\Downloads\\SoftwareTesting\\chromedriver_win32\\chromedriver.exe");
	    driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://signup.heroku.com/login");
		
  }
  @Test(dataProvider ="LoginData" )
  
  public void Read(String first_name ,String last_name,String email ,String company ,String role ,String country ,String language)
  {
	  driver.findElement(By.xpath(" //input[@id='first_name']")).clear();
	  driver.findElement(By.xpath(" //input[@id='first_name']")).sendKeys(first_name);
	  
	  driver.findElement(By.xpath(" //input[@id='last_name']")).clear();
	  driver.findElement(By.xpath(" //input[@id='last_name']")).sendKeys(last_name);
	  
	  
	  driver.findElement(By.xpath(" //input[@id='email']")).clear();
	  driver.findElement(By.xpath(" //input[@id='email']")).sendKeys(email);
	  
	  driver.findElement(By.xpath(" //input[@id='company']")).clear();
	  driver.findElement(By.xpath(" //input[@id='company']")).sendKeys(company);
	  
	 
	  
	  Select selectrole = new Select(driver.findElement(By.xpath("//select[@id='role']")));
	  selectrole.selectByVisibleText(role);
	  
	  Select selectcountry = new Select(driver.findElement(By.xpath(" //select[@id='self_declared_country']")));
	  selectcountry.selectByVisibleText(country);
	  
	  Select selectlang = new Select(driver.findElement(By.xpath(" //select[@id='main_programming_language']")));
	  selectlang.selectByVisibleText(language);
	  
	  
  }
  @DataProvider(name ="LoginData")
  public String[][] getData()
  {
	  String loginData[][] = {{"SOMA","JAN","SOMA@GMAIL.COM","SBNT","Student","Canada","Java"},
			  				{"lixy","eldo","lixy@GMAIL.COM","SBNT","Student","Canada","Java"}

			  
	  						};
	  return loginData;
  }
  @AfterMethod
  public void tearDown()
  {
	 driver.close();
	 driver.quit();
  }


}

