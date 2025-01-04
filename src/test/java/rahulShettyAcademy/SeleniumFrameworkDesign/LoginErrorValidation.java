package rahulShettyAcademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyAcademy.commonTests.BaseTest;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.ShippingInformation;

public class LoginErrorValidation extends BaseTest {
	
	
   
	@Test(groups = {"importantTests"},dataProvider = "getdata1")
	public void validateLoginError(String email , String password) throws IOException{
		// TODO Auto-generated method stub
		
		initialiseDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

        
		
		//email - test@testold.com
		//pwd - Test@123
		
		Landingpage login = new Landingpage(driver);
		login.goTo("https://rahulshettyacademy.com/client");
		login.loginApplication(email,password);
		
		Assert.assertEquals(login.getloginError(),"Incorrect email or password.");
		driver.close();
		
		
		
		
		
		
		
		
		
		

	}
	
	@DataProvider
	public Object[][] getdata1() {
		Object[][] object = {{"test@testold.com","Test@124"},{"test@testoldfive.com","Test@124"}};
		return object;
	}

}
