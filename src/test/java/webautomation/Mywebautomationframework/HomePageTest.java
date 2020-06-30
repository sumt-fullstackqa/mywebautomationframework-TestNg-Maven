/**
 * @author sumit.mishra
 *
 */

package webautomation.Mywebautomationframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.Testbase;

public class HomePageTest extends Testbase {
	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {

		// accessing methods through inheritance concept

		driver = initializeDriver();
	}

	@Test(dataProvider="getData")
	public void basepagenavigation(String Username, String Password) throws IOException {

		// accessing methods through inheritance concept
		driver.get(prop.getProperty("url"));

		// creating object of that class and invoking method of it
		HomePage h1 = new HomePage(driver);

		WebElement loginbutton = h1.getlogin();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginbutton);
		
		LoginPage l1=new LoginPage(driver);
		
		l1.getEmail().sendKeys(Username);
		
		l1.getPassword().sendKeys(Password);
		
		l1.getloginbutton().click();
		log.info("successfully validated login with 3 different credentials");
	}
	@AfterTest

	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		
		//Row stands for how many different data types test should run 
		// column stands for how many values per each test 
		
		Object[][] data = new Object[3][2];
		
		//oth row
		data[0][0]="abc@test.com";
		data[0][1]="123456";
		
		//1st row
		data[1][0]="def@test.com";
		data[1][1]="1234";
		
		//2nd row
		data[2][0]="ghi@test.com";
		data[2][1]="1234567";
		
		return data;
		
	}
}
