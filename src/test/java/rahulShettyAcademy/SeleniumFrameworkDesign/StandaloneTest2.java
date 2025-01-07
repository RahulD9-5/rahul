package rahulShettyAcademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

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
import rahulShettyAcademy.data.ConvertJsontoHashmap;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.OrderHistoryPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.ShippingInformation;

public class StandaloneTest2 extends BaseTest {
	
	
    @Test(dataProvider = "getData",groups = "importantTests")
	public void submitOrder(HashMap<String, String> input) throws IOException{
		// TODO Auto-generated method stub
		
		initialiseDriver();
		//email - test@testold.com
		//pwd - Test@123
		
		Landingpage login = new Landingpage(driver);
		login.goTo("https://rahulshettyacademy.com/client");
		login.loginApplication(input.get("email"),input.get("password"));
		
		
		ProductCatalogue productSelect = new ProductCatalogue(driver);
		productSelect.validateTitle("Let's Shop");
		productSelect.addProductToCart();
		
		
	
		productSelect.goToCart();
		
		
		ShippingInformation shipdetails = productSelect.checkOut();
		
	
		shipdetails.provideEmail("test@test.com");
		shipdetails.provideCountry("India");
		
	    
		
		
		ConfirmationPage confirm1 = shipdetails.placeOrder();
		
		confirm1.validateProductName();
	
		confirm1.closeBrowser();
        
		
	}
    
    
    @Test(dependsOnMethods = "submitOrder")
    public void validateOrderHistory() throws IOException {
    	
    	initialiseDriver();
		//email - test@testold.com
		//pwd - Test@123
		
		Landingpage login = new Landingpage(driver);
		login.goTo("https://rahulshettyacademy.com/client");
		login.loginApplication("test@testold.com","Test@123");
		OrderHistoryPage ordHst = new OrderHistoryPage(driver);
		ordHst.toOrderHistoryPage();
		Assert.assertTrue(ordHst.validateifProductisPresent("ZARA COAT 3"));
		driver.close();
		
    	}
    
    
    
    @DataProvider
    public Object[][] getData() throws IOException {
		/*
		 * HashMap<String,String> map = new HashMap<String, String>(); map.put("email",
		 * "test@testold.com"); map.put("password", "Test@123"); //steps to retrieve
		 * data using Just an Object Array //Object[][] object =
		 * {{"test@testold.com","Test@123"},{"shettynew@gmail.com","IamKing@000"}};
		 * //return object; HashMap<String,String> map1 = new HashMap<String, String>();
		 * map1.put("email", "shettynew@gmail.com"); map1.put("password",
		 * "IamKing@000"); Object[][] object = {{map},{map1}};
		 */
    	 Object[][] object;
    	 ConvertJsontoHashmap jsonConverter = new ConvertJsontoHashmap();
    	 List<HashMap<String,String>> dataList = jsonConverter.getDatafromJson();
    	 return new Object[][] {{dataList.get(0)},{dataList.get(1)}};  
			
		
    	
    	
    }

}
