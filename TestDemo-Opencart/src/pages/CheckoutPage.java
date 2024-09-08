package demoOpencartpageBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	By login = By.linkText("login page");
	By add = By.id("input-shipping-address");
	By shipm = By.id("button-shipping-methods");
	By frate = By.id("input-shipping-method-flat-flat");
	By smehtod = By.id("button-shipping-method");
	By pay = By.id("button-payment-methods");
	By cod = By.id("input-payment-method-cod-cod");
	By con = By.id("button-payment-method");
	By cnfmBtn = By.id("button-confirm");
	By act = By.cssSelector("#common-success>.row>#content>h1");
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(login).click();
	}
	
	public void clickAdd()
	{
		driver.findElement(add).click();
	}
	
	public void clickShipm()
	{
		driver.findElement(shipm).click();
	}
	
	public void fsRate()
	{
		driver.findElement(frate).click();
	}
	
	public void clickAplShip()
	{
		driver.findElement(smehtod).click();
	}
	
	public void clickPay()
	{
		driver.findElement(pay).click();
	}
	
	public void cashDel()
	{
		driver.findElement(cod).click();
	}
	
	public void clickCon()
	{
		driver.findElement(con).click();
	}
	
	public void clickCnfmBtn()
	{
		driver.findElement(cnfmBtn).click();
	}
	
	public String actText()
	{
		return driver.findElement(act).getText();
	}
}
