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
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Testbase {
	
	public WebDriver driver ;
	public Properties prop;
	
	//below line will create object of the Logger class
	public static Logger logger = Logger.getLogger("Testbase.class");
	
	
	public static void writeLogs(String msg)
	{
		logger.info(msg);
	}
	
	public static void writeErrorLogs(Throwable t) {
		
		logger.error(t.getMessage());
	}
	
	public WebDriver initializeDriver() throws IOException
	{
		
		//chrome
		
		prop= new Properties();
		FileInputStream fis= new FileInputStream("src/main/resources/configfile/config.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("Browser");
		
		
		if (browserName.equals("chrome"))
		
		{
			//write code for chhrome initilization
			
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			//write code for firefox initilization
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			//write code for IE initilization 
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public String getScreenshotpath(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
	
	FileUtils.copyFile(source,new File(destinationFile));
		
	return destinationFile;
	
	}
	
}



