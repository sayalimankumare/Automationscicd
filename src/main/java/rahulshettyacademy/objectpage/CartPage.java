package rahulshettyacademy.objectpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.objectpage.CheckOutPage;
import rahulshetyaacademy.Absrtactcomponent.AbstarctComponent;

public class CartPage extends rahulshettyacademy.Abstractcomponent.AbstarctComponent{
	
	WebDriver driver;
	
	
	

	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	

	@FindBy(css=".cartsection h3")
	private List<WebElement> cartProducts ;
	
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public Boolean VerfiyProductDisplay(String productName) 
	{
				Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
				return match;
	}
	
	public CheckOutPage  gotoCheckout()
	{
		checkoutEle.click();
		return new CheckOutPage(driver);
	}

}
