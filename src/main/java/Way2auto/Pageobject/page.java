package Way2auto.Pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class page {

	public static WebDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(page.class.getSimpleName());
	//public static ExcelReader excel = new ExcelReader("./Runner/testdata.xlsx");
	public static WebDriverWait wait;
	public static Topnavigation topnav;
	public ChromeOptions options = new ChromeOptions();
	public page() throws IOException
	{    if(driver == null)
		 launch();
	}
	

	public  void launch() throws IOException
	{
		{
		fis = new FileInputStream("./src/test/resources/OR.properties");
	    OR.load(fis);
	    fis = new FileInputStream("./src/test/resources/Config.properties");
	    Config.load(fis);
	    PropertyConfigurator.configure("./Runner/log4j.properties");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
	 /*   if(Config.getProperty("browser").equalsIgnoreCase("chrome"))
	    {
	    	
	    	cap.setBrowserName("chrome");
	    	cap.setPlatform(Platform.ANY);
	    	Map<String, Object> prefs = new HashMap<String, Object>();
            
            // Set the notification setting it will override the default setting
	       prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ChromeOption class
	       

            // Set the experimental option
	       options.setExperimentalOption("prefs", prefs);
	    	options.merge(cap);
	    	
			
	    }
	    else if (Config.getProperty("browser").equalsIgnoreCase("InternetExplorer"))
	    {
	    	
	    	cap.setBrowserName("internet explorer");
	    	cap.setPlatform(Platform.WINDOWS);
	    	
	    	
			
	    }
	    driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);*/
		driver.get(Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("Implicit_wait")), TimeUnit.SECONDS);
		wait =new WebDriverWait(driver,Integer.parseInt(Config.getProperty("Explicit_wait")));
		topnav=new Topnavigation();
		}
		
	}
	public static String Screenshot(String method) throws IOException
	{
		Date d = new Date();
		String file=d.toString().replaceAll("  ", "__").replaceAll(":", "_").replaceAll(" ", "_");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\pankaj\\workspace\\Pageobject\\screenshot\\"+method+"_"+file+".jpg"));
		return  file;
	}
	
	public static void click(String locator)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		log.info("clicking on element located by "+locator );
	}
	
	public static void type(String locator , String value)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		log.info("clicking on element located by "+locator+" typed the value as "+value);
	}
	
}
