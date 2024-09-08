package demoOpencartpageBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OCByanItem 
{
	By phone = By.linkText("Phones & PDAs");
	By htc = By.linkText("HTC Touch HD");
	By md = By.id("input-option-value-30");
	By qty = By.id("input-quantity");
	By atc = By.id("button-cart");
	By xBtn = By.cssSelector("td.an_i>a>i");
	By scart = By.partialLinkText("Shopping Cart");
	By btnCl = By.className("btn-close");
	
	WebDriver driver;
	
//	constructor
	public OCByanItem(WebDriver driver)
	{
		this.driver = driver;
	}
	
//	methods
	public void clickPhonelink()
	{
		driver.findElement(phone).click();
	}

	public void clickPhoneName()
	{
		driver.findElement(htc).click();
	}
	
	public void clickSize()
	{
		driver.findElement(md).click();
	}
	
	public void addQty()
	{
		driver.findElement(qty).clear();
		driver.findElement(qty).sendKeys("2");
	}
	
	public void clickAddtoCart()
	{
		driver.findElement(atc).click();
	}
	
	public void clickCloseBtn()
	{
		driver.findElement(btnCl).click();
	}
	
	public void clickScart()
	{
		driver.findElement(scart).click();
	}
}
