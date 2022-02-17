package com.qa.demo.AutoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.demo.TestPages.LoginPage;
import com.qa.demo.basePkg.AutomationBaseClass;

public class LoginTest extends AutomationBaseClass {
	LoginPage lp;

	@BeforeMethod
	public void initialize() {
		 initialisation();
		  lp=new LoginPage();
	}
  @Test
  public void Login() throws InterruptedException {
	 
	 
	  Assert.assertEquals(lp.enterLogin(), "nopCommerce demo store. Login", "Didn't enter crrect page");
	  Assert.assertEquals( lp.Loginmethod(prop.getProperty("email"), prop.getProperty("pwd")), "nopCommerce demo store", "Didn't enter crrect page"); 
	  Thread.sleep(1000);
	  closure();
  }
 
}
