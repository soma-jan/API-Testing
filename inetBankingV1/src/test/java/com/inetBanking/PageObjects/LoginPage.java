package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement bSubmitLogin;

	
	public void setUserName(String username)
	{
		txtUsername.sendKeys(username);
	}
	public void setPassWord(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void btnClick()
	{
		bSubmitLogin.click();
	}

}
