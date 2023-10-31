package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartDetailsVerifyAddedFromQuickViewPage;
import pom.HomePageNaptol;
import pom.ProductSearchResultPage;
import pom.QuickViewProductDescriptionPage;

public class TestProductSearchPage extends BaseTest{
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver = LaunchBrowser.openBrowser();
	}
	
	@Test(priority =1)
	public void verifyProductSearchTest()
	{
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.enterProductToSearch("Cooker");
		homePageNaptol.clickSearchButton();
		ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		int products=searchResultPage.getNumberOfProductDispalyedAfterSerach();
		//Assert.assertTrue(products > 0);
		Assert.assertTrue(driver.getTitle().contains("Cooker"));
		
		
	}
	@Test(priority=2)
	public void verifyProductIsVisibleInQuickViewTab() throws InterruptedException
	{
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.enterProductToSearch("Cooker");
		homePageNaptol.clickSearchButton();
		ProductSearchResultPage searchResultPage=new ProductSearchResultPage(driver);
		String title=searchResultPage.getProductTitle(0);
		Thread.sleep(2000);
		searchResultPage.moveToDesiredProduct(driver, 0);
		QuickViewProductDescriptionPage quickViewDescriptionPage=new QuickViewProductDescriptionPage(driver);
		quickViewDescriptionPage.clickOnQuickView(0);
		String QkvTitle=quickViewDescriptionPage.getQuickViewProductTitle(driver, 0);
		System.out.println(QkvTitle);
		Assert.assertTrue(QkvTitle.contains(title));
		quickViewDescriptionPage.getQuickViewProductDisplayPrice(driver, 0);
//	    String price=productPrice.replaceAll("[^0-9]","").substring(0,4);
//		int finalPrice= Integer.parseInt(price);
//	    System.out.println(finalPrice);
		quickViewDescriptionPage.getQuickViewProductShippingCharge(driver, 0);
//	    String shippingPrice=productPrice.replaceAll("[^0-9]", "").substring(4,7);
//	    int finalShipingPrice= Integer.parseInt(shippingPrice);
//	    System.out.println(finalShipingPrice);
		quickViewDescriptionPage.enterLocationPincode();
		quickViewDescriptionPage.clickOnPinCodeAvailabilityCheckButton();
		quickViewDescriptionPage.clickOnClickHereToBuyButton();
		
		
	}
	
	
}
