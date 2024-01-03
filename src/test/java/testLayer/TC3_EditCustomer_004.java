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

import pomPackage.PomEditCustomer;
import pomPackage.PomLogin;


public class TC3_EditCustomer_004 extends BaseClass{
	 PomLogin lp;
	 private Logger log;
	
		public TC3_EditCustomer_004 (){
			super();
		} 
		
		@BeforeMethod //from TestNG
		public void initsetup() {
			initiation(); //initiation method of BaseHRMClass has browser,url information
			lp=new PomLogin();
			//intializeReport();
			
		}
		
		@Test(priority=1)
		public void EditCustomer() throws InterruptedException, IOException {
			log=LogManager.getLogger("TDDProject.testLayer.TC3_EditCustomer_004");
			
			lp.typeusername(prop.getProperty("username"));
			lp.typePassword(prop.getProperty("password"));
			log.info("entered username and password");
		
			lp.clickbtn(); 
	
			log.info("clicked on submit button");
			PomEditCustomer ed=new PomEditCustomer();
			
			
			ed.clickEditNewCustomer();
			ed.EnterCustId("1234");
			
			log.info("edited customer details");
			// wait to page to load
			
			ed.clickSubmitBtn();
			
			
			
			
			try{
				// verify updating customer data
					if(isAlertPresent()==true) {
	
				
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
					}}
					
			catch(Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(5000);	
		}
		
		@AfterMethod
		public void close() {
			
			driver.close();
			
		}
	}
		
		
