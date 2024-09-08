                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import demoOpencartpageBean.OpencartRegister;

public class TesttRegistrationWithBlankFields
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
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
		
		WebElement fnameErrorMsg = driver.findElement(By.id("error-firstname"));
		WebElement lnameErrorMsg = driver.findElement(By.id("error-lastname"));
		WebElement emailErrorMsg = driver.findElement(By.id("error-email"));
		WebElement pwdErrorMsg = driver.findElement(By.id("error-password"));
		
		if(fnameErrorMsg.isDisplayed())
		{
			System.out.println("Error message for wrong first name is: " +fnameErrorMsg.getText());
		}
		
		if(lnameErrorMsg.isDisplayed())
		{
			System.out.println("Error message for wrong last name is: " +lnameErrorMsg.getText());
		}
		
		if(emailErrorMsg.isDisplayed())
		{
			System.out.println("Error message for wrong email is: " +emailErrorMsg.getText());
		}
		
		if(pwdErrorMsg.isDisplayed())
		{
			System.out.println("Error message for wrong password is: " +pwdErrorMsg.getText());
		}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		
		WebElement element = driver.findElement(By.linkText("My Account"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	@DataProvider(name="data")
	public Object[][] dataset()
	{
		return new Object[][] 
		{
//			Blank fields
			{"", "Tayde", "abrt5536@gmail.com", "tayde@839"},
			{"Dinesh", "", "abrt717@gmail.com", "tayde@839"},
			{"Dinesh", "Tayde", "", "tayde@839"},
			{"Dinesh", "Tayde", "abrt419@gmail.com", ""},
			{"", "", "", ""}
		};
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
}
