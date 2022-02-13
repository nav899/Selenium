package com.qa.demo.basePkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationBaseClass {
	FileInputStream fis;
	public static Properties prop;
	public static WebDriver wd;
	
	public AutomationBaseClass() {
		try {
			fis = new FileInputStream ("src//main//java//com//qa//demo//configPkg//config.properties");
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void initialisation() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\navitha\\OneDrive\\EndToEndAutomation\\Driver\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().deleteAllCookies();
		wd.get(prop.getProperty("url"));
		wd.manage().window().maximize();
		
	}
	public void closure() {
		wd.quit();
	}
}
