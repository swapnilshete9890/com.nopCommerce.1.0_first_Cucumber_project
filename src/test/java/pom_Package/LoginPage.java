package pom_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(id="Email")
	@CacheLookup
	private WebElement txt_username;
	
	@FindBy(id="Password")
	@CacheLookup
	private WebElement txt_password;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	@CacheLookup
	private WebElement btn_login;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	private WebElement btn_logout;
	
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username)
	{
		txt_username.clear();
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txt_password.clear();
		txt_password.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		btn_login.click();
	}
	
	public void clickOnLogout()
	{
		btn_logout.click();
	}
	
	
	
	

}
