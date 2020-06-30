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

public class ValidateMenu extends Testbase {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateMenu.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		// accessing methods through inheritance concept

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void basepagenavigation() throws IOException {

		// creating object of that class and invoking method of it
		HomePage h1 = new HomePage(driver);
		Assert.assertTrue(h1.getmenutext().isDisplayed());
		log.info("successfully validated one of the menus text");
	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

}
