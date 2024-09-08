      package demoOpencartpageBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpencartRegister 
{
	By myacc = By.cssSelector(".list-inline-item>.dropdown>a>span.d-md-inline");
	By reg = By.linkText("Register");
	By log = By.linkText("Login");
	By fname = By.id("input-firstname");
	By lname = By.id("input-lastname");
	By email = By.id("input-email");
	By pass = By.id("input-password");
	By plc = By.name("agree");
	By sub = By.cssSelector("button[type='submit']");
	By usermail = By.id("input-email");
	By userpass = By.id("input-password");
	By btn = By.cssSelector(".text-end>button");
	By lout = By.xpath("//*[@id='top']/div/div[2]/ul/li[2]/div/ul/li[5]/a");
	By con = By.xpath("//*[@id='content']/div/a");
	By fnameError = By.id("error-firstname");
	By lnameError = By.id("error-lastname");
	By emailError = By.id("error-email");
	By pwdError = By.id("error-password");
	
	WebDriver driver;
	
//	constructor
	public OpencartRegister(WebDriver driver)
	{
		this.driver = driver;
	}
	
//	methods
	public void clickMyacc()
	{
		driver.findElement(myacc).click();
	}
	
	public void clickRegBtn()
	{
		driver.findElement(reg).click();
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(log).click();
	}
	
	public void setFname(String name)
	{
		driver.findElement(fname).sendKeys(name);
	}
	
	public void setLname(String ln)
	{
		driver.findElement(lname).sendKeys(ln);
	}
	
	public void setMail(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	public void setPass(String pwd)
	{
		driver.findElement(pass).sendKeys(pwd);
	}
	
	public void clickAgree()
	{
		driver.findElement(plc).click();
	}
	
	public void clickSubBtn()
	{
		driver.findElement(sub).click();
	}
	
	public void setUname(String umail)
	{
		driver.findElement(usermail).sendKeys(umail);
	}
	
	public void setPwd(String pass)
	{
		driver.findElement(userpass).sendKeys(pass);
	}
	
	public void clickLogBtn()
	{
		driver.findElement(btn).click();
	}
	
	public void clickLogoutBtn()
	{
		driver.findElement(lout).click();;
	}
	
	public void clickCon()
	{
		driver.findElement(con).click();
	}
	
	public String fnameError()
	{
		return driver.findElement(fnameError).getText();
	}
	
	public String lnameError()
	{
		return driver.findElement(lnameError).getText();
	}
	
	public String emailError()
	{
		return driver.findElement(emailError).getText();
	}
	
	public String pwdError()
	{
		return driver.findElement(pwdError).getText();
	}
}
