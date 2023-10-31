package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	public static WebDriver openBrowser() throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.naaptol.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		return driver;
	}
	
	

}
