package rahulshettyacademy.objectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetty.objectpage.ComformationPage;
import rahulshetyaacademy.Absrtactcomponent.AbstarctComponent;

public class CheckOutPage extends rahulshettyacademy.Abstractcomponent.AbstarctComponent {
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}


	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2])")
	WebElement selectCountry;
	
	
	By results =By.cssSelector(".ta-results");
	 
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();

		waitForElementToAppear(By.cssSelector(".ta-results"));
		
		selectCountry.click();
	}
	
	
	public ComformationPage submitOrder()
	{
		submit.click();
		return new ComformationPage(driver);
	}



}
