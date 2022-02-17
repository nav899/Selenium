package com.qa.demo.TestPages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.basePkg.AutomationBaseClass;

public class RegistrationPage extends AutomationBaseClass {
	public RegistrationPage() {
		PageFactory.initElements(wd, this);
	}

	public String pwd = "";
	JavascriptExecutor js = (JavascriptExecutor) wd;
	Select select;
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement Registerbutton;
	@FindBy(xpath = "//label[text()='Female']")
	WebElement femaleButton;
	@FindBy(id = "FirstName")
	WebElement firstName;
	@FindBy(id = "LastName")
	WebElement lastName;
	@FindBy(name = "DateOfBirthDay")
	WebElement datePicker;
	@FindBy(name = "DateOfBirthMonth")
	WebElement monthPicker;
	@FindBy(name = "DateOfBirthYear")
	WebElement yearPicker;
	@FindBy(id = "Email")
	WebElement eid;
	@FindBy(id = "Company")
	WebElement company;
	@FindBy(id = "Newsletter")
	WebElement Newsletter;
	@FindBy(id = "Password")
	WebElement Password;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;
	@FindBy(id = "register-button")
	WebElement register;
	@FindBy(xpath = "//li[contains(text(),'must have at least 6 characters')]")
	WebElement errorMsg1;
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	WebElement regSuccess;
	@FindBy(xpath="//a[contains(text(),'Continue')]") WebElement continueButton;
	public String validateRegistrationButton() throws InterruptedException {
		
		Registerbutton.click();
		Thread.sleep(2000);
		return wd.getTitle();
	}

	public void enterRegistrationDetails(String email) throws InterruptedException {
		femaleButton.click();
		firstName.sendKeys("firstname");
		lastName.sendKeys("lastName");
		select = new Select(datePicker);
		select.selectByIndex(10);
		Thread.sleep(2000);
		select = new Select(monthPicker);
		select.selectByValue("4");
		Thread.sleep(2000);
		select = new Select(yearPicker);
		select.selectByVisibleText("2020");
		Thread.sleep(2000);
		eid.sendKeys(email);
		company.sendKeys("ABC");
		js.executeScript("arguments[0].scrollIntoView(true);", Newsletter);
		Thread.sleep(5000);
		Newsletter.click();
	}

	public void password(String pwd) {

		Password.sendKeys(pwd);
		Password.sendKeys(Keys.ENTER);
	}

//	public boolean passwordMsgs() {
//		if (errorMsg1.isDisplayed()) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public void confPassword(String pwd) throws InterruptedException {
		confirmPassword.sendKeys(pwd);
		register.click();
		Thread.sleep(1000);
	}
	public String regStatus() throws InterruptedException {
		try {
			continueButton.isDisplayed();
			continueButton.click();
			Thread.sleep(3000);
			return  "Your registration completed";}
		catch(NoSuchElementException e)
		{
			return "The specified email already exists";
		}
	}
}
