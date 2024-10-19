package rahulshettyacademy.objectpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetyaacademy.Absrtactcomponent.AbstarctComponent;

public class ProductCatalogue extends rahulshettyacademy.Abstractcomponent.AbstarctComponent {
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}



@FindBy(css=".mb-3")
List<WebElement> products;

@FindBy(css=".ng-animating")
WebElement spinner;

By productBy = By.cssSelector(".mb-3");
By addToCart = By.cssSelector(".card-body button:last-of-type");
By toastMessage = 	By.cssSelector("#toast-container");





public List<WebElement> getProductList() {
	
	waitForElementToAppear(productBy);
	return products;
	//driver.get("https://rahulshettyacademy.com/client");
	
}

public WebElement getProductByName(String productName)
{
	WebElement prod = getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals("productname")).findFirst().orElse(null);
	return prod;
}

public  void addProductToCart(String productName)
{
	WebElement prod=getProductByName(productName);
	prod.findElement(addToCart).click();
	waitForElementToAppear(toastMessage);
	waitForElementToDisappear(spinner);
	
}

public void addProductToCart() {
	// TODO Auto-generated method stub
	
}




}
