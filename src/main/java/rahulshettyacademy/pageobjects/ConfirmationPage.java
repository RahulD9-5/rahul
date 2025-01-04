package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ConfirmationPage {
	
	WebDriver driver;
	
	public  ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
		
	}
	
	
	
	
	
	public void validateProductName() {
		
		WebElement confirmationsection = driver.findElement(By.cssSelector("table.order-summary"));
		
		Assert.assertTrue(confirmationsection.findElements(By.xpath("tbody/div/tr")).stream().anyMatch(product -> product.findElement(By.xpath("//td[2]/div[1]")).getText().equalsIgnoreCase("ADIDAS ORIGINAL")));
		
	}
	
	public void closeBrowser() {
		
		driver.close();
	}



}
