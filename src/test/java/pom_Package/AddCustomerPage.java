package pom_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver driver;
	

	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}

	By lnkCustomers_menu = By.xpath("(//*[contains(@class,'right fas fa-angle-left')])[4]");
	By lnkCustomer_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By btn_Addnew = By.xpath("//a [@Class='btn btn-primary']");

	By txt_Email = By.xpath("//input[@id='Email']");
	By txt_Password = By.xpath("//input[@id='Password']");

	By txt_FirstName=By.xpath("//input[@id='FirstName']"); 
	By txt_LastName=By.xpath("//input[@id='LastName']"); 

	By rdobtn_male=By.xpath("//input[@id='Gender_Male']");
	By rdobtn_female=By.xpath("//input[@id='Gender_Female']");

	By txt_Dob=By.xpath("//input[@id='DateOfBirth']");

	By txt_cmpnyName=By.xpath("//input[@id='Company']");

	By chkbox_taxExp=By.xpath("//input[@id='IsTaxExempt']");

	By txtcustomerRole=By.xpath("(//*[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]");

	By lstItemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstItemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstItemForumModerators=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstItemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstItemVendors=By.xpath("//li[contains(text(),'Vendors')]");

	By drpManagerofVendor=By.xpath("//select[@id='VendorId']");

	By txtAdminComment=By.xpath("//*[@id='AdminComment']");

	By btn_save=By.xpath("(//button[@class='btn btn-primary'])[1]");

	//Action Methods
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}

	public void clickOnCustomerMenu()
	{
		driver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomerMenuItem()
	{
		driver.findElement(lnkCustomer_menuitem).click();
	}

	public void clickOnAddNew()
	{
		driver.findElement(btn_Addnew).click();
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(txt_Email).sendKeys(email);
	}

	public void enterPassword(String password)
	{
		driver.findElement(txt_Password).sendKeys(password);
	}
	
	public void enterFirstName(String Fname)
	{
		driver.findElement(txt_FirstName).sendKeys(Fname);
	}
    
    public void enterLastName(String Lname)
    {
    	driver.findElement(txt_LastName).sendKeys(Lname);
    }
    
    public void selectGender(String gender)
    {
    	if(gender.equals("Male"))
    	{
    		driver.findElement(rdobtn_male).click();
    	}
    	else if(gender.equals("Female"))
    	{
    		driver.findElement(rdobtn_female).click();
    	}
    	else
    	{
    		driver.findElement(rdobtn_male).click();  //Default if None of above selected
    	}
    	
    }

     public void setDateOfBirth(String dob)
     {
    	 driver.findElement(txt_Dob).sendKeys(dob);
     }

     public void enterCompanyName(String CompName) 
     {
    	 driver.findElement(txt_cmpnyName).sendKeys(CompName);
     }
     
     public void setCustomerRoles(String role) throws InterruptedException
     {
    	//Doubt
    	 
    	 if(!role.equals("Vendors")) //If role is vendors should not delete Register as per 
    	 {
    		 driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click(); //Doubt
    		
    	 }
//    	 driver.findElement(txtcustomerRole).click();
//    	 driver.findElement(txtcustomerRole).clear();;	
//    	 driver.findElement(txtcustomerRole).clear();
    	 
    	 driver.findElement(txtcustomerRole).click();
    	 
    	 WebElement listitem = null; //Doubt
    	 
    	 Thread.sleep(3000);
    	 
    	 if(role.equals("Administrators"))
    	 {
    		 listitem= driver.findElement(lstItemAdministrators);
    	 }
    	 else if(role.equals("Vendors"))
    	 {
    		 listitem=driver.findElement(lstItemVendors);
    	 }
    	 else if(role.equals("Guests"))
    	 {
    		 listitem= driver.findElement(lstItemGuests);
    	 }
    	 else if(role.equals("ForumModerators"))
    	 {
    		 listitem= driver.findElement(lstItemForumModerators);
    	 }
    	 else if(role.equals("Registered"))
    	 {
    		 listitem= driver.findElement(lstItemRegistered);
    	 }
    	 
    	 listitem.click();
    	  
           //Or if click() method is fail then use JavaScriptExecutor method
    
//    	  JavascriptExecutor js=(JavascriptExecutor) driver;
//    	  js.executeScript("argument[0].click();", listitem);
     
     }
     
     public void setManagerOfVendor(String value)
     {
    	 Select drp=new Select(driver.findElement(drpManagerofVendor));
    	 drp.selectByVisibleText(value);
     }
     
     public void enterAdminComment(String comment)
     {
    	 driver.findElement(txtAdminComment).sendKeys(comment);
     }
     
     public void clickOnSave()
     {
    	 driver.findElement(btn_save).click();
     }
     
     
 



}
