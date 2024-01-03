package basePackage;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.TimeUtils;


public class BaseClass {
	
	public static Properties prop=new Properties();//to read data from config.properties file,static to make this accessible in all methods
	public static WebDriver driver;//globally declare driver
	private static Logger log;
	
	
	
	
	//Step1: create constructor of base class "GuruBank99BaseClass", to read the properties of config.properties file
		//pass the location of the config.properties file as parameter
		//use 2 try catch block, 1  file is not found exception and one for IO exception
		// we are loading the file, so there will be some IO Exception like if we cannot read data from file, so use try catch block
	
	
	public BaseClass()  {
		try {
			log=LogManager.getLogger("TDDProject.basePackage.BaseClass"); //or use this.getClass().getName
		
			FileInputStream file = new FileInputStream("C:\\Users\\neeth\\eclipse-workspace\\TDDProject\\src\\test\\java\\environmentvariables\\config.properties");
			prop.load(file);
		} 
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		
	//Step2:create a method to keep all the common commands which is used in the child class 
	
	      
			public void initiation() { 
			//common commands-driver path,maximize,pageload,implicit,getting url
				
		//According to the browser value in config.properties file we need to run code here, don't want to be dependent on a specific browser
			//using reference variable of properties file read the browser value from config file
			String browsername=	prop.getProperty("browser"); //store the value in a String varaiable
			if(browsername.equals("Firefox")){
				System.setProperty("Webdriver.gecko.driver","geckodriver.exe"); // ./ represents the current directory
				driver=new FirefoxDriver();
				log.info("browser used is firefox");
			}
				else if(browsername.equals("chrome")) {
				System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
				driver=new ChromeDriver();
				log.info("browser used is chrome");
				}
			 driver.manage().window().maximize();
			 driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 driver.get(prop.getProperty("url")); //reading value from property file
			 
			}
			  
			//taking screenshot and storing it in the local machine
	         public  String captureScreen(String Filename) {
	        //SimpleDateFormat is a class, and Date is a class
	        
	       /* SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
	        Date dt=new Date();
	        String timestamp1=df.format(dt);*/
	        
	     //   All the above 3 lines are combined to generate below timestamp

	 	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        
	         //convert webdriver object to take screenshot, so driver can take screenshot,getScreenShotmethod is used to create image file
	        //and output should be file format
	 	       
	        //Inorder to see the screenshot in our OS, use FileUtils to copy the screen shot from srcFile to the C Drive
	       
	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + Filename + "_" + timeStamp + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;
//getting the location of screesht in local machine
	        
	         }
	       
	        public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	    	{
	    		try
	    		{
	    		driver.switchTo().alert();//alert present, return true
	    		return true;
	    		}
	    		catch(NoAlertPresentException e)//if alert not present, catch the exception
	    		{
	    			return false;
	    		}
	    		
	    	}

		
	    
			
			

	   
	 //  public static void selectDateByJs(WebElement element, String date) {
		   //JavascriptExecutor js = (JavascriptExecutor) driver;
		  // js.executeScript("arguments[0].setAttribute('value','"+date"');",element)
	

	   }
