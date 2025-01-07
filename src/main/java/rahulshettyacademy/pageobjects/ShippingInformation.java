package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingInformation {
	
	WebDriver driver;
	
	public ShippingInformation(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	
	

	
	public void provideEmail(String paymentEmail) {
		WebElement email = driver.findElement(By.xpath("//div[@class='details__user']/div/input"));
		
		email.sendKeys(paymentEmail);
	}
	
	public void provideCountry(String countryName) {
		WebElement country = driver.findElement(By.xpath("//div/input[@placeholder='Select Country']"));
		country.sendKeys(countryName);
		List<WebElement> countries = country.findElements(By.xpath("//section/button"));
		for (WebElement webElement : countries) {
			if (webElement.getText().equalsIgnoreCase("india")) {
				webElement.click();
				
			}
			
		}
	}
	
	public ConfirmationPage placeOrder() {
		
		WebElement element1 = driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted' and text()='Place Order ']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
		ConfirmationPage confirm1 = new ConfirmationPage(driver);
		return confirm1;
	}

}
