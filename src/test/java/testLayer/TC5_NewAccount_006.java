package testLayer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import basePackage.BaseClass;
import pomPackage.PomLogin;
import pomPackage.PomNewAccount;

public class TC5_NewAccount_006  extends BaseClass{
	private Logger log;
	PomLogin lp;
	TC5_NewAccount_006 (){
		super();
	}
	
	@BeforeMethod //from TestNG
	public void initsetup() {
		initiation(); //initiation method of BaseHRMClass has browser,url information
		lp=new PomLogin();
		//intializeReport();
	}
	@Test
	public void createnewaccount() throws IOException, InterruptedException {
		
		 log=LogManager.getLogger("TDDProject.testLayer.TC5_NewAccount_006 ");
		
			lp.typeusername(prop.getProperty("username"));
			lp.typePassword(prop.getProperty("password"));
			log.info("entered username and password");
			lp.clickbtn();
		
			log.info("click on submit btn");
			
			
			PomNewAccount newacc=new PomNewAccount();
			
			newacc.NewAccLink();
			
			newacc.EnterCustId("82313");
			newacc.SelectAcc();
			newacc.initdeposit("10000");
			
			newacc.clickSubmitBtn();
			log.info("new account added");
			
			
}
	
	@AfterMethod
	public void close() {
		
		driver.close();
		
	}
}