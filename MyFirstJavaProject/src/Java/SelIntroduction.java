package WEEK2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverInfo;

public class SelIntroduction {
	/*public static void main(String arg[]) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma.000\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.w3schools.com/");
	System.out.println(driver.getTitle());
	C:\Users\soma.000\Downloads\geckodriver-v0.30.0-win32.zip
	
	public static void main(String arg[]) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\soma.000\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		driver.get("https://www.w3schools.com/");
		System.out.println(driver.getTitle());
	
	public static void main(String arg[]) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\soma.000\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver =new EdgeDriver();
		driver.get("https://www.w3schools.com/");
		System.out.println(driver.getTitle());*/
	public static void main(String arg[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma.000\\Downloads\\SoftwareTesting\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://sso.teachable.com/secure/9521/identity/login");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("email")).sendKeys("soma.j18@gmail.com");
		driver.findElement(By.id("password")).sendKeys("app123");
		driver.findElement(By.name("commit")).click();
		//String s=driver.findElement(By.className("bodySmall")).getText();
		String s=driver.findElement(By.xpath("//div[@class='bodySmall m-b-3-xs text-center-xs auth-flash-error']")).getText();
	    System.out.println(s);
		//		driver.quit();

	

}
	}
