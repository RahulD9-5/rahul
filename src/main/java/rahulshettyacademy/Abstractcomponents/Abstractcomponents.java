package rahulshettyacademy.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponents {
	
	WebDriver driver;

	public Abstractcomponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath = "//button[contains(text(),'ORDERS')]")
	public WebElement orders;
	
	public void waitforInvisibility(String x) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	      // Wait until the element is visible on the page (e.g., login button)
	      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(x)));
	      //toast-container
	}
	
	
	

}
