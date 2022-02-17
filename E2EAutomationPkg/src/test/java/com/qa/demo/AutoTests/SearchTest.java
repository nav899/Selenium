package com.qa.demo.AutoTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.demo.TestData.ExcelUtility;
import com.qa.demo.TestPages.LoginPage;
import com.qa.demo.TestPages.SearchPage;
import com.qa.demo.basePkg.AutomationBaseClass;

public class SearchTest extends AutomationBaseClass {
	LoginPage lp;
	SearchPage sp;
	ExcelUtility eu;
	@BeforeTest
	public void launchAndLogin() throws InterruptedException {
		initialisation();
		lp = new LoginPage();
		sp=new SearchPage();
		lp.enterLogin();
		eu = new ExcelUtility(prop.getProperty("data"));
		lp.Loginmethod(prop.getProperty("email"), prop.getProperty("pwd"));
	}
	
	@Test
	public void searchusingExcelUtility() {
		String result=sp.searchProduct(eu.readExceldata());
		Thread.sleep(2000);
		System.out.println("Product result: "+ result);
	}
	

	//@Test(dataProvider = "dp")
	public void searchtest(String email, String pwd, String prod) throws InterruptedException {
		
		String result=sp.searchProduct(prod);
		Thread.sleep(2000);
		System.out.println("Product result: "+ result);
	}

	@DataProvider(name = "dp")
	public String[][] dataProviderMethod() {
		String[][] data = { { prop.getProperty("email"), prop.getProperty("pwd"), "Headphone" },
				{ prop.getProperty("email"), prop.getProperty("pwd"), "Bracelet" } };
		return data;

	}
	@AfterTest
	public void close() {
		lp.closure();
	}
}
