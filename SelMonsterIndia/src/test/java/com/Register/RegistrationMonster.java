package com.Register;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationMonster extends Base{
	@Test
	public void action() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='form_first_name_id']")).sendKeys("soma");
		driver.findElement(By.xpath("//*[@id=\'form_last_name_id\']")).sendKeys("Janardhanan");
		driver.findElement(By.xpath("//*[@id=\'form_email_id\']")).sendKeys("soma.j1990@gmail.com");
		driver.findElement(By.xpath("//*[@id=\'form_mobile_id\']")).sendKeys("6471498666");
		driver.findElement(By.xpath("//*[@id=\'form_loc_id\']/div[2]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\'form_loc_id_typeahead\']")).sendKeys("Bang");
		driver.findElement(By.xpath("//div[contains(text(),'Bangl')]/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//*[@id=\'form_loc_id_value\']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"recprofileform\"]/div/div/div[1]/div[4]/div[2]/label")).click();
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\'myframe\']")));
		driver.findElement(By.xpath("//*[@id=\'image_file\']")).sendKeys("C:\\Users\\soma.000\\Desktop\\All files\\soma.jpg");
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\'upload_form\']/div[4]/div[1]/div/div[1]")));
		//actions.moveToElement(driver.findElement(By.xpath("//*[@id=\'upload_form\']/div[4]/div[1]/div/div[1]")));
		actions.perform();
		String newStyle = "width:80px";
				JavascriptExecutor js = (JavascriptExecutor)driver;
				WebElement element = driver.findElement(By.xpath("//*[@id=\'upload_form\']/div[4]/div[1]/div/div[1]"));
				js.executeScript("arguments[0].setAttribute('style', '" + newStyle + "')", element);
				//String highlightJavascript =  @"$(arguments[0]).css({ "border-width"" : ""2px"", ""border-style"" : ""solid"", ""border-color"" : ""red" });";
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
	
	}

}
