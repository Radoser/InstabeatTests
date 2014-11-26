
 package InstabeatSanity.Tests;

import instabeat.utils.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ParallelBrowserSanity {

	WebDriver driver;

	
	@BeforeTest
	@Parameters({"browser"})
	public void BeforeTests(/*@Optional("browsers.xml")*/String browser ) {
	
		Utils.logFile();
		Utils.Log.info("*===========================================*");
		Utils.Log.info("*        Start running test cases...        *");
		Utils.Log.info("*===========================================*");
		
		if (browser.equalsIgnoreCase("firefox")) {
            Utils.Log.info("|FF running");
			driver = new FirefoxDriver();
     } else if (browser.equalsIgnoreCase("chrome")) {
            // Set Path for the executable file
            System.setProperty("webdriver.chrome.driver",
                         "D:\\Java\\JARs\\chromedriver_win32\\chromedriver.exe");
            Utils.Log.info("|Chrome running");
            driver = new ChromeDriver();
     } else if (browser.equalsIgnoreCase("ie")) {
            // Set Path for the executable file
            System.setProperty("webdriver.ie.driver", "D:\\Java\\JARs\\IEDriverServer_Win32_2.43.0\\IEDriverServer.exe");
            Utils.Log.info("|IE running");
            driver = new InternetExplorerDriver();
     }else
     {
    	 Utils.Log.info("Unknown error O_o");
     }
	
		driver.manage().window().maximize();
//		driver.get("http://user.instabeat.me/user/");
		driver.get("http://staging-web-664817575.us-west-2.elb.amazonaws.com/user/");
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
