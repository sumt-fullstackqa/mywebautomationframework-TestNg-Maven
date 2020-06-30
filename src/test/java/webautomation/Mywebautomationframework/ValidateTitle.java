/**
 * @author sumit.mishra
 *
 */

package webautomation.Mywebautomationframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import testbase.Testbase;

public class ValidateTitle extends Testbase {
	
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	
	public void initialize() throws IOException {
		
		// accessing methods through inheritance concept
		
		driver = initializeDriver();
		
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to url");
		
	}

	@Test
	public void validatetitletext() throws IOException {

	
		

		// creating object of that class and invoking method of it
		HomePage h1 = new HomePage(driver);
		
		//compare the text from the browser with actual value
	String tiltletext= h1.gettitle().getText();
	
	Assert.assertEquals(tiltletext, "Business Plans Include1");
	log.info("successfully validated title text");
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
}
}