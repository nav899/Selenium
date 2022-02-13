package com.qa.demo.TestPages;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.basePkg.AutomationBaseClass;

public class ShoppingApparelPage extends  AutomationBaseClass{
	
	public ShoppingApparelPage() {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Apparel')]") WebElement apparel;
	@FindBy(xpath = "//strong[contains(text(),'Featured products')]") WebElement fp;
	@FindBy(xpath="//img[@title='Show products in category Electronics']") WebElement electronics;
	@FindBy(xpath="//img[@title='Show products in category Camera & photo']") WebElement cam;
	@FindBy(xpath="(//a[text()='Leica T Mirrorless Digital Camera'])[2]") WebElement mirrorless;
	@FindBy(id="main-product-img-16") WebElement fullimg;
	@FindBy(xpath="//button[@class='mfp-close']") WebElement close;
	@FindBy(xpath="//input[@id='product_enteredQuantity_16']") WebElement quantity;
	@FindBy(xpath="//button[@id='add-to-wishlist-button-16']") WebElement addtowishlist;
	@FindBy(xpath="//span[@title='Close']") WebElement closeconfmsg;
	@FindBy(xpath="//input[@id='small-searchterms']") WebElement search;
	@FindBy(xpath="(//input[@class='qty-input'])[1]") WebElement quant;
	@FindBy(id="updatecart") WebElement updatecart;
	@FindBy(xpath="//input[@name='addtocart']") WebElement chkbox;
	@FindBy(xpath="//button[@name='addtocartbutton']") WebElement addtocartbutton;
	@FindBy(xpath="//span[@class='wishlist-label']") WebElement wishlist;
	@FindBy(xpath="//button[text()='Search']") WebElement magnifier;
	@FindBy(xpath="//div[text()='No products were found that matched your criteria.']") WebElement noprod;
	@FindBy(xpath="//span[text()='Shopping cart']") WebElement cart;
	@FindBy(xpath="//button[text()='Go to cart']") WebElement gotoCart;
	@FindBy(id="termsofservice") WebElement tos;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkout;
	
	Actions act=new Actions(wd);
	JavascriptExecutor js=(JavascriptExecutor) wd;
	
	public String scrollandvalidatePElements() throws Exception {
		
		js.executeScript("arguments[0].scrollIntoView(true);", apparel);
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", fp);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", apparel);
		Thread.sleep(3000);
		electronics.click();
		return wd.getTitle();
	}
	public void shoppe() throws InterruptedException {
		cam.click();
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true);", mirrorless);
		Thread.sleep(2000);
		mirrorless.click();
		Thread.sleep(2000);
		fullimg.click();
		Thread.sleep(2000);
		close.click();
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.sendKeys("12");
		Thread.sleep(2000);
		addtowishlist.click();
		Thread.sleep(2000);
		closeconfmsg.click();
		wishlist.click();
		Thread.sleep(7000);
		quant.sendKeys(Keys.BACK_SPACE);
		quant.sendKeys("1");
		Thread.sleep(2000);
		updatecart.click();
		Thread.sleep(3000);
		chkbox.click();
		addtocartbutton.click();
		act.moveToElement(search).build().perform();
		Thread.sleep(2000);
		search.sendKeys("headphone");
		Thread.sleep(2000);
		magnifier.click();
		Thread.sleep(2000);
		try {
			cart.click();
			Thread.sleep(2000);
			gotoCart.click();
			tos.click();
			checkout.click();
			Thread.sleep(2000);
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}}