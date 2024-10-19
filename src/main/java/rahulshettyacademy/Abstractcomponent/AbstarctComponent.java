package rahulshettyacademy.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshetty.objectpage.CartPage;
import rahulshettyacademy.objectpage.CheckOutPage;
import rahulshettyacademy.objectpage.OrderPage;

public class AbstarctComponent {

	WebDriver driver;
	
	public AbstarctComponent(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	public void waitForElementToAppear(By FindBy) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));	
	}
	

	public rahulshettyacademy.objectpage.CartPage goToCartPage()
	{
		cartHeader.click();
		rahulshettyacademy.objectpage.CartPage cartPage= new rahulshettyacademy.objectpage.CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderPage= new OrderPage(driver);
		return orderPage;
	}
	public void waitForElementToDisappear(WebElement ele)throws InterruptedException
	{
		
		Thread.sleep(1000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}



}
