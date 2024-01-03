package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomAddCustomer  extends BaseClass{
	//step1. create object repository
	//write all the elements on the Login page and their locators
	
	//@FindBy. is the replacement of driver.finElement(By.
	@FindBy(xpath="//a[contains(text(),'New Customer')]") WebElement newCustomer;
	@FindBy(name="name") WebElement Customername;
    @FindBy(name="rad1") WebElement RadioMale;
   // @FindBy(id="picker") WebElement datePicker;
    
    
    
    
    @FindBy(id="dob") WebElement txtdob;
    @FindBy(name="addr")  WebElement Address;
    @FindBy(name="city") WebElement City;
    @FindBy(name="state") WebElement State;
    @FindBy(name="pinno") WebElement Pincode;
    @FindBy(name="telephoneno") WebElement Telephonenum;
    @FindBy(name="emailid") WebElement Email;
    @FindBy(name="password") WebElement Password;
    @FindBy(name="sub") WebElement Submit;
	
   
    
    //initiate page elements
    //create constructor of this pom calss
    
    public PomAddCustomer() {
    	//initElement is a static method in Page Factory, using this we can initialize all the webelement specified bythi at@FindBy
    	//this keyword convert local variable into global variable
    	PageFactory.initElements(driver, this);	
    }
    //actions to be performed on the element is created as methods
   
    public void clickAddNewCustomer() {
		newCustomer.click();
			
	}

	public void custName(String cname) {
		Customername.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		RadioMale.click();
	}

	
	
	
	  public void custdob(String date) {
	  
	  
	  txtdob.sendKeys(date);
	 	
	  }

	public void custaddress(String caddress) {
		Address.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		City.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		State.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		Pincode.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		Telephonenum.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		Email.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		Password.sendKeys(cpassword);
	}

	public void custsubmit() {
		Submit.click();
	}
	
	
	
	
}
