package demoOpencartpageBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage 
{
	By price = By.xpath("//div[@id='shopping-cart']//tfoot/tr[4]/td[2]");
	By Tax = By.cssSelector(".accordion-item:first-of-type>.accordion-header>button");
	By country = By.id("input-country");
	By state = By.id("input-zone");
	By pin = By.id("input-postcode");
	By btnQt = By.id("button-quote");
	By frate = By.id("input-shipping-method-flat-flat");
	By smehtod = By.id("button-shipping-method");
	By chkout = By.xpath("//*[@id='content']/div[3]/div[2]/a");
	
	WebDriver driver;
	
//	constructor
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getPriceText()
	{
		return driver.findElement(price).getText();
	}
	
	public void clickTaxBtn()
	{
		driver.findElement(Tax).click();
	}
	
	public void setPin()
	{
		driver.findElement(pin).sendKeys("421605");
	}
	
	public void getQt()
	{
		driver.findElement(btnQt).click();
	}
	
	public void fsRate()
	{
		driver.findElement(frate).click();
	}
	
	public void clickAplShip()
	{
		driver.findElement(smehtod).click();
	}
	
	public void clickCkOut()
	{
		driver.findElement(chkout).click();
	}
}
