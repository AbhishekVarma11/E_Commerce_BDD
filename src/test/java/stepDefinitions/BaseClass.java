package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	
	public AddCustomerPage addCust;
	
	public static String RandomString() {
		String generatedString1=RandomStringUtils.randomAlphanumeric(5);
		return generatedString1;
	}

}
