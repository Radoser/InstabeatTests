package InstabeatSanity.Tests;

import instabeat.utils.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class AbstractTestClass {

	WebDriver driver;
	
	
	@BeforeTest
	public void BeforeTests() {
		
		Utils.logFile();
		Utils.Log.info("*===========================================*");
		Utils.Log.info("*        Start running test cases...        *");
		Utils.Log.info("*===========================================*");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.get("http://production-web-1285655940.us-west-2.elb.amazonaws.com");
		driver.get("http://staging-web-664817575.us-west-2.elb.amazonaws.com/user/");
//		driver.get("http://user.instabeat.me/user/");
//		 driver.get("http://ibeat.pub.globallogic.com/user/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterTest
	public void AfterTests() {
		Utils.Log.info("*===========================================*");
		Utils.Log.info("*       Finish running test cases...        *");
		Utils.Log.info("*===========================================*");
		Utils.Log.info("\n");
		
		driver.close();
		driver.quit();
	}
	
	
}
