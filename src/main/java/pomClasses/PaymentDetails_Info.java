package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;

public class PaymentDetails_Info extends UtilClass1 {
     WebDriver driver ;
//1
	@FindBy(xpath=("(//div[text()='Order Summary'])"))
	private WebElement OrderSummary ;
//2	
	@FindBy(xpath=("(//div[text()='PhonePe'])"))
	private WebElement SelectPhonePe ;
//3	
	@FindBy(xpath=("(//button[@type='button'])"))
	private WebElement ContinuButton;
//4	
	@FindBy(xpath=("(//input[@id='mobileNumber'])"))
	private WebElement Mobilenumber1;
//5
	@FindBy(xpath=("(//button[@id='onboardingFormSubmitBtn'])"))
	private WebElement ClickSendOTPtoLogin ; 
//6	
	@FindBy(xpath=("(//input[@id='cardNumber'])"))
	private WebElement EnterCardNumber ;
//7
	@FindBy(xpath=("(//input[@id='selMonth'])"))
	private WebElement EnterMM ;
//8
	@FindBy(xpath=("(//input[@id='selYear'])"))
	private WebElement EnterYYYY ;
//9	
	@FindBy(xpath=("(//input[@id='cvvNumber'])"))
	private WebElement EnterCVV ;
//10	
	@FindBy(xpath=("(//input[@type='checkbox'])"))
	private WebElement CheckBOX ;
// 11
	@FindBy(xpath=("(//button[@id='paySubmitButton'])"))
	private WebElement paySubmitButton ;
//12
	@FindBy(xpath=("(//span[text()='SAVED SAVED'])"))
	private WebElement ClickSAVEDSAVED ;
	
	
	public  PaymentDetails_Info (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
//1
	public boolean isOrderSummaryVisiable() {
		
		try {
			//WebElement element = ScrollActions(driver ,OrderSummary);
			WebElement element = expliciteWait(driver,OrderSummary);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
//2
	public void Click_SelectPhonePe() throws InterruptedException {
		WebElement element = expliciteWait(driver,SelectPhonePe);
		element.click();
	}
//3	
	public void Click_ContinuButton() throws InterruptedException {
		ContinuButton.click();	
	}
//4
	public void Enter_Mobilenumber() throws InterruptedException {
		WebElement element = expliciteWait(driver, Mobilenumber1);
		element.sendKeys("7768868534");	
	}
//5
	public void is_ClickSendOTPtoLogin() throws InterruptedException {
		ClickSendOTPtoLogin.click();	
		
	}
//12
	public void is_ClickSAVEDSAVED() throws InterruptedException {
		ClickSAVEDSAVED.click();	
	}
	
//6
		public void is_EnterCardNumber() throws InterruptedException {
		EnterCardNumber.sendKeys("4622441617704081");
		}
//7		
		public void is_EnterMM() throws InterruptedException {
			EnterMM.sendKeys("11");
			}
//8
		public void is_EnterYYYY() throws InterruptedException {
			EnterYYYY.sendKeys("2023");
			}
//9
		public void is_EnterCVV() throws InterruptedException {
			EnterCVV.sendKeys("901");
			}
//10
		public void Click_CheckBOX() throws InterruptedException {
			CheckBOX.click();
			}
//11
		public void Click_paySubmitButton() throws InterruptedException {
			paySubmitButton.click();
		}	
}
