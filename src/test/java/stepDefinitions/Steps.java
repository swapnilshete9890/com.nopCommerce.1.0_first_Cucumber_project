package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pom_Package.AddCustomerPage;
import pom_Package.LoginPage;
import pom_Package.SearchCustomerPage;

public class Steps extends BaseClass {


	@Given("user is open the browser")
	public void user_is_open_the_browser() {

		System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();

		lp=new LoginPage(driver);

	}

	@When("user enter url {string}")
	public void user_enter_url(String url) 
	{
		driver.get(url); //URL passing from feature file
	}

	@And("user enter the valid username as {string} and password as {string}")
	public void user_enter_the_valid_username_as_and_password_as(String username, String password) 
	{
		lp.enterUsername(username); //Username & password passing from feature file
		lp.enterPassword(password);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException 
	{
		lp.clickOnLoginButton();
		Thread.sleep(2000);
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String title) 
	{
		if(driver.getPageSource().contains("Login was unsuccessful")) //to find page title go on webpage and press ctrl+U
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("user clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException 
	{
		lp.clickOnLogout();
		Thread.sleep(3000);
	}

	@And("close the browser")
	public void close_the_browser() 
	{
		driver.quit();
	}


	// Customer feature Step Definitions.......................................................

	@Then("User can view Dashboard")      //Validation
	public void user_can_view_dashboard() 
	{
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on cutomers menu")
	public void user_click_on_cutomers_menu() throws InterruptedException 
	{
		Thread.sleep(3000);
		addCust.clickOnCustomerMenu();
	}

	@When("click on customers from menu item")
	public void click_on_customers_from_menu_item() throws InterruptedException
	{
		Thread.sleep(2000);
		addCust.clickOnCustomerMenuItem();	
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException 
	{
		Thread.sleep(2000);
		addCust.clickOnAddNew();
	}

	@Then("User can view Add new customer page") //Validation
	public void user_can_view_add_new_customer_page()  
	{

		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{


		String email=randomstring()+"@gmail.com";
		addCust.enterEmail(email);
		addCust.enterPassword("test12345");

		Thread.sleep(3000);
		//By default customer is-- Registered
		//The Customer Cannot be in both "Guests" and "Registered" customer roles
		//Add the Customer to "Guests" or "Registered" customer role


		addCust.setCustomerRoles("Registered");
		Thread.sleep(2000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.selectGender("Male");
		addCust.enterFirstName("James");
		addCust.enterLastName("Bond");
		addCust.setDateOfBirth("11/01/2022"); //Format: MM/DD/YYYY
		addCust.enterCompanyName("Secret Agency");
		addCust.enterAdminComment("This is for Testing Only...........");
		Thread.sleep(3000);
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException 
	{
		addCust.clickOnSave();
		Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) 
	{
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}

	// Steps for searching a customer using Email-id

	@When("Enter customer Email")
	public void enter_customer_email() 
	{
		searchCust=new SearchCustomerPage(driver);

		searchCust.setEmail("victoria_victoria@nopCommerce.com");

	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException 
	{
		searchCust.clickOnSearch();
		Thread.sleep(3000);
	}

	@Then("user should found Email in the search table")
	public void user_should_found_email_in_the_search_table() 
	{
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertTrue(status);
	}

	// Steps for searching a customer by using First Name & Last Name	

	@When("Enter customer FirstName")
	public void enter_customer_first_name() 
	{
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() 
	{
		searchCust.setLastName("Terces");
	}
	
	
	@Then("user should found Name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException 
	{
		Thread.sleep(3000);
		boolean status=searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}


}
