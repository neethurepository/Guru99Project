package testLayer;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import basePackage.BaseClass;
import pomPackage.PomLogin;
import testData.ExcelSheet;

public class TC1_LoginDDT_002  extends BaseClass {
	private Logger log;
	PomLogin Log1;
	
		public TC1_LoginDDT_002(){
			
			super();
			
		}

		
		@BeforeMethod //from TestNG
		public void initsetup() throws IOException {
			initiation(); //initiation method of BaseHRMClass has browser,url information
			//calling screenshots method, screenshot should come as Login.jpg
		
			Log1=new PomLogin();		
				}
			
			
			// we can also use test.warn and test.fail
			
			
		 
		
		@DataProvider
		public Object[][] Details(){
			Object result[][]=ExcelSheet.readdata("Sheet1");//Dataprovider will read data from Excelsheet class, readdata method i.e., from sheet1
			return result;
		}
		
		@Test(dataProvider="Details")
		public void Login(String name,String password) throws InterruptedException, IOException {

    		log=LogManager.getLogger("TDDProject.testLayer.TC1_LoginDDT_002");
		   
		
			Log1.typeusername(name);
			
			Thread.sleep(3000);
			Log1.typePassword(password);
			log.info("username and password is entered");
			Log1.clickbtn();
			
			
			
			
			if(isAlertPresent()==true) {

				driver.switchTo().alert().accept();//close alert
				log.info("alert Accepted");
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);//if alert is present test case failed
				
				
					}
			else {
				Assert.assertTrue(true);//tes case passed
			
				Log1.logoutbtn();//click on logout
				driver.switchTo().alert().accept();//close alert in logout window
				
				log.info("alert accepted");
				driver.switchTo().defaultContent();
			}
			
					
			
		}
		
		@AfterMethod
		public void close() {
			driver.close();
			
		}
}
