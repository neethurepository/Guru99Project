package testLayer;

import java.io.IOException;

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
import pomPackage.PomDeleteCustomer;
import pomPackage.PomLogin;


public class TC4_DeleteCustomer_005 extends BaseClass{
	 PomLogin lp;
	 private Logger log;
	TC4_DeleteCustomer_005(){
    super();
	}
	
	@BeforeMethod //from TestNG
	public void initsetup() {
		initiation(); //initiation method of BaseHRMClass has browser,url information
		lp=new PomLogin();
		//intializeReport();
	
	}
	@Test
	public void deletecustomer() throws IOException, InterruptedException {
		log=LogManager.getLogger("TDDProject.testLayer.TC4_DeleteCustomer_005");
		
		
		    lp.typeusername(prop.getProperty("username"));
			lp.typePassword(prop.getProperty("password"));
			log.info("entered username and password");
			lp.clickbtn(); 
			log.info("clicked on submit button");
	
			
		
	PomDeleteCustomer deletecus=new PomDeleteCustomer();

	deletecus.clickDeleteNewCustomer();
	deletecus.EnterCustId("3007");
	 
	deletecus.clickSubmitBtn();
	log.info("deleted customer details");
   
	
	
	try{
		// verify updating customer data
			if(isAlertPresent()==true) {

		driver.switchTo().alert().accept();//close alert
		System.out.println("alert accepted");
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
		
			}
			
	}
			
	catch(Exception e) {
		e.printStackTrace();
	}
		

}
	@AfterMethod
	public void close() {
		
		driver.close();
	
	}
}
	

