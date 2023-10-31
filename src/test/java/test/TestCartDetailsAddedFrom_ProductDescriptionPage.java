package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.AddToCartFromProductDescriptionPage;
import pom.HomePageNaptol;
import pom.ProductDescriptionPage;
import pom.ProductSearchResultPage;

public class TestCartDetailsAddedFrom_ProductDescriptionPage extends BaseTest {

	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		driver=LaunchBrowser.openBrowser();
	}
	
	@Test(priority = 1)
	public void verifyItemAddedToCartSuccessfully() throws InterruptedException
	{
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.enterProductToSearch("Cooker");
		homePageNaptol.clickSearchButton();
		
		ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		Thread.sleep(2000);
		searchResultPage.moveToDesiredProduct(driver, 1);
		searchResultPage.clickOnDesiredProduct(1);
		
		//AddToCartFromProductDescriptionPage descriptionPage =new AddToCartFromProductDescriptionPage(driver);
		//String handle= driver.getWindowHandle();
		ProductDescriptionPage descPage1=new ProductDescriptionPage(driver);
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowID= it.next();
		System.out.println(parentWindowID);
		String parentTitle=driver.getTitle();
		System.out.println("ParentWindow Title-:"+ parentTitle);
		while(it.hasNext()) {
			String childWindowID=it.next();
			System.out.println(childWindowID);
			Thread.sleep(5000);
			driver.switchTo().window(childWindowID);
			String currentTitle=driver.getTitle();
			System.out.println("Child Window title-:"+currentTitle);
			Thread.sleep(5000);
			if(currentTitle.contains("Buy Bluetooth Calling Smart Watch"))
			{
				
				descPage1.enterLocationPincode();
				descPage1.clickOnPinCodeAvailabilityCheckButton();
				descPage1.clickOnClickHereToBuyButton();
				AddToCartFromProductDescriptionPage cartProduct= new AddToCartFromProductDescriptionPage(driver);
				Assert.assertEquals(cartProduct.getCartProductTitle(driver, 0),descPage1.getDescriptionPageProductTitle(driver, 0));
				
			}
					
		}
		
	}
	
	
	
	@Test(priority = 2)
	public void verifyCartProductDescriptionMatchesWithProductDescriptionPage() throws InterruptedException
	{
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.enterProductToSearch("Cooker");
		homePageNaptol.clickSearchButton();
		
		ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		Thread.sleep(2000);
		searchResultPage.moveToDesiredProduct(driver, 1);
		searchResultPage.clickOnDesiredProduct(1);
		
        ProductDescriptionPage descPage1=new ProductDescriptionPage(driver);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowID= it.next();
		System.out.println(parentWindowID);
		String parentTitle=driver.getTitle();
		System.out.println("ParentWindow Title-:"+ parentTitle);
		while(it.hasNext()) {
			String childWindowID=it.next();
			//System.out.println(childWindowID);
			Thread.sleep(5000);
			driver.switchTo().window(childWindowID);
			String currentTitle=driver.getTitle();
			//System.out.println("Child Window title-:"+currentTitle);
			Thread.sleep(5000);
			if(currentTitle.contains("Buy"))
			{
				
				descPage1.enterLocationPincode();
				descPage1.clickOnPinCodeAvailabilityCheckButton();
				descPage1.clickOnClickHereToBuyButton();
				AddToCartFromProductDescriptionPage cartProduct= new AddToCartFromProductDescriptionPage(driver);

				Assert.assertEquals(descPage1.getDescriptionPageProductTitle(driver, 0),cartProduct.getCartProductTitle(driver, 0));
				Assert.assertEquals(descPage1.getProductDisplayPrice(driver, 0),cartProduct.getCartProductPrice(driver, 0));
				Assert.assertEquals(descPage1.getProductShippingCharge(driver, 0),cartProduct.getCartProductShippingCharge(driver, 0));
				Assert.assertEquals(descPage1.getProductOrderAmount(driver, 0),cartProduct.getCartProductOrderAmount(driver, 0));
				
			}
					
		}
	}
}
