package testLayer;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import basePackage.BaseClass;
import pomPackage.PomAddCustomer;
import pomPackage.PomLogin;



public class TC2_AddCustomerPage_003  extends BaseClass{
	PomLogin lp;
	private Logger log;
	public TC2_AddCustomerPage_003(){
		super();
		
	} 
	
	@BeforeMethod //from TestNG
	public void initsetup() {
		initiation(); //initiation method of BaseHRMClass has browser,url information
	
		lp=new PomLogin();
	}
	
	@Test
	public void AddCustomer() throws InterruptedException, IOException {

		log=LogManager.getLogger("TDDProject.testLayer.TC2_AddCustomerPage_003");
  
		
		
			
		
		lp.typeusername(prop.getProperty("username"));
		lp.typePassword(prop.getProperty("password"));
		log.info("username nad password entered");
		lp.clickbtn(); 
	
		
	
		
		PomAddCustomer addcust=new PomAddCustomer();
		
		addcust.clickAddNewCustomer();
		addcust.custName("Abin");
		addcust.custgender("male");
		addcust.custdob("1993-12-10");
		
		Thread.sleep(5000);
		
		
		addcust.custaddress("INDIA is a great nation");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		Thread.sleep(2000);
	    String email=	randomestring()+"@gmail.com";
		addcust.custemailid(email);
		
		
		
		addcust.custpassword("abcdef");
		log.info("entered all the details");
		addcust.custsubmit();
		log.info("clicked on submit button");
	 
		Thread.sleep(3000);
		
	
	
	
	//Validation,after entering all the details we have to get the message "Customer added sussessfully"
	
	
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	
	if(res==true)
	{
		Assert.assertTrue(true);
		Thread.sleep(3000);
		
		
		
	}
	else
	{
	
		 
		Assert.assertTrue(false);
	
	}
		
}
	
	
	
	// the email id is unique, so hardcoding the email value is not possible
	//create a method randomString to generate any random 5character alphabets
	
	public String randomestring()
	{
		
		//RandomStringUtils.randomAlphabets create random alphabets of 8 characters
		String generatedstring=RandomStringUtils.randomAlphabetic(10);
		log.info("random emial generated");
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	 @AfterMethod
	 	public void close() {
		
	 		driver.close();
	 		
	 	}
 
}
