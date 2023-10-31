package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.HomePageNaptol;

public class TestNaptolHomePage extends BaseTest {
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver=LaunchBrowser.openBrowser();
	}
	
	@Test
	public void naptolLoginTest() throws InterruptedException
	{
		HomePageNaptol homePageNaptol=new HomePageNaptol(driver);
		homePageNaptol.clickOnLoginOrRegister();
		homePageNaptol.enterMobileNumber("8080145250");
		homePageNaptol.clickOnContinueButton();
		Thread.sleep(30000);
		Assert.assertTrue(homePageNaptol.isLogoutDisplayed());
		Assert.assertEquals(homePageNaptol.getUserName(),"PK");
		
	}

}
