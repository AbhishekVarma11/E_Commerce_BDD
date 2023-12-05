package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class steps extends BaseClass{

	//login testcase steps
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
	
	//Add customer steps 



	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();

	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenuItem();

	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(3000);

	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());


	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email=RandomString()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
				// The customer cannot be in both 'Guests' and 'Registered' customer roles
				// Add the customer to 'Guests' or 'Registered' customer role
				addCust.setCustomerRoles("Guest");
				Thread.sleep(3000);
				addCust.setManagerOfVendor("Vendor 2");
				addCust.setGender("Male");
				addCust.setFirstName("Abhi");
				addCust.setLastName("G");
				addCust.setDob("1/02/2000"); // Format: D/MM/YYY
				addCust.setCompanyName("Fast_QA");
				addCust.setAdminContent("This is under test-----");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		addCust.clickOnSave();
		 Thread.sleep(2000);

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
}
