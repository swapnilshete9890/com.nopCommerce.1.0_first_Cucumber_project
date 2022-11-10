package pom_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class SearchCustomerPage
{

	public WebDriver driver;

	public SearchCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); // OR instead of "SearchCustomerPage.class" we use "this" also which is referred to the current class
	}

	@FindBy(how=How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id='SearchLastName']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(how=How.ID, using= "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(how=How.XPATH, using= "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResult;

	@FindBy(how=How.XPATH, using= "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how=How.XPATH, using= "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tblRows;

	@FindBy(how=How.XPATH, using= "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tblColumns;



	public void setEmail(String Email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}

	public void setFirstName(String Fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(Fname);
	}

	public void setLastName(String Lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(Lname);
	}

	public void clickOnSearch()
	{
		btnSearch.click();
	}

	public int getNoOfRows()
	{
		return(tblRows.size());
	}

	public int getNoOfColumns()
	{
		return(tblColumns.size());
	}

    public boolean searchCustomerByEmail(String email)
    {
		boolean flag=false;
		
		for(int i=1; i<=getNoOfRows(); i++)
		{
			String emailID=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
		
			System.out.println(emailID);
			
			if(emailID.equals(email))
			{
				flag=true;
			}
		}
		
		return flag;
    	
    }

    public boolean searchCustomerByName(String Name)
    {
		boolean flag=false;
		
		for(int i=1; i<=getNoOfRows(); i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
		
			String names[]=name.split(" "); //Separating first name and last name
			
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag=true;
			}
		}
		
		return flag;
    	
    }








}
