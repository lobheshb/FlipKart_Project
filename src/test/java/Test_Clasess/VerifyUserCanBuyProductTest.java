package Test_Clasess;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass1;
import ListenersClasses.ListenersClasse;
import UtilClasses.UtilClass1;
import pomClasses.Home_Page;
import pomClasses.Login_Page;
import pomClasses.PaymentDetails_Info;
import pomClasses.ProductDetails_page;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class VerifyUserCanBuyProductTest extends UtilClass1 {
	
	
	//@Listeners(ListenersClasse.class)
	
	WebDriver driver ;
	Login_Page lp ;
	Home_Page hp;
	ProductDetails_page pdp;
	PaymentDetails_Info pdi ;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	
	ExtentTest test;

	
	  @BeforeClass
	  public void beforeClass() {
		  driver=BaseClass1.getChromeDriver();
		  
		    htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			test = report.createTest("VerifyUserCanBuyProduct");

	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  lp = new Login_Page(driver);
		  hp = new Home_Page(driver);
		  pdp = new ProductDetails_page(driver);
		  pdi = new PaymentDetails_Info(driver);
		  
	  }
 SoftAssert soft = new SoftAssert();
 
  @Test(priority=1)
  public void VeriyUserCanLogin() throws InterruptedException { 
	  lp.putemail();
	  lp.putpassword();
	  lp.clicklogin();
	  soft.assertTrue(hp.isProfileNameVisible());  
  }
  
  @Test(priority=2)
  public void verifyUserCanSearchProduct() throws EncryptedDocumentException, IOException, InterruptedException {
	  String dtat = hp.getDataFromExcelSheet("Sheet1",0, 0);
	  hp.enterSearchText(dtat);
	  hp.clickSearchButton();
	  
	  Assert.assertTrue(hp.isProductListAppeared());
  }
  
  @Test(priority=3)
  public void VerifyUserCanSelectProductAndMoveTOProdutDetailsPage() throws InterruptedException {
	hp.ClickOnFristProduct();
	Assert.assertTrue(pdp.isBuyNowButtonIsAppeared()) ;  
  }
  @Test(priority=4)
  public void VerifyUserCanAddProductToCart() throws InterruptedException {
	 
	  Assert.assertTrue(pdp.isProductListAppeared());
	 
	  pdp.ClickAddToCartButton();
	  Assert.assertTrue(pdp.isPlaceOrderButtonVisiable());
  }
  @Test(priority=5)
  public void VerifyCardCalculations() throws InterruptedException {
	          
  }
  
  @Test(priority=6)
  public void VerifyUserCanSelectDeliveryAddress() throws InterruptedException {
	      pdp.ClickToPlaceOrderButton();
	 	  Assert.assertTrue(pdp.isDelevaryAddressVisiable());
		  pdp.ClickToContinueButton();
	 	  pdp.ClickToAcceptAndContinueButton();
  }
  @Test(priority=7)
  public void VerifyUserSelectPeymentOption() throws InterruptedException {
	 
	 Assert.assertTrue(pdi.isOrderSummaryVisiable());
	
	 pdi.Click_SelectPhonePe();
	 Thread.sleep(1000);
	 
	 pdi.Click_ContinuButton();
	 pdi.Enter_Mobilenumber();
	 pdi.is_ClickSendOTPtoLogin();
	 Thread.sleep(30000);
	 
	 pdi.is_ClickSAVEDSAVED();
	 Thread.sleep(1000);
	 
	 pdi.is_EnterCardNumber();
	 pdi.is_EnterMM();
	 pdi.is_EnterYYYY();
	 pdi.is_EnterCVV();
	 pdi.Click_CheckBOX();
	 pdi.Click_paySubmitButton();
	
	  //pdi.ClickContinueButtonPay();
  } 
  
  @Test(priority=8)
  public void VerifUserPlacedQrderSuccessfully() {
	  
	 
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
		
	  if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, "Test is passed " + result.getName());
		}
		else{
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), 
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}  
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  report.flush();
	 // driver.quit();  
     } 
}
