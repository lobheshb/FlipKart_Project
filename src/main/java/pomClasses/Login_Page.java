package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page{
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")                   //(//input[@type='text'])[2]
	private WebElement email ;
	
//	@FindBy(xpath="(//input[@type='password'])")
//	private WebElement password ;
	
//	@FindBy(xpath="(//button[@type='submit'])[2]")
//	private WebElement loginButton ;
	
	public Login_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void putemail() {
		//email.sendKeys("8010259517");
		email.click();
	}
//	public void putpassword() {
//		password.sendKeys("Pramod@07");
//	}
//	
//	public void clicklogin() {
//		loginButton.click();
//	}	
}
