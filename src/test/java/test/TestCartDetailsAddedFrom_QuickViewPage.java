package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartDetailsVerifyAddedFromQuickViewPage;
import pom.HomePageNaptol;
import pom.ProductSearchResultPage;
import pom.QuickViewProductDescriptionPage;

public class TestCartDetailsAddedFrom_QuickViewPage extends BaseTest{
	
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver=LaunchBrowser.openBrowser();
	}
	
	@Test(priority = 1)
	public void verifyProductAddedToCartSuccessfully() throws InterruptedException
	{ 
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.enterProductToSearch("Cooker");
		homePageNaptol.clickSearchButton();
		
		ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		Thread.sleep(2000);
		searchResultPage.moveToDesiredProduct(driver, 2);
		QuickViewProductDescriptionPage quickViewDescriptionPage= new QuickViewProductDescriptionPage(driver);
		quickViewDescriptionPage.clickOnQuickView(2);
		String QkvTitle=quickViewDescriptionPage.getQuickViewProductTitle(driver, 0);
		System.out.println("Quick View Product Title:---"+QkvTitle);
		Thread.sleep(3000);
		quickViewDescriptionPage.enterLocationPincode();
		quickViewDescriptionPage.clickOnPinCodeAvailabilityCheckButton();
		quickViewDescriptionPage.clickOnClickHereToBuyButton();
		
		CartDetailsVerifyAddedFromQuickViewPage cartDetailsVerify= new CartDetailsVerifyAddedFromQuickViewPage(driver);
		String itemAddToCartTitle=cartDetailsVerify.getDesiredProductAddedToCart(driver, 0);
		System.out.println("Cart Product Title:---"+itemAddToCartTitle);
		Assert.assertEquals(itemAddToCartTitle,QkvTitle);
	
	}
	
	@Test(priority = 2 ) 
	public void verifyProductDescriptionMatchesWithQuickViewProductDescription() throws InterruptedException
	{
		System.out.println("<---QuickView Product Details--->");
		//Click on Search Button
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.enterProductToSearch("Mobile");
		homePageNaptol.clickSearchButton();
		
		//Click on QuickView & Print Title
		ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		Thread.sleep(2000);
		searchResultPage.moveToDesiredProduct(driver, 3);
		QuickViewProductDescriptionPage quickViewDescriptionPage= new QuickViewProductDescriptionPage(driver);
		quickViewDescriptionPage.clickOnQuickView(3);
		String QkvTitle=quickViewDescriptionPage.getQuickViewProductTitle(driver, 0);
		System.out.println("QuickView Product Title:-"+ QkvTitle);
		//Assert.assertTrue(QkvTitle.contains(title));
		
		//Extract Price & Shipping charge  from quickView and print finalOrderAmount
		quickViewDescriptionPage.getQuickViewProductDisplayPrice(driver, 0);
		quickViewDescriptionPage.getQuickViewProductShippingCharge(driver, 0);
		quickViewDescriptionPage.getQuickViewProductOrderAmount(driver, 0);
//	    String price= productPrice.replaceAll("[^0-9]","").substring(0,4);
//		int finalPrice= Integer.parseInt(price);
//	    System.out.println("Quick View Unit Price:-"+finalPrice);
//	    String shippingCharge=productPrice.replaceAll("[^0-9]", "").substring(4,7);
//	    int finalShipingCharge= Integer.parseInt(shippingCharge);
//	    System.out.println("Quick View Shipping Charge:-"+finalShipingCharge);
	    
//	    int orderAmountTotal= finalPrice+finalShipingCharge;
//	    System.out.println("Total Amount Calculated:-"+orderAmountTotal);
        Thread.sleep(3000);
		quickViewDescriptionPage.enterLocationPincode();
		quickViewDescriptionPage.clickOnPinCodeAvailabilityCheckButton();
		quickViewDescriptionPage.clickOnClickHereToBuyButton();
	    
	    
		System.out.println("<---CartView Product Details--->");  
	    //Check CartItem & Quickview item same
	    CartDetailsVerifyAddedFromQuickViewPage cartDetailsVerify= new CartDetailsVerifyAddedFromQuickViewPage(driver);
//		cartDetailsVerify.getProductDescriptionIsCorrectInCart(driver);
//		System.out.println("Product Title In Cart:-"+itemAddedTitle);
		Assert.assertEquals(cartDetailsVerify.getDesiredProductAddedToCart(driver, 0),quickViewDescriptionPage.getQuickViewProductTitle(driver, 0));
		
		//Print quantity
		
		cartDetailsVerify.getProductQuantityIsCorrectInCart(driver, 0);
		//int cartQuantity=Integer.parseInt(quantity);
//		System.out.println(quantity);
		
		//print product price
		cartDetailsVerify.getProductPriceIsCorrectInCart(driver, 0);
//	    String cartPrice=cartproductPrice.replaceAll("[^0-9]","").substring(0,4);
//		int finalCartPrice= Integer.parseInt(cartPrice);
//	    System.out.println("Unit Price in Cart:-"+finalCartPrice);
	    Assert.assertEquals(cartDetailsVerify.getProductPriceIsCorrectInCart(driver, 0), quickViewDescriptionPage.getQuickViewProductDisplayPrice(driver, 0));
	    
	    //print shipping charge
	    cartDetailsVerify.getProductShippingChargeCorrectInCart(driver, 0);
//	    String cartshipingCharge=cartProductShipingCharge.replaceAll("[^0-9]","").substring(0,3);
//		int finalCartShipingCharge= Integer.parseInt(cartshipingCharge);
//	    System.out.println("Shipping Charge in Cart:-"+finalCartShipingCharge);
	    Assert.assertEquals(cartDetailsVerify.getProductShippingChargeCorrectInCart(driver, 0), quickViewDescriptionPage.getQuickViewProductShippingCharge(driver, 0));	
			
	    //CartDetailsVerifyPage cartDetailsVerify= new CartDetailsVerifyPage(driver);
		cartDetailsVerify.getProductOrderAmountIsCorrectInCart(driver, 0);
//		String cartOrderAmount1=cartOrderAmount.replaceAll("[^0-9]","").substring(0,4);
//		int totalCartAmount=Integer.parseInt(cartOrderAmount1);
//		System.out.println("Total Order Amount in Cart:-"+totalCartAmount);
		Assert.assertEquals(cartDetailsVerify.getProductOrderAmountIsCorrectInCart(driver, 0), quickViewDescriptionPage.getQuickViewProductOrderAmount(driver, 0)); 
	}
	
}
