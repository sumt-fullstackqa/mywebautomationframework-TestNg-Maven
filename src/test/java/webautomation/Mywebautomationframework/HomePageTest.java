/**
 * @author sumit.mishra
 *
 */

package webautomation.Mywebautomationframework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ForgotPassword;
import pages.HomePage;
import pages.LoginPage;
import testbase.Testbase;


public class HomePageTest extends Testbase {
	public WebDriver driver;
	HomePage h1;
	@BeforeTest
	public void initialize() throws IOException {

		// accessing methods through inheritance concept

		driver = initializeDriver();
		writeLogs("driver is initialized");
	}

	@Test(dataProvider = "getData")
	public void basepagenavigation(String Username, String Password) throws IOException {

		// accessing methods through inheritance concept
		driver.get(prop.getProperty("url"));

		// creating object of that class and invoking method of it
		h1 = new HomePage(driver);
		LoginPage	l1= h1.getlogin();
		l1.getEmail().sendKeys(Username);
		l1.getPassword().sendKeys(Password);
		l1.getloginbutton().click();
		writeLogs("successfully validated login with 3 different credentials");
		
	}

	@Test
	
	public void forgotpasswordtest() {
		
		ForgotPassword fp =	h1.forgotpassword();
		
		fp.getForgetEmail().sendKeys(prop.getProperty("Forgotemail"));
		
		fp.getResetlinkbutton().click();
		writeLogs("successfully validated Forgot password feature");
	}
	
	@AfterTest

	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many different data types test should run
		// column stands for how many values per each test

		Object[][] data = new Object[3][2];

		// oth row
		data[0][0] = "abc@test.com";
		data[0][1] = "123456";

		// 1st row
		data[1][0] = "def@test.com";
		data[1][1] = "1234";

		// 2nd row
		data[2][0] = "ghi@test.com";
		data[2][1] = "1234567";

		return data;

	}
}
