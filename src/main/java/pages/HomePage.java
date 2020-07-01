/**
 * @author sumit.mishra
 *
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	
	public WebDriver driver;
	
	By Login=By.cssSelector("a[href*='signin']");
	
	By title=By.xpath("//div[contains(text(),'Business Plans Include')]");
	
	By menu=By.xpath("//a[@class='nav-item'][contains(text(),'Pricing')]");
	
	By forgotpassword=By.xpath("//a[@class='reset_pass']");
	
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public ForgotPassword forgotpassword() {
		
		driver.findElement(forgotpassword).click();
		
		return  new ForgotPassword(driver);
				
	}
	
	public LoginPage getlogin() {
		
	WebElement loginbutton= driver.findElement(Login);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginbutton);
		LoginPage l1 = new LoginPage(driver);
		
		return l1;
		
	}
	public WebElement gettitle() {
		
		return driver.findElement(title);
	}
      public WebElement getmenutext() {
		
		return driver.findElement(menu);
	}
	
}
