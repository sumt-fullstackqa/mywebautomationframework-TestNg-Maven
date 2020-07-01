/**
 * @author sumit.mishra
 *
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	By forgotemail = By.xpath("//input[@placeholder='Email']");

	By resetlinkbutton = By.xpath("//a[@class='btn btn-default submit']");

	public ForgotPassword(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getForgetEmail() {

		return driver.findElement(forgotemail);
	}

	public WebElement getResetlinkbutton() {

		return driver.findElement(resetlinkbutton);
	}
}
