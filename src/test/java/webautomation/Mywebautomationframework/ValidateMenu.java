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

public class ValidateMenu extends Testbase {
	public WebDriver driver;
	@BeforeTest

	public void initialize() throws IOException {

		// accessing methods through inheritance concept

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void validatemenutext() throws IOException {

		// creating object of that class and invoking method of it
		HomePage h1 = new HomePage(driver);
		Assert.assertTrue(h1.getmenutext().isDisplayed());
		writeLogs("validated menu text successfully");
	}

	@AfterTest

	public void teardown() {
		driver.close();
	}

}
