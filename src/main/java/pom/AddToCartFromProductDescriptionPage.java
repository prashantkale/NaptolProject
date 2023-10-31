package pom;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartFromProductDescriptionPage {
	
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[1]/div[2]/h2/a")private List<WebElement> cartProductTitle;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[2]/input")private List<WebElement> cartQTY;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[3]")private List<WebElement> cartUnitPrice;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[4]")private List<WebElement> cartShippingCharge;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[5]")private List<WebElement> cartAmount;
	@FindBy (xpath="//ul[@id=\"shopCartHead\"]/li[2]/a[1]")private WebElement continueShopping;
	@FindBy (xpath="//ul[@id='shopCartHead']/li[2]/a[2]")private WebElement checkoutbtn;
	
	
	
	public AddToCartFromProductDescriptionPage(WebDriver driver)  
	{
		PageFactory.initElements(driver,this);
	}
		
	   
    public String getCartProductTitle(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartProductTitle));
	    String cartproductTitle=cartProductTitle.get(index).getText();
	    System.out.println("Cart Product Title:-"+cartproductTitle);
        return cartproductTitle;
    }
    
    public String getCartPtoductQuantity(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartQTY));
	    String quantity=cartQTY.get(index).getText();
    	return quantity;
    }
    
    public int getCartProductPrice(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartUnitPrice));
     	String cartProductPrice =  cartUnitPrice.get(index).getText();
 	    String cartPrice=cartProductPrice.replaceAll("[^0-9]","").substring(0,4);
 		int finalcartPrice= Integer.parseInt(cartPrice);
 		System.out.println("Cart Unit Price:-"+finalcartPrice);
 		return finalcartPrice;
    }
    
    public int getCartProductShippingCharge(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartShippingCharge));
   	    String cartShipCharge= cartShippingCharge.get(index).getText();
    	String shipCharge=cartShipCharge.replaceAll("[^0-9]","").substring(0,3);
 		int finalShipCharge= Integer.parseInt(shipCharge);
 		System.out.println("Cart Shiping Charge:-"+finalShipCharge);
 		return finalShipCharge;
    }
    public int getCartProductOrderAmount(WebDriver driver,int index)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartAmount));
    	String cartOrderAmount= cartAmount.get(index).getText();
    	String cartAmount=cartOrderAmount.replaceAll("[^0-9]","").substring(0,4);
 		int finalcartAmount= Integer.parseInt(cartAmount);
 		System.out.println("Cart Order Amount:-"+finalcartAmount);
 		return finalcartAmount;
 		
    }
    
    public void clickOnContinueShopping(WebDriver driver)
    {    
    	continueShopping.click();   
    }
    
    public void ClickOnProccedToCheckoutButton(){ checkoutbtn.click(); }
    
}
    
    
    
    
    

