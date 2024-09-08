	package demoOpencartpageBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReturnPage 
{
	By myacc = By.cssSelector(".list-inline-item>.dropdown>a>span");
	By orderhis = By.linkText("Order History");
	By view = By.xpath("//*[@id='content']/div[1]/table/tbody/tr[1]/td[8]/a");
	By ret = By.xpath("//*[@id='content']/div[2]/table/tbody/tr/td[6]/a[2]");
	By tele = By.id("input-telephone");
	By rea = By.xpath("//*[@id='input-return-reason-3']");
	By no = By.id("input-opened-no");
	By res = By.id("input-comment");
	By btn = By.cssSelector("button[type='submit']");
	By act = By.cssSelector("#content>h1");
	
	WebDriver driver;
	
//	constructor
	public ProductReturnPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickMyAcc()
	{
		driver.findElement(myacc).click();
	}
	
	public void clickOh()
	{
		driver.findElement(orderhis).click();
	}
	
	public void clickView()
	{
		driver.findElement(view).click();
	}
	
	public void clickRet()
	{
		driver.findElement(ret).click();
	}
	
	public void setPhone(String num)
	{
		driver.findElement(tele).sendKeys(num);
	}
	
	public void clickRetRes()
	{
		driver.findElement(rea).click();
	}
	
	public void clickNo()
	{
		driver.findElement(no).click();
	}
	
	public void putComment(String com)
	{
		driver.findElement(res).sendKeys(com);
	}
	
	public void clickSub()
	{
		driver.findElement(btn).click();
	}
	
	public String actText()
	{
		return driver.findElement(act).getText();
	}
}
