package test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.AddToCartFromProductDescriptionPage;
import pom.CartDetailsVerifyAddedFromQuickViewPage;
import pom.HomePageNaptol;
import pom.ProductDescriptionPage;
import pom.ProductSearchResultPage;
import pom.QuickViewProductDescriptionPage;

	public class TestMultipleProductAddToCart extends BaseTest {

	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver=LaunchBrowser.openBrowser();
	}
	
	@Test
	public void verifyMultipleProductAddToCartFunctionality() throws InterruptedException
	{
		 String parentPage=driver.getWindowHandle();
		 HomePageNaptol  homePageNaptol= new HomePageNaptol(driver);
		 homePageNaptol.enterProductToSearch("Cooker");
		 homePageNaptol.clickSearchButton();
		 
		 ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		 Thread.sleep(2000);
		 searchResultPage.moveToDesiredProduct(driver, 2);
		 searchResultPage.clickOnDesiredProduct(2);
		 ProductDescriptionPage productDescriptionPage=new ProductDescriptionPage(driver);
		 
		 Set<String> handles=driver.getWindowHandles();
		 Iterator<String> it=handles.iterator();
		 String parenwidowID=it.next();
		 System.out.println("Parent Window ID-:" + parenwidowID);
		 String	parentwindowTitle= driver.getTitle();
		 System.out.println("ParentWindow Title-:" + parentwindowTitle);
		 while(it.hasNext())
		 {
			 String childwidowID=it.next();
			 System.out.println("Child Window ID-:" + childwidowID);
			 Thread.sleep(5000);
			 driver.switchTo().window(childwidowID);
			 String childWindowTitle=driver.getTitle();
			 System.out.println("Child Window Title-:"+ childWindowTitle);
			 
			 if(childWindowTitle.contains("Buy 7 Pcs Induction Friendly Cookware"))
			 {
			 
			 productDescriptionPage.enterLocationPincode();
			 productDescriptionPage.clickOnPinCodeAvailabilityCheckButton();
			 productDescriptionPage.clickOnClickHereToBuyButton();
			 
			 Thread.sleep(5000);
			 AddToCartFromProductDescriptionPage cartPageObject=new AddToCartFromProductDescriptionPage(driver);
			 Assert.assertEquals(cartPageObject.getCartProductTitle(driver,0),productDescriptionPage.getDescriptionPageProductTitle(driver, 0));
			 Assert.assertEquals(cartPageObject.getCartProductPrice(driver,0),productDescriptionPage.getProductDisplayPrice(driver, 0));
			 Assert.assertEquals(cartPageObject.getCartProductShippingCharge(driver,0),productDescriptionPage.getProductShippingCharge(driver,0));
			 Assert.assertEquals(cartPageObject.getCartProductOrderAmount(driver,0),productDescriptionPage.getProductOrderAmount(driver,0));
			 
//			 
//			  if(cartPageObject.getCartPtoductQuantity(driver) == "1")
//			  { 
			      Thread.sleep(5000);
				  cartPageObject.clickOnContinueShopping(driver);
	     		  driver.switchTo().window(parentPage);
				  Thread.sleep(2000);
				 
				 HomePageNaptol  homePageNaptol2= new HomePageNaptol(driver);
				 homePageNaptol2.enterProductToSearch("Lunch Box");
				 homePageNaptol2.clickSearchButton();
				 
				 ProductSearchResultPage searchResultPage2 = new ProductSearchResultPage(driver);
				 Thread.sleep(2000);
				 searchResultPage2.moveToDesiredProduct(driver, 1);
				 QuickViewProductDescriptionPage quickViewDescriptionPage=new QuickViewProductDescriptionPage(driver);
				 quickViewDescriptionPage.clickOnQuickView(1);
				 
				 Set<String> handles2=driver.getWindowHandles();
				 Iterator<String> it2=handles2.iterator();
				 String parenwidowID2 =it2.next();
				 System.out.println("Parent Window ID2-:" + parenwidowID2);
				 String	parentwindowTitle2= driver.getTitle();
				 System.out.println("ParentWindow Title2-:" + parentwindowTitle2);
				 while(it2.hasNext())
				 {
					 String childwidowID2=it2.next();
					 System.out.println("Child Window ID2-:" + childwidowID2);
					 Thread.sleep(5000);
					 //driver.switchTo().window(childwidowID2);
					 String childWindowTitle2=driver.getTitle();
					 System.out.println("Child Window Title2-:"+ childWindowTitle2);
					 
					 if(childWindowTitle2.contains("Search Result for Lunch Box"))
					 {
						 Thread.sleep(5000);
						 quickViewDescriptionPage.clickOnColorButton(driver);
						 quickViewDescriptionPage.changeLocationPincode();
						 quickViewDescriptionPage.enterLocationPincode();
						 quickViewDescriptionPage.clickOnPinCodeAvailabilityCheckButton();
						 quickViewDescriptionPage.clickOnClickHereToBuyButton();
					 //QuickViewProductDescriptionPage quickViewDescriptionPage=new QuickViewProductDescriptionPage(driver);
//					 AsAssert.assertEquals(cartPageObject.getCartProductTitle(driver,0)+1,quickViewDescriptionPage.getQuickViewProductTitle(driver,0)+1);
//					 Assert.assertEquals(cartPageObject.getCartProductPrice(driver,0)+1,quickViewDescriptionPage.getQuickViewProductDisplayPrice(driver,0)+1);
//					 Assert.assertEquals(cartPageObject.getCartProductShippingCharge(driver,0)+1,quickViewDescriptionPage.getQuickViewProductShippingCharge(driver,0)+1);
//					 sert.assertEquals(cartPageObject.getCartProductOrderAmount(driver,0)+1,quickViewDescriptionPage.getQuickViewProductOrderAmount(driver,0)+1);
					 
					 }
//					 AddToCartFromProductDescriptionPage cartPageObject=new AddToCartFromProductDescriptionPage(driver);
//					 Assert.assertEquals(cartPageObject.getCartProductTitle(driver,0),productDescriptionPage.getDescriptionPageProductTitle(driver, 0));
//					 Assert.assertEquals(cartPageObject.getCartProductPrice(driver,0),productDescriptionPage.getProductDisplayPrice(driver, 0));
//					 Assert.assertEquals(cartPageObject.getCartProductShippingCharge(driver,0),productDescriptionPage.getProductShippingCharge(driver,0));
//					 Assert.assertEquals(cartPageObject.getCartProductOrderAmount(driver,0),productDescriptionPage.getProductOrderAmount(driver,0));
//					 
			    }
			 }
			 
		 }
	}

  }
