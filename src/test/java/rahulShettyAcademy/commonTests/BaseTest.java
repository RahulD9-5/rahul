package rahulShettyAcademy.commonTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	
	public WebDriver driver;
	public void initialiseDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\Globaldata.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
				
				//prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
				
			}
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			
		}
	
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file1 = ts.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir") + "\\reports\\" + testcaseName +  ".png");
		FileUtils.copyFile(file1, file2);
		return file2.getAbsolutePath();
		
	}
	
	

}
