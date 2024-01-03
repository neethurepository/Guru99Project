package testLayer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import basePackage.BaseClass;

import pomPackage.PomLogin;


public class TC1_Login_001 extends BaseClass{
	PomLogin Log1;
	private static Logger log;
	
	public TC1_Login_001(){
		super();
		
	}
	
	@BeforeMethod //from TestNG
	public void initsetup() {
	initiation(); //initiation method of BaseHRMClass has browser,url information
	
//calling screenshots method, screenshot should come as Login.jpg
	Log1=new PomLogin();
	}
	 
     @Test(priority=1)
	 public void Login() throws IOException, InterruptedException {
    	 
    log=LogManager.getLogger("TDDProject.testLayer.TC1_Login_001");
	 Log1.typeusername(prop.getProperty("username"));//takevalue from the config.properties file
	 
	
	 Log1.typePassword(prop.getProperty("password"));
	 Thread.sleep(2000);	 
	
	 log.info(" enter usename and password ");
	
	
	 
	 Log1.clickbtn(); 
	 
	 
	 String actual=	Log1.verify();//call methods from POMLogin class using the POMLogin Object reference variable
     log.info(actual);
     if(actual.equals("Guru99 Bank Manager HomePage")) {
    	
		//Log.Verify gives the actual value, store it in a vraiabe
    Assert.assertTrue(true);
   
  
     }
     else {
    	 
    	
    	 Assert.assertTrue(false);
    	
     }
    
     
     }
     
     @AfterMethod
 	public void close() {
    
 		driver.close();
 		
 	}
 
}
 	






