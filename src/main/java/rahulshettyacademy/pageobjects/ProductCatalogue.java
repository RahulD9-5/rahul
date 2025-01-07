package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.Abstractcomponents.Abstractcomponents;

public class ProductCatalogue extends Abstractcomponents {
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
		this.driver = driver;
	}
	
	
		
	public void validateTitle(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void addProductToCart() {
		WebElement addToCartbutton = driver.findElement(By.xpath("//div[@class=\"row\"]/div[1]/div/div/button[2]"));
		addToCartbutton.click();
		waitforInvisibility("toast-container");
	}
	
	  
      
	
	public void goToCart() {
		
		WebElement cart = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart' and contains(text(), 'Cart')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cart);
		
		cart.click();
	}
	
	public ShippingInformation checkOut() {
		
		
		WebElement checkOut = driver.findElement(By.xpath("//button[text() = 'Checkout']"));
		checkOut.click();
		ShippingInformation shipdetails = new ShippingInformation(driver);
		return shipdetails;
		
	}
	

}
