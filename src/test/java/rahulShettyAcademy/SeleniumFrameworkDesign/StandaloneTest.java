package rahulShettyAcademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Landingpage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		//email - test@testold.com
		//pwd - Test@123
		
		Landingpage login = new Landingpage(driver);
		//driver.findElement(By.id("userEmail")).sendKeys("test@testold.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		Assert.assertEquals(driver.getTitle(), "Let's Shop");
		driver.findElement(By.xpath("//div[@class=\"row\"]/div[1]/div/div/button[2]")).click();
		//button[@class='fa fa-shopping-cart' and text()='Cart']
		Thread.sleep(5000);
		WebElement cart = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart' and contains(text(), 'Cart')]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cart);
		
		cart.click();
		
		//Assert.assertEquals(driver.getTitle(),"My Cart");
	
		driver.findElement(By.xpath("//button[text() = 'Checkout']")).click();
		//WebElement creditCard  = driver.findElement(By.xpath("//div[text()='Credit Card Number ']/following::input[1]"));
		//creditCard.sendKeys("3434343434");
		//WebElement cvv = driver.findElement(By.xpath("//div[@class='row'][2]/div[2]/input"));
		//cvv.sendKeys("2345");
		WebElement email = driver.findElement(By.xpath("//div[@class='details__user']/div/input"));
		email.sendKeys("test@test.com");
		WebElement country = driver.findElement(By.xpath("//div/input[@placeholder='Select Country']"));
		country.sendKeys("india");
		List<WebElement> countries = country.findElements(By.xpath("//section/button"));
		for (WebElement webElement : countries) {
			if (webElement.getText().equalsIgnoreCase("india")) {
				webElement.click();
				
			}
			
		}
		
		WebElement element1 = driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted' and text()='Place Order ']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
		
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space(text())='Thankyou for the order.']")).isDisplayed());
		
		WebElement confirmationsection = driver.findElement(By.cssSelector("table.order-summary"));
		Assert.assertTrue(confirmationsection.findElements(By.xpath("tbody/div/tr")).stream().anyMatch(product -> product.findElement(By.xpath("//td[2]/div[1]")).getText().equalsIgnoreCase("ZARA COAT 3")));
		
		
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		

	}

}
