package InstabeatSanity.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractTestClass {

	WebDriver driver;

	/*
	 * private String expected = null; private String actual = null;
	 */

	/*
	 * @BeforeMethod public void verifyPageTitle() { String expected = "Login";
	 * String actual = driver.getTitle(); Assert.assertEquals(expected, actual);
	 * System.out.println("------------------>" + actual+" Page" +
	 * "<------------------"); }
	 */
	@BeforeTest
	public void BeforeTests() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://user.instabeat.me/user/");
		// driver.get("http://ibeat.pub.globallogic.com/user/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterTest
	public void AfterTests() {
		driver.close();
		driver.quit();
	}

}
