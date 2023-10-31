package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickViewProductDescriptionPage {
	
//	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath="//a[@href='#QuickView']")private List<WebElement> quickView;
//	@FindBy (xpath="//div[@class='item_title']")private List<WebElement> productTitle;
	//@FindBy (xpath="//div[@id='square_Details']/h1")private List<WebElement> descriptionProductTitle;
	@FindBy	(xpath="//div[@id='square_Details']/h1")private List<WebElement> quickViewProductTitle;
	@FindBy (xpath="//li[@id='productPriceDisplay']/span[2]")private List<WebElement> productDisplayPrice;
		
	@FindBy (xpath="//input[@id='pincodeDeliveryId_0']")private WebElement pinCodeEnter;
	@FindBy (xpath="(//a[@class='button_1'])[3]")private WebElement clickCheckBtn;
	@FindBy (xpath="//a[@id='cart-panel-button-0']/span")private WebElement clickOnBuyBtn;
	@FindBy (xpath="//ul[@id='color_box_0']/li[1]/a")private WebElement colorOption;
	@FindBy (xpath="//div[@id='pincodeForDeliveryDiv_modify_0']/a")private WebElement changePinCode;
	
	public QuickViewProductDescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnQuickView(int index)
	{
		quickView.get(index).click();
	}
	
    public String getQuickViewProductTitle(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(quickViewProductTitle));
		String productTitle= quickViewProductTitle.get(index).getText();
		System.out.println("QuickView Page Product Title:-"+productTitle);
		return productTitle;
    }
    public int getQuickViewProductDisplayPrice(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productDisplayPrice));
    	//return productDisplayPrice1.getText();
    	String productPrice =  productDisplayPrice.get(index).getText();
	    String price=productPrice.replaceAll("[^0-9]","").substring(0,3);
		int unitPrice= Integer.parseInt(price);
		System.out.println("QuickView Description Page Product Price:-"+unitPrice);
		return unitPrice;
    }
    public int getQuickViewProductShippingCharge(WebDriver driver,int index)
    {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productDisplayPrice));
    	//return productDisplayPrice1.getText();
    	String productPrice =  productDisplayPrice.get(index).getText();
	    String price=productPrice.replaceAll("[^0-9]","").substring(3,6);
		int ShippingCharge= Integer.parseInt(price);
		System.out.println("QuickView Description Page Shipping Charge:-"+ShippingCharge);
		return ShippingCharge;
    }
    public int getQuickViewProductOrderAmount(WebDriver driver,int index)
    {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productDisplayPrice));
    	//return productDisplayPrice1.getText();
    	String productPrice =  productDisplayPrice.get(index).getText();
    	String price=productPrice.replaceAll("[^0-9]","").substring(0,3);
		int finalPrice= Integer.parseInt(price);

	    String price1=productPrice.replaceAll("[^0-9]","").substring(3,6);
		int ShippingCharge= Integer.parseInt(price1);
		int finalOrderAmount=finalPrice+ShippingCharge;
		System.out.println("QuickView Description Page Product Order Amount Total:-"+finalOrderAmount);
		return finalOrderAmount;
    }
    
    public void clickOnColorButton(WebDriver driver) 
    { 
    	colorOption.click(); 
    } 
    
    public void enterLocationPincode()
    { 
    	pinCodeEnter.sendKeys("422011"); 
    }
    
    public void clickOnPinCodeAvailabilityCheckButton()
    { 
    	clickCheckBtn.click();
    }
	
    public void clickOnClickHereToBuyButton()
    { 
    	clickOnBuyBtn.click();
    }
    public void changeLocationPincode()
    { 
    	changePinCode.click(); 
    }
  }
