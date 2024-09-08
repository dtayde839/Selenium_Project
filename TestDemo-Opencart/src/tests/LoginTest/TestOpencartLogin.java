package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demoOpencartpageBean.OpencartRegister;
import utilities.UserDataProvider;

public class TestOpencartLogin 
{
	WebDriver driver;
	OpencartRegister or;
	
	@BeforeTest
	public void beforeTest()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo-opencart.com/");
		or = new OpencartRegister(driver);
	}
	
	@Test(dataProvider="dp")
	public void loginTest(String username, String password) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		or.clickMyacc();
		or.clickLoginBtn();
		or.setMail(username);
		or.setPwd(password);
		or.clickLogBtn();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
		String url = driver.getCurrentUrl();
		
//		Assert.assertTrue(url.contains("account/account"));
		
		if(url.contains("account/account")) 
		{
			or.clickMyacc();
			or.clickLogoutBtn();
			or.clickCon();
		}
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}

	@DataProvider
	public Object[][] dp()
	{
		Object[][] data = new Object[5][2];
		
//		valid username valid password
		data[0][0] = "tayde411@gmail.com";
		data[0][1] = "tayde@839";
		
//		valid username invalid password
		data[1][0] = "tayde411@gmail.com";
		data[1][1] = "efefe839";
		
//		invalid username valid password
		data[2][0] = "wrwwt344@gmail.com";
		data[2][1] = "tayde@839";

//		invalid username invalid password
		data[3][0] = "abcdd@gmail.com";
		data[3][1] = "12345";
		
//		blank username and password
		data[4][0] = "";
		data[4][1] = "";
		
		return data;
	}
		
}
