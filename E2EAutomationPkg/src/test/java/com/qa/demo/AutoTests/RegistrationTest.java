package com.qa.demo.AutoTests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.TestPages.RegistrationPage;
import com.qa.demo.basePkg.AutomationBaseClass;

public class RegistrationTest extends AutomationBaseClass{
	RegistrationPage rp;
  @BeforeTest
  public void initalizeRegistration() throws InterruptedException {
	  initialisation();
	  rp=new RegistrationPage(); 
	 
  }
  @Test(priority=1)
  public void validateRegisterPageOptions() throws InterruptedException {
	  Assert.assertEquals(rp.validateRegistrationButton(),
			  "nopCommerce demo store. Register", "Did not direct to register page");
	  rp.enterRegistrationDetails();
  }
  @Test(priority=2)
  public void passwordScenarioandRegisterButtonTest() throws InterruptedException {
	  rp.password();
	  Thread.sleep(3000);
	  if(rp.pwd.length()<6) {
		  Assert.assertEquals(rp.passwordMsgs(), true);
	  }else {
		  rp.confPassword();
		  Thread.sleep(3000);
	  }
  }
  @Test(priority=3)
  public void registrationStatus() throws InterruptedException {
	  Assert.assertEquals(rp.regStatus(), "Your registration completed", "Registration not successful-");
  }
  @AfterTest
  public void close() {
	 rp.closure();
  }
}
