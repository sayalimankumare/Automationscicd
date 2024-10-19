package rahulshettyacademy.objectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.objectpage.ProductCatalogue;
import rahulshetyaacademy.Absrtactcomponent.AbstarctComponent;

public class LandingPage  extends rahulshettyacademy.Abstractcomponent.AbstarctComponent 
{

	
	private static final By errorMessage = null;


	static WebDriver driver ;
	
	public  LandingPage(WebDriver driver){
		
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	//WebElement userEmails =driver.findElement(By.cssSelector("input[id=\"userEmail\"]"));
	
	@FindBy(css="userEmail")
	static
	WebElement userEmail;
	

	@FindBy(id="userPassword")
	static
	WebElement passwordele;
	

	@FindBy(xpath="login")
	static
	WebElement submit;
	
	public static ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys("email");
		passwordele.sendKeys("password");
		submit.click();
	
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}
