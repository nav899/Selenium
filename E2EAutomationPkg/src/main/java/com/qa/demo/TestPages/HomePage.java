package com.qa.demo.TestPages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

import com.qa.demo.basePkg.AutomationBaseClass;

public class HomePage extends AutomationBaseClass {
	JavascriptExecutor js;
	@FindBy(xpath = "//input[@id='small-searchterms']")
	public WebElement searchbox;
	@FindBy(xpath = "//button[text()='Subscribe']")
	public WebElement button;

	public HomePage() {
		PageFactory.initElements(wd, this);
	}

	public String validateTitle() {
		return wd.getTitle();
	}

	public void scrollandvalidatePageElements() throws Exception {
		js = (JavascriptExecutor) wd;
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", button);
		Thread.sleep(2000);
	}
}
