package com.qa.demo.AutoTests;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.TestPages.HomePage;
import com.qa.demo.basePkg.AutomationBaseClass;

public class HomePageTest extends AutomationBaseClass {
	HomePage hp;

	public HomePageTest() throws IOException {
		super();
		 
	}
	@BeforeMethod
	public void launchUrl() {
		initialisation();
		hp = new HomePage();
	}

	@Test(priority=1)
	public void launchUrlandValidatePageElements() throws Exception {
		Assert.assertEquals(hp.validateTitle(), "nopCommerce demo store", "TC 01: Title not as expected - ");
	}
	@Test(priority=2)
	public void scrollTest() throws Exception {

		hp.scrollandvalidatePageElements();
	}

	@AfterTest
	public void closeTest() {
		closure();
	}
}
