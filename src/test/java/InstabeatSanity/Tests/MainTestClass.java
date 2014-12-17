package InstabeatSanity.Tests;

import instabeat.utils.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;


public class MainTestClass {

	protected WebDriver driver;
	
	@BeforeGroups(groups = {"Sanity"})
	public void BeforeGroup(){
		Utils.logFile();
		Utils.Log.info("*===========================================*");
		Utils.Log.info("*        Start running test cases...        *");
		Utils.Log.info("*===========================================*");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://staging-web-664817575.us-west-2.elb.amazonaws.com/user/");
		//		driver.get("http://user.instabeat.me/user/");
		//		driver.get("http://ibeat.pub.globallogic.com/user/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@AfterGroups(groups = {"Sanity"})
	public void AfterGroup() {
		Utils.Log.info("*===========================================*");
		Utils.Log.info("*       Finish running test cases...        *");
		Utils.Log.info("*===========================================*");
		Utils.Log.info("\n");

		driver.close();
		driver.quit();
	}

	
	@BeforeMethod
	public void BeforeMethod() {

/*		Utils.logFile();
		Utils.Log.info("*===========================================*");
		Utils.Log.info("*        Start running test cases...        *");
		Utils.Log.info("*===========================================*");*/

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://staging-web-664817575.us-west-2.elb.amazonaws.com/user/");
		//		driver.get("http://user.instabeat.me/user/");
		//		driver.get("http://ibeat.pub.globallogic.com/user/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}


	@AfterMethod
	public void AfterTests() {
/*		Utils.Log.info("*===========================================*");
		Utils.Log.info("*       Finish running test cases...        *");
		Utils.Log.info("*===========================================*");
		Utils.Log.info("\n");*/

		driver.close();
//		driver.quit();
	}

	/*@AfterTest(alwaysRun = true)
	protected boolean Finish() {
		boolean blnRes = true;
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return blnRes;
	}*/
}	
