package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomLogin extends BaseClass {
	//step1. create object repository
			//write all the elements on the Login page and their locators
			
			//@FindBy. is the replacement of driver.finElement(By.
			@FindBy(name="uid") WebElement Username;
		    @FindBy(name="password") WebElement Password;
		    @FindBy(name="btnLogin") WebElement Loginbtn;
		    @FindBy(linkText="Log out")  WebElement Logout;
			
		   
		    
		    //initiate page elements
		    //create constructor of this pom calss
		    
		    public PomLogin() {
		    	//initElement is a static method in Page Factory, using this we can initialize all the webelement specified bythi at@FindBy
		    	//this keyword convert local variable into global variable
		    	PageFactory.initElements(driver, this);	
		    }
		    //actions to be performed on the element is created as methods
		    
		    public void typeusername(String name) {
		    	//driver.findElement(By.name("usename") is Usename
		    	Username.sendKeys(name);
		    }

		    public void typePassword(String pass) {
		    	//driver.findElement(By.name("usename") is Usename
		    	Password.sendKeys(pass);
		    }
		    
		    public void clickbtn() {
		    	Loginbtn.click();
		    }
		    
		    public String verify() {
		    	return driver.getTitle();
		    }
		    
		    public void logoutbtn() {
		    	Logout.click();
		    	
		    }
		   

}
