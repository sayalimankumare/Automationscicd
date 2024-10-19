package rahulshettyacademy.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshetyaacademy.Absrtactcomponent.AbstarctComponent;

public class ComformationPage extends rahulshettyacademy.Abstractcomponent.AbstarctComponent{
	
	WebDriver driver;

	public ComformationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(css=".hero-primary")
	WebElement ConfrimationMessage;
	
	public String getConfirmationMessage()
	{
		return ConfrimationMessage.getText();
	}


}
