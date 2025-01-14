package rahulshettyacademy.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.objectpage.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage  landingpage;
	
	public WebDriver  initializerDriver() throws IOException
	{
		//properties class 
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dri")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName =System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		// prop.getProperty("browser");
		
		
		if(browserName.contains("chrome")){
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver =new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		{
			
		
			WebDriverManager.chromedriver().setup();
	
			driver= new ChromeDriver();
		}

		 if(browserName.equalsIgnoreCase("firefox"));
		{
		//firefox browser
			System.setProperty("Webdriver.gecko.driver","C:/Program Files/selenium/geckodriver-v0.34.0-win-aarch64");
			driver = new FirefoxDriver();
		}

		 if(browserName.equalsIgnoreCase("Edge"));
		{
			//edge browser
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	
	public class DataReader {
		public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
		{
			//read json  to string
			String jsonContent= FileUtils.readFileToString(new File(filePath),
					StandardCharsets.UTF_8);
			
			
			//String to HashMap Jackson DataBind
			
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
				
			});
			return data;
		}

	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("User.dir")+"//reports//"+ testCaseName +".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("User.dir")+"//reports//"+ testCaseName +".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication()throws IOException
	{
		driver =initializerDriver();
		landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod(alwaysRun=true)
	void tearDown()
	{
		driver.close();
	}
	
}
