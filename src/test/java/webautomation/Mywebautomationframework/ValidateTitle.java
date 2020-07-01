/**
 * @author sumit.mishra
 *
 */

package webautomation.Mywebautomationframework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import testbase.Testbase;


public class ValidateTitle extends Testbase {
	
	public WebDriver driver;
	
	@BeforeTest
	
	public void initialize() throws IOException {
		
		// accessing methods through inheritance concept
		
		driver = initializeDriver();
		
		writeLogs("driver is initialized");
		driver.get(prop.getProperty("url"));
		writeLogs("Navigated to url");
		
	}

	@Test
	public void validatetitletext() throws IOException {

	
		

		// creating object of that class and invoking method of it
		HomePage h1 = new HomePage(driver);
		
		//compare the text from the browser with actual value
	String tiltletext= h1.gettitle().getText();
	
	Assert.assertEquals(tiltletext, "Business Plans Include1");
	writeLogs("title not matched");
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
}
}