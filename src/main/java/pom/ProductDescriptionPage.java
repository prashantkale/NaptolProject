package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDescriptionPage {
	@FindBy (xpath="//div[@id='square_Details']/h1")private List<WebElement> descriptionProductTitle;
	@FindBy (xpath="//li[@id='productPriceDisplay']/span[2]")private List<WebElement> productDisplayPrice1;
	@FindBy (xpath="//input[@id='pincodeDeliveryId_0']")private WebElement pinCodeEnter1;
	@FindBy (xpath="//div[@id='pincodeForDeliveryDiv_provide_0']/a/span")private WebElement clickCheckBtn1;
	@FindBy (xpath="//a[@id='cart-panel-button-0']/span")private WebElement clickOnBuyBtn1;
	@FindBy (xpath="//ul[@id='color_box_0']/li[1]/a")private WebElement colorOption;
	@FindBy (xpath="//div[@id='pincodeForDeliveryDiv_modify_0']/a")private WebElement changePinCode;
	
	
	public ProductDescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getDescriptionPageProductTitle(WebDriver driver,int index)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3500));
		wait.until(ExpectedConditions.visibilityOfAllElements(descriptionProductTitle));
		String DescTitle=descriptionProductTitle.get(index).getText();
		System.out.println("Description Page Product Title:-"+DescTitle);
		return DescTitle;
	}
	public int getProductDisplayPrice(WebDriver driver,int index)
    {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3500));
		wait.until(ExpectedConditions.visibilityOfAllElements(productDisplayPrice1));
    	//return productDisplayPrice1.getText();
    	String productPrice =  productDisplayPrice1.get(index).getText();
	    String price=productPrice.replaceAll("[^0-9]","").substring(0,4);
		int unitPrice= Integer.parseInt(price);
		System.out.println("Description Page Product Price:-"+unitPrice);
		return unitPrice;
    }
	public int getProductShippingCharge(WebDriver driver,int index)
    {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3500));
		wait.until(ExpectedConditions.visibilityOfAllElements(productDisplayPrice1));
    	//return productDisplayPrice1.getText();
    	String productPrice =  productDisplayPrice1.get(index).getText();
	    String price=productPrice.replaceAll("[^0-9]","").substring(4,7);
		int ShippingCharge= Integer.parseInt(price);
		System.out.println("Description Page Shipping Charge:-"+ShippingCharge);
		return ShippingCharge;
    }
    
	public int getProductOrderAmount(WebDriver driver,int index)
    {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3500));
		wait.until(ExpectedConditions.visibilityOfAllElements(productDisplayPrice1));
    	//return productDisplayPrice1.getText();
    	String productPrice =  productDisplayPrice1.get(index).getText();
    	String price=productPrice.replaceAll("[^0-9]","").substring(0,4);
		int finalPrice= Integer.parseInt(price);

	    String price1=productPrice.replaceAll("[^0-9]","").substring(4,7);
		int ShippingCharge= Integer.parseInt(price1);
		int finalOrderAmount=finalPrice+ShippingCharge;
		System.out.println("Description Page Product Order Amount Total:-"+finalOrderAmount);
		return finalOrderAmount;
    }
	
	public void clickOnColorButton() 
	  { 
	    	colorOption.click(); 
	  } 
    public void enterLocationPincode()
    { 
    	pinCodeEnter1.sendKeys("422011"); 
    }
    
    public void clickOnPinCodeAvailabilityCheckButton()
    { 
    	clickCheckBtn1.click();
    }
	
    public void clickOnClickHereToBuyButton()
    { 
    	clickOnBuyBtn1.click();
    }
    public void changeLocationPincode()
    { 
    	changePinCode.click(); 
    }
    
    

}
