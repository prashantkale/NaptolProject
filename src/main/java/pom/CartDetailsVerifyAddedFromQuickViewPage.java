package pom;

import java.time.Duration;
//import java.util.List;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDetailsVerifyAddedFromQuickViewPage {
	//@FindBy (xpath="//el[@id=\"shopCartHead\"]/li[1]/h1")private WebElement cartTitle;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[1]/div[2]/h2/a")private List<WebElement> cartProductTitle;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[2]/input")private List<WebElement> cartQTY;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[3]")private List<WebElement> cartUnitPrice;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[4]")private List<WebElement> cartShippingCharge;
	@FindBy (xpath="//ul[@id=\"cartData\"]/li[5]")private List<WebElement> cartAmount;
 
	public CartDetailsVerifyAddedFromQuickViewPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getDesiredProductAddedToCart(WebDriver driver,int index) 
	{ 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartProductTitle));
        return cartProductTitle.get(index).getText();
     // System.out.println(cartTitle);
	}
	
	public String getProductDescriptionIsCorrectInCart(WebDriver driver,int index)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartProductTitle));
		return cartProductTitle.get(index).getText();
	}
	
	public String getProductQuantityIsCorrectInCart(WebDriver driver,int index) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartQTY));
		return cartQTY.get(index).getText();
	}
	public int getProductPriceIsCorrectInCart(WebDriver driver,int index)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartUnitPrice));
	    String cartProductPrice =  cartUnitPrice.get(index).getText();
 	    //String cartPrice=cartProductPrice.replaceAll("[^0-9]","").substring(0,3);
 		int finalcartPrice= Integer.parseInt(cartProductPrice.replaceAll("[^0-9]","").substring(0,3));
 		System.out.println("Cart Unit Price:-"+finalcartPrice);
 		return finalcartPrice;
	}
	public int getProductShippingChargeCorrectInCart(WebDriver driver,int index)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartShippingCharge));
	    String cartShipCharge= cartShippingCharge.get(index).getText();
//    	String shipCharge=cartShipCharge.replaceAll("[^0-9]","").substring(0,3);
 		int finalShipCharge= Integer.parseInt(cartShipCharge.replaceAll("[^0-9]","").substring(0,3));
 		System.out.println("Cart Shiping Charge:-"+finalShipCharge);
 		return finalShipCharge;
	}
	
	public int getProductOrderAmountIsCorrectInCart(WebDriver driver,int index) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(cartAmount));
	    String cartOrderAmount= cartAmount.get(index).getText();
    	//String cartAmount=cartOrderAmount.replaceAll("[^0-9]","").substring(0,3);
 		int finalcartAmount= Integer.parseInt(cartOrderAmount.replaceAll("[^0-9]","").substring(0,3));
 		System.out.println("Cart Order Amount:-"+finalcartAmount);
 		return finalcartAmount;
	}
}
