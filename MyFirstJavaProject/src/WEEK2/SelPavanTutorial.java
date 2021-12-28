package WEEK2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelPavanTutorial 
{
	
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma.000\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String act_title=driver.getTitle();
		System.out.println(act_title);
		String exp_title ="";
		exp_title =driver.getTitle();
		if(act_title.equals(exp_title))
			{
				System.out.print("Test Passed");
			}
		else
			{
				System.out.print("Test Failed");
			}

	}
}