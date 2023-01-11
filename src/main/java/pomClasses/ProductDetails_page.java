package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;

public class ProductDetails_page  extends UtilClass1{
	
	WebDriver driver ;
	
	@FindBy(xpath=("(//button[text()='BUY NOW'])"))
	private WebElement BuyNowButton ;
	
	@FindBy(xpath=("(//span[contains(text(),'realme')])")) 
	private WebElement ProductGet;
	
	@FindBy(xpath=("(//button[text()='ADD TO CART'])"))
	private WebElement AddToCartButton;
	
	@FindBy(xpath=("(//span[text()='Place Order'])"))
	private WebElement PlaceOrderButton ;
	
	@FindBy(xpath=("(//span[contains(text(),'Near Vittal Mandir')])"))
	private WebElement DelevaryAddress ;
	
	@FindBy(xpath=("(//button[text()='CONTINUE'])"))
	private WebElement ContinueButton;
	
	@FindBy(xpath=("(//button[text()='Accept & Continue'])"))
	private WebElement AcceptAndContinueButton ;
	
	
	
	public ProductDetails_page (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean isBuyNowButtonIsAppeared(){
		try {
			WebElement element = expliciteWait(driver,BuyNowButton);
			return true ;
		    }
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isProductListAppeared() {
		try {
			WebElement element = expliciteWait(driver,ProductGet);
				return true ;
			}
		catch (Exception e ) {
				e.printStackTrace();    //or System.out.println(e);
				return false;
			}
		 }
	
 public void ClickAddToCartButton() {
	 
	 AddToCartButton.click();; 
 }
 
 public boolean isPlaceOrderButtonVisiable() {
	 
	 try {
		 WebElement element = expliciteWait(driver,PlaceOrderButton);
		 return true;
	    } 
	 catch(Exception e) {
		 e.printStackTrace();
		 return false;
	   }
	}
 
 public void ClickToPlaceOrderButton() throws InterruptedException {
	 
	 PlaceOrderButton.click();
	 Thread.sleep(1000);
 }
 
 public boolean isDelevaryAddressVisiable() {
	try{
	
		WebElement element = expliciteWait(driver,DelevaryAddress);
		return true ;
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
	 
 }
 public void ClickToContinueButton() throws InterruptedException {
	 ContinueButton.click();
	 Thread.sleep(1000);
 }
 public void ClickToAcceptAndContinueButton() {
	 AcceptAndContinueButton.click();
 }
 
}
