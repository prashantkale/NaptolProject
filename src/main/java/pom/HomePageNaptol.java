package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageNaptol {
	
	@FindBy (xpath="//a[@id='login-panel-link']")private WebElement loginOrRegister;
	@FindBy (xpath="//a[text()='Track Order']]")private WebElement trackOrder;
	@FindBy (xpath="//div[@onmouseover='javascript:menu.showMainMenu(true)']")private WebElement shoppingCategories;
	@FindBy (xpath="//input[@id='header_search_text']")private WebElement searchBox;
	@FindBy (xpath="(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement searchButon;
	@FindBy (xpath="(//a[@id='cart-panel-link'])[2]")private WebElement cartButon;
	@FindBy (xpath="//input[@id='registration-basic-panel-mobile']")private WebElement enterMobile;
	@FindBy (xpath="//input[@id='registration-basic-panel-submit']")private WebElement clickContinuebtn;
	@FindBy (xpath="//div[@class='small_links']//b")private WebElement userName;
	@FindBy (xpath="//a[text()='Logout']")private WebElement logout;
	//@FindBy (xpath="//a[@id='visitor-panel-link']")private WebElement displayUsername;
	
	
	public HomePageNaptol(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public void clickOnLoginOrRegister() 
	{
		loginOrRegister.click();
	}
	
	public void enterMobileNumber(String number)
	{
		enterMobile.sendKeys(number);
	}
	public void clickOnContinueButton()
	{
		clickContinuebtn.click();
	}
	
	public void clickOnTrackOrder()
	{
		trackOrder.click();
	}
	
	public void moveToShoppingCategories(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(shoppingCategories);
		actions.perform();
	}
	
	public void enterProductToSearch(String Product)
	{
		searchBox.clear();
		searchBox.sendKeys(Product);
	}
	
	public void clickSearchButton()
	{
		searchButon.click();
	}
	
	public void clickOnCartButton()
	{
		cartButon.click();
	}
	
	public boolean isLogoutDisplayed()
	{
		return logout.isDisplayed();
	}

	public String getUserName()
	{
	return userName.getText();
	}
}


