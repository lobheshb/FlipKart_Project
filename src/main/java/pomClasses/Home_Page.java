package pomClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;

public class Home_Page extends UtilClass1{

	@FindBy(xpath="(//input[@name='q'])")private WebElement searchField ;   // 1
	
	@FindBy(xpath="(//button[@type='submit'])")private WebElement searchButton ;  // 2
	
	@FindBy(xpath="//div[@class='YUhWwv']")private WebElement cartBtn;  // 3
	
	@FindBy(xpath="//div[text()='Pramod N. ']")private WebElement profileName;  // 4
	
	@FindBy(xpath="(//div[@class='_2kHMtA'])[1]")private WebElement productList;  // 5
	
	//@findBy(xpath="")
	
	WebDriver driver;
	
	public Home_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}
	//1
	public void enterSearchText(String dtat) {
		searchField.sendKeys("realme");
	}
	//2
	public void clickSearchButton() {
		searchButton.click();
	}
	//3
	public void clickCartButton() {
		cartBtn.click();
	}
	//4
	public boolean isProfileNameVisible() {
		
		try {
			WebElement element = expliciteWait(driver,profileName);
			return true ;
		}catch(Exception e) {
			e.printStackTrace();   //or System.out.println(e);
		    return false;
		}
	}
	// 5
	public boolean isProductListAppeared() {
		
		try {
			WebElement element = expliciteWait(driver,productList);
			return true ;
		}catch (Exception e ) {
			e.printStackTrace();    //or System.out.println(e);
			return false;
		}
	  }
	 // Back Space
	public void clearSearchField(String searchData)
	{
		for(int a=0; a<searchData.length(); a++)
		{
			searchField.sendKeys(Keys.BACK_SPACE);
		}
		
	}

	public String getDataFromExcelSheet(String string, int row , int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("src\\main\\resources\\TestData\\Mob2.xlsx");   //File Path
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");        // Sheet data which pick in excel
		
		try {
			 String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		}catch(Exception e) {
			String data= String.valueOf(sheet.getRow(row).getCell(cell).getStringCellValue());
		}
		return string;
   }
	public void ClickOnFristProduct() {
       productList.click();
	   List<String> address = new ArrayList<String>(driver.getWindowHandles());
	   driver.switchTo().window(address.get(1));	
	}
	
}	