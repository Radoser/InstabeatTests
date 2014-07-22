package instabeat.pages;

import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgotPasswordPage extends MainPagesFunc{

	
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
	}
	
	
	public void verifyPageTitle() {
		String	expected = "Login";
		String	actual = driver.getTitle();
			Assert.assertEquals(expected, actual);
			System.out.println("------------------>" + actual+" Page" + "<------------------");
		}
	
	public void typeExistingUserEmail ()
	{
		values(By.id(parameters.EmailField), parameters.UserEmail);
		//driver.findElement(By.id("email")).sendKeys(user);
	    //driver.findElement(By.xpath(".//*[@id='response-false']/form/div[3]/div[2]/button")).click();
	}
	
	public ForgotPasswordPageResults clickOnResetButton(){
		click(By.xpath(parameters.ResetPasswordButton));
		//driver.findElement(By.xpath(".//*[@id='response-false']/form/div[3]/div[2]/button")).click();
		return new ForgotPasswordPageResults(driver);
	}
}
