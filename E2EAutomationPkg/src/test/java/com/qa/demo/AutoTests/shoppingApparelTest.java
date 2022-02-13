package com.qa.demo.AutoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.demo.TestPages.LoginPage;
import com.qa.demo.TestPages.ShoppingApparelPage;
import com.qa.demo.basePkg.AutomationBaseClass;

public class shoppingApparelTest  extends AutomationBaseClass{
	LoginPage lp;
	ShoppingApparelPage apprl;
  @BeforeTest
  public void Login() throws Exception {
		 
	  initialisation();
	  lp=new LoginPage();
	  lp.enterLogin();
	  lp.Loginmethod(prop.getProperty("email"), prop.getProperty("password"));
	  apprl=new ShoppingApparelPage();
	  apprl.scrollandvalidatePElements();
	 
  }
  @Test
  public void shop() throws InterruptedException {
	  apprl.shoppe();
	  closure();
  }
}
