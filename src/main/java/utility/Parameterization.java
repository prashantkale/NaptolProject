package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pojo.LaunchBrowser;



public class Parameterization {
	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriver driver=LaunchBrowser.openBrowser("https://www.facebook.com");
		
		String emailId=Parameterization.getExcelData("Creds",0,0);
		
		
		
		WebElement uname=driver.findElement(By.xpath("//input[@id='email']"));
		uname.sendKeys("email");
		
		WebElement pwd=driver.findElement(By.xpath(""));
		pwd.sendKeys("PrashntP");
	
		FileInputStream file=new FileInputStream("C:\\Users\\prashant\\Desktop\\Testdata.xlsx");
		
		String value =WorkbookFactory.create(file).getSheet("New").getRow(1).getCell(0).getStringCellValue();
		System.out.println(value);
	}


}
