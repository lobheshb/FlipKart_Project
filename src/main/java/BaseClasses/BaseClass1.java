package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass1{

	public static WebDriver getChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		return driver;
		
	}
}
