package rahulshettyacademy.pageobjects;

import java.util.List;

import javax.swing.plaf.basic.BasicBorders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcomponents;

public class OrderHistoryPage extends Abstractcomponents {
	
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//tr/td[2]")
	public List<WebElement> orderedProducts;
	
	public void toOrderHistoryPage() {
		
		
		orders.click();
		
	}
	
	public boolean validateifProductisPresent(String a) {
		
		boolean result = orderedProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(a));
		return result;
	}
	
	
	
	

}
