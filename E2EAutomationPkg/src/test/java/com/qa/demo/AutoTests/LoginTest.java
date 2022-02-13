package com.qa.demo.AutoTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demo.TestPages.LoginPage;
import com.qa.demo.basePkg.AutomationBaseClass;

public class LoginTest extends AutomationBaseClass {
	LoginPage lp;
	public LoginTest() {
		super();
	}
  @Test
  public void Login() throws InterruptedException {
	 
	  initialisation();
	  lp=new LoginPage();
	  Assert.assertEquals(lp.enterLogin(), "nopCommerce demo store. Login", "Didn't enter crrect page");
	  Thread.sleep(2000);
	  Assert.assertEquals( lp.Loginmethod(prop.getProperty("email"), prop.getProperty("password")), "nopCommerce demo store", "Didn't enter crrect page"); 
	  Thread.sleep(1000);
	  closure();
  }
}
