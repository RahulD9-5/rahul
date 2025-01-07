package rahulShettyAcademy.stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShettyAcademy.commonTests.BaseTest;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.ShippingInformation;

public class StepDefinition extends BaseTest {
	
	Landingpage login;
	ProductCatalogue productSelect;
	ShippingInformation shipdetails; 
	ConfirmationPage confirm1;
	
	@Given("i landed on eccommerce Page")
	public void i_landed_on_ecommerce_Page () throws IOException {
		initialiseDriver();
		login = new Landingpage(driver);
		login.goTo("https://rahulshettyacademy.com/client");
	}
	
	 @Given("^i logged in with username (.+) and password (.+)$")
	 public void i_logged_in_with_username_and_password(String username,String password) {
			login.loginApplication(username,password);
	 }
	 
	 @When("i add product to Cart")
	 public void i_add_product_to_cart() {
		    productSelect = new ProductCatalogue(driver);
			productSelect.validateTitle("Let's Shop");
			productSelect.addProductToCart();
	 }
	 
	   @And("click on Cart Button")
	   public void click_on_cart_button() {
		   productSelect.goToCart();
	   }
	   
	   @And("click on checkout button")
	   public void click_on_checkout_button() {
		   shipdetails = productSelect.checkOut();
	   }
	   
	   @And("provide Shiping information and click on Place Order button")
	   public void provide_Shiping_information_and_click_on_Place_Order_button() {
		   

		   shipdetails.provideEmail("test@test.com");
		   shipdetails.provideCountry("India");
		   confirm1 = shipdetails.placeOrder();
		   
	   }
	   
	   @Then("validate that productname is being displayed")
	   public void validate_that_productname_us_being_displayed() {
		   confirm1.validateProductName();
			
		   confirm1.closeBrowser();
	   }
	   
	   @Then("^validate that \"([^\"]*)\" error is received$")
	   public void validate_the_loginErrormessage(String message) {
		   Assert.assertEquals(login.getloginError(),message);
		   
	   }

}
