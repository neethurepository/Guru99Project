package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomDeleteCustomer extends BaseClass {


	@FindBy(linkText="Delete Customer") WebElement ClickDeleteCustLink;
	@FindBy(name="cusid") WebElement Custid;
    @FindBy(name="AccSubmit") WebElement Submitbtn;
   
    
    //initiate page elements
    //create constructor of this pom calss
    
    public PomDeleteCustomer () {
    	//initElement is a static method in Page Factory, using this we can initialize all the webelement specified bythi at@FindBy
    	//this keyword convert local variable into global variable
    	PageFactory.initElements(driver, this);	
    }
    //actions to be performed on the element is created as methods
   
    public void clickDeleteNewCustomer() {
    	ClickDeleteCustLink.click();

    }
    public void EnterCustId(String id) {
    	Custid.sendKeys(id);
		

    }
    public void clickSubmitBtn() {
    	Submitbtn.click();

    }
}
