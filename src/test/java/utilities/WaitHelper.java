package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	public WebDriver driver;
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
public void WaitForElement(WebElement el,long timeOutInSeconds) {
	WebDriverWait Wait=new WebDriverWait(driver,timeOutInSeconds);
	Wait.until(ExpectedConditions.visibilityOf(el));
}
}
