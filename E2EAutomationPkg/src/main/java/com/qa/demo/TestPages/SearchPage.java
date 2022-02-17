package com.qa.demo.TestPages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.basePkg.AutomationBaseClass;

public class SearchPage extends AutomationBaseClass {
	public SearchPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(id="small-searchterms") WebElement search;
	@FindBy(xpath="//button[@class='button-2 product-box-add-to-cart-button']") WebElement addtocart;
	@FindBy(xpath="(//button[text()=\"Search\"])[1]") WebElement searchifier;
	WebDriverWait wait= new WebDriverWait(wd,Duration.ofSeconds(120));
	
	public String searchProduct(String product) {
		search.sendKeys(product);
		searchifier.click();
		wait.until(ExpectedConditions.urlContains(product));
		try {
			addtocart.isDisplayed();
			return "Product available";
		}
		catch(NoSuchElementException e) {
			return "Product Unavailable";
		}
	}
}
