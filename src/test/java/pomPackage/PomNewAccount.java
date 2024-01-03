package pomPackage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import basePackage.BaseClass;
public class PomNewAccount extends BaseClass {
	@FindBy(linkText="New Account") WebElement ClickNewAccount;
	@FindBy(name="cusid") WebElement Custid;
	@FindBy(xpath="//tbody/tr[3]/td[2]/select[1]") WebElement SelectAccount; 
	@FindBy(name="inideposit") WebElement Initialdeposit;
    @FindBy(name="button2") WebElement Submitbtn;
    //initiate page elements
    //create constructor of this pom calss
    public PomNewAccount () {
    	//initElement is a static method in Page Factory, using this we can initialize all the webelement specified bythi at@FindBy
    	//this keyword convert local variable into global variable
    	PageFactory.initElements(driver, this);	
    }
    //actions to be performed on the element is created as methods
   
    public void NewAccLink() {
    	ClickNewAccount.click();

    }
    public void EnterCustId(String id) {
    	Custid.sendKeys(id);
    }
    
    public void SelectAcc() {
    	Select sel=new Select(SelectAccount);
    	sel.selectByValue("Current");
    }
    public void initdeposit(String dep) {
    	Initialdeposit.sendKeys(dep);
    	
    }
    
    public void clickSubmitBtn() {
    	Submitbtn.click();

    }

}
