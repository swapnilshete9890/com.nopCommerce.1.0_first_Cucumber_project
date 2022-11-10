package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pom_Package.AddCustomerPage;
import pom_Package.LoginPage;
import pom_Package.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
    public	LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCust;
    
    //Created for generating Random String for unique email
    public static String randomstring()
    {
    	String generatedString1 = RandomStringUtils.randomAlphabetic(6);
    	return (generatedString1);
    }
 

}
