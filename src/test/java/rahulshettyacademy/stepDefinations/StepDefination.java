package rahulshettyacademy.stepDefinations;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.objectpage.CartPage;
import rahulshettyacademy.objectpage.CheckOutPage;
import rahulshettyacademy.objectpage.ComformationPage;
import rahulshettyacademy.objectpage.LandingPage;
import rahulshettyacademy.objectpage.ProductCatalogue;

public class StepDefination  {
	
	
	public LandingPage landingPage;
	public  ProductCatalogue  productCatalogue;
	public ComformationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage= launchApplication();
		//code
	}
	
	@Given("^ Logged in with username (.+) and password (.+)$")
	public void  Logged_in_username_and_password(String username,String password)
	{
		productCatalogue = landingPage.loginApplication(username, password);
	}

	
	@When("^I add product (.+)to Cart$")
	public void i_add_product_to_cart(String productName)throws InterruptedException
	{
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	
	@When("^Checkout(.+)and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CartPage cartpage =productCatalogue.goToCartPage();
		
		Boolean match =cartpage.VerfiyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = CartPage.gotoCheckout();
		checkoutpage.selectCountry("india");
		confirmationPage = checkoutpage.submitOrder();
		
	}
	@Then("{string} message is displayed on ConfirmationPage")
	public void mesasage_displayed_confirtiomPage(String string)
	{
		String confirmMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}

}
