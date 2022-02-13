package com.qa.demo.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demo.basePkg.AutomationBaseClass;

public class LoginPage extends AutomationBaseClass {
	public LoginPage() {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath="//a[contains(text(),'Log in')]") WebElement login;
	@FindBy(id="Email") WebElement eid;
	@FindBy(id="Password") WebElement pwd;
	@FindBy(xpath="//button[@type='submit' and contains(text(),'Log in')]") WebElement Login;
	@FindBy(xpath="//div[contains(text(),'Login was unsuccessful.')]") WebElement unsuccess;
	public String enterLogin()
	{
		login.click();
		return wd.getTitle();
	}
	public String Loginmethod(String email,String password) throws InterruptedException {
		eid.sendKeys(email);
		Thread.sleep(1000);
		pwd.sendKeys(password);
		Login.click();
		return wd.getTitle();
	}
	
}
