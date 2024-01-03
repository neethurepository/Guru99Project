package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomEditCustomer extends BaseClass {
	
	@FindBy(linkText="Edit Customer") WebElement ClickEditCustLink;
	@FindBy(name="cusid") WebElement Custid;
    @FindBy(name="AccSubmit") WebElement Submitbtn;
   // @FindBy(id="picker") WebElement datePicker;
    
    //initiate page elements
    //create constructor of this pom calss
    
    public PomEditCustomer () {
    	//initElement is a static method in Page Factory, using this we can initialize all the webelement specified bythi at@FindBy
    	//this keyword convert local variable into global variable
    	PageFactory.initElements(driver, this);	
    }
    //actions to be performed on the element is created as methods
   
    public void clickEditNewCustomer() {
    	ClickEditCustLink.click();

    }
    public void EnterCustId(String id) {
    	Custid.sendKeys(id);
		

    }
    public void clickSubmitBtn() {
    	Submitbtn.click();

    }
    
    

}
