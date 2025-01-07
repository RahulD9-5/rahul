package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		
		this.driver = driver;
		
		
		
		
	}
	

	
	public void loginApplication(String email1, String password) {
		
		WebElement userId = driver.findElement(By.id("userEmail"));
		WebElement passWordField = driver.findElement(By.id("userPassword"));
		WebElement loginButton = driver.findElement(By.id("login"));
	
		userId.sendKeys(email1);
		passWordField.sendKeys(password);
		loginButton.click();
	
		
	}
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	
	public String getloginError() {
		WebElement errorMessage = driver.findElement(By.id("toast-container"));
		String errMsg = errorMessage.getText();
		return errMsg;
		
		
		
		
	}
	
	
	
	

}
