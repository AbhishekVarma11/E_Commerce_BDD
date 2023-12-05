package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class steps {
	public WebDriver driver;
	public LoginPage lp;
	@Given("user launches the chrome Browser")
	public void user_launches_the_chrome_Browser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		

	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String username, String password) {
		lp.setUserName(username);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		lp.clickLogin();

	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String text) {
		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(text,driver.getTitle());
		}
		
	}

	@When("User Click on Log out Link")
	public void user_Click_on_Log_out_Link() throws InterruptedException {
		Thread.sleep(3000);
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();

	}
}
