/**
 * @author sumit.mishra
 *
 */



package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Testbase {
	
	public WebDriver driver ;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		//chrome
		
		prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\sumit.mishra\\eclipse-workspace\\Mywebautomationframework-master\\resources\\configfile\\config.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("Browser");
		
		
		if (browserName.equals("chrome"))
		
		{
			//write code for chhrome initilization
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumit.mishra\\eclipse-workspace\\Mywebautomationframework-master\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			//write code for firefox initilization
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sumit.mishra\\eclipse-workspace\\Mywebautomationframework-master\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			//write code for IE initilization 
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sumit.mishra\\eclipse-workspace\\Mywebautomationframework-master\\resources\\drivers\\MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public void getScreenshotpath(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	
	FileUtils.copyFile(source,new File(destinationFile));
		
	}
	
}



