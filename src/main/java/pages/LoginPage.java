/**
 * @author sumit.mishra
 *
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By email = By.xpath("//input[@placeholder='Email']");

	By password = By.xpath("//input[@placeholder='Password']");

	By loginbutton = By.xpath("//a[@class='btn btn-default submit']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement getloginbutton() {

		return driver.findElement(loginbutton);
	}
}
