package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import demoOpencartpageBean.OpencartRegister;

public class TestRegistrationWithDuplicateUsername 
{
	WebDriver driver;
	OpencartRegister or;
	File file;
	FileInputStream fis;
	Properties p;
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		String fpath = "C:\\Users\\acer\\TestNg_Workspace\\Selenium_Practise\\src\\test\\resources\\demoOpencart.properties";
		file = new File(fpath);
		fis = new FileInputStream(file);
		p = new Properties();
		p.load(fis);   
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("url"));
		or = new OpencartRegister(driver);	
	}
	
	@BeforeMethod
	public void beforeMethod()
	{                     
		or.clickMyacc();
		or.clickRegBtn();
	}
//	
	@Test(dataProvider="data")
	public void testRegistration(String uname, String lname, String mail, String pwd) throws InterruptedException
	{
		or.setFname(uname);
		or.setLname(lname);
		or.setMail(mail);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700);");
		or.setPass(pwd);
		or.clickAgree();
		or.clickSubBtn();
		Thread.sleep(2000);
		
		WebElement duplicateErr = driver.findElement(By.xpath("//*[@id='alert']/dirv"));
		WebElement close = driver.findElement(By.xpath("//*[@id='alert']/dirv/button"));
		
		if(duplicateErr.isDisplayed())
		{
			System.out.println("Error message for duplicate email is: " +duplicateErr.getText());
			close.click();
		}	
	}
	
	@DataProvider(name="data")
	public Object[][] dataset()
	{
		return new Object[][] 
		{
//			duplicate
			{"Dinesh", "Tayde", "tayde411@gmail.com", "tayde@839"}
		};
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}

}
