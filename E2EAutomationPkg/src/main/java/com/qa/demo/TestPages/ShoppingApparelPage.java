package com.qa.demo.TestPages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.basePkg.AutomationBaseClass;

public class ShoppingApparelPage extends  AutomationBaseClass{
	//WebDriverWait wait;
	CartPage cp;
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
	@FindBy(id="add-to-cart-button-16") WebElement addtocartbutton;
	@FindBy(xpath="//span[@class='wishlist-label']") WebElement wishlist;
	@FindBy(xpath="//button[text()='Search']") WebElement magnifier;
	@FindBy(xpath="//div[text()='No products were found that matched your criteria.']") WebElement noprod;
	@FindBy(xpath="//span[text()='Shopping cart']") WebElement cart;
	@FindBy(xpath="//button[text()='Go to cart']") WebElement gotoCart;
	@FindBy(id="termsofservice") WebElement tos;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkout;
	
	Actions act=new Actions(wd);
	JavascriptExecutor js=(JavascriptExecutor) wd;
	WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
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
		wait.until(ExpectedConditions.visibilityOf(mirrorless));
		js.executeScript("arguments[0].scrollIntoView(true);", mirrorless);
		wait.until(ExpectedConditions.visibilityOf(mirrorless));
		mirrorless.click();
		wait.until(ExpectedConditions.visibilityOf(fullimg));
		fullimg.click();
		wait.until(ExpectedConditions.visibilityOf(close));
		close.click();
		quantity.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		quantity.sendKeys("2");
		Thread.sleep(2000);
	}
	public CartPage addtoCart() {
		addtocartbutton.click();
		cart.click();
		wait.until(ExpectedConditions.visibilityOf(gotoCart));
		gotoCart.click();
		wait.until(ExpectedConditions.titleContains("cart"));
		return new CartPage();
	}
}