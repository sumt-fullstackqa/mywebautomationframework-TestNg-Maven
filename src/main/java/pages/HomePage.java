/**
 * @author sumit.mishra
 *
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	
	public WebDriver driver;
	
	By Login=By.cssSelector("a[href*='signin']");
	
	By title=By.xpath("//div[contains(text(),'Business Plans Include')]");
	
	By menu=By.xpath("//a[@class='nav-item'][contains(text(),'Pricing')]");
	
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public WebElement getlogin() {
		
		return driver.findElement(Login);
	}
	public WebElement gettitle() {
		
		return driver.findElement(title);
	}
      public WebElement getmenutext() {
		
		return driver.findElement(menu);
	}
	
}
