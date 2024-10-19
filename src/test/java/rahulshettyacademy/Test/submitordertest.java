package rahulshettyacademy.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.objectpage.CartPage;
import rahulshettyacademy.objectpage.CheckOutPage;
import rahulshettyacademy.objectpage.ComformationPage;
import rahulshettyacademy.objectpage.LandingPage;
import rahulshettyacademy.objectpage.OrderPage;
import rahulshettyacademy.objectpage.ProductCatalogue;
	
public class submitordertest extends BaseTest{

	String productName="ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"purches"})
	
public void SubmitOrder(HashMap<String,String>input) throws IOException,InterruptedException
	{
	
		
		
		
		ProductCatalogue productcatalogue=LandingPage.loginApplication(input.get("email"),input.get("password"));
	
		List<WebElement> products= productcatalogue.getProductList();
		productcatalogue.addProductToCart( input.get("product"));
		CartPage cartpage=productcatalogue.goToCartPage();
		
		
		
		Boolean match =cartpage.VerfiyProductDisplay(input.get("product")); 	
		Assert.assertTrue(match);
		CheckOutPage checkoutPage=cartpage.gotoCheckout();
		checkoutPage.selectCountry("india");
		ComformationPage confirmationPage =checkoutPage.submitOrder();
		
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(" Thankyou for the order. "));
		//driverdriver.close();
	
	}
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest()
	{
		//"ZARA COST 3"
		ProductCatalogue productcatalogue=LandingPage.loginApplication("mankumaresayali@gmail.com","Sayali123$");
		OrderPage orderspage =productcatalogue.goToOrderPage();
		Assert.assertTrue(orderspage.VerfiyOrderDisplay(productName));
	}
	
	

		@DataProvider
		public Object[][] getData() throws IOException
		{
				
			 List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\purchaseOrder.json");
			return new Object [] [] {{data.get(0)},{data.get(1)}};
		}
		
}
