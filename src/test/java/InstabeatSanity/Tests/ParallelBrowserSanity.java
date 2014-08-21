
 package InstabeatSanity.Tests;

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
	
		if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
     } else if (browser.equalsIgnoreCase("chrome")) {
            // Set Path for the executable file
            System.setProperty("webdriver.chrome.driver",
                         "D:\\eclipse-java-juno-SR1-win32-x86_64\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
     } else if (browser.equalsIgnoreCase("ie")) {
            // Set Path for the executable file
            System.setProperty("webdriver.ie.driver", "D:\\eclipse-java-juno-SR1-win32-x86_64\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
     }else
     {System.out.println("-------------");
     
     }
	
		driver.manage().window().maximize();
		driver.get("http://user.instabeat.me/user/");
//		 driver.get("http://ibeat.pub.globallogic.com/user/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterTest
	public void AfterTests() {
		
		driver.close();
		driver.quit();
	}

}
