package rahulshettyacademy.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.objectpage.CartPage;
import rahulshettyacademy.objectpage.CheckOutPage;
import rahulshettyacademy.objectpage.ComformationPage;
import rahulshettyacademy.objectpage.LandingPage;
import rahulshettyacademy.objectpage.ProductCatalogue;

public class ErrorValidation  extends BaseTest{
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void  SubmitOrder() throws IOException,InterruptedException
	{
		String productName="ZARA COAt 3";
		LandingPage.loginApplication("mankumaresayali07@gmail.com","Sayali123$");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
		
	}

	@Test
	
public void ProductErrorValidation () throws IOException,InterruptedException
	{
	
		
		String productName="ZARA COAT 3";
		
		
		ProductCatalogue productcatalogue=landingpage.loginApplication("mankumaresayali@gmail.com","Sayali123$");
	
		List<WebElement> products= productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartpage=productcatalogue.goToCartPage();
		
		
		
		Boolean match =cartpage.VerfiyProductDisplay("ZARA COAT 33"); 	
		Assert.assertFalse(match);
			}
}
