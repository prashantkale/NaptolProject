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

public class ProductSearchResultPage {
	
	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath="//a[@href='#QuickView']")private List<WebElement> quickView;
	@FindBy (xpath="//div[@class='item_title']")private List<WebElement> productTitle;
	//@FindBy (xpath="//div[@id='square_Details']/h1")private List<WebElement> descriptionProductTitle;
	@FindBy	(xpath="//div[@id='square_Details']/h1")private WebElement quickViewProductTitle;
	@FindBy (xpath="//li[@id='productPriceDisplay']/span[2]")private WebElement productDisplayPrice;
	@FindBy (xpath="//input[@id='pincodeDeliveryId_0']")private WebElement pinCodeEnter;
	@FindBy (xpath="(//a[@class='button_1'])[3]")private WebElement clickCheckBtn;
	@FindBy (xpath="//a[@id='cart-panel-button-0']/span")private WebElement clickOnBuyBtn;
	@FindBy (xpath="//ul[@id='color_box_0']/li[1]/a")private WebElement colorOption;

	public ProductSearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public int getNumberOfProductDispalyedAfterSerach()
	{
		return products.size();
	}
	
	public void moveToDesiredProduct(WebDriver driver,int index)
	{
		Actions action=new Actions(driver);
		action.moveToElement(products.get(index));
		action.perform();
	}
	
	public void clickOnDesiredProduct(int index)
	{
		products.get(index).click();
	}
	
	public String getProductTitle(int index)
	{
		return productTitle.get(index).getText();
	}
	
	
	
//	public void clickOnQuickView(int index)
//	{
//		quickView.get(index).click();
//	}
//	
//    public String getQuickViewProductTitle(WebDriver driver)
//    {
//    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
//		wait.until(ExpectedConditions.visibilityOf(quickViewProductTitle));
//		return quickViewProductTitle.getText();
//    }
//    public String getProductDisplayPrice(WebDriver driver)
//    {
//    	return productDisplayPrice.getText();
//    }
//    
//    public void clickOnColorButton(WebDriver driver) 
//    { 
//    	colorOption.click(); 
//    } 
//    
//    public void enterLocationPincode()
//    { 
//    	pinCodeEnter.sendKeys("422011"); 
//    }
//    
//    public void clickOnPinCodeAvailabilityCheckButton()
//    { 
//    	clickCheckBtn.click();
//    }
//	
//    public void clickOnClickHereToBuyButton()
//    { 
//    	clickOnBuyBtn.click();
//    }
    }
